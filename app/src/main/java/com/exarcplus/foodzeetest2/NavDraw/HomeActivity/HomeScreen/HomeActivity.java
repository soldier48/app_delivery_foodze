package com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen;

import android.content.Intent;
import android.content.SharedPreferences;
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

import com.exarcplus.foodzeetest2.NavDraw.HomeActivity.BeveragesViewAll.BeveragesViewAllActivity;
import com.exarcplus.foodzeetest2.NavDraw.HomeActivity.FreshItemsViewAll.FreshItemViewAllActivity;
import com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.BeveragesRecycler.BeveragesAdapter;
import com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.BeveragesRecycler.BeveragesAdapter2;
import com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.BeveragesRecycler.BeveragesModel;
import com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.BeveragesRecycler.BeveragesModell;
import com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.FreshItemsRecycler.FreshItemsAdapter;
import com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.FreshItemsRecycler.FreshItemsAdapter2;
import com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.FreshItemsRecycler.FreshItemsModel;
import com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.FreshItemsRecycler.FreshItemsModell;
import com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.MyCart.MyCartActivity;
//import com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.SearchView.SearchViewActivity;
import com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.SearchView.SearchViewActivity;
import com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.SpecialOffers.SpecialOfferAdapter;
import com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.SpecialOffers.SpecialOffersModel;
import com.exarcplus.foodzeetest2.NavDraw.MyOrdersActivity.MyOrdersActivity;
import com.exarcplus.foodzeetest2.NavDraw.MyProfileActivity.MyProfileActivity;
import com.exarcplus.foodzeetest2.NavDraw.NotificationsActivity.NotificationsActivity;
import com.exarcplus.foodzeetest2.NavDraw.SupportActivity.SupportActivity;
import com.exarcplus.foodzeetest2.NavDraw.TermsAndConditionsActivity.TermsAndConditionsActivity;
import com.exarcplus.foodzeetest2.NavDraw.WishlistActivity.WishlistActivity;
import com.exarcplus.foodzeetest2.R;
import com.exarcplus.foodzeetest2.login_register.LoginActivity.LoginActivity;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

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
    ArrayList<SpecialOffersModel> specialOffersModel = new ArrayList<>();
    SpecialOfferAdapter specialOfferAdapter;

    RecyclerView recyclerView2;
    ArrayList<FreshItemsModel> freshItemsModel = new ArrayList<>();
    FreshItemsAdapter freshItemsAdapter;

    RecyclerView recyclerView3;
    ArrayList<BeveragesModel> beveragesModel = new ArrayList<>();
    BeveragesAdapter beveragesAdapter;

    RecyclerView recyclerView4;
    ArrayList<FreshItemsModell> freshItemsModell = new ArrayList<>();
    FreshItemsAdapter2 freshItemsAdapter2;

    RecyclerView recyclerView5;
    ArrayList<BeveragesModell> beveragesModell = new ArrayList<>();
    BeveragesAdapter2 beveragesAdapter2;

    ImageView menu;
    TextView location;
    String addressPin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

