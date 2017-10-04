package example.mvp.com.myapplication.MainModule;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import example.mvp.com.myapplication.Presenter.MainPresenter;
import example.mvp.com.myapplication.R;
import example.mvp.com.myapplication.SharedPreferences.MySharedPreferences;
import example.mvp.com.myapplication.SharedPreferences.SharedPreferencesModule;
import example.mvp.com.myapplication.UtilityClass.AppConstant;
import example.mvp.com.myapplication.adapters.PostsAdapter;
import example.mvp.com.myapplication.component.DaggerMainActivityComponent;
import example.mvp.com.myapplication.component.MainActivityComponent;
import example.mvp.com.myapplication.model.GitHubRepo;
import example.mvp.com.myapplication.retrofitApi.ApiModule;
import example.mvp.com.myapplication.retrofitApi.GitHubClient;

public class MainActivity extends AppCompatActivity implements MainActivityView{
    private static final String TAG = "MainActivity";
    public String API_BASE_URL = "https://api.github.com/";

    private RecyclerView rv_posts;
    @Inject
    MainPresenter mainPresenter;
    @Inject
    GitHubClient gitHubClient;

    private ProgressDialog dialog;
    private PostsAdapter postsAdapter;
    private ArrayList<GitHubRepo> gitHubArrayList;
    private TextView txtName;
    @Inject
    MySharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_posts = (RecyclerView) findViewById(R.id.rv_posts);
        txtName = (TextView) findViewById(R.id.txtName);

        MainActivityComponent mainActivityComponent= DaggerMainActivityComponent.builder()
                .mainActivityModule(new MainActivityModule(this))
                .apiModule(new ApiModule(API_BASE_URL))
                .sharedPreferencesModule(new SharedPreferencesModule(this))
                .build();
        mainActivityComponent.inject(this);
        gitHubArrayList = new ArrayList<>();
        //ButterKnife.bind(this);
        dialog = new ProgressDialog(this);
        mainPresenter.setView(gitHubClient);
        mainPresenter.fetchDetails();
        txtName.setText(mSharedPreferences.getData(AppConstant.INFO)+"=="+mSharedPreferences.getLast(AppConstant.LASTNAME));


    }

    @Override
    public void displayList(List<GitHubRepo> gitHubRepos) {
        Log.d(TAG, gitHubRepos.toString());
        for (int i = 0; i< gitHubRepos.size(); i++){
            gitHubArrayList.add(gitHubRepos.get(i));
        }
        rv_posts.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        postsAdapter = new PostsAdapter(this,gitHubArrayList);
        rv_posts.setAdapter(postsAdapter);

    }

    @Override
    public void showErrorMsg() {

    }

    @Override
    public void showLoader() {
        dialog.setMessage("Loading Please Wait..");
        dialog.show();
    }

    @Override
    public void cancelLoader() {
        dialog.cancel();
    }
}
