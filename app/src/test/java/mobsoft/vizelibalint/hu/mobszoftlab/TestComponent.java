package mobsoft.vizelibalint.hu.mobszoftlab;

import javax.inject.Singleton;

import dagger.Component;
import mobsoft.vizelibalint.hu.mobszoftlab.interactor.InteractorModule;
import mobsoft.vizelibalint.hu.mobszoftlab.mock_network.MockNetworkModule;
import mobsoft.vizelibalint.hu.mobszoftlab.repository.TestRepositoryModule;

@Singleton
@Component(modules = {MockNetworkModule.class, TestModule.class, InteractorModule.class, TestRepositoryModule.class})
public interface TestComponent extends MobSoftApplicationComponent {
}
