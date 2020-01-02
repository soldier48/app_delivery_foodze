package com.exarcplus.foodzeetest2.NavDraw.MyOrdersActivity;

import android.content.Intent;
import android.graphics.Color;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.HomeActivity;
import com.exarcplus.foodzeetest2.NavDraw.MyProfileActivity.MyProfileActivity;
import com.exarcplus.foodzeetest2.NavDraw.NotificationsActivity.NotificationsActivity;
import com.exarcplus.foodzeetest2.NavDraw.SupportActivity.SupportActivity;
import com.exarcplus.foodzeetest2.NavDraw.TermsAndConditionsActivity.TermsAndConditionsActivity;
import com.exarcplus.foodzeetest2.NavDraw.WishlistActivity.WishlistActivity;
import com.exarcplus.foodzeetest2.R;
import com.exarcplus.foodzeetest2.login_register.LoginActivity.LoginActivity;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import java.util.ArrayList;

public class MyOrdersActivity extends AppCompatActivity {

    ///////NAV DRAW///////
    private NavigationView navigationView;
    private DrawerLayout drawer;
    private View navHeader;
    private ImageView imgNavHeaderBg, imgProfile;
    private TextView txtName, txtEmail;

    private static final float END_SCALE = 0.7f;
    private View contentView;
///////NAV DRAW///////

    RecyclerView recyclerView1;
    ArrayList<MyOrdersCurrentModel> myOrdersCurrentModel = new ArrayList<>();
    MyOrdersCurrentAllAdapter myOrdersCurrentAllAdapter;


//    ArrayList<String> currentorderID = new ArrayList<>(Arrays.asList("FAIZIA00439"));
//    ArrayList<String> currentorderTime = new ArrayList<>(Arrays.asList("Sun 3, June 2019 | 2:30 PM"));
//    ArrayList<String> deliveryTime = new ArrayList<>(Arrays.asList("1:20 PM"));

    RecyclerView recyclerView2;
    ArrayList<MyOrdersPastModel> myOrdersPastModel = new ArrayList<>();
    MyOrdersPastAllAdapter myOrdersPastAllAdapter;


    //IMPORTANT//
    String star_rating="";

    ExpandableRelativeLayout expandableLayout1;

    ExpandableRelativeLayout expandableLayout2;

    int item_disappear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);


///////NAV DRAW///////
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout_myorders);
        navigationView = (NavigationView) findViewById(R.id.nav_view);

        // Navigation view header
        navHeader = navigationView.getHeaderView(0);
        txtName = (TextView) navHeader.findViewById(R.id.name);
        txtEmail = (TextView) navHeader.findViewById(R.id.email);
        imgNavHeaderBg = (ImageView) navHeader.findViewById(R.id.img_header_bg);
        imgProfile = (ImageView) navHeader.findViewById(R.id.img_profile);

        contentView = findViewById(R.id.frame_myorders);

        // load nav menu header data
        loadNavHeader();


        //go to home activity
        TextView homenav = findViewById(R.id.nav_home);
        homenav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myordersnav = new Intent(MyOrdersActivity.this, HomeActivity.class);
                startActivity(myordersnav);
                drawer.closeDrawers();
            }
        });

        //go to myorders activity
        TextView myordersnav = findViewById(R.id.nav_myorders);
        myordersnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.closeDrawers();
            }
        });

        //go to wishlist activity
        TextView wishlistnav = findViewById(R.id.nav_wishlist);
        wishlistnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent wishlistnav = new Intent(MyOrdersActivity.this, WishlistActivity.class);
                startActivity(wishlistnav);
                drawer.closeDrawers();
            }
        });

        //go to notifications activity
        TextView notificationnav = findViewById(R.id.nav_notifications);
        notificationnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent notificationnav = new Intent(MyOrdersActivity.this, NotificationsActivity.class);
                startActivity(notificationnav);
                drawer.closeDrawers();
            }
        });

        //go to myprofile activity
        TextView myprofilenav = findViewById(R.id.nav_myprofile);
        myprofilenav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myprofilenav = new Intent(MyOrdersActivity.this, MyProfileActivity.class);
                startActivity(myprofilenav);
                drawer.closeDrawers();
            }
        });

        //go to support activity
        TextView supportnav = findViewById(R.id.nav_support);
        supportnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent supportnav = new Intent(MyOrdersActivity.this, SupportActivity.class);
                startActivity(supportnav);
                drawer.closeDrawers();
            }
        });

        //go to termsandconditions activity
        TextView termsandconditionsnav = findViewById(R.id.nav_termsandconditions);
        termsandconditionsnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent termsandconditionsnav = new Intent(MyOrdersActivity.this, TermsAndConditionsActivity.class);
                startActivity(termsandconditionsnav);
                drawer.closeDrawers();
            }
        });

        //go to login page
        TextView logout = findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logout = new Intent(MyOrdersActivity.this, LoginActivity.class);
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


        recyclerView1 = (RecyclerView) findViewById(R.id.current_orders_recycler);
        myorderscurrentallAdapter();

