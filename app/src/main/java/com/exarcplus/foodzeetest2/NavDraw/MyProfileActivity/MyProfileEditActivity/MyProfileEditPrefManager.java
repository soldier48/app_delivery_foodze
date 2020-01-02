package com.exarcplus.foodzeetest2.NavDraw.MyProfileActivity.MyProfileEditActivity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Class for Shared Preference
 */
public class MyProfileEditPrefManager {

    Context context;

    MyProfileEditPrefManager(Context context) {
        this.context = context;
    }

    public void saveMyProfileEditDetails(String username, String email, String mobilenumber, String address) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("MyProfileEditDetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Username", username);
        editor.putString("Email", email);
        editor.putString("Mobile_Number", mobilenumber);
        editor.putString("Address", address);
        editor.commit();
    }

}