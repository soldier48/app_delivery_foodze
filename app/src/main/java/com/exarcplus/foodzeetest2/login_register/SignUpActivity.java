package com.exarcplus.foodzeetest2.login_register;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.exarcplus.foodzeetest2.R;
import com.exarcplus.foodzeetest2.login_register.LoginActivity.LoginActivity;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        //go back to login page
        ImageButton backtologin = findViewById(R.id.backtologin);
        backtologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backtologin = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(backtologin);
            }
        });


//        //signup to foodzee
//        Button signup_to_foodzee = findViewById(R.id.signup_to_foodzee);
//        signup_to_foodzee.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent signup_to_foodzee = new Intent(SignUpActivity.this, LoginActivity.class);
//                startActivity(signup_to_foodzee);
//            }
//        });


        //go to login page
        TextView login_screen = findViewById(R.id.login_screen);
        login_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login_screen = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(login_screen);
            }
        });


    }
}