//        MyOrdersCurrentModel myOrdersCurrentModel1 = new MyOrdersCurrentModel("Carrot Halwa and Pudhina Fry","$23", "(Item 1)", R.drawable.home_freshitem1,R.drawable.ic_veg);
//        myOrdersCurrentModel.add(myOrdersCurrentModel1);

        MyOrdersCurrentModel myOrdersCurrentModel2 = new MyOrdersCurrentModel("Onion Cheese with Curry","$25", "(Item 2)", R.drawable.home_freshitem2,R.drawable.ic_non_veg);
        myOrdersCurrentModel.add(myOrdersCurrentModel2);

        MyOrdersCurrentModel myOrdersCurrentModel3 = new MyOrdersCurrentModel("Carrot Halwa and Pudhina Fry","$23", "(Item 3)", R.drawable.home_freshitem1,R.drawable.ic_veg);
        myOrdersCurrentModel.add(myOrdersCurrentModel3);

        MyOrdersCurrentModel myOrdersCurrentModel4 = new MyOrdersCurrentModel("Onion Cheese with Curry","$25", "(Items 4)", R.drawable.home_freshitem2,R.drawable.ic_non_veg);
        myOrdersCurrentModel.add(myOrdersCurrentModel4);


        recyclerView2 = (RecyclerView) findViewById(R.id.past_orders_recycler);
        myorderspastallAdapter();

        ArrayList<MyOrdersPastModel.MyOrdersPastItem> myOrdersPastItems = new ArrayList<>();

        MyOrdersPastModel myOrdersPastModel1 = new MyOrdersPastModel(myOrdersPastItems,"FAIZIA00439","Mon 30, May 2019 | 3:30 PM","Mon 30, May 2019 | 4:00 PM");
        myOrdersPastModel.add(myOrdersPastModel1);

        MyOrdersPastModel.MyOrdersPastItem myOrdersPastItem11 = new MyOrdersPastModel.MyOrdersPastItem("Carrot Halwa and Pudhina Fry","$23","(Item 1)",R.drawable.home_freshitem1,R.drawable.ic_veg);
        myOrdersPastItems.add(myOrdersPastItem11);

        MyOrdersPastModel.MyOrdersPastItem myOrdersPastItem12 = new MyOrdersPastModel.MyOrdersPastItem("Carrot Halwa and Pudhina Fry","$23","(Item 2)",R.drawable.home_freshitem1,R.drawable.ic_veg);
        myOrdersPastItems.add(myOrdersPastItem12);


//        ArrayList<MyOrdersPastModel.MyOrdersPastItem> myOrdersPastItems2 = new ArrayList<>();

        MyOrdersPastModel myOrdersPastModel2 = new MyOrdersPastModel(myOrdersPastItems,"FLPSQA56903","Wed 11, May 2019 | 1:25 PM","Wed 11, May 2019 | 2:10 PM");
        myOrdersPastModel.add(myOrdersPastModel2);

        MyOrdersPastModel.MyOrdersPastItem myOrdersPastItem21 = new MyOrdersPastModel.MyOrdersPastItem("Onion Cheese with Curry","$25","(Item 1)",R.drawable.home_freshitem2,R.drawable.ic_non_veg);
        myOrdersPastItems.add(myOrdersPastItem21);

        MyOrdersPastModel.MyOrdersPastItem myOrdersPastItem22 = new MyOrdersPastModel.MyOrdersPastItem("Onion Cheese with Curry","$25","(Item 1)",R.drawable.home_freshitem2,R.drawable.ic_non_veg);
        myOrdersPastItems.add(myOrdersPastItem22);


