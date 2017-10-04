package example.mvp.com.myapplication.LoginModule;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import example.mvp.com.myapplication.MainModule.MainActivity;
import example.mvp.com.myapplication.Presenter.LoginPresenter;
import example.mvp.com.myapplication.R;
import example.mvp.com.myapplication.SharedPreferences.MySharedPreferences;
import example.mvp.com.myapplication.SharedPreferences.SharedPreferencesModule;
import example.mvp.com.myapplication.UtilityClass.AppConstant;
import example.mvp.com.myapplication.component.DaggerLoginActivityComponent;
import example.mvp.com.myapplication.component.LoginActivityComponent;
import example.mvp.com.myapplication.model.LoginResponse;
import example.mvp.com.myapplication.retrofitApi.ApiModule;
import example.mvp.com.myapplication.retrofitApi.GitHubClient;
import retrofit2.Response;

/**
 * Created by Guest User on 9/26/2017.
 */

public class LoginActivity extends AppCompatActivity implements LoginActivityView{

    public final String API_BASE_URL = "https://studytutorial.in/";
    private EditText EtFirstName;
    private EditText EtLastName;
    private Button btnLogin;
    private ProgressDialog dialog;

    @Inject
    LoginPresenter loginPresenter;
    @Inject
    MySharedPreferences mySharedPreferences;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginActivityComponent loginActivityComponent = DaggerLoginActivityComponent.builder()
                .loginActivityModule(new LoginActivityModule(this))
                .apiModule(new ApiModule(API_BASE_URL))
                .sharedPreferencesModule(new SharedPreferencesModule(this))
                .build();
        loginActivityComponent.inject(this);

        dialog = new ProgressDialog(this);

        EtFirstName= (EditText) findViewById(R.id.EtFirstName);
        EtLastName= (EditText) findViewById(R.id.EtLastName);
        btnLogin= (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.loginBtnClick();
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        loginPresenter.setView();
        loginPresenter.getCurrentUser();
    }

    @Override
    public void showErrorMsg() {
        Toast.makeText(this,"First Name and Last Name not empty", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSucess(Response<LoginResponse> loginResponseResponse) {
        if(loginResponseResponse.isSuccessful()) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
        }else{
            Toast.makeText(this,"Some thing wrong", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void loginFailed() {
        Toast.makeText(this,"Invaild user name and password", Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getFirstName() {
        return EtFirstName.getText().toString().trim();
    }

    @Override
    public String getLastName() {
        return EtLastName.getText().toString().trim();
    }

    @Override
    public void showDialog() {
        dialog.setMessage("Loading Please Wait..");
        dialog.show();
    }

    @Override
    public void cancelDialog() {
        dialog.cancel();
    }

    @Override
    public void setFirstName(String fname) {
        EtFirstName.setText(fname);
    }

    @Override
    public void setLastName(String lname) {
        EtFirstName.setText(lname);
    }
}
