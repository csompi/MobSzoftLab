package mobsoft.vizelibalint.hu.mobszoftlab.interactor.main;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;

import javax.inject.Inject;

import mobsoft.vizelibalint.hu.mobszoftlab.MobSoftApplication;
import mobsoft.vizelibalint.hu.mobszoftlab.interactor.BaseEvent;
import mobsoft.vizelibalint.hu.mobszoftlab.interactor.category.UserUpdateEvent;
import mobsoft.vizelibalint.hu.mobszoftlab.model.User;
import mobsoft.vizelibalint.hu.mobszoftlab.network.API;
import mobsoft.vizelibalint.hu.mobszoftlab.repository.Repository;
import retrofit2.Call;
import retrofit2.Response;

public class MainInteractor {

    @Inject
    API networkApi;

    @Inject
    Repository repository;

    public MainInteractor() {
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

    public void deleteSeqNumber() {
        User user = repository.getCurrentUser();
        if (user.getSeqNumber() != null) {
            Call<Void> deleteCall = networkApi.deleteSeqNumber(user.getSeqNumber().getNumber());
            DeleteSeqNumberEvent event = new DeleteSeqNumberEvent();
            try {
                Response<Void> response = deleteCall.execute();
                switch (response.code()) {
                    case 200:
                        repository.getCurrentUser().setSeqNumber(null);
                        updateUserInServer(repository.getCurrentUser());
                        eventPostSuccessMessage(response.code(), event);
                        break;
                    default:
                        eventPostFailMessage(event, new Exception());
                        break;
                }
            } catch (Exception e) {
                eventPostFailMessage(event, e);
            }
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
