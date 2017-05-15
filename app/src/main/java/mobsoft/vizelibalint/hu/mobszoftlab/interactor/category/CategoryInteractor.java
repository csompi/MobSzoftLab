package mobsoft.vizelibalint.hu.mobszoftlab.interactor.category;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;

import javax.inject.Inject;

import mobsoft.vizelibalint.hu.mobszoftlab.MobSoftApplication;
import mobsoft.vizelibalint.hu.mobszoftlab.interactor.BaseEvent;
import mobsoft.vizelibalint.hu.mobszoftlab.model.Category;
import mobsoft.vizelibalint.hu.mobszoftlab.model.Company;
import mobsoft.vizelibalint.hu.mobszoftlab.model.SeqNumber;
import mobsoft.vizelibalint.hu.mobszoftlab.model.User;
import mobsoft.vizelibalint.hu.mobszoftlab.network.API;
import mobsoft.vizelibalint.hu.mobszoftlab.repository.Repository;
import retrofit2.Call;
import retrofit2.Response;

public class CategoryInteractor {

    @Inject
    API networkApi;

    @Inject
    Repository repository;

    public CategoryInteractor(){
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

    public void getSeqNumberForCategory(Company company, Category category){
        SeqNumber seqNumber = new SeqNumber();

        Call<SeqNumber> createSeqNumberCall = networkApi.addSeqNumber(seqNumber);
        CategoryEvent categoryEvent = new CategoryEvent();
        try {
            Response<SeqNumber> response = createSeqNumberCall.execute();
            switch (response.code()) {
                case 201:
                    category.getSeqNumbers().add(response.body());
                    repository.addOrDeleteSeqNumberToCategory(company, category);
                    User user = repository.getCurrentUser();
                    user.setSeqNumber(response.body());
                    repository.setCurrentUser(user);
                    updateUserInServer(user);
                    categoryEvent.setCategory(category);
                    eventPostSuccessMessage(response.code(), categoryEvent);
                    break;
                default:
                    eventPostFailMessage(categoryEvent, new Exception());
                    break;
            }
        } catch (Exception e) {
            eventPostFailMessage(categoryEvent, e);
        }
    }

    private void updateUserInServer(User user) {
        Call<Void> updateUserCall = networkApi.updateUser(user.getEmail(), user);
        UserUpdateEvent event = new UserUpdateEvent();
        try {
            Response<Void> response = updateUserCall.execute();
        } catch (IOException e) {
            eventPostFailMessage(event, e);
        }
    }
}
