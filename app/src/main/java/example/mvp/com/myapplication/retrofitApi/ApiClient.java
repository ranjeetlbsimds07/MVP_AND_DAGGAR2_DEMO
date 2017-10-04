package example.mvp.com.myapplication.retrofitApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Guest User on 9/23/2017.
 */

public class ApiClient {
    //public static final String BASE_URL = "http://api.themoviedb.org/3/";
    //public static final String BASE_URL = "https://api.github.com/";
    //public static final String BASE_URL = "http://192.168.0.63/demo/";
    public static final String BASE_URL = "https://studytutorial.in/";
    //public static final String BASE_URL = "https://devsecure.marylandhealthconnection.gov/MHC/public/services/providerservice/";
    private static Retrofit retrofit = null;
    public static String API_KEY = "";

    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
