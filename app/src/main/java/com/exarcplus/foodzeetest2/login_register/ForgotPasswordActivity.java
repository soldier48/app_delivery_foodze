package com.exarcplus.foodzeetest2.login_register;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.exarcplus.foodzeetest2.R;
import com.exarcplus.foodzeetest2.login_register.LoginActivity.LoginActivity;

public class ForgotPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);


        //go back to login page
        ImageButton backtologin = findViewById(R.id.backtologin);
        backtologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backtologin = new Intent(ForgotPasswordActivity.this, LoginActivity.class);
                startActivity(backtologin);
            }
        });


//        //resend email
//        Button resend_mail = findViewById(R.id.resend_email);
//        resend_mail.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent resend_mail = new Intent(ForgotPasswordActivity.this, LoginActivity.class);
//                startActivity(resend_mail);
//            }
//        });
//

//        //submit email address
//        Button submit_forgot_password = findViewById(R.id.submit_forgot_password);
//        submit_forgot_password.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent submit_forgot_password = new Intent(ForgotPasswordActivity.this, LoginActivity.class);
//                startActivity(submit_forgot_password);
//            }
//        });
    }
}
