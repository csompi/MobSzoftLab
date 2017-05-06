package mobsoft.vizelibalint.hu.mobszoftlab;

import android.app.Application;

import javax.inject.Inject;

import mobsoft.vizelibalint.hu.mobszoftlab.repository.Repository;
import mobsoft.vizelibalint.hu.mobszoftlab.ui.UIModule;

public class MobSoftApplication extends Application {

	public static MobSoftApplicationComponent injector;

	@Inject
	Repository repository;

	@Override
	public void onCreate() {
		super.onCreate();

		injector = DaggerMobSoftApplicationComponent.builder().uIModule(new UIModule(this)).build();
		injector.inject(this);
		repository.open(getApplicationContext());
	}
}