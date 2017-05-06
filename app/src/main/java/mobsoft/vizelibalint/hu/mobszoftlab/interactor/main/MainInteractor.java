package mobsoft.vizelibalint.hu.mobszoftlab.interactor.main;

import mobsoft.vizelibalint.hu.mobszoftlab.MobSoftApplication;

public class MainInteractor {

    public MainInteractor() {
        MobSoftApplication.injector.inject(this);
    }

}
