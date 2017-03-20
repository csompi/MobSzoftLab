package mobsoft.vizelibalint.hu.mobszoftlab.ui.main;


import mobsoft.vizelibalint.hu.mobszoftlab.Presenter;

public class MainPresenter extends Presenter<MainScreen> {

    public MainPresenter() {
    }

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void showArtistsSearchList(
            String artistSearchTerm) {
        screen.showMessage(artistSearchTerm);
    }
}
