package com.exarcplus.foodzeetest2.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

import com.exarcplus.foodzeetest2.R;
import com.exarcplus.foodzeetest2.login_register.PreLoginActivity;

public class SplashScreenActivity extends AppCompatActivity {

    //Splash Screen
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this, PreLoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);

    }

}
