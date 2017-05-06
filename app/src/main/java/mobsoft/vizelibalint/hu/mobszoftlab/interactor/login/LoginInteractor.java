package mobsoft.vizelibalint.hu.mobszoftlab.interactor.login;

import mobsoft.vizelibalint.hu.mobszoftlab.MobSoftApplication;

public class LoginInteractor {

    public LoginInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void login(String username, String password) {

    }

}
