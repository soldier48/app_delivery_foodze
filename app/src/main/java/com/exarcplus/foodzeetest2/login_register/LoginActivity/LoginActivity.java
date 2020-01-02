package com.exarcplus.foodzeetest2.login_register.LoginActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.MyCart.Checkout.CheckoutStep1Activity;
import com.exarcplus.foodzeetest2.R;
import com.exarcplus.foodzeetest2.login_register.ForgotPasswordActivity;
import com.exarcplus.foodzeetest2.login_register.SignUpActivity;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {


    private EditText mEmailView;
    private EditText mPasswordView;

    SharedPreferences sharedpreferences;
    EditText email;
    EditText password;

    public static final String mypreference = "mypref";
    public static final String Email = "emailKey";
    public static final String Password = "passwordKey";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

////////////SHARED PREFERENCE////////////START


        mEmailView = (EditText) findViewById(R.id.email_login);
        mPasswordView = (EditText) findViewById(R.id.password_login);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        Button mEmailSignInButton = (Button) findViewById(R.id.login_to_foodzee);
        mEmailSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });


        email = (EditText) findViewById(R.id.email_login);
        password = (EditText) findViewById(R.id.password_login);
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        if (sharedpreferences.contains(Email)) {
            email.setText(sharedpreferences.getString(Email, ""));
        }
        if (sharedpreferences.contains(Password)) {
            password.setText(sharedpreferences.getString(Password, ""));
        }


////////////SHARED PREFERENCE////////////END


        //go to forgot password page
        TextView forgot_password = findViewById(R.id.forgot_password);
        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent forgot_password = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(forgot_password);
            }
        });


        //go to signup page
        TextView signup_screen = findViewById(R.id.signup_screen);
        signup_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signup_screen = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(signup_screen);
            }
        });


    }

////////////SHARED PREFERENCE////////////

    public void Save(View view) {
        String e = email.getText().toString();
        String n = password.getText().toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Email, e);
        editor.putString(Password, n);
        editor.commit();
    }

    public void clear(View view) {
        email = (EditText) findViewById(R.id.email_login);
        password = (EditText) findViewById(R.id.password_login);
        email.setText("");
        password.setText("");


    }

    public void Get(View view) {
        email = (EditText) findViewById(R.id.email_login);
        password = (EditText) findViewById(R.id.password_login);
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);


        if (sharedpreferences.contains(Email)) {
            email.setText(sharedpreferences.getString(Email, ""));
        }

        if (sharedpreferences.contains(Password)) {
            password.setText(sharedpreferences.getString(Password, ""));
        }

    }

    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {

        // Reset errors.
        mEmailView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            mEmailView.setError(getString(R.string.error_invalid_email));
            focusView = mEmailView;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
//            // save data in local shared preferences
//            if (checkBoxRememberMe.isChecked())
                saveLoginDetails(email, password);
            startCheckoutStep1Activity();
        }



    }


    private void startCheckoutStep1Activity() {
        Intent intent = new Intent(this, CheckoutStep1Activity.class);
        startActivity(intent);
        finish();
    }

    private void saveLoginDetails(String email, String password) {
        new LoginPrefManager(this).saveLoginDetails(email, password);
    }


    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return Pattern.compile("(?=.*[a-zA-Z])(?=.*[0-9]).{8,12}").matcher(password).matches();

    }




}