//        ArrayList<MyOrdersPastModel.MyOrdersPastItem> myOrdersPastItems3 = new ArrayList<>();

        MyOrdersPastModel myOrdersPastModel3 = new MyOrdersPastModel(myOrdersPastItems,"FAIZIA00439","Mon 30, May 2019 | 3:30 PM","Mon 30, May 2019 | 4:00 PM");
        myOrdersPastModel.add(myOrdersPastModel3);

        MyOrdersPastModel.MyOrdersPastItem myOrdersPastItem31 = new MyOrdersPastModel.MyOrdersPastItem("Carrot Halwa and Pudhina Fry","$23","(Item 1)",R.drawable.home_freshitem1,R.drawable.ic_veg);
        myOrdersPastItems.add(myOrdersPastItem31);

        MyOrdersPastModel.MyOrdersPastItem myOrdersPastItem32 = new MyOrdersPastModel.MyOrdersPastItem("Carrot Halwa and Pudhina Fry","$23","(Item 1)",R.drawable.home_freshitem1,R.drawable.ic_veg);
        myOrdersPastItems.add(myOrdersPastItem32);


//        ArrayList<MyOrdersPastModel.MyOrdersPastItem> myOrdersPastItems4 = new ArrayList<>();

        MyOrdersPastModel myOrdersPastModel4 = new MyOrdersPastModel(myOrdersPastItems,"FLPSQA56903","Wed 11, May 2019 | 1:25 PM","Wed 11, May 2019 | 2:10 PM");
        myOrdersPastModel.add(myOrdersPastModel4);

        MyOrdersPastModel.MyOrdersPastItem myOrdersPastItem41 = new MyOrdersPastModel.MyOrdersPastItem("Onion Cheese with Curry","$25","(Item 1)",R.drawable.home_freshitem2,R.drawable.ic_non_veg);
        myOrdersPastItems.add(myOrdersPastItem41);

        MyOrdersPastModel.MyOrdersPastItem myOrdersPastItem42 = new MyOrdersPastModel.MyOrdersPastItem("Onion Cheese with Curry","$25","(Item 1)",R.drawable.home_freshitem2,R.drawable.ic_non_veg);
        myOrdersPastItems.add(myOrdersPastItem42);


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
                Intent notificationbutton = new Intent(MyOrdersActivity.this, NotificationsActivity.class);
                startActivity(notificationbutton);
            }
        });


        /////////////// More or Less ///////////////////////
        TextView current_more = (TextView) findViewById(R.id.current_more);
        TextView current_less = (TextView) findViewById(R.id.current_less);
        LinearLayout current_items_displayed = (LinearLayout) findViewById(R.id.current_items_displayed);


        if(item_disappear == 0){
            current_items_displayed.setVisibility(View.GONE);
        }else {
            current_items_displayed.setVisibility(View.VISIBLE);

        }

        ///LIKE OR UNLIKE
        current_less.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(item_disappear == 0){
                    current_items_displayed.setVisibility(View.GONE);
                    current_more.setVisibility(View.VISIBLE);
                    current_less.setVisibility(View.GONE);
                }else {
                    expandableLayout2.toggle();
                    current_items_displayed.setVisibility(View.VISIBLE);
                    current_more.setVisibility(View.GONE);
                    current_less.setVisibility(View.VISIBLE);
                }
            }
        });

        current_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(item_disappear != 0){
                    expandableLayout2.toggle();
                    current_items_displayed.setVisibility(View.GONE);
                    current_more.setVisibility(View.VISIBLE);
                    current_less.setVisibility(View.GONE);
                }else {
                    current_items_displayed.setVisibility(View.VISIBLE);
                    current_more.setVisibility(View.GONE);
                    current_less.setVisibility(View.VISIBLE);
                }
            }
        });
