package com.exarcplus.foodzeetest2.NavDraw.TermsAndConditionsActivity;

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
import com.exarcplus.foodzeetest2.NavDraw.MyProfileActivity.MyProfileActivity;
import com.exarcplus.foodzeetest2.NavDraw.NotificationsActivity.NotificationsActivity;
import com.exarcplus.foodzeetest2.NavDraw.SupportActivity.SupportActivity;
import com.exarcplus.foodzeetest2.NavDraw.WishlistActivity.WishlistActivity;
import com.exarcplus.foodzeetest2.R;
import com.exarcplus.foodzeetest2.login_register.LoginActivity.LoginActivity;

public class TermsAndConditionsActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_terms_and_conditions);


        ///////NAV DRAW///////
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout_termsandconditions);
        navigationView = (NavigationView) findViewById(R.id.nav_view);

        // Navigation view header
        navHeader = navigationView.getHeaderView(0);
        txtName = (TextView) navHeader.findViewById(R.id.name);
        txtEmail = (TextView) navHeader.findViewById(R.id.email);
        imgNavHeaderBg = (ImageView) navHeader.findViewById(R.id.img_header_bg);
        imgProfile = (ImageView) navHeader.findViewById(R.id.img_profile);

        contentView = findViewById(R.id.frame_termsandconditions);


        // load nav menu header data
        loadNavHeader();


        //go to home activity
        TextView homenav = findViewById(R.id.nav_home);
        homenav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myordersnav = new Intent(TermsAndConditionsActivity.this, HomeActivity.class);
                startActivity(myordersnav);
                drawer.closeDrawers();
            }
        });

        //go to myorders activity
        TextView myordersnav = findViewById(R.id.nav_myorders);
        myordersnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent wishlistnav = new Intent(TermsAndConditionsActivity.this, MyOrdersActivity.class);
                startActivity(wishlistnav);
                drawer.closeDrawers();
            }
        });

        //go to wishlist activity
        TextView wishlistnav = findViewById(R.id.nav_wishlist);
        wishlistnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent wishlistnav = new Intent(TermsAndConditionsActivity.this, WishlistActivity.class);
                startActivity(wishlistnav);
                drawer.closeDrawers();
            }
        });

        //go to notifications activity
        TextView notificationnav = findViewById(R.id.nav_notifications);
        notificationnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent notificationnav = new Intent(TermsAndConditionsActivity.this, NotificationsActivity.class);
                startActivity(notificationnav);
                drawer.closeDrawers();
            }
        });

        //go to myprofile activity
        TextView myprofilenav = findViewById(R.id.nav_myprofile);
        myprofilenav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myprofilenav = new Intent(TermsAndConditionsActivity.this, MyProfileActivity.class);
                startActivity(myprofilenav);
                drawer.closeDrawers();
            }
        });

        //go to support activity
        TextView supportnav = findViewById(R.id.nav_support);
        supportnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent termsandconditionsnav = new Intent(TermsAndConditionsActivity.this, SupportActivity.class);
                startActivity(termsandconditionsnav);
                drawer.closeDrawers();
            }
        });

        //go to termsandconditions activity
        TextView termsandconditionsnav = findViewById(R.id.nav_termsandconditions);
        termsandconditionsnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.closeDrawers();
            }
        });

        //go to login page
        TextView logout = findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logout = new Intent(TermsAndConditionsActivity.this, LoginActivity.class);
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
                Intent notificationbutton = new Intent(TermsAndConditionsActivity.this, NotificationsActivity.class);
                startActivity(notificationbutton);
            }
        });
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
}
