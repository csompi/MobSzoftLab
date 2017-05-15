package mobsoft.vizelibalint.hu.mobszoftlab;

import android.app.Application;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

import javax.inject.Inject;

import mobsoft.vizelibalint.hu.mobszoftlab.repository.Repository;
import mobsoft.vizelibalint.hu.mobszoftlab.ui.UIModule;

public class MobSoftApplication extends Application {

	private Tracker mTracker;

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

	public void setInjector(MobSoftApplicationComponent appComponent) {
		injector = appComponent;
		injector.inject(this);
		repository.open(getApplicationContext());
	}

	synchronized public Tracker getDefaultTracker() {
		if (mTracker == null) {
			GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
			// To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
			mTracker = analytics.newTracker(R.xml.global_tracker);
		}
		return mTracker;
	}
}