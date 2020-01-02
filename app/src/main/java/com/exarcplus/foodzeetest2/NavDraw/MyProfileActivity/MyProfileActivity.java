package com.exarcplus.foodzeetest2.NavDraw.MyProfileActivity;

import android.content.Intent;
import android.graphics.Color;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.HomeActivity;
import com.exarcplus.foodzeetest2.NavDraw.MyOrdersActivity.MyOrdersActivity;
import com.exarcplus.foodzeetest2.NavDraw.MyProfileActivity.MyProfileEditActivity.GlideApp;
import com.exarcplus.foodzeetest2.NavDraw.MyProfileActivity.MyProfileEditActivity.MyProfileEditActivity;
import com.exarcplus.foodzeetest2.NavDraw.NotificationsActivity.NotificationsActivity;
import com.exarcplus.foodzeetest2.NavDraw.SupportActivity.SupportActivity;
import com.exarcplus.foodzeetest2.NavDraw.TermsAndConditionsActivity.TermsAndConditionsActivity;
import com.exarcplus.foodzeetest2.NavDraw.WishlistActivity.WishlistActivity;
import com.exarcplus.foodzeetest2.R;
import com.exarcplus.foodzeetest2.login_register.LoginActivity.LoginActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyProfileActivity extends AppCompatActivity {

///////NAV DRAW///////
    private NavigationView navigationView;
    private DrawerLayout drawer;
    private View navHeader;
    private ImageView imgNavHeaderBg, imgProfile;
    private TextView txtName, txtEmail;

    private static final float END_SCALE = 0.7f;
    private View contentView;
///////NAV DRAW///////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        TextView usernameprofile = (TextView) findViewById(R.id.username_profile);
        TextView emailprofile = (TextView) findViewById(R.id.email_profile);
        TextView mobilenumberprofile = (TextView) findViewById(R.id.mobile_profile);
        TextView myaddressprofile = (TextView) findViewById(R.id.address_profile);

///////NAV DRAW///////
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout_myprofile);
        navigationView = (NavigationView) findViewById(R.id.nav_view);

        // Navigation view header
        navHeader = navigationView.getHeaderView(0);
        txtName = (TextView) navHeader.findViewById(R.id.name);
        txtEmail = (TextView) navHeader.findViewById(R.id.email);
        imgNavHeaderBg = (ImageView) navHeader.findViewById(R.id.img_header_bg);
        imgProfile = (ImageView) navHeader.findViewById(R.id.img_profile);

        contentView = findViewById(R.id.frame_myprofile);

        // load nav menu header data
        loadNavHeader();


        //go to home activity
        TextView homenav = findViewById(R.id.nav_home);
        homenav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myordersnav = new Intent(MyProfileActivity.this, HomeActivity.class);
                startActivity(myordersnav);
                drawer.closeDrawers();
            }
        });

        //go to myorders activity
        TextView myordersnav = findViewById(R.id.nav_myorders);
        myordersnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent wishlistnav = new Intent(MyProfileActivity.this, MyOrdersActivity.class);
                startActivity(wishlistnav);
                drawer.closeDrawers();
            }
        });

        //go to wishlist activity
        TextView wishlistnav = findViewById(R.id.nav_wishlist);
        wishlistnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent wishlistnav = new Intent(MyProfileActivity.this, WishlistActivity.class);
                startActivity(wishlistnav);
                drawer.closeDrawers();
            }
        });

        //go to notifications activity
        TextView notificationnav = findViewById(R.id.nav_notifications);
        notificationnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent notificationnav = new Intent(MyProfileActivity.this, NotificationsActivity.class);
                startActivity(notificationnav);
                drawer.closeDrawers();
            }
        });

        //go to myprofile activity
        TextView myprofilenav = findViewById(R.id.nav_myprofile);
        myprofilenav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.closeDrawers();
            }
        });

        //go to support activity
        TextView supportnav = findViewById(R.id.nav_support);
        supportnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent supportnav = new Intent(MyProfileActivity.this, SupportActivity.class);
                startActivity(supportnav);
                drawer.closeDrawers();
            }
        });

        //go to termsandconditions activity
        TextView termsandconditionsnav = findViewById(R.id.nav_termsandconditions);
        termsandconditionsnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent termsandconditionsnav = new Intent(MyProfileActivity.this, TermsAndConditionsActivity.class);
                startActivity(termsandconditionsnav);
                drawer.closeDrawers();
            }
        });

        //go to login page
        TextView logout = findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logout = new Intent(MyProfileActivity.this, LoginActivity.class);
                startActivity(logout);
            }
        });


        drawer.setScrimColor(Color.TRANSPARENT);
        drawer.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }

        });


