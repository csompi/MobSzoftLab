package mobsoft.vizelibalint.hu.mobszoftlab.ui.company;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import mobsoft.vizelibalint.hu.mobszoftlab.MobSoftApplication;
import mobsoft.vizelibalint.hu.mobszoftlab.ui.Presenter;

public class CompanyPresenter extends Presenter<CompanyScreen> {

    @Inject
    Executor companyExecutor;

//    @Inject
//    CompanyInteractor companyInteractor;

    public CompanyPresenter() {
        MobSoftApplication.injector.inject(this);
    }

    @Override
    public void attachScreen(CompanyScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }
}
