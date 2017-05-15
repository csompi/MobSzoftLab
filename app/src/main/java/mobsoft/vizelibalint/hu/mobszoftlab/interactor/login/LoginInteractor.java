package mobsoft.vizelibalint.hu.mobszoftlab.interactor.login;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import mobsoft.vizelibalint.hu.mobszoftlab.MobSoftApplication;
import mobsoft.vizelibalint.hu.mobszoftlab.interactor.BaseEvent;
import mobsoft.vizelibalint.hu.mobszoftlab.model.User;
import mobsoft.vizelibalint.hu.mobszoftlab.network.API;
import mobsoft.vizelibalint.hu.mobszoftlab.repository.Repository;
import retrofit2.Call;
import retrofit2.Response;

public class LoginInteractor {

    @Inject
    API networkApi;

    @Inject
    Repository repository;

    public LoginInteractor() {
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

    public void login(String username, String password) {
        Call<User> userCall = networkApi.loginUser(username, password);
        LoginEvent event = new LoginEvent();
        try {
            Response<User> userResponse = userCall.execute();
            switch (userResponse.code()) {
                case 200:
                    repository.setCurrentUser(userResponse.body());
                    event.setUser(userResponse.body());
                    eventPostSuccessMessage(userResponse.code(), event);
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
