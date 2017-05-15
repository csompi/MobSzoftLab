package mobsoft.vizelibalint.hu.mobszoftlab.interactor.company;

import java.util.List;

import mobsoft.vizelibalint.hu.mobszoftlab.interactor.BaseEvent;
import mobsoft.vizelibalint.hu.mobszoftlab.model.Company;

public class CompanyEvent extends BaseEvent {
    private List<Company> companies;

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

}
