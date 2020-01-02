package com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.SecondBeverages;

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


public class SecondBeveragesActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<SecondBeveragesExtraModel> secondBeveragesExtraModel = new ArrayList<>();
    SecondBeveragesExtraAdapter secondBeveragesExtraAdapter;

    RecyclerView recyclerView2;
    ArrayList<SecondBeveragesReviewModel> secondBeveragesReviewModel = new ArrayList<>();
    SecondBeveragesReviewAdapter secondBeveragesReviewAdapter;

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
        setContentView(R.layout.activity_second_beverages);
        selectedName = (TextView) findViewById(R.id.selectedName);
        selectedPrice = (TextView) findViewById(R.id.selectedPrice);
        selectedImage = (ImageView) findViewById(R.id.selectedImage);
//        selectedVNV = (ImageView) findViewById(R.id.selectedVNV);
        Intent intent = getIntent();
        selectedName.setText(intent.getStringExtra("name"));
        selectedPrice.setText(intent.getStringExtra("price"));
        selectedImage.setImageResource(intent.getIntExtra("image", 0));
//        selectedVNV.setImageResource(intent.getIntExtra("vnv", 0));


        recyclerView = (RecyclerView) findViewById(R.id.beverages_recycler);
        beveragesAdapter();

        SecondBeveragesExtraModel secondBeveragesExtraModel1 = new SecondBeveragesExtraModel("Beverages 1", R.drawable.home_beverages1, R.drawable.ic_veg);
        secondBeveragesExtraModel.add(secondBeveragesExtraModel1);

        SecondBeveragesExtraModel secondBeveragesExtraModel2 = new SecondBeveragesExtraModel("Beverages 2", R.drawable.home_beverages2, R.drawable.ic_veg);
        secondBeveragesExtraModel.add(secondBeveragesExtraModel2);

        SecondBeveragesExtraModel secondBeveragesExtraModel3 = new SecondBeveragesExtraModel("Beverages 3", R.drawable.home_beverages3, R.drawable.ic_veg);
        secondBeveragesExtraModel.add(secondBeveragesExtraModel3);

        SecondBeveragesExtraModel secondBeveragesExtraModel4 = new SecondBeveragesExtraModel("Beverages 4", R.drawable.home_beverages4, R.drawable.ic_veg);
        secondBeveragesExtraModel.add(secondBeveragesExtraModel4);

        SecondBeveragesExtraModel secondBeveragesExtraModel5 = new SecondBeveragesExtraModel("Beverages 5", R.drawable.home_beverages5, R.drawable.ic_veg);
        secondBeveragesExtraModel.add(secondBeveragesExtraModel5);


        recyclerView2 = (RecyclerView) findViewById(R.id.reviews_recycler_beverages);
        beveragesreviewAdapter();

        SecondBeveragesReviewModel secondBeveragesReviewModel1 = new SecondBeveragesReviewModel("Andrew", "4.0", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam id velit aliquam tortor sodales convallis nec ac nulla.",R.drawable.home_specialoffer1);
        secondBeveragesReviewModel.add(secondBeveragesReviewModel1);

        SecondBeveragesReviewModel secondBeveragesReviewModel2 = new SecondBeveragesReviewModel("Jacob", "3.0", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam id velit aliquam tortor sodales convallis nec ac nulla.",R.drawable.home_specialoffer2);
        secondBeveragesReviewModel.add(secondBeveragesReviewModel2);

        SecondBeveragesReviewModel secondBeveragesReviewModel3 = new SecondBeveragesReviewModel("Jeremiah", "2.3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam id velit aliquam tortor sodales convallis nec ac nulla.",R.drawable.home_specialoffer3);
        secondBeveragesReviewModel.add(secondBeveragesReviewModel3);

        SecondBeveragesReviewModel secondBeveragesReviewModel4 = new SecondBeveragesReviewModel("Alex", "5.0", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam id velit aliquam tortor sodales convallis nec ac nulla.",R.drawable.home_specialoffer4);
        secondBeveragesReviewModel.add(secondBeveragesReviewModel4);

        SecondBeveragesReviewModel secondBeveragesReviewModel5 = new SecondBeveragesReviewModel("Eliza", "4.8", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam id velit aliquam tortor sodales convallis nec ac nulla.",R.drawable.home_specialoffer5);
        secondBeveragesReviewModel.add(secondBeveragesReviewModel5);

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


    ///BEVERAGES///
    public void beveragesAdapter(){
        secondBeveragesExtraAdapter = new SecondBeveragesExtraAdapter(this, secondBeveragesExtraModel);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        gridLayoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(secondBeveragesExtraAdapter);
    }

    public void beveragesreviewAdapter() {
        secondBeveragesReviewAdapter = new SecondBeveragesReviewAdapter(this, secondBeveragesReviewModel);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        recyclerView2.setLayoutManager(gridLayoutManager);
        recyclerView2.setItemAnimator(new DefaultItemAnimator());
        recyclerView2.setAdapter(secondBeveragesReviewAdapter);
    }

}
