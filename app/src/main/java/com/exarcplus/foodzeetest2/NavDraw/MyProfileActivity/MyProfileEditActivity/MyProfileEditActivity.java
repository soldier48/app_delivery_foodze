package com.exarcplus.foodzeetest2.NavDraw.MyProfileActivity.MyProfileEditActivity;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.exarcplus.foodzeetest2.NavDraw.MyProfileActivity.MyProfileActivity;
import com.exarcplus.foodzeetest2.R;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class MyProfileEditActivity extends AppCompatActivity {


    private EditText mUserNameView;
    private EditText mEmailView;
    private EditText mMobileNumberView;
    private EditText mMyAddressView;

    private CircleImageView proPic;

    SharedPreferences sharedpreferences;
    EditText username;
    EditText email;
    EditText mobilenumber;
    EditText myaddress;
    String pic_url="";
    public static final String mypreference = "mypref";
    public static final String Username = "usernameKey";
    public static final String Email = "emailKey";
    public static final String Mobile_Number = "mobileKey";
    public static final String My_Address = "addressKey";


    ///// profile image update /////
    private static final String TAG = MyProfileEditActivity.class.getSimpleName();
    public static final int REQUEST_IMAGE = 100;

    @BindView(R.id.img_profileedited)
    ImageView imgProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile_edit);

//////////SHARED PREFERENCE////////////START

        mUserNameView = (EditText) findViewById(R.id.username_edit);
        mEmailView = (EditText) findViewById(R.id.email_edit);
        mMobileNumberView = (EditText) findViewById(R.id.mobile_edit);
        mMyAddressView = (EditText) findViewById(R.id.address_edit);

//        proPic = (CircleImageView) findViewById(R.id.img_profile);
//        proPic.setImageResource(R.drawable.navdraw_profile);


        //Calling previous page
        ImageView back = (ImageView) findViewById(R.id.backtopreviouspage);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        Button updateprofile = (Button) findViewById(R.id.update_profile);
        updateprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptUpdate();

             /*   Bundle bundle = new Bundle();
               bundle.putString("username",mUserNameView.getText().toString());*/


               MyProfileActivity myProfileActivity = new MyProfileActivity();


            }
        });


        username = (EditText) findViewById(R.id.username_edit);
        email = (EditText) findViewById(R.id.email_edit);
        mobilenumber = (EditText) findViewById(R.id.mobile_edit);
        myaddress = (EditText) findViewById(R.id.address_edit);
        proPic = (CircleImageView) findViewById(R.id.img_profileedited);

        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        if (sharedpreferences.contains(Username)) {
            username.setText(sharedpreferences.getString(Username, ""));
        }
        if (sharedpreferences.contains(Email)) {
            email.setText(sharedpreferences.getString(Email, ""));
        }
        if (sharedpreferences.contains(Mobile_Number)) {
            mobilenumber.setText(sharedpreferences.getString(Mobile_Number, ""));
        }
        if (sharedpreferences.contains(My_Address)) {
            myaddress.setText(sharedpreferences.getString(My_Address, ""));
        }


        ///// profile image update continued...../////

        ButterKnife.bind(this);

        loadProfileDefault();

        ImagePickerActivity.clearCache(this);


    }

