package example.mvp.com.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Guest User on 9/25/2017.
 */

public class Post {
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("pwd")
    @Expose
    private String pwd;

}
