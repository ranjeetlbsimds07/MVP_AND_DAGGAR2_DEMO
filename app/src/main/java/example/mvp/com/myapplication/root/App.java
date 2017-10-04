package example.mvp.com.myapplication.root;

import android.app.Application;


/**
 * Created by Guest User on 9/26/2017.
 */

public class App extends Application {
    private ApplicationComponent component;
    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApplicationComponent.builder()
                .appilcationModule(new AppilcationModule(this))
                .build();
    }

    public ApplicationComponent applicationComponent(){
        return component;
    }
}