////////////SHARED PREFERENCE////////////

    public void Save(View view) {
        String u = username.getText().toString();
        String e = email.getText().toString();
        String m = mobilenumber.getText().toString();
        String a = myaddress.getText().toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Username, u);
        editor.putString(Email, e);
        editor.putString(Mobile_Number, m);
        editor.putString(My_Address, a);
        editor.commit();
    }

    public void clear(View view) {
        username = (EditText) findViewById(R.id.username_edit);
        email = (EditText) findViewById(R.id.email_edit);
        mobilenumber = (EditText) findViewById(R.id.mobile_edit);
        myaddress = (EditText) findViewById(R.id.address_edit);
        username.setText("");
        email.setText("");
        mobilenumber.setText("");
        myaddress.setText("");


    }

    public void Get(View view) {
        username = (EditText) findViewById(R.id.username_edit);
        email = (EditText) findViewById(R.id.email_edit);
        mobilenumber = (EditText) findViewById(R.id.mobile_edit);
        myaddress = (EditText) findViewById(R.id.address_edit);
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);


        if (sharedpreferences.contains(Username)) {
            username.setText(sharedpreferences.getString(Username, ""));
        }
        if (sharedpreferences.contains(Email)) {
            email.setText(sharedpreferences.getString(Email, ""));
        }
        if (sharedpreferences.contains(Mobile_Number)) {
            mobilenumber.setText(sharedpreferences.getString(Mobile_Number, ""));
        }
        if (sharedpreferences.contains(My_Address)) {
            myaddress.setText(sharedpreferences.getString(My_Address, ""));
        }

    }

    private void attemptUpdate() {

        // Reset errors.
        mUserNameView.setError(null);
        mEmailView.setError(null);
        mMobileNumberView.setError(null);
        mMyAddressView.setError(null);

        // Store values at the time of the login attempt.
        String username = mUserNameView.getText().toString();
        String email = mEmailView.getText().toString();
        String mobilenumber = mMobileNumberView.getText().toString();
        String address = mMyAddressView.getText().toString();

        boolean cancel = false;
        View focusView = null;


        // Check for a valid username, if the user entered one.
        if (!TextUtils.isEmpty(username) && !isUsernameValid(username)) {
            mUserNameView.setError(getString(R.string.error_invalid_username));
            focusView = mUserNameView;
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


        // Check for a valid mobilenumber, if the user entered one.
        if (!TextUtils.isEmpty(mobilenumber) && !isMobileNumberValid(mobilenumber)) {
            mMobileNumberView.setError(getString(R.string.error_invalid_mobile_number));
            focusView = mMobileNumberView;
            cancel = true;
        }

        // Check for a valid address, if the user entered one.
        if (!TextUtils.isEmpty(address) && !isMyAddressValid(address)) {
            mMyAddressView.setError(getString(R.string.error_invalid_address));
            focusView = mMyAddressView;
            cancel = true;
        }



        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
//            // save data in local shared preferences
//            if (checkBoxRememberMe.isChecked())
            saveLoginDetails(username, email, mobilenumber, address);
            startMyProfileActivity();
        }



    }


    private void startMyProfileActivity() {
        Intent intent = new Intent(this, MyProfileActivity.class);
        intent.putExtra("Username",username.getText().toString());
        intent.putExtra("Email",email.getText().toString());
        intent.putExtra("Mobile_Number",mobilenumber.getText().toString());
        intent.putExtra("Address",myaddress.getText().toString());
        intent.putExtra("Profile",pic_url);
        startActivity(intent);
        finish();
    }

    private void saveLoginDetails(String username, String email, String mobilenumber, String address) {
        new MyProfileEditPrefManager(this).saveMyProfileEditDetails(username, email, mobilenumber, address);
    }


    private boolean isUsernameValid(String username) {
        //TODO: Replace this with your own logic
        return username.length() > 4;
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isMobileNumberValid(String mobilenumber) {
        //TODO: Replace this with your own logic
        return Pattern.compile("(?=.*[0-9]).{10}").matcher(mobilenumber).matches();

    }

    private boolean isMyAddressValid(String myaddress) {
        //TODO: Replace this with your own logic
        return myaddress.length() > 4;

    }


    ///// profile image update continued...../////


    private void loadProfile(String url) {
        Log.d(TAG, "Image cache path: " + url);
        pic_url = url;
        GlideApp.with(this).load(url)
                .into(imgProfile);
        imgProfile.setColorFilter(ContextCompat.getColor(this, android.R.color.transparent));
    }

    private void loadProfileDefault() {
        GlideApp.with(this).load(R.drawable.navdraw_profile)
                .into(imgProfile);
//        imgProfile.setColorFilter(ContextCompat.getColor(this, R.color.profile_default_tint));
    }

    @OnClick({R.id.addprofileimage, R.id.img_profileedited})
    void onProfileImageClick() {
        Dexter.withActivity(this)
                .withPermissions(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        if (report.areAllPermissionsGranted()) {
                            showImagePickerOptions();
                        }

                        if (report.isAnyPermissionPermanentlyDenied()) {
                            showSettingsDialog();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).check();
    }

//    @OnClick({R.id.addbgimage, R.id.img_bg})
//    void onProfileImageClick() {
//        Dexter.withActivity(this)
//                .withPermissions(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE)
//                .withListener(new MultiplePermissionsListener() {
//                    @Override
//                    public void onPermissionsChecked(MultiplePermissionsReport report) {
//                        if (report.areAllPermissionsGranted()) {
//                            showImagePickerOptions();
//                        }
//
//                        if (report.isAnyPermissionPermanentlyDenied()) {
//                            showSettingsDialog();
//                        }
//                    }
//
//                    @Override
//                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
//                        token.continuePermissionRequest();
//                    }
//                }).check();
//    }

    private void showImagePickerOptions() {
        ImagePickerActivity.showImagePickerOptions(this, new ImagePickerActivity.PickerOptionListener() {
            @Override
            public void onTakeCameraSelected() {
                launchCameraIntent();
            }

            @Override
            public void onChooseGallerySelected() {
                launchGalleryIntent();
            }
        });
    }

    private void launchCameraIntent() {
        Intent intent = new Intent(MyProfileEditActivity.this, ImagePickerActivity.class);
        intent.putExtra(ImagePickerActivity.INTENT_IMAGE_PICKER_OPTION, ImagePickerActivity.REQUEST_IMAGE_CAPTURE);

        // setting aspect ratio
        intent.putExtra(ImagePickerActivity.INTENT_LOCK_ASPECT_RATIO, true);
        intent.putExtra(ImagePickerActivity.INTENT_ASPECT_RATIO_X, 1); // 16x9, 1x1, 3:4, 3:2
        intent.putExtra(ImagePickerActivity.INTENT_ASPECT_RATIO_Y, 1);

        // setting maximum bitmap width and height
        intent.putExtra(ImagePickerActivity.INTENT_SET_BITMAP_MAX_WIDTH_HEIGHT, true);
        intent.putExtra(ImagePickerActivity.INTENT_BITMAP_MAX_WIDTH, 1000);
        intent.putExtra(ImagePickerActivity.INTENT_BITMAP_MAX_HEIGHT, 1000);

        startActivityForResult(intent, REQUEST_IMAGE);
    }

    private void launchGalleryIntent() {
        Intent intent = new Intent(MyProfileEditActivity.this, ImagePickerActivity.class);
        intent.putExtra(ImagePickerActivity.INTENT_IMAGE_PICKER_OPTION, ImagePickerActivity.REQUEST_GALLERY_IMAGE);

        // setting aspect ratio
        intent.putExtra(ImagePickerActivity.INTENT_LOCK_ASPECT_RATIO, true);
        intent.putExtra(ImagePickerActivity.INTENT_ASPECT_RATIO_X, 1); // 16x9, 1x1, 3:4, 3:2
        intent.putExtra(ImagePickerActivity.INTENT_ASPECT_RATIO_Y, 1);
        startActivityForResult(intent, REQUEST_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_IMAGE) {
            if (resultCode == Activity.RESULT_OK) {
                Uri uri = data.getParcelableExtra("path");
                try {
                    // You can update this bitmap to your server
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);

                    // loading profile image from local cache
                    loadProfile(uri.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Showing Alert Dialog with Settings option
     * Navigates user to app settings
     * NOTE: Keep proper title and message depending on your app
     */
    private void showSettingsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MyProfileEditActivity.this);
        builder.setTitle(getString(R.string.dialog_permission_title));
        builder.setMessage(getString(R.string.dialog_permission_message));
        builder.setPositiveButton(getString(R.string.go_to_settings), (dialog, which) -> {
            dialog.cancel();
            openSettings();
        });
        builder.setNegativeButton(getString(android.R.string.cancel), (dialog, which) -> dialog.cancel());
        builder.show();

    }

    // navigating user to app settings
    private void openSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", getPackageName(), null);
        intent.setData(uri);
        startActivityForResult(intent, 101);
    }




}