///////NAV DRAW///////
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout_home);
        navigationView = (NavigationView) findViewById(R.id.nav_view);

        // Navigation view header
        navHeader = navigationView.getHeaderView(0);
        txtName = (TextView) navHeader.findViewById(R.id.name);
        txtEmail = (TextView) navHeader.findViewById(R.id.email);
        imgNavHeaderBg = (ImageView) navHeader.findViewById(R.id.img_header_bg);
        imgProfile = (ImageView) navHeader.findViewById(R.id.img_profile);

        contentView = findViewById(R.id.frame_home);

        // load nav menu header data
        loadNavHeader();


        //go to home activity
        TextView homenav = findViewById(R.id.nav_home);
        homenav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.closeDrawers();
            }
        });

        //go to myorders activity
        TextView myordersnav = findViewById(R.id.nav_myorders);
        myordersnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myordersnav = new Intent(HomeActivity.this, MyOrdersActivity.class);
                startActivity(myordersnav);
                drawer.closeDrawers();
            }
        });

        //go to wishlist activity
        TextView wishlistnav = findViewById(R.id.nav_wishlist);
        wishlistnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent wishlistnav = new Intent(HomeActivity.this, WishlistActivity.class);
                startActivity(wishlistnav);
                drawer.closeDrawers();
            }
        });

        //go to notifications activity
        TextView notificationnav = findViewById(R.id.nav_notifications);
        notificationnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent notificationnav = new Intent(HomeActivity.this, NotificationsActivity.class);
                startActivity(notificationnav);
                drawer.closeDrawers();
            }
        });

        //go to myprofile activity
        TextView myprofilenav = findViewById(R.id.nav_myprofile);
        myprofilenav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myprofilenav = new Intent(HomeActivity.this, MyProfileActivity.class);
                startActivity(myprofilenav);
                drawer.closeDrawers();
            }
        });

        //go to support activity
        TextView supportnav = findViewById(R.id.nav_support);
        supportnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent supportnav = new Intent(HomeActivity.this, SupportActivity.class);
                startActivity(supportnav);
                drawer.closeDrawers();
            }
        });

        //go to termsandconditions activity
        TextView termsandconditionsnav = findViewById(R.id.nav_termsandconditions);
        termsandconditionsnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent termsandconditionsnav = new Intent(HomeActivity.this, TermsAndConditionsActivity.class);
                startActivity(termsandconditionsnav);
                drawer.closeDrawers();
            }
        });

        //go to login page
        TextView logout = findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logout = new Intent(HomeActivity.this, LoginActivity.class);
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


        recyclerView1 = (RecyclerView) findViewById(R.id.specialoffers_recycler);
        specialofferAdapter();

        SpecialOffersModel specialOffersModel1 = new SpecialOffersModel("35% OFF on Beverages", R.drawable.home_specialoffer1, 0);
        specialOffersModel.add(specialOffersModel1);

        SpecialOffersModel specialOffersModel2 = new SpecialOffersModel("45% OFF on Non-Veg", R.drawable.home_specialoffer2, 0);
        specialOffersModel.add(specialOffersModel2);

        SpecialOffersModel specialOffersModel3 = new SpecialOffersModel("Special Offer 3", R.drawable.home_specialoffer3, 0);
        specialOffersModel.add(specialOffersModel3);

        SpecialOffersModel specialOffersModel4 = new SpecialOffersModel("Special Offer 4", R.drawable.home_specialoffer4, 0);
        specialOffersModel.add(specialOffersModel4);

        SpecialOffersModel specialOffersModel5 = new SpecialOffersModel("Special Offer 5", R.drawable.home_specialoffer5, 0);
        specialOffersModel.add(specialOffersModel5);

        /////FOR RECYCLERVIEW 2/////

        recyclerView2 = (RecyclerView) findViewById(R.id.freshitems_recycler);
        freshitemsAdapter();

        FreshItemsModel freshItemsModel1 = new FreshItemsModel("Carrot Halwa and Pudhina Fry","$23",R.drawable.home_freshitem1,R.drawable.ic_veg,0,0);
        freshItemsModel.add(freshItemsModel1);

        FreshItemsModel freshItemsModel2 = new FreshItemsModel("Onion Cheese with Curry","$25",R.drawable.home_freshitem2,R.drawable.ic_veg,0,0);
        freshItemsModel.add(freshItemsModel2);

        FreshItemsModel freshItemsModel3 = new FreshItemsModel("Italian Chova with Onion Manjuri","$27",R.drawable.home_freshitem3,R.drawable.ic_non_veg,0,0);
        freshItemsModel.add(freshItemsModel3);

        FreshItemsModel freshItemsModel4 = new FreshItemsModel("Orange Juice (2 Packs)","$29",R.drawable.home_freshitem4,R.drawable.ic_veg,0,0);
        freshItemsModel.add(freshItemsModel4);

        FreshItemsModel freshItemsModel5 = new FreshItemsModel("Panneer Fry","$31",R.drawable.home_freshitem5,R.drawable.ic_non_veg,0,0);
        freshItemsModel.add(freshItemsModel5);


        /////FOR RECYCLERVIEW 3/////
        recyclerView3 = (RecyclerView) findViewById(R.id.beverages_recycler);
        beveragesAdapter();

        BeveragesModel beveragesModel1 = new BeveragesModel("Orange Juice","$23", R.drawable.home_beverages1, R.drawable.ic_veg, 0,0);
        beveragesModel.add(beveragesModel1);

        BeveragesModel beveragesModel2 = new BeveragesModel("Rose Milk","$25", R.drawable.home_beverages2, R.drawable.ic_veg, 0,0);
        beveragesModel.add(beveragesModel2);

        BeveragesModel beveragesModel3 = new BeveragesModel("Pineapple Mocktail","$27", R.drawable.home_beverages3, R.drawable.ic_veg, 0,0);
        beveragesModel.add(beveragesModel3);

        BeveragesModel beveragesModel4 = new BeveragesModel("Apple Juice","$29", R.drawable.home_beverages4, R.drawable.ic_veg, 0,0);
        beveragesModel.add(beveragesModel4);

        BeveragesModel beveragesModel5 = new BeveragesModel("Guava Milkshake","$31", R.drawable.home_beverages5, R.drawable.ic_veg, 0,0);
        beveragesModel.add(beveragesModel5);

        /////FOR RECYCLERVIEW 4/////

        recyclerView4 = (RecyclerView) findViewById(R.id.freshitems_recycler2);
        freshitemsAdapter2();

        FreshItemsModell freshItemsModel21 = new FreshItemsModell("Carrot Halwa and Pudhina Fry","$23",R.drawable.home_freshitem1,R.drawable.ic_veg,0,0);
        freshItemsModell.add(freshItemsModel21);

        FreshItemsModell freshItemsModel22 = new FreshItemsModell("Onion Cheese with Curry","$25",R.drawable.home_freshitem2,R.drawable.ic_veg,0,0);
        freshItemsModell.add(freshItemsModel22);

        FreshItemsModell freshItemsModel23 = new FreshItemsModell("Italian Chova with Onion Manjuri","$27",R.drawable.home_freshitem3,R.drawable.ic_non_veg,0,0);
        freshItemsModell.add(freshItemsModel23);

        FreshItemsModell freshItemsModel24 = new FreshItemsModell("Orange Juice (2 Packs)","$29",R.drawable.home_freshitem4,R.drawable.ic_veg,0,0);
        freshItemsModell.add(freshItemsModel24);

        FreshItemsModell freshItemsModel25 = new FreshItemsModell("Panneer Fry","$31",R.drawable.home_freshitem5,R.drawable.ic_non_veg,0,0);
        freshItemsModell.add(freshItemsModel25);


        /////FOR RECYCLERVIEW 5/////
        recyclerView5 = (RecyclerView) findViewById(R.id.beverages_recycler2);
        beveragesAdapter2();

        BeveragesModell beveragesModel21 = new BeveragesModell("Orange Juice","$23", R.drawable.home_beverages1, R.drawable.ic_veg, 0,0);
        beveragesModell.add(beveragesModel21);

        BeveragesModell beveragesModel22 = new BeveragesModell("Rose Milk","$25", R.drawable.home_beverages2, R.drawable.ic_veg, 0,0);
        beveragesModell.add(beveragesModel22);

        BeveragesModell beveragesModel23 = new BeveragesModell("Pineapple Mocktail","$27", R.drawable.home_beverages3, R.drawable.ic_veg, 0,0);
        beveragesModell.add(beveragesModel23);

        BeveragesModell beveragesModel24 = new BeveragesModell("Apple Juice","$29", R.drawable.home_beverages4, R.drawable.ic_veg, 0,0);
        beveragesModell.add(beveragesModel24);

        BeveragesModell beveragesModel25 = new BeveragesModell("Guava Milkshake","$31", R.drawable.home_beverages5, R.drawable.ic_veg, 0,0);
        beveragesModell.add(beveragesModel25);


        //Calling FreshItemViewAllActivity
        TextView viewall1 = findViewById(R.id.viewall1);
        viewall1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewall1 = new Intent(HomeActivity.this, FreshItemViewAllActivity.class);
                startActivity(viewall1);
            }
        });


        //Calling BeveragesViewAllActivity
        TextView viewall2 = findViewById(R.id.viewall2);
        viewall2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewall2 = new Intent(HomeActivity.this, BeveragesViewAllActivity.class);
                startActivity(viewall2);
            }
        });

        //Calling FreshItemViewAllActivity2
        TextView viewall3 = findViewById(R.id.viewall3);
        viewall3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewall3 = new Intent(HomeActivity.this, FreshItemViewAllActivity.class);
                startActivity(viewall3);
            }
        });

        //Calling BeveragesViewAllActivity2
        TextView viewall4 = findViewById(R.id.viewall4);
        viewall4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewall4 = new Intent(HomeActivity.this, FreshItemViewAllActivity.class);
                startActivity(viewall4);
            }
        });

        //got to searchview screen
        TextView go_to_searchview = findViewById(R.id.searchbar_home);
        go_to_searchview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_to_searchview = new Intent(HomeActivity.this, SearchViewActivity.class);
                startActivity(go_to_searchview);
            }
        });


        //Calling notifications with button
        ImageButton notificationbutton = (ImageButton) findViewById(R.id.notifications_button);
        notificationbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent notificationbutton = new Intent(HomeActivity.this, NotificationsActivity.class);
                startActivity(notificationbutton);
            }
        });
        //got to mycart screen
        ImageView cartbutton = findViewById(R.id.cart_button);
        cartbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cartbutton = new Intent(HomeActivity.this, MyCartActivity.class);
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


