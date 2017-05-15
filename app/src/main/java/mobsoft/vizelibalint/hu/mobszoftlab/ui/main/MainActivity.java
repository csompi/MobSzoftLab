package mobsoft.vizelibalint.hu.mobszoftlab.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mobsoft.vizelibalint.hu.mobszoftlab.MobSoftApplication;
import mobsoft.vizelibalint.hu.mobszoftlab.R;
import mobsoft.vizelibalint.hu.mobszoftlab.model.SeqNumber;
import mobsoft.vizelibalint.hu.mobszoftlab.model.User;
import mobsoft.vizelibalint.hu.mobszoftlab.repository.Repository;
import mobsoft.vizelibalint.hu.mobszoftlab.ui.company.CompanyActivity;

public class MainActivity extends AppCompatActivity implements MainScreen {

    @Inject
    Tracker mTracker;

    @Inject
    Repository repository;

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
    void deleteNumber() {
        if (currentUser.getSeqNumber() != null) {
            mTracker.send(new HitBuilders.EventBuilder()
                    .setCategory("Delete")
                    .setAction("Delete seqnumber")
                    .setValue(1)
                    .build());
            mainPresenter.deleteNumber();
        }
    }

    private User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        MobSoftApplication.injector.inject(this);

        currentUser = repository.getCurrentUser();
        if (currentUser.getSeqNumber() != null) {
            main_current_number_tv.setText(currentUser.getSeqNumber().getNumber().toString());
        }
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
        if (currentUser.getSeqNumber() == null) {
            mTracker.send(new HitBuilders.EventBuilder()
                    .setCategory("Start")
                    .setAction("Company screen start")
                    .setValue(1)
                    .build());
            Intent intent = new Intent(this, CompanyActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void updateSeqNumber(SeqNumber seqNumber) {
        if (seqNumber != null) {
            main_current_number_tv.setText(seqNumber.getNumber());
        } else {
            main_current_number_tv.setText("-");
        }
    }
}
