package mobsoft.vizelibalint.hu.mobszoftlab.ui.category;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import mobsoft.vizelibalint.hu.mobszoftlab.MobSoftApplication;
import mobsoft.vizelibalint.hu.mobszoftlab.interactor.category.CategoryEvent;
import mobsoft.vizelibalint.hu.mobszoftlab.interactor.category.CategoryInteractor;
import mobsoft.vizelibalint.hu.mobszoftlab.interactor.category.UserUpdateEvent;
import mobsoft.vizelibalint.hu.mobszoftlab.model.Category;
import mobsoft.vizelibalint.hu.mobszoftlab.model.Company;
import mobsoft.vizelibalint.hu.mobszoftlab.ui.Presenter;

public class CategoryPresenter extends Presenter<CategoryScreen> {

    @Inject
    Executor categoryExecutor;

    @Inject
    CategoryInteractor categoryInteractor;

    public CategoryPresenter() {
        MobSoftApplication.injector.inject(this);
    }

    @Override
    public void attachScreen(CategoryScreen screen) {
        super.attachScreen(screen);
        if (!EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().register(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final CategoryEvent event) {
        if (event.getCode() == 201) {
            screen.navigateToMainScreen(event.getCategory());
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final UserUpdateEvent event) {

    }

    public void getNewSeqNumber(final Company company, final Category category) {
        categoryExecutor.execute(new Runnable() {
            @Override
            public void run() {
                categoryInteractor.getSeqNumberForCategory(company, category);
            }
        });
    }



}
