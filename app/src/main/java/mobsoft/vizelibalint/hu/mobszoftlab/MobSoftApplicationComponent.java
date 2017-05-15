package mobsoft.vizelibalint.hu.mobszoftlab;

import javax.inject.Singleton;

import dagger.Component;
import mobsoft.vizelibalint.hu.mobszoftlab.interactor.InteractorModule;
import mobsoft.vizelibalint.hu.mobszoftlab.interactor.category.CategoryInteractor;
import mobsoft.vizelibalint.hu.mobszoftlab.interactor.company.CompanyInteractor;
import mobsoft.vizelibalint.hu.mobszoftlab.interactor.login.LoginInteractor;
import mobsoft.vizelibalint.hu.mobszoftlab.interactor.main.MainInteractor;
import mobsoft.vizelibalint.hu.mobszoftlab.interactor.register.RegisterInteractor;
import mobsoft.vizelibalint.hu.mobszoftlab.network.NetworkModule;
import mobsoft.vizelibalint.hu.mobszoftlab.repository.RepositoryModule;
import mobsoft.vizelibalint.hu.mobszoftlab.ui.UIModule;
import mobsoft.vizelibalint.hu.mobszoftlab.ui.category.CategoryActivity;
import mobsoft.vizelibalint.hu.mobszoftlab.ui.category.CategoryPresenter;
import mobsoft.vizelibalint.hu.mobszoftlab.ui.category.CategoryRecyclerViewAdapter;
import mobsoft.vizelibalint.hu.mobszoftlab.ui.company.CompanyActivity;
import mobsoft.vizelibalint.hu.mobszoftlab.ui.company.CompanyPresenter;
import mobsoft.vizelibalint.hu.mobszoftlab.ui.company.CompanyRecyclerViewAdapter;
import mobsoft.vizelibalint.hu.mobszoftlab.ui.login.LoginActivity;
import mobsoft.vizelibalint.hu.mobszoftlab.ui.login.LoginPresenter;
import mobsoft.vizelibalint.hu.mobszoftlab.ui.main.MainActivity;
import mobsoft.vizelibalint.hu.mobszoftlab.ui.main.MainPresenter;
import mobsoft.vizelibalint.hu.mobszoftlab.ui.register.RegisterActivity;
import mobsoft.vizelibalint.hu.mobszoftlab.ui.register.RegisterPresenter;

@Singleton
@Component(modules = {UIModule.class, NetworkModule.class, RepositoryModule.class, InteractorModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity mainActivity);
    void inject(MainPresenter mainPresenter);
    void inject(MainInteractor mainInteractor);

    void inject(LoginActivity loginActivity);
    void inject(LoginPresenter loginPresenter);
    void inject(LoginInteractor loginInteractor);

    void inject(RegisterActivity registerActivity);
    void inject(RegisterPresenter registerPresenter);
    void inject(RegisterInteractor registerInteractor);

    void inject(CompanyActivity companyActivity);
    void inject(CompanyPresenter companyPresenter);
    void inject(CompanyInteractor companyInteractor);

    void inject(CategoryActivity categoryActivity);
    void inject(CategoryPresenter categoryPresenter);
    void inject(CategoryInteractor categoryInteractor);

    void inject(MobSoftApplication mobSoftApplication);

    void inject(CategoryRecyclerViewAdapter categoryRecyclerViewAdapter);

    void inject(CompanyRecyclerViewAdapter companyRecyclerViewAdapter);

}
