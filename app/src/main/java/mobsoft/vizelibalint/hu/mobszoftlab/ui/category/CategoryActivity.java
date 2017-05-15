package mobsoft.vizelibalint.hu.mobszoftlab.ui.category;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import mobsoft.vizelibalint.hu.mobszoftlab.MobSoftApplication;
import mobsoft.vizelibalint.hu.mobszoftlab.R;
import mobsoft.vizelibalint.hu.mobszoftlab.model.Category;
import mobsoft.vizelibalint.hu.mobszoftlab.model.Company;
import mobsoft.vizelibalint.hu.mobszoftlab.ui.main.MainActivity;

public class CategoryActivity extends AppCompatActivity implements CategoryScreen {

    @Inject
    Tracker mTracker;

    @Inject
    CategoryPresenter categoryPresenter;

    @BindView(R.id.category_recycler_view)
    RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        ButterKnife.bind(this);
        MobSoftApplication.injector.inject(this);

        Company company = (Company) getIntent().getSerializableExtra("company");

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        CategoryRecyclerViewAdapter adapter = new CategoryRecyclerViewAdapter(this, company.getCategories());
        adapter.companyObject = company;
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        categoryPresenter.attachScreen(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        categoryPresenter.attachScreen(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        categoryPresenter.detachScreen();
    }

    @Override
    protected void onStop() {
        super.onStop();
        categoryPresenter.detachScreen();
    }

    @Override
    public void navigateToMainScreen(Category category) {
        mTracker.send(new HitBuilders.EventBuilder()
                .setCategory("Create")
                .setAction("Create seqnumber")
                .setValue(1)
                .build());
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("category", category);
        this.startActivity(intent);
    }
}
