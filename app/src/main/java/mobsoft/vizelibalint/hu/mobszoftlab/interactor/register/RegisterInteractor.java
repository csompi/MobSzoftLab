package mobsoft.vizelibalint.hu.mobszoftlab.interactor.register;

import mobsoft.vizelibalint.hu.mobszoftlab.MobSoftApplication;

public class RegisterInteractor {

    public RegisterInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void register(String name, String email, String password) {

    }
}
