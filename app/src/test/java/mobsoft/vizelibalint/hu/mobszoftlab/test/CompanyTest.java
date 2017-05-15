package mobsoft.vizelibalint.hu.mobszoftlab.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;

import mobsoft.vizelibalint.hu.mobszoftlab.BuildConfig;
import mobsoft.vizelibalint.hu.mobszoftlab.ui.company.CompanyPresenter;
import mobsoft.vizelibalint.hu.mobszoftlab.ui.company.CompanyScreen;
import mobsoft.vizelibalint.hu.mobszoftlab.utils.RobolectricDaggerTestRunner;

import static mobsoft.vizelibalint.hu.mobszoftlab.TestHelper.setTestInjector;
import static org.mockito.Mockito.mock;

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class CompanyTest {


    private CompanyPresenter companyPresenter;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        companyPresenter = new CompanyPresenter();
    }

    @Test
    public void testCompany() {
        CompanyScreen companyScreen = mock(CompanyScreen.class);
        companyPresenter.attachScreen(companyScreen);
    }

    @After
    public void tearDown() {
        companyPresenter.detachScreen();
    }
}