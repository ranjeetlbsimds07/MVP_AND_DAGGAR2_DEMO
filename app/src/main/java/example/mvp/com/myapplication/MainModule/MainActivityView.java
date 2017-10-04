package example.mvp.com.myapplication.MainModule;

import java.util.List;

import example.mvp.com.myapplication.model.GitHubRepo;

/**
 * Created by Guest User on 9/27/2017.
 */

public interface MainActivityView {
    void displayList(List<GitHubRepo> gitHubRepos);
    void showErrorMsg();
    void showLoader();
    void cancelLoader();
}
