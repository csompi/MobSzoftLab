package mobsoft.vizelibalint.hu.mobszoftlab.interactor.register;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import mobsoft.vizelibalint.hu.mobszoftlab.MobSoftApplication;
import mobsoft.vizelibalint.hu.mobszoftlab.interactor.BaseEvent;
import mobsoft.vizelibalint.hu.mobszoftlab.model.User;
import mobsoft.vizelibalint.hu.mobszoftlab.network.API;
import retrofit2.Call;
import retrofit2.Response;

public class RegisterInteractor {

    @Inject
    API networkApi;

    public RegisterInteractor() {
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

    public void register(String name, String email, String password) {
        User newUser = new User();
        newUser.setName(name);
        newUser.setEmail(email);
        newUser.setPassword(password);

        Call<Void> registerCall = networkApi.createUser(newUser);
        RegisterEvent registerEvent = new RegisterEvent();

        try {
            Response<Void> registerResponse = registerCall.execute();
            switch (registerResponse.code()) {
                case 200:
                    eventPostSuccessMessage(registerResponse.code(), registerEvent);
                    break;
                default:
                    eventPostFailMessage(registerEvent, new Exception());
                    break;
            }
        } catch (Exception e) {
            eventPostFailMessage(registerEvent, e);
        }
    }
}
