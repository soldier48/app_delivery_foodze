package com.exarcplus.foodzeetest2.NavDraw.HomeActivity.FreshItemsViewAll;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.FreshItemsRecycler.FreshItemsAdapter;
import com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.FreshItemsRecycler.FreshItemsModel;
import com.exarcplus.foodzeetest2.R;

import java.util.ArrayList;

public class FreshItemViewAllActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<FreshItemsModel> freshItemsModel = new ArrayList<>();
    FreshItemsAdapter freshItemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresh_item_view_all);

        recyclerView = (RecyclerView) findViewById(R.id.fresh_items_view_all_recycler);
        freshitemsviewallAdapter();

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


        //Calling previous page
        ImageView back = (ImageView) findViewById(R.id.backtopreviouspage);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    ///FRESH ITEMS VIEW ALL///
    public void freshitemsviewallAdapter() {
        freshItemsAdapter = new FreshItemsAdapter(this, freshItemsModel);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(freshItemsAdapter);


        freshItemsAdapter.SetOnItemClickListener(new FreshItemsAdapter.OnItemClickProductFreshItem() {
            @Override
            public void onItemClick(View view, int position, String type) {
                if(type.equals("like")){
                    freshItemsModel.get(position).setLike_status(1);
                }else {
                    freshItemsModel.get(position).setLike_status(0);
                }

                freshItemsAdapter.notifyDataSetChanged();
            }
        });


    }
}
