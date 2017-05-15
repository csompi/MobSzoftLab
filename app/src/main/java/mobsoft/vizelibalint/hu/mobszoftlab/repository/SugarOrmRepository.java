package mobsoft.vizelibalint.hu.mobszoftlab.repository;

import android.content.Context;

import com.orm.SugarContext;
import com.orm.SugarRecord;
import com.orm.query.Condition;
import com.orm.query.Select;

import java.util.List;

import mobsoft.vizelibalint.hu.mobszoftlab.model.Category;
import mobsoft.vizelibalint.hu.mobszoftlab.model.Company;
import mobsoft.vizelibalint.hu.mobszoftlab.model.Desk;
import mobsoft.vizelibalint.hu.mobszoftlab.model.SeqNumber;
import mobsoft.vizelibalint.hu.mobszoftlab.model.User;

public class SugarOrmRepository implements Repository {

    @Override
    public void open(Context context) {
        SugarContext.init(context);
    }

    @Override
    public void close() {
        SugarContext.terminate();
    }

    @Override
    public List<Company> getCompanies() {
        return Select.from(Company.class).list();
    }

    @Override
    public void setCompanies(List<Company> companies) {
        List<Company> oldCompanies = getCompanies();
        for(Company comp : oldCompanies)
            SugarRecord.delete(comp);
        SugarRecord.saveInTx(companies);
    }

    @Override
    public void addOrDeleteSeqNumberToCategory(Company company, Category category) {
        deleteCategory(company.getCompanyId(), category.getCategoryId());
        addNewCategoryToCompany(company, category);
    }

    @Override
    public void deleteCategory(Integer companyId, Integer categoryId) {
        Company company = Select.from(Company.class)
                .where(Condition.prop("companyId").eq(companyId))
                .first();
        for(Category category : company.getCategories()) {
            if (category.getCategoryId() == categoryId) {
                company.getCategories().remove(category);
                break;
            }
        }
        company.save();
    }

    @Override
    public void addNewCategoryToCompany(Company company, Category category) {
        Company comp = Select.from(Company.class)
                .where(Condition.prop("companyId").eq(company.getCompanyId()))
                .first();
        comp.getCategories().add(category);
        comp.save();
    }

    @Override
    public void setCurrentUser(User user) {

    }

    @Override
    public User getCurrentUser() {
        return null;
    }

    @Override
    public void addSeqNumberToUser(User user, SeqNumber seqNumber) {
        User u = Select.from(User.class)
                .where(Condition.prop("userId").eq(user.getUserId()))
                .first();
        u.setSeqNumber(seqNumber);
        u.save();
    }

    @Override
    public void deleteUserSeqNumber(User user, SeqNumber seqNumber) {
        User u = Select.from(User.class)
                .where(Condition.prop("userId").eq(user.getUserId()))
                .first();
        u.setSeqNumber(null);
        u.save();
    }

    @Override
    public void setDeskActualSeqNumber(Desk desk, SeqNumber seqNumber) {
        Desk d = Select.from(Desk.class)
                .where(Condition.prop("deskId").eq(desk.getDeskId()))
                .first();
        d.setActualSeqNumber(seqNumber);
        d.save();
    }
}