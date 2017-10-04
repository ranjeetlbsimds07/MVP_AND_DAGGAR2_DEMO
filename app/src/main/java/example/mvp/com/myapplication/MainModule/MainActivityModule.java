package example.mvp.com.myapplication.MainModule;

import dagger.Module;
import dagger.Provides;
import example.mvp.com.myapplication.LoginModule.LoginActivity;
import example.mvp.com.myapplication.Presenter.MainPresenter;

/**
 * Created by Guest User on 9/27/2017.
 */
@Module
public class MainActivityModule {
    private MainActivity mainActivity;

    public MainActivityModule( MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides
    public MainActivity providerMainActivity(){
        return mainActivity;
    }
    @Provides
    public MainPresenter providerMainPresnter(MainActivity mainActivity){
        return new MainPresenter(mainActivity);
    }
}
