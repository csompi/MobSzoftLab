package mobsoft.vizelibalint.hu.mobszoftlab.ui.category;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import mobsoft.vizelibalint.hu.mobszoftlab.MobSoftApplication;
import mobsoft.vizelibalint.hu.mobszoftlab.R;
import mobsoft.vizelibalint.hu.mobszoftlab.model.Company;

public class CategoryActivity extends AppCompatActivity implements CategoryScreen {

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
}
