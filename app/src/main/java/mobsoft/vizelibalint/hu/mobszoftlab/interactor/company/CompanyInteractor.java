package mobsoft.vizelibalint.hu.mobszoftlab.interactor.company;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import javax.inject.Inject;

import mobsoft.vizelibalint.hu.mobszoftlab.MobSoftApplication;
import mobsoft.vizelibalint.hu.mobszoftlab.interactor.BaseEvent;
import mobsoft.vizelibalint.hu.mobszoftlab.model.Company;
import mobsoft.vizelibalint.hu.mobszoftlab.network.API;
import mobsoft.vizelibalint.hu.mobszoftlab.repository.Repository;
import retrofit2.Call;
import retrofit2.Response;


public class CompanyInteractor {

    @Inject
    API networkApi;

    @Inject
    Repository repository;

    public CompanyInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    private void eventPostSuccessMessage(Integer code, BaseEvent event){
        event.setCode(code);
        EventBus.getDefault().post(event);
    }

    private void eventPostFailMessage(BaseEvent event, Exception e){
        event.setThrowable(e);
        event.setMessage("Nem elérhető a szerver");
        EventBus.getDefault().post(event);
    }

    public void getCompanies() {
        Call<List<Company>> listCall = networkApi.getCompanies();
        CompanyEvent companyEvent = new CompanyEvent();
        try {
            Response<List<Company>> response = listCall.execute();
            switch (response.code()) {
                case 200:
                    companyEvent.setCompanies(response.body());
                    repository.setCompanies(response.body());
                    eventPostSuccessMessage(response.code(), companyEvent);
                    break;
                default:
                    eventPostFailMessage(companyEvent, new Exception());
                    break;
            }
        } catch (Exception e){
            eventPostFailMessage(companyEvent, e);
        }
    }
}
