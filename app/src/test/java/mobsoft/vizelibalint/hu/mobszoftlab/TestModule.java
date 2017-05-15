package mobsoft.vizelibalint.hu.mobszoftlab;

import android.content.Context;

import com.google.android.gms.analytics.Tracker;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mobsoft.vizelibalint.hu.mobszoftlab.ui.category.CategoryPresenter;
import mobsoft.vizelibalint.hu.mobszoftlab.ui.company.CompanyPresenter;
import mobsoft.vizelibalint.hu.mobszoftlab.ui.login.LoginPresenter;
import mobsoft.vizelibalint.hu.mobszoftlab.ui.main.MainPresenter;
import mobsoft.vizelibalint.hu.mobszoftlab.ui.register.RegisterPresenter;
import mobsoft.vizelibalint.hu.mobszoftlab.utils.UiExecutor;
import mobsoft.vizelibalint.hu.mobszoftlab.ui.UIModule;

@Module
public class TestModule {

    private final UIModule UIModule;

    public TestModule(Context context) {
        this.UIModule = new UIModule(context);
    }

    @Provides
    public Context provideContext() {
        return UIModule.provideContext();
    }

    @Provides
    @Singleton
    public LoginPresenter provideLoginPresenter() {
        return new LoginPresenter();
    }

    @Provides
    @Singleton
    public RegisterPresenter provideRegisterPresenter() {
        return new RegisterPresenter();
    }

    @Provides
    @Singleton
    public CompanyPresenter provideCompanyPresenter() {
        return new CompanyPresenter();
    }

    @Provides
    @Singleton
    public CategoryPresenter provideCategoryPresenter() {
        return new CategoryPresenter();
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

    @Provides
    @Singleton
    public EventBus provideEventBus() {
        return EventBus.getDefault();
    }

    @Provides
    @Singleton
    public Executor provideNetworkExecutor() {
        return new UiExecutor();
    }

    @Provides
    public Tracker provideTracker() {
        return UIModule.provideTracker();
    }

}
