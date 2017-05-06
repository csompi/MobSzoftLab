package mobsoft.vizelibalint.hu.mobszoftlab.ui.company;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import mobsoft.vizelibalint.hu.mobszoftlab.MobSoftApplication;
import mobsoft.vizelibalint.hu.mobszoftlab.R;
import mobsoft.vizelibalint.hu.mobszoftlab.model.Category;
import mobsoft.vizelibalint.hu.mobszoftlab.model.Company;

public class CompanyActivity extends AppCompatActivity implements CompanyScreen {

    @Inject
    CompanyPresenter companyPresenter;

    @BindView(R.id.company_recycler_view)
    RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);

        ButterKnife.bind(this);
        MobSoftApplication.injector.inject(this);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        //TEST
        List<Company> companies = new ArrayList<>();

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

        companies.add(company);
        //TEST

        CompanyRecyclerViewAdapter adapter = new CompanyRecyclerViewAdapter(this, companies);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        companyPresenter.attachScreen(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        companyPresenter.attachScreen(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        companyPresenter.detachScreen();
    }

    @Override
    protected void onStop() {
        super.onStop();
        companyPresenter.detachScreen();
    }
}
