package mobsoft.vizelibalint.hu.mobszoftlab.mock_network;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import mobsoft.vizelibalint.hu.mobszoftlab.model.Category;
import mobsoft.vizelibalint.hu.mobszoftlab.model.Company;
import mobsoft.vizelibalint.hu.mobszoftlab.model.User;

public class MockData {
    private List<User> users;
    private List<Company> companies;
    private List<Category> categories;

    private Gson gson;

    public MockData(){
        gson = new Gson();
        createMockUsersAndCredentials();
        createCompanies();
    }

    String Login(String email, String password){
        User mUser = null;
        for (User user : users)
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                mUser = user;
                break;
            }
        if (email == null || password == null)
            return "";

        for (User u : users)
            if (u.getEmail().equals(email))
                return gson.toJson(u);

        return "";
    }

    private void createCompanies() {
        companies = new ArrayList<>();
        categories = new ArrayList<>();

        Company company = new Company();
        company.setName("T-Mobile");
        company.setAddress("1519 Budapest, Pf. 434");
        company.setCompanyId(1);

        Company company2 = new Company();
        company2.setName("MKB Bank");
        company2.setAddress("1056 Budapest, Váci utca 38.");
        company2.setCompanyId(2);

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

        Category category3 = new Category();
        category3.setCategoryId(1);
        category3.setName("Készpénzfelvét");
        category3.setEnabled(true);

        Category category4 = new Category();
        category4.setCategoryId(2);
        category4.setName("Hitelügyintézés");
        category4.setEnabled(true);

        List<Category> categoryList2 = new ArrayList<>();
        categoryList2.add(category3);
        categoryList2.add(category4);

        company.setCategories(categoryList);
        company2.setCategories(categoryList2);

        categories.add(category1);
        categories.add(category2);
        categories.add(category3);
        categories.add(category4);

        companies.add(company);
        companies.add(company2);
    }

    private void createMockUsersAndCredentials(){
        users = new ArrayList<>();

        User user = new User();
        user.setUserId(1);
        user.setUserRole(User.UserRoleEnum.CLIENT);
        user.setName("Vizeli Bálint");
        user.setEmail("vizeli@seqnumber.com");
        user.setPassword("1234");

        User user2 = new User();
        user2.setUserId(2);
        user2.setUserRole(User.UserRoleEnum.CLIENT);
        user2.setName("Cicakutya");
        user2.setEmail("cicakutya@seqnumber.com");
        user2.setPassword("4321");

        users.add(user);
        users.add(user2);
    }
}