/////LOCATION///////
        TextView locationhome = findViewById(R.id.location_home);

        String address = getIntent().getStringExtra("address");

        if(address!=null && !address.equals("")){
            locationhome.setText(address);

        }

//        locationhome.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent maps = new Intent(HomeActivity.this, MapsActivity.class);
//                startActivity(maps);
//            }
//        });
/////LOCATION///////


        SharedPreferences sp = this.getSharedPreferences("key", 0);
        addressPin = sp.getString("addresspin","");



///////////// to open the navdraw with the menu icon ////////////////

//        menu = view.findViewById(R.id.nav_draw_button);
//
//        mDrawerLayout = view.findViewById(R.id.drawer_layout);
////        mDrawerLayout = (DrawerLayout) view.findViewById(R.id.drawer_layout);
//        menu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mDrawerLayout.openDrawer(Gravity.START);
//            }
//        });

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


    ///SPECIAL OFFER///
    public void specialofferAdapter(){
        specialOfferAdapter = new SpecialOfferAdapter(this, specialOffersModel);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        gridLayoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
        recyclerView1.setLayoutManager(gridLayoutManager);
        recyclerView1.setItemAnimator(new DefaultItemAnimator());
        recyclerView1.setAdapter(specialOfferAdapter);
    }

    ///FRESH ITEMS///
    public void freshitemsAdapter(){
        freshItemsAdapter = new FreshItemsAdapter(this, freshItemsModel);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        gridLayoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
        recyclerView2.setLayoutManager(gridLayoutManager);
        recyclerView2.setItemAnimator(new DefaultItemAnimator());
        recyclerView2.setAdapter(freshItemsAdapter);


        freshItemsAdapter.SetOnItemClickListener(new FreshItemsAdapter.OnItemClickProductFreshItem() {
            @Override
            public void onItemClick(View view, int position, String type) {
                if(type.equals("like")){
                    freshItemsModel.get(position).setLike_status(1);
                }else {
                    freshItemsModel.get(position).setLike_status(0);
                }

                if(type.equals("addtocart")){
                    freshItemsModel.get(position).setAdd_status(1);
                }else {
                    freshItemsModel.get(position).setAdd_status(0);
                }

                freshItemsAdapter.notifyDataSetChanged();
            }
        });


    }

    ///BEVERAGES///
    public void beveragesAdapter(){
        beveragesAdapter = new BeveragesAdapter(this, beveragesModel);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        gridLayoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
        recyclerView3.setLayoutManager(gridLayoutManager);
        recyclerView3.setItemAnimator(new DefaultItemAnimator());
        recyclerView3.setAdapter(beveragesAdapter);

        beveragesAdapter.SetOnItemClickListener(new BeveragesAdapter.OnItemClickProductBeverages() {
            @Override
            public void onItemClick(View view, int position, String type) {
                if(type.equals("like")){
                    beveragesModel.get(position).setLike_status(1);
                }else {
                    beveragesModel.get(position).setLike_status(0);
                }

                if(type.equals("addtocart")){
                    beveragesModel.get(position).setAdd_status(1);
                }else {
                    beveragesModel.get(position).setAdd_status(0);
                }

                beveragesAdapter.notifyDataSetChanged();
            }
        });



    }

    ///FRESH ITEMS 2///
    public void freshitemsAdapter2(){
        freshItemsAdapter2 = new FreshItemsAdapter2(this, freshItemsModell);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        gridLayoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
        recyclerView4.setLayoutManager(gridLayoutManager);
        recyclerView4.setItemAnimator(new DefaultItemAnimator());
        recyclerView4.setAdapter(freshItemsAdapter2);


        freshItemsAdapter2.SetOnItemClickListener(new FreshItemsAdapter2.OnItemClickProductFreshItem2() {
            @Override
            public void onItemClick(View view, int position, String type) {
                if(type.equals("like")){
                    freshItemsModell.get(position).setLike_status2(1);
                }else {
                    freshItemsModell.get(position).setLike_status2(0);
                }

                if(type.equals("addtocart")){
                    freshItemsModell.get(position).setAdd_status2(1);
                }else {
                    freshItemsModell.get(position).setAdd_status2(0);
                }

                freshItemsAdapter2.notifyDataSetChanged();
            }
        });


    }


    ///BEVERAGES 2///
    public void beveragesAdapter2(){
        beveragesAdapter2 = new BeveragesAdapter2(this, beveragesModell);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        gridLayoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
        recyclerView5.setLayoutManager(gridLayoutManager);
        recyclerView5.setItemAnimator(new DefaultItemAnimator());
        recyclerView5.setAdapter(beveragesAdapter2);

        beveragesAdapter2.SetOnItemClickListener(new BeveragesAdapter2.OnItemClickProductBeverages2() {
            @Override
            public void onItemClick(View view, int position, String type) {
                if(type.equals("like")){
                    beveragesModell.get(position).setLike_status2(1);
                }else {
                    beveragesModell.get(position).setLike_status2(0);
                }

                if(type.equals("addtocart")){
                    beveragesModell.get(position).setAdd_status2(1);
                }else {
                    beveragesModell.get(position).setAdd_status2(0);
                }

                beveragesAdapter2.notifyDataSetChanged();
            }
        });



    }


}
