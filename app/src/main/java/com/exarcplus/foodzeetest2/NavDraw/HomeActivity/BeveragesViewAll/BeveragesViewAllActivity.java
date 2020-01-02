package com.exarcplus.foodzeetest2.NavDraw.HomeActivity.BeveragesViewAll;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.BeveragesRecycler.BeveragesAdapter;
import com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.BeveragesRecycler.BeveragesModel;
import com.exarcplus.foodzeetest2.R;

import java.util.ArrayList;

public class BeveragesViewAllActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<BeveragesModel> beveragesModel = new ArrayList<>();
    BeveragesAdapter beveragesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beverages_view_all);

        recyclerView = (RecyclerView) findViewById(R.id.beverages_view_all_recycler);
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


        //Calling previous page
        ImageView back = (ImageView) findViewById(R.id.backtopreviouspage);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    ///BEVERAGES///
    public void beveragesAdapter(){
        beveragesAdapter = new BeveragesAdapter(this, beveragesModel);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(beveragesAdapter);

        beveragesAdapter.SetOnItemClickListener(new BeveragesAdapter.OnItemClickProductBeverages() {
            @Override
            public void onItemClick(View view, int position, String type) {
                if(type.equals("like")){
                    beveragesModel.get(position).setLike_status(1);
                }else {
                    beveragesModel.get(position).setLike_status(0);
                }

                beveragesAdapter.notifyDataSetChanged();
            }
        });

    }

}
