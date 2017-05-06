package mobsoft.vizelibalint.hu.mobszoftlab.ui.category;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import mobsoft.vizelibalint.hu.mobszoftlab.MobSoftApplication;
import mobsoft.vizelibalint.hu.mobszoftlab.ui.Presenter;

public class CategoryPresenter extends Presenter<CategoryScreen> {

    @Inject
    Executor categoryExecutor;

//    @Inject
//    CategoryInteractor categoryInteractor;

    public CategoryPresenter() {
        MobSoftApplication.injector.inject(this);
    }

    @Override
    public void attachScreen(CategoryScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }
}
