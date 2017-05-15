package mobsoft.vizelibalint.hu.mobszoftlab.repository;

import android.content.Context;

import java.util.List;

import mobsoft.vizelibalint.hu.mobszoftlab.model.Category;
import mobsoft.vizelibalint.hu.mobszoftlab.model.Company;
import mobsoft.vizelibalint.hu.mobszoftlab.model.Desk;
import mobsoft.vizelibalint.hu.mobszoftlab.model.SeqNumber;
import mobsoft.vizelibalint.hu.mobszoftlab.model.User;

public interface Repository {

    void open(Context context);
    void close();

    List<Company> getCompanies();
    void setCompanies(List<Company> companies);
    void addOrDeleteSeqNumberToCategory(Company company, Category category);
    void deleteCategory(Integer companyId, Integer categoryId);
    void addNewCategoryToCompany(Company company, Category category);

    void setCurrentUser(User user);
    User getCurrentUser();

    void addSeqNumberToUser(User user, SeqNumber seqNumber);
    void deleteUserSeqNumber(User user, SeqNumber seqNumber);

    void setDeskActualSeqNumber(Desk desk, SeqNumber seqNumber);
}