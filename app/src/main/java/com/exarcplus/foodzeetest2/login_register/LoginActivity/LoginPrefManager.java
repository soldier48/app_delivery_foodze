package com.exarcplus.foodzeetest2.login_register.LoginActivity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Class for Shared Preference
 */
public class LoginPrefManager {

    Context context;

    LoginPrefManager(Context context) {
        this.context = context;
    }

    public void saveLoginDetails(String email, String password) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Email", email);
        editor.putString("Password", password);
        editor.commit();
    }

}