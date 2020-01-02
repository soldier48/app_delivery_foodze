package com.exarcplus.foodzeetest2.NavDraw.WishlistActivity;

import android.content.Intent;
import android.graphics.Color;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.HomeActivity;
import com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.MyCart.MyCartActivity;
import com.exarcplus.foodzeetest2.NavDraw.MyOrdersActivity.MyOrdersActivity;
import com.exarcplus.foodzeetest2.NavDraw.MyProfileActivity.MyProfileActivity;
import com.exarcplus.foodzeetest2.NavDraw.NotificationsActivity.NotificationsActivity;
import com.exarcplus.foodzeetest2.NavDraw.SupportActivity.SupportActivity;
import com.exarcplus.foodzeetest2.NavDraw.TermsAndConditionsActivity.TermsAndConditionsActivity;
import com.exarcplus.foodzeetest2.R;
import com.exarcplus.foodzeetest2.login_register.LoginActivity.LoginActivity;

import java.util.ArrayList;

public class WishlistActivity extends AppCompatActivity {

///////NAV DRAW///////
    private NavigationView navigationView;
    private DrawerLayout drawer;
    private View navHeader;
    private ImageView imgNavHeaderBg, imgProfile;
    private TextView txtName, txtEmail;

    private static final float END_SCALE = 0.7f;
    private View contentView;
///////NAV DRAW///////

    RecyclerView recyclerView;
    ArrayList<WishlistModel> wishlistModel = new ArrayList<>();
    WishlistAdapter wishlistAdapter;

    TextView clearnow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist);


///////NAV DRAW///////
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout_wishlist);
        navigationView = (NavigationView) findViewById(R.id.nav_view);

        // Navigation view header
        navHeader = navigationView.getHeaderView(0);
        txtName = (TextView) navHeader.findViewById(R.id.name);
        txtEmail = (TextView) navHeader.findViewById(R.id.email);
        imgNavHeaderBg = (ImageView) navHeader.findViewById(R.id.img_header_bg);
        imgProfile = (ImageView) navHeader.findViewById(R.id.img_profile);

        contentView = findViewById(R.id.frame_wishlist);

        // load nav menu header data
        loadNavHeader();


        //go to home activity
        TextView homenav = findViewById(R.id.nav_home);
        homenav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myordersnav = new Intent(WishlistActivity.this, HomeActivity.class);
                startActivity(myordersnav);
                drawer.closeDrawers();
            }
        });

        //go to myorders activity
        TextView myordersnav = findViewById(R.id.nav_myorders);
        myordersnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent wishlistnav = new Intent(WishlistActivity.this, MyOrdersActivity.class);
                startActivity(wishlistnav);
                drawer.closeDrawers();
            }
        });

        //go to wishlist activity
        TextView wishlistnav = findViewById(R.id.nav_wishlist);
        wishlistnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.closeDrawers();
            }
        });

        //go to notifications activity
        TextView notificationnav = findViewById(R.id.nav_notifications);
        notificationnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent notificationnav = new Intent(WishlistActivity.this, NotificationsActivity.class);
                startActivity(notificationnav);
                drawer.closeDrawers();
            }
        });

        //go to myprofile activity
        TextView myprofilenav = findViewById(R.id.nav_myprofile);
        myprofilenav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myprofilenav = new Intent(WishlistActivity.this, MyProfileActivity.class);
                startActivity(myprofilenav);
                drawer.closeDrawers();
            }
        });

        //go to support activity
        TextView supportnav = findViewById(R.id.nav_support);
        supportnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent supportnav = new Intent(WishlistActivity.this, SupportActivity.class);
                startActivity(supportnav);
                drawer.closeDrawers();
            }
        });

        //go to termsandconditions activity
        TextView termsandconditionsnav = findViewById(R.id.nav_termsandconditions);
        termsandconditionsnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent termsandconditionsnav = new Intent(WishlistActivity.this, TermsAndConditionsActivity.class);
                startActivity(termsandconditionsnav);
                drawer.closeDrawers();
            }
        });

        //go to login page
        TextView logout = findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logout = new Intent(WishlistActivity.this, LoginActivity.class);
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


        recyclerView = (RecyclerView) findViewById(R.id.recycler_wishlist);
        wishlistAdapter();

        WishlistModel wishlistModel1 = new WishlistModel("Carrot Halwa and Pudhina Fry","$23", R.drawable.home_specialoffer2, R.drawable.ic_veg, 0,0);
        wishlistModel.add(wishlistModel1);

        WishlistModel wishlistModel2 = new WishlistModel("Onion Cheese with Curry","$25", R.drawable.home_freshitem2, R.drawable.ic_veg, 0,0);
        wishlistModel.add(wishlistModel2);

        WishlistModel wishlistModel3 = new WishlistModel("Italian Chova with Onion Manjuri","$27", R.drawable.home_freshitem1, R.drawable.ic_non_veg, 0,0);
        wishlistModel.add(wishlistModel3);

        WishlistModel wishlistModel4 = new WishlistModel("Orange Juice (2 Packs)","$29", R.drawable.home_beverages3, R.drawable.ic_veg, 0,0);
        wishlistModel.add(wishlistModel4);


        //Calling notifications with button
        ImageButton notificationbutton = (ImageButton) findViewById(R.id.notifications_button);
        notificationbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent notificationbutton = new Intent(WishlistActivity.this, NotificationsActivity.class);
                startActivity(notificationbutton);
            }
        });
        //got to mycart screen
        ImageView cartbutton = findViewById(R.id.cart_button);
        cartbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cartbutton = new Intent(WishlistActivity.this, MyCartActivity.class);
                startActivity(cartbutton);
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


        clearnow = (TextView) findViewById(R.id.clearnow);
        clearnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wishlistModel.clear();
                wishlistAdapter.notifyDataSetChanged();
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


    ///WISHLIST///
    public void wishlistAdapter(){
        wishlistAdapter = new WishlistAdapter(this, wishlistModel);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(wishlistAdapter);

/////////////// FOR WISHLIST ///////////////////
        wishlistAdapter.SetOnItemClickListener(new WishlistAdapter.OnItemClickProductWishlist() {
            @Override
            public void onItemClick(View view, int position, String type) {
                if(type.equals("remove")){

                }

                if(type.equals("addtocart")){
                    wishlistModel.get(position).setAdd_status(1);
                }else {
                    wishlistModel.get(position).setAdd_status(0);
                }

                wishlistAdapter.notifyDataSetChanged();
            }
        });
/////////////// FOR WISHLIST ///////////////////

    }
}
