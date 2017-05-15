package mobsoft.vizelibalint.hu.mobszoftlab.interactor;

import dagger.Module;
import dagger.Provides;
import mobsoft.vizelibalint.hu.mobszoftlab.interactor.category.CategoryInteractor;
import mobsoft.vizelibalint.hu.mobszoftlab.interactor.company.CompanyInteractor;
import mobsoft.vizelibalint.hu.mobszoftlab.interactor.login.LoginInteractor;
import mobsoft.vizelibalint.hu.mobszoftlab.interactor.main.MainInteractor;
import mobsoft.vizelibalint.hu.mobszoftlab.interactor.register.RegisterInteractor;

@Module
public class InteractorModule {

	@Provides
	public LoginInteractor loginInteractor() {
		return new LoginInteractor();
	}

	@Provides
	public RegisterInteractor registerInteractor() {
		return new RegisterInteractor();
	}

	@Provides
	public MainInteractor mainInteractor() {
		return new MainInteractor();
	}

	@Provides
	public CompanyInteractor companyInteractor() { return new CompanyInteractor(); }

	@Provides
	public CategoryInteractor categoryInteractor() {return new CategoryInteractor(); }
}