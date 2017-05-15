package mobsoft.vizelibalint.hu.mobszoftlab.ui.login;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import mobsoft.vizelibalint.hu.mobszoftlab.MobSoftApplication;
import mobsoft.vizelibalint.hu.mobszoftlab.interactor.login.LoginEvent;
import mobsoft.vizelibalint.hu.mobszoftlab.interactor.login.LoginInteractor;
import mobsoft.vizelibalint.hu.mobszoftlab.ui.Presenter;

public class LoginPresenter extends Presenter<LoginScreen> {

    @Inject
    Executor loginExecutor;

    @Inject
    LoginInteractor loginInteractor;

    public LoginPresenter() {
        MobSoftApplication.injector.inject(this);
    }

    public void login(final String username, final String password) {
        loginExecutor.execute(new Runnable() {
            @Override
            public void run() {
                loginInteractor.login(username, password);
            }
        });
    }

    @Override
    public void attachScreen(LoginScreen screen) {
        super.attachScreen(screen);
        MobSoftApplication.injector.inject(this);
        if(!EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().register(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final LoginEvent event) {
        if (event.getCode() == 200) {
            if (screen != null) {
                screen.navigateToMainScreen();
            }
        }
    }
}
