package mobsoft.vizelibalint.hu.mobszoftlab;

import android.app.Application;

public class MobSoftApplication extends Application {

	public static MobSoftApplicationComponent injector;

	@Override
	public void onCreate() {
		super.onCreate();

		injector =
				DaggerMobSoftApplicationComponent.builder().
						uIModule(
								new UIModule(this)
						).build();
	}
}