package mobsoft.vizelibalint.hu.mobszoftlab.ui.register;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import mobsoft.vizelibalint.hu.mobszoftlab.MobSoftApplication;
import mobsoft.vizelibalint.hu.mobszoftlab.interactor.register.RegisterEvent;
import mobsoft.vizelibalint.hu.mobszoftlab.interactor.register.RegisterInteractor;
import mobsoft.vizelibalint.hu.mobszoftlab.ui.Presenter;

public class RegisterPresenter extends Presenter<RegisterScreen> {

    @Inject
    Executor registerExecutor;

    @Inject
    RegisterInteractor registerInteractor;

    public RegisterPresenter() {
        MobSoftApplication.injector.inject(this);
    }

    void registerUser(final String name, final String email, final String password) {
        registerExecutor.execute(new Runnable() {
            @Override
            public void run() {
                registerInteractor.register(name, email, password);
            }
        });
    }

    @Override
    public void attachScreen(RegisterScreen screen) {
        super.attachScreen(screen);
        if(!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final RegisterEvent event) {
        if(screen != null) {
            if (event.getCode() == 200) {
                screen.navigateBackToLogin();
            }
        }
    }
}
