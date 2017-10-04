package example.mvp.com.myapplication.retrofitApi;

import java.util.List;

import example.mvp.com.myapplication.model.GitHubRepo;
import example.mvp.com.myapplication.model.LoginResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Guest User on 9/27/2017.
 */

public interface GitHubClient {
    @GET("/users/{user}/repos")
    Call<List<GitHubRepo>> reposForUser(
            @Path("user") String user
    );

    @POST("post.php")
    @FormUrlEncoded
    Call<LoginResponse> signIn(@Field("name") String name,
                               @Field("email") String email);
}
