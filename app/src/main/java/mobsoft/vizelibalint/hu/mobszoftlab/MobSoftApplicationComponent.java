package mobsoft.vizelibalint.hu.mobszoftlab;

import javax.inject.Singleton;

import dagger.Component;
import mobsoft.vizelibalint.hu.mobszoftlab.ui.main.MainActivity;

/**
 * Created by mobsoft on 2017. 03. 20..
 */

@Singleton
@Component(modules = {UIModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity mainActivity);
}
