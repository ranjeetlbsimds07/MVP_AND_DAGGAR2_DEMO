package example.mvp.com.myapplication.LoginModule;

import example.mvp.com.myapplication.model.LoginResponse;
import retrofit2.Response;

/**
 * Created by Guest User on 9/27/2017.
 */

public interface LoginActivityView {
    void showErrorMsg();
    void loginSucess(Response<LoginResponse> loginResponseResponse);
    void loginFailed();

    String getFirstName();
    String getLastName();
    void showDialog();
    void cancelDialog();

    void setFirstName(String fname);
    void setLastName(String lname);


}
