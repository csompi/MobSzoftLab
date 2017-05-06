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

	private static List<Company> companies;

	@Override
	public void open(Context context) {
		companies = new ArrayList<>();
        Company company = new Company();
        company.setName("T-Mobile");
        company.setAddress("1519 Budapest, Pf. 434");
        company.setCompanyId(1);

        Category category1 = new Category();
        category1.setCategoryId(1);
        category1.setName("Telefon");
        category1.setEnabled(true);

        Category category2 = new Category();
        category2.setCategoryId(2);
        category2.setName("Internet");
        category2.setEnabled(true);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(category1);
        categoryList.add(category2);

        company.setCategories(categoryList);
	}

	@Override
	public void close() {

	}

    @Override
    public List<Company> getCompanies() {
        return companies;
    }

    @Override
    public void addOrDeleteSeqNumberToCategory(Company company, Category category) {
        deleteCategory(company.getCompanyId(), category.getCategoryId());
        addNewCategoryToCompany(company, category);
    }

    @Override
    public void deleteCategory(Integer companyId, Integer categoryId) {
        for(Company company : companies) {
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