///////NAV DRAW///////


        //go to edit profile page
        ImageButton editmyprofile = findViewById(R.id.editmyprofile);
        editmyprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent editmyprofile = new Intent(MyProfileActivity.this, MyProfileEditActivity.class);

//                editmyprofile.putExtra("Username",usernameprofile.getText().toString());
//                editmyprofile.putExtra("Email",emailprofile.getText().toString());
//                editmyprofile.putExtra("Mobile_Number",mobilenumberprofile.getText().toString());
//                editmyprofile.putExtra("Address",myaddressprofile.getText().toString());

                startActivity(editmyprofile);
                finish();

            }
        });

        //Calling navdraw fragment with button
        ImageView menubutton = (ImageView) findViewById(R.id.nav_draw_button);
        menubutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(Gravity.START);
            }
        });

        //Calling notifications with button
        ImageButton notificationbutton = (ImageButton) findViewById(R.id.notifications_button);
        notificationbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent notificationbutton = new Intent(MyProfileActivity.this, NotificationsActivity.class);
                startActivity(notificationbutton);
            }
        });


        TextView username_profile = findViewById(R.id.username_profile);
        String username = getIntent().getStringExtra("Username");
        if(username!=null && !username.equals("")){
            username_profile.setText(username);
        }

        TextView email_profile = findViewById(R.id.email_profile);
        String email = getIntent().getStringExtra("Email");
        if(email!=null && !email.equals("")){
            email_profile.setText(email);
        }

        TextView mobile_profile = findViewById(R.id.mobile_profile);
        String mobile = getIntent().getStringExtra("Mobile_Number");
        if(mobile!=null && !mobile.equals("")){
            mobile_profile.setText("+91 " + mobile);
        }

        TextView address_profile = findViewById(R.id.address_profile);
        String address = getIntent().getStringExtra("Address");
        if(address!=null && !address.equals("")){
            address_profile.setText(address);
        }

        CircleImageView img_profile = findViewById(R.id.img_profile);
        String profile = getIntent().getStringExtra("Profile");
        if(profile!=null && !profile.equals("")){
            Intent intent = getIntent();
            GlideApp.with(this).load(profile)
                    .into(img_profile);
//            img_profile.setText(profile);
        //    img_profile.setImageResource(intent.getIntExtra("Profile", 0));

        }


    }


////////NAV DRAW////////
    private void loadNavHeader() {
        txtName.setText("Andrew Khremer");
        txtEmail.setText("andrew234@gmail.com");
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawers();
            return;
        }
        super.onBackPressed();
    }

////////NAV DRAW////////

////////SHARE APP/////////Using obnClick
    public void shareText(View view) {
        Intent intent = new Intent(android.content.Intent.ACTION_SEND);
        intent.setType("text/plain");
        String shareBodyText = "SHARE FOODZEE APP... GO DOWNLOAD IN PLAYSTORE IF AVAILABLE...MAYBE...";
        intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject/Title");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, shareBodyText);
        startActivity(Intent.createChooser(intent, "Choose sharing method"));
    }
////////SHARE APP/////////


}
