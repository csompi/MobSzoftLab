package mobsoft.vizelibalint.hu.mobszoftlab.interactor.login;

import mobsoft.vizelibalint.hu.mobszoftlab.interactor.BaseEvent;
import mobsoft.vizelibalint.hu.mobszoftlab.model.User;

public class LoginEvent extends BaseEvent {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
