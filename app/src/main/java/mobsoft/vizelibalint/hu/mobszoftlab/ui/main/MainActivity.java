package mobsoft.vizelibalint.hu.mobszoftlab.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mobsoft.vizelibalint.hu.mobszoftlab.MobSoftApplication;
import mobsoft.vizelibalint.hu.mobszoftlab.R;
import mobsoft.vizelibalint.hu.mobszoftlab.ui.company.CompanyActivity;

public class MainActivity extends AppCompatActivity implements MainScreen {

    @Inject
    MainPresenter mainPresenter;
    @BindView(R.id.main_current_number_tv)
    TextView main_current_number_tv;
    @BindView(R.id.main_applicants_waiting_tv)
    TextView main_applicants_waiting_tv;

    @OnClick(R.id.main_get_number_btn)
    void getNumber() {
        navigateToCompanies();
    }

    @OnClick(R.id.main_delete_number_btn)
    void deleteNumber(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachScreen(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainPresenter.attachScreen(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mainPresenter.detachScreen();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.detachScreen();
    }

    private void navigateToCompanies() {
        Intent intent = new Intent(this, CompanyActivity.class);
        startActivity(intent);
    }
}
