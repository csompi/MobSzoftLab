package mobsoft.vizelibalint.hu.mobszoftlab.ui;

import android.content.Context;

import com.google.android.gms.analytics.Tracker;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mobsoft.vizelibalint.hu.mobszoftlab.MobSoftApplication;
import mobsoft.vizelibalint.hu.mobszoftlab.ui.category.CategoryPresenter;
import mobsoft.vizelibalint.hu.mobszoftlab.ui.company.CompanyPresenter;
import mobsoft.vizelibalint.hu.mobszoftlab.ui.login.LoginPresenter;
import mobsoft.vizelibalint.hu.mobszoftlab.ui.main.MainPresenter;
import mobsoft.vizelibalint.hu.mobszoftlab.ui.register.RegisterPresenter;

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
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
    public Executor provideNetworkExecutor() {
        return Executors.newFixedThreadPool(10);
    }

    @Provides
    @Singleton
    public Tracker provideTracker() {
        MobSoftApplication application = (MobSoftApplication) context.getApplicationContext();
        return application.getDefaultTracker();
    }
}