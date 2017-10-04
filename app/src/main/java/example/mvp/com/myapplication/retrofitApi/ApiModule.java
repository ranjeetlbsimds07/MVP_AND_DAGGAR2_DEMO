package example.mvp.com.myapplication.retrofitApi;

import dagger.Module;
import dagger.Provides;
import example.mvp.com.myapplication.LoginModule.LoginActivity;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Guest User on 9/27/2017.
 */
@Module
public class ApiModule {
    //public final String API_BASE_URL = "https://api.github.com/";
    //public final String API_BASE_URL = "https://studytutorial.in/";
    private String API_BASE_URL;


    public ApiModule(String API_BASE_URL) {
        this.API_BASE_URL = API_BASE_URL;
    }

    @Provides
    public OkHttpClient provideClient(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
    }

    @Provides
    public Retrofit provideRetrofit(String baseUrl, OkHttpClient client){
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    public  GitHubClient gitHubClient(){
        return provideRetrofit(API_BASE_URL, provideClient()).create(GitHubClient.class);
    }
}
