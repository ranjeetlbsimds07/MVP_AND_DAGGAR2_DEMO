package example.mvp.com.myapplication.root;

import javax.inject.Singleton;

import dagger.Component;
import example.mvp.com.myapplication.LoginModule.LoginActivity;

/**
 * Created by Guest User on 9/26/2017.
 */
@Singleton
@Component(modules = {AppilcationModule.class})
public interface ApplicationComponent {
    //void inject(LoginActivity target);
    void inject(App app);
}
