package mobsoft.vizelibalint.hu.mobszoftlab.ui.register;

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

public class RegisterActivity extends AppCompatActivity implements RegisterScreen {

    @Inject
    RegisterPresenter registerPresenter;

    @BindView(R.id.register_name_et)
    EditText register_name_et;

    @BindView(R.id.register_email_et)
    EditText register_email_et;

    @BindView(R.id.register_password_et)
    EditText register_password_et;

    @BindView(R.id.register_repassword_et)
    EditText register_repassword_et;

    LinearLayout register_layout;

    @OnClick(R.id.register_register_btn)
    void registerUser(){
        if (register_name_et.getText().toString().length() == 0) {
            register_name_et.setError("Name is required!");
            return;
        }
        if (register_password_et.getText().toString().length() == 0) {
            register_password_et.setError("Password is required!");
            return;
        }
        if (register_repassword_et.getText().toString().length() == 0) {
            register_repassword_et.setError("Re-Password is required!!");
            return;
        }
        if (!register_password_et.getText().toString().matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,}$")) {
            register_password_et.setError("Password is not strong enough! (6 char, 1 upper, 1 lower, 1 numeric)");
            return;
        }
        if (register_password_et.getText().toString().equals(register_repassword_et.getText().toString())) {
            registerPresenter.registerUser(register_name_et.getText().toString(), register_email_et.getText().toString(), register_password_et.getText().toString());
        } else {
            register_repassword_et.setError("Passwords do not match!");
            register_password_et.setError("Passwords do not match!");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        register_layout = (LinearLayout) findViewById(R.id.activity_register);
        ButterKnife.bind(this);
        MobSoftApplication.injector.inject(this);

        register_name_et.setText("Puhadisznó");
        register_email_et.setText("cicakutya@gmail.com");
        register_password_et.setText("Asd1234");
        register_repassword_et.setText("Asd1234");
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        registerPresenter.detachScreen();
    }

    @Override
    public void navigateBackToLogin() {
        finish();
    }
}
