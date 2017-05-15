package mobsoft.vizelibalint.hu.mobszoftlab.repository;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import mobsoft.vizelibalint.hu.mobszoftlab.model.Category;
import mobsoft.vizelibalint.hu.mobszoftlab.model.Company;
import mobsoft.vizelibalint.hu.mobszoftlab.model.Desk;
import mobsoft.vizelibalint.hu.mobszoftlab.model.SeqNumber;
import mobsoft.vizelibalint.hu.mobszoftlab.model.User;

public class MemoryRepository implements Repository {

	private static final long MINUTE = 60 * 1000;

	private List<Company> mCompanies;

    private User currentUser;

	@Override
	public void open(Context context) {
		mCompanies = new ArrayList<>();
	}

	@Override
	public void close() {}

    @Override
    public List<Company> getCompanies() {
        return mCompanies;
    }

    @Override
    public void setCompanies(List<Company> companies) {
        mCompanies = companies;
    }

    @Override
    public void addOrDeleteSeqNumberToCategory(Company company, Category category) {
        deleteCategory(company.getCompanyId(), category.getCategoryId());
        addNewCategoryToCompany(company, category);
    }

    @Override
    public void deleteCategory(Integer companyId, Integer categoryId) {
        for(Company company : mCompanies) {
            if (company.getCompanyId() == companyId) {
                for(Category category : company.getCategories()) {
                    if (category.getCategoryId() == categoryId) {
                        company.getCategories().remove(category);
                        break;
                    }
                }
            }
        }
    }

    @Override
    public void addNewCategoryToCompany(Company company, Category category) {
        company.getCategories().add(category);
    }

    @Override
    public void setCurrentUser(User user) {
        currentUser = user;
    }

    @Override
    public User getCurrentUser() {
        return currentUser;
    }

    @Override
    public void addSeqNumberToUser(User user, SeqNumber seqNumber) {
        user.setSeqNumber(seqNumber);
    }

    @Override
    public void deleteUserSeqNumber(User user, SeqNumber seqNumber) {
        user.setSeqNumber(null);
    }

    @Override
    public void setDeskActualSeqNumber(Desk desk, SeqNumber seqNumber) {
        desk.setActualSeqNumber(seqNumber);
    }
}
