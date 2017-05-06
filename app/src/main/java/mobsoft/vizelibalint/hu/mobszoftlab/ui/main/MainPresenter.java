package mobsoft.vizelibalint.hu.mobszoftlab.ui.main;


import java.util.concurrent.Executor;

import javax.inject.Inject;

import mobsoft.vizelibalint.hu.mobszoftlab.MobSoftApplication;
import mobsoft.vizelibalint.hu.mobszoftlab.interactor.main.MainInteractor;
import mobsoft.vizelibalint.hu.mobszoftlab.ui.Presenter;

public class MainPresenter extends Presenter<MainScreen> {

    @Inject
    Executor mainExecutor;

    @Inject
    MainInteractor mainInteractor;

    public MainPresenter() {
        MobSoftApplication.injector.inject(this);
    }

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

}
