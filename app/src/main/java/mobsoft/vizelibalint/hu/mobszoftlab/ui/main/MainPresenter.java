package mobsoft.vizelibalint.hu.mobszoftlab.ui.main;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import mobsoft.vizelibalint.hu.mobszoftlab.MobSoftApplication;
import mobsoft.vizelibalint.hu.mobszoftlab.interactor.category.UserUpdateEvent;
import mobsoft.vizelibalint.hu.mobszoftlab.interactor.main.DeleteSeqNumberEvent;
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
        if(!EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().register(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void deleteNumber() {
        mainExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mainInteractor.deleteSeqNumber();
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final DeleteSeqNumberEvent event) {
        if (event.getCode() == 200) {
            screen.updateSeqNumber(null);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final UserUpdateEvent event) {

    }
}
