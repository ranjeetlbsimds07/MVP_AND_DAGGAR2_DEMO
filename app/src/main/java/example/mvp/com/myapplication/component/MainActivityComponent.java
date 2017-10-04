package example.mvp.com.myapplication.component;

import dagger.Component;
import example.mvp.com.myapplication.MainModule.MainActivity;
import example.mvp.com.myapplication.MainModule.MainActivityModule;
import example.mvp.com.myapplication.SharedPreferences.SharedPreferencesModule;
import example.mvp.com.myapplication.retrofitApi.ApiModule;

/**
 * Created by Guest User on 9/27/2017.
 */
@Component (modules = {MainActivityModule.class, ApiModule.class, SharedPreferencesModule.class})
public interface MainActivityComponent {
    void inject(MainActivity mainActivity);
}
