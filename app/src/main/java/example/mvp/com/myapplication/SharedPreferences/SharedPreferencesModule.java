package example.mvp.com.myapplication.SharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Guest User on 9/28/2017.
 */
@Module
public class SharedPreferencesModule {
    private Context context;

    public SharedPreferencesModule(Context context) {
        this.context = context;
    }

    @Provides
    SharedPreferences provideSharedPreferences(){
        return  context.getSharedPreferences("PrefName",Context.MODE_PRIVATE);
    }
}
