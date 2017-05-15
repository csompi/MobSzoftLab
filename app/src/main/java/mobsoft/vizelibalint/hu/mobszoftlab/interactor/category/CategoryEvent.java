package mobsoft.vizelibalint.hu.mobszoftlab.interactor.category;

import mobsoft.vizelibalint.hu.mobszoftlab.interactor.BaseEvent;
import mobsoft.vizelibalint.hu.mobszoftlab.model.Category;

public class CategoryEvent extends BaseEvent {

    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