/////////////// More or Less ///////////////////////



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


    ///MY ORDERS CURRENT ALL///
    public void myorderscurrentallAdapter(){
        myOrdersCurrentAllAdapter = new MyOrdersCurrentAllAdapter(this, myOrdersCurrentModel);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        recyclerView1.setLayoutManager(gridLayoutManager);
        recyclerView1.setItemAnimator(new DefaultItemAnimator());
        recyclerView1.setAdapter(myOrdersCurrentAllAdapter);
    }

    ///MY ORDERS PAST ALL///
    public void myorderspastallAdapter(){
        myOrdersPastAllAdapter = new MyOrdersPastAllAdapter(this, myOrdersPastModel);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        recyclerView2.setLayoutManager(gridLayoutManager);
        recyclerView2.setItemAnimator(new DefaultItemAnimator());
        recyclerView2.setAdapter(myOrdersPastAllAdapter);
    }

    public void buttonReview(View view) {
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        view = layoutInflater.inflate(R.layout.alert_dialog_myorders, null);
        final AlertDialog dialog = new AlertDialog.Builder(this).create();
        ImageView gobacktomyorders = (ImageView) view.findViewById(R.id.gobacktomyorders1);
        Button submitrating = (Button) view.findViewById(R.id.submitrating);

        ImageView star1 = (ImageView) view.findViewById(R.id.star1);
        ImageView star2 = (ImageView) view.findViewById(R.id.star2);
        ImageView star3 = (ImageView) view.findViewById(R.id.star3);
        ImageView star4 = (ImageView) view.findViewById(R.id.star4);
        ImageView star5 = (ImageView) view.findViewById(R.id.star5);

        ///1 STAR
        star1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                star1.setImageResource(R.drawable.ic_star);
                star2.setImageResource(R.drawable.ic_stargrey);
                star3.setImageResource(R.drawable.ic_stargrey);
                star4.setImageResource(R.drawable.ic_stargrey);
                star5.setImageResource(R.drawable.ic_stargrey);
                star_rating = "1star";
            }
        });


        ///2 STAR
        star2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                star1.setImageResource(R.drawable.ic_star);
                star2.setImageResource(R.drawable.ic_star);
                star3.setImageResource(R.drawable.ic_stargrey);
                star4.setImageResource(R.drawable.ic_stargrey);
                star5.setImageResource(R.drawable.ic_stargrey);
                star_rating = "2star";
            }
        });


        ///3 STAR
        star3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                star1.setImageResource(R.drawable.ic_star);
                star2.setImageResource(R.drawable.ic_star);
                star3.setImageResource(R.drawable.ic_star);
                star4.setImageResource(R.drawable.ic_stargrey);
                star5.setImageResource(R.drawable.ic_stargrey);
                star_rating = "3star";
            }
        });


        ///4 STAR
        star4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                star1.setImageResource(R.drawable.ic_star);
                star2.setImageResource(R.drawable.ic_star);
                star3.setImageResource(R.drawable.ic_star);
                star4.setImageResource(R.drawable.ic_star);
                star5.setImageResource(R.drawable.ic_stargrey);
                star_rating = "4star";
            }
        });


        ///5 STAR
        star5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                star1.setImageResource(R.drawable.ic_star);
                star2.setImageResource(R.drawable.ic_star);
                star3.setImageResource(R.drawable.ic_star);
                star4.setImageResource(R.drawable.ic_star);
                star5.setImageResource(R.drawable.ic_star);
                star_rating = "5star";
            }
        });



        gobacktomyorders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        submitrating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                MyOrdersFragment();
                dialog.dismiss();
            }
        });

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        // this is set the view from XML inside AlertDialog
        alert.setView(view);
        // disallow cancel of AlertDialog on click of back button and outside touch
        alert.setCancelable(false);

        dialog.setView(view);

        dialog.show();
    }

    public void expandableButton1(View view) {
        expandableLayout1 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout1);
        expandableLayout1.toggle(); // toggle expand and collapse
    }

//    public void expandableButton2(View view) {
//        expandableLayout2 = (ExpandableRelativeLayout) view.findViewById(R.id.expandableLayout2);
//        expandableLayout2.toggle(); // toggle expand and collapse
//    }

}
