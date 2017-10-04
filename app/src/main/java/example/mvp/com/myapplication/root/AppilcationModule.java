package example.mvp.com.myapplication.root;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Guest User on 9/26/2017.
 */
@Module
public class AppilcationModule {
    private Application application;

    public AppilcationModule(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    public Context provideContext(){
        return application;
    }
}
