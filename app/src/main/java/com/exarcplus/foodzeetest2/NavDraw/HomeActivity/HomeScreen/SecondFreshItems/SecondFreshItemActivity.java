package com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.SecondFreshItems;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.exarcplus.foodzeetest2.R;

import java.util.ArrayList;


public class SecondFreshItemActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<SecondFreshItemExtraModel> secondFreshItemExtraModel = new ArrayList<>();
    SecondFreshItemExtraAdapter secondFreshItemExtraAdapter;

    RecyclerView recyclerView2;
    ArrayList<SecondFreshItemReviewModel> secondFreshItemReviewModel = new ArrayList<>();
    SecondFreshItemReviewAdapter secondFreshItemReviewAdapter;

    TextView selectedName;
    TextView selectedPrice;
    ImageView selectedImage;
//    ImageView selectedVNV;

    int minteger = 0;


    /////FOR FAVOURITES/////
    int favourites;

    /////FOR FAVOURITES/////


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_fresh_items);
        selectedName = (TextView) findViewById(R.id.selectedName);
        selectedPrice = (TextView) findViewById(R.id.selectedPrice);
        selectedImage = (ImageView) findViewById(R.id.selectedImage);
//        selectedVNV = (ImageView) findViewById(R.id.selectedVNV);
        Intent intent = getIntent();
        selectedName.setText(intent.getStringExtra("name"));
        selectedPrice.setText(intent.getStringExtra("price"));
        selectedImage.setImageResource(intent.getIntExtra("image", 0));
//        selectedVNV.setImageResource(intent.getIntExtra("vnv", 0));


        recyclerView = (RecyclerView) findViewById(R.id.freshitems_recycler);
        freshitemsviewAdapter();

        SecondFreshItemExtraModel secondFreshItemExtraModel1 = new SecondFreshItemExtraModel("Pancakes", R.drawable.home_specialoffer1, R.drawable.ic_veg);
        secondFreshItemExtraModel.add(secondFreshItemExtraModel1);

        SecondFreshItemExtraModel secondFreshItemExtraModel2 = new SecondFreshItemExtraModel("Pudina", R.drawable.home_specialoffer2, R.drawable.ic_veg);
        secondFreshItemExtraModel.add(secondFreshItemExtraModel2);

        SecondFreshItemExtraModel secondFreshItemExtraModel3 = new SecondFreshItemExtraModel("Orange Juice", R.drawable.home_specialoffer3, R.drawable.ic_veg);
        secondFreshItemExtraModel.add(secondFreshItemExtraModel3);

        SecondFreshItemExtraModel secondFreshItemExtraModel4 = new SecondFreshItemExtraModel("Breakfast Berries", R.drawable.home_specialoffer4, R.drawable.ic_veg);
        secondFreshItemExtraModel.add(secondFreshItemExtraModel4);

        SecondFreshItemExtraModel secondFreshItemExtraModel5 = new SecondFreshItemExtraModel("Something", R.drawable.home_specialoffer5, R.drawable.ic_veg);
        secondFreshItemExtraModel.add(secondFreshItemExtraModel5);

        recyclerView2 = (RecyclerView) findViewById(R.id.reviews_recycler_fresh_items);
        freshitemsreviewAdapter();

        SecondFreshItemReviewModel secondFreshItemReviewModel1 = new SecondFreshItemReviewModel("Andrew", "4.0", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam id velit aliquam tortor sodales convallis nec ac nulla.",R.drawable.home_specialoffer1);
        secondFreshItemReviewModel.add(secondFreshItemReviewModel1);

        SecondFreshItemReviewModel secondFreshItemReviewModel2 = new SecondFreshItemReviewModel("Jacob", "3.0", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam id velit aliquam tortor sodales convallis nec ac nulla.",R.drawable.home_specialoffer2);
        secondFreshItemReviewModel.add(secondFreshItemReviewModel2);

        SecondFreshItemReviewModel secondFreshItemReviewModel3 = new SecondFreshItemReviewModel("Jeremiah", "2.3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam id velit aliquam tortor sodales convallis nec ac nulla.",R.drawable.home_specialoffer3);
        secondFreshItemReviewModel.add(secondFreshItemReviewModel3);

        SecondFreshItemReviewModel secondFreshItemReviewModel4 = new SecondFreshItemReviewModel("Alex", "5.0", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam id velit aliquam tortor sodales convallis nec ac nulla.",R.drawable.home_specialoffer4);
        secondFreshItemReviewModel.add(secondFreshItemReviewModel4);

        SecondFreshItemReviewModel secondFreshItemReviewModel5 = new SecondFreshItemReviewModel("Eliza", "4.8", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam id velit aliquam tortor sodales convallis nec ac nulla.",R.drawable.home_specialoffer5);
        secondFreshItemReviewModel.add(secondFreshItemReviewModel5);


        //Calling previous page
        ImageView back = (ImageView) findViewById(R.id.backtopreviouspage);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        /////////////// Like or Unlike ///////////////////////
        ImageView unfavourite = (ImageView) findViewById(R.id.prelike);
        ImageView favourite = (ImageView) findViewById(R.id.like);

        if(favourites == 0){
            unfavourite.setVisibility(View.VISIBLE);
        }else {
            favourite.setVisibility(View.GONE);

        }

        ///LIKE OR UNLIKE
        unfavourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(favourites == 0){
                    favourite.setVisibility(View.VISIBLE);
                }else {
                    unfavourite.setVisibility(View.GONE);
                }
            }
        });

        favourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(favourites != 0){
                    unfavourite.setVisibility(View.VISIBLE);
                }else {
                    favourite.setVisibility(View.GONE);
                }
            }
        });
/////////////// Like or Unlike ///////////////////////


    }



    public void increaseInteger(View view) {
        minteger = minteger + 1;
        display(minteger);

    }public void decreaseInteger(View view) {
        minteger = minteger - 1;
        if(minteger<0){
            minteger=0;
        }
        display(minteger);
    }

    private void display(int number) {
        TextView displayInteger = (TextView) findViewById(
                R.id.quantity_item);
        displayInteger.setText("" + number);
    }


    public void freshitemsviewAdapter() {
        secondFreshItemExtraAdapter = new SecondFreshItemExtraAdapter(this, secondFreshItemExtraModel);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        gridLayoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(secondFreshItemExtraAdapter);
    }

    public void freshitemsreviewAdapter() {
        secondFreshItemReviewAdapter = new SecondFreshItemReviewAdapter(this, secondFreshItemReviewModel);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        recyclerView2.setLayoutManager(gridLayoutManager);
        recyclerView2.setItemAnimator(new DefaultItemAnimator());
        recyclerView2.setAdapter(secondFreshItemReviewAdapter);
    }

}
