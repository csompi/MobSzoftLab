package mobsoft.vizelibalint.hu.mobszoftlab.ui.company;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import mobsoft.vizelibalint.hu.mobszoftlab.MobSoftApplication;
import mobsoft.vizelibalint.hu.mobszoftlab.interactor.company.CompanyEvent;
import mobsoft.vizelibalint.hu.mobszoftlab.interactor.company.CompanyInteractor;
import mobsoft.vizelibalint.hu.mobszoftlab.ui.Presenter;

public class CompanyPresenter extends Presenter<CompanyScreen> {

    @Inject
    Executor companyExecutor;

    @Inject
    CompanyInteractor companyInteractor;

    private CompanyRecyclerViewAdapter recyclerViewAdapter;

    public CompanyPresenter() {
        MobSoftApplication.injector.inject(this);
    }

    public CompanyRecyclerViewAdapter getRecyclerViewAdapter() {
        return recyclerViewAdapter;
    }

    public void setRecyclerViewAdapter(CompanyRecyclerViewAdapter recyclerViewAdapter) {
        this.recyclerViewAdapter = recyclerViewAdapter;
    }

    @Override
    public void attachScreen(CompanyScreen screen) {
        super.attachScreen(screen);
        if (!EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().register(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void getCompanies() {
        companyExecutor.execute(new Runnable() {
            @Override
            public void run() {
                companyInteractor.getCompanies();
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final CompanyEvent event) {
        if (event.getCode() == 200) {
            recyclerViewAdapter.setNewItems(event.getCompanies());
        }
    }
}
