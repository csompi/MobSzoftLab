package mobsoft.vizelibalint.hu.mobszoftlab.ui.register;


import mobsoft.vizelibalint.hu.mobszoftlab.Presenter;

public class RegisterPresenter extends Presenter<RegisterScreen> {

    public RegisterPresenter() {
    }

    @Override
    public void attachScreen(RegisterScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void registerUser(
            String message) {
        screen.showMessage(message);
    }
}
