package com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.MyCart;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.exarcplus.foodzeetest2.R;
import com.exarcplus.foodzeetest2.login_register.LoginActivity.LoginActivity;

import java.util.ArrayList;

public class MyCartActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<MyCartModel> myCartModel = new ArrayList<>();
    MyCartAdapter myCartAdapter;

    TextView totalprice;

    int minteger = 0;

    ImageView increment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart);

        recyclerView = (RecyclerView) findViewById(R.id.mycart_recycler);
        mycartAdapter();

        MyCartModel myCartModel1 = new MyCartModel("Carrot Halwa and Pudhina Fry","$23","Vegetarian",0, R.drawable.home_freshitem1, R.drawable.ic_veg,0,0,0);
        myCartModel.add(myCartModel1);

        MyCartModel myCartModel2 = new MyCartModel("Onion Cheese with Curry","$25","Non-Vegetarian",0,R.drawable.home_freshitem2, R.drawable.ic_non_veg,0,0,0);
        myCartModel.add(myCartModel2);


        //Calling previous page
        ImageView back = (ImageView) findViewById(R.id.backtopreviouspage);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        //go to checkout step 1 page
        TextView go_to_login = findViewById(R.id.go_to_login);
        go_to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_to_login = new Intent(MyCartActivity.this, LoginActivity.class);
                startActivity(go_to_login);
            }
        });

//        TextView totalprice = (TextView) findViewById(R.id.totalprice);
//        totalprice = myCartModel.add(myCartModel.get(0));

    }

    ///MY CART///
    public void mycartAdapter(){
        MyCartAdapter myCartAdapter = new MyCartAdapter(this, myCartModel);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(myCartAdapter);

        increment = (ImageView) findViewById(R.id.increase_item);

        TextView itemquantity = (TextView) findViewById(R.id.quantity_item);

/////////////// TO DO STUFF IN MyCart ///////////////////
        myCartAdapter.SetOnItemClickListener(new MyCartAdapter.OnItemClickProductMyCart() {
            @Override
            public void onItemClick(View view, int position, String type) {
                if(type.equals("remove")){

                }

                if(type.equals("increment")){

                }

                if(type.equals("decrement")){

                }
                myCartAdapter.notifyDataSetChanged();
            }
        });
/////////////// TO REMOVE FROM MyCart ///////////////////

    }

}
