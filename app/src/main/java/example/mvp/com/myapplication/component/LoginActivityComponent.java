package example.mvp.com.myapplication.component;

import dagger.Component;
import dagger.Module;
import example.mvp.com.myapplication.LoginModule.LoginActivity;
import example.mvp.com.myapplication.LoginModule.LoginActivityModule;
import example.mvp.com.myapplication.SharedPreferences.SharedPreferencesModule;
import example.mvp.com.myapplication.retrofitApi.ApiModule;

/**
 * Created by Guest User on 9/27/2017.
 */

@Component(modules = {LoginActivityModule.class, ApiModule.class,SharedPreferencesModule.class})
public interface LoginActivityComponent {
    void inject(LoginActivity loginActivity);
}
