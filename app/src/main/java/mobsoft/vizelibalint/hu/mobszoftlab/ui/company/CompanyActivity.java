package mobsoft.vizelibalint.hu.mobszoftlab.ui.company;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.android.gms.analytics.Tracker;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import mobsoft.vizelibalint.hu.mobszoftlab.MobSoftApplication;
import mobsoft.vizelibalint.hu.mobszoftlab.R;
import mobsoft.vizelibalint.hu.mobszoftlab.model.Company;

public class CompanyActivity extends AppCompatActivity implements CompanyScreen {

    @Inject
    Tracker mTracker;

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

        if (companyPresenter.getRecyclerViewAdapter() == null) {
            CompanyRecyclerViewAdapter adapter = new CompanyRecyclerViewAdapter(this, new ArrayList<Company>());
            adapter.mTracker = mTracker;
            companyPresenter.setRecyclerViewAdapter(adapter);
        }
        recyclerView.setAdapter(companyPresenter.getRecyclerViewAdapter());

        getCompanies();
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

    @Override
    public void getCompanies() {
        companyPresenter.getCompanies();
    }
}
