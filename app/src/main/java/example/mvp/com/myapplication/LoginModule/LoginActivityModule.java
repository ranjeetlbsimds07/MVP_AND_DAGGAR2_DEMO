package example.mvp.com.myapplication.LoginModule;

import dagger.Module;
import dagger.Provides;
import example.mvp.com.myapplication.Presenter.LoginPresenter;

/**
 * Created by Guest User on 9/27/2017.
 */

@Module
public class LoginActivityModule {
    private LoginActivity activity;

    public LoginActivityModule(LoginActivity activity) {
        this.activity = activity;
    }
/*
    @Provides
    public LoginPresenter provideLoginPresenter(LoginActivity activity){
        return new LoginPresenter(activity);
    }*/

    @Provides
    public LoginActivity provideLoginActivity(){
        return activity;
    }
}
