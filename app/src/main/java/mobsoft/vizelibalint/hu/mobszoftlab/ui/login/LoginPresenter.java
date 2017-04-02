package mobsoft.vizelibalint.hu.mobszoftlab.ui.login;


import mobsoft.vizelibalint.hu.mobszoftlab.Presenter;

public class LoginPresenter extends Presenter<LoginScreen> {

    public LoginPresenter() {
    }

    @Override
    public void attachScreen(LoginScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void showMessage(
            String message) {
        screen.showMessage(message);
    }
}
