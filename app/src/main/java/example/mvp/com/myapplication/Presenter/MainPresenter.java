package example.mvp.com.myapplication.Presenter;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import example.mvp.com.myapplication.MainModule.MainActivity;
import example.mvp.com.myapplication.MainModule.MainPresenterView;
import example.mvp.com.myapplication.model.GitHubRepo;
import example.mvp.com.myapplication.model.LoginResponse;
import example.mvp.com.myapplication.retrofitApi.ApiClient;
import example.mvp.com.myapplication.retrofitApi.ApiInterface;
import example.mvp.com.myapplication.retrofitApi.GitHubClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Guest User on 7/5/2017.
 */

public class MainPresenter implements MainPresenterView {
    private static final String TAG = MainPresenter.class.getSimpleName();
    private MainActivity mainActivity;
    private GitHubClient gitHubClient;


    public MainPresenter(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }


    public void setView(GitHubClient gitHubClient) {
        this.gitHubClient = gitHubClient;
    }

    @Override
    public void fetchDetails() {
        mainActivity.showLoader();
        Call<List<GitHubRepo>> call = gitHubClient.reposForUser("ranjeetlbsimds07");

        call.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                mainActivity.cancelLoader();
                List<GitHubRepo>  gitHubRepos = response.body();
                mainActivity.displayList(gitHubRepos);
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
                mainActivity.cancelLoader();
                mainActivity.showErrorMsg();
            }
        });

        //Toast.makeText(mainActivity,"SUCC",Toast.LENGTH_SHORT).show();
    }


   /* public void netWorkCall() {
        pd = new ProgressDialog(mainActivity);
        pd.setMessage("loading");
        pd.show();


        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<List<GitHubRepo>> call = apiService.reposForUser("ranjeetlbsimds07");

        call.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                pd.cancel();
                List<GitHubRepo>  gitHubRepos = response.body();
                view.fetchGithubList(gitHubRepos);
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
                pd.cancel();
            }
        });



    }*/

   /* public void signIn() {
        pd = new ProgressDialog(mainActivity);
        pd.setMessage("Login loading");
        pd.show();
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<LoginResponse> call = apiService.signIn("novo1","1234");

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                pd.cancel();
                Log.d(TAG, response.message());
                Toast.makeText(mainActivity,"SUCC"+response.message(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                pd.cancel();
            }
        });
        //Call<String> call = apiService.reposForUsers();

        *//*
        Call<List<String>> call = apiService.getupdateDt();

        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                pd.cancel();
                Log.d(TAG, response.message());
                Toast.makeText(context,"SUCC"+response.message(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                pd.cancel();
                Toast.makeText(context,"FAIL"+call.toString(),Toast.LENGTH_SHORT).show();
            }
        });*//*

    }*/
/*
    public interface View {
        void fetchGithubList(List<GitHubRepo> gitHubRepos);
    }*/
}
