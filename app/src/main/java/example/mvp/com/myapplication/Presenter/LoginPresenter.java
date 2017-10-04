package example.mvp.com.myapplication.Presenter;

import android.widget.Toast;

import javax.inject.Inject;

import example.mvp.com.myapplication.LoginModule.LoginActivity;
import example.mvp.com.myapplication.LoginModule.LoginPresenterView;
import example.mvp.com.myapplication.SharedPreferences.MySharedPreferences;
import example.mvp.com.myapplication.UtilityClass.AppConstant;
import example.mvp.com.myapplication.model.LoginResponse;
import example.mvp.com.myapplication.retrofitApi.ApiInterface;
import example.mvp.com.myapplication.retrofitApi.GitHubClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Guest User on 9/27/2017.
 */

public class LoginPresenter implements LoginPresenterView {
    private static final String TAG =LoginPresenter.class.getName().toString();
    private LoginActivity view;
    private ApiInterface apiService;
    private GitHubClient gitHubClient;
    private LoginResponse loginResponse;
    private MySharedPreferences mySharedPreferences;
    @Inject
    public LoginPresenter(LoginActivity activity,GitHubClient gitHubClient, MySharedPreferences mySharedPreferences) {
        this.view = activity;
        this.gitHubClient = gitHubClient;
        this.mySharedPreferences = mySharedPreferences;
    }

    @Override
    public void loginBtnClick() {

        if(view !=null){
            if(view.getFirstName().equalsIgnoreCase("") || view.getLastName().equalsIgnoreCase("")){
                view.showErrorMsg();
            }else{
                /* view.showDialog();
                Call<List<GitHubRepo>> call = gitHubClient.reposForUser("ranjeetlbsimds07");
                call.enqueue(new Callback<List<GitHubRepo>>() {
                    @Override
                    public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                        List<GitHubRepo>  gitHubRepos = response.body();
                        view.cancelDialog();
                    }

                    @Override
                    public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
                        view.cancelDialog();
                    }
                });*/

                view.showDialog();
                //apiService = ApiClient.getClient().create(ApiInterface.class);
                Call<LoginResponse> call = gitHubClient.signIn(view.getFirstName(),view.getLastName());

                call.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        view.cancelDialog();
                        loginResponse = response.body();
                        mySharedPreferences.putData(AppConstant.INFO,loginResponse.getName().toString());
                        mySharedPreferences.putLast(AppConstant.LASTNAME,loginResponse.getEmail().toString());
                        view.loginSucess(response);
                        //Log.d(TAG, response.message());
                        //Toast.makeText(view,"SUCC"+response.message(),Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        view.cancelDialog();
                        view.loginFailed();
                    }
                });
            }

        }

    }

    @Override
    public void getCurrentUser() {
        Toast.makeText(view,"User Name=="+mySharedPreferences.getData(AppConstant.INFO),Toast.LENGTH_SHORT).show();
        if(loginResponse !=null){
            view.setFirstName(loginResponse.getName());
            view.setLastName(loginResponse.getEmail());
        }else{
            Toast.makeText(view,"Nothing Data",Toast.LENGTH_SHORT).show();
        }

    }


    public void setView() {
    }


}
