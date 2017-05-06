package mobsoft.vizelibalint.hu.mobszoftlab.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.LinearLayout;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mobsoft.vizelibalint.hu.mobszoftlab.MobSoftApplication;
import mobsoft.vizelibalint.hu.mobszoftlab.R;
import mobsoft.vizelibalint.hu.mobszoftlab.ui.main.MainActivity;
import mobsoft.vizelibalint.hu.mobszoftlab.ui.register.RegisterActivity;

public class LoginActivity extends AppCompatActivity implements LoginScreen {

    @Inject
    LoginPresenter loginPresenter;

    @BindView(R.id.login_email_et)
    EditText login_email_et;

    @BindView(R.id.login_password_et)
    EditText login_password_et;

    LinearLayout login_layout;

    @OnClick(R.id.login_login_btn)
    void loginUser() {
        loginPresenter.login(login_email_et.getText().toString(), login_password_et.getText().toString());
        navigateToMainScreen();
    }

    @OnClick(R.id.login_register_btn)
    void navigateToRegistration() {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login_layout = (LinearLayout) findViewById(R.id.activity_login);
        ButterKnife.bind(this);
        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        loginPresenter.attachScreen(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        loginPresenter.detachScreen();
    }

    @Override
    protected void onStop() {
        super.onStop();
        loginPresenter.detachScreen();
    }

    private void navigateToMainScreen() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
