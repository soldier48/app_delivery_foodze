package com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.MyCart.Checkout;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.exarcplus.foodzeetest2.R;

import java.util.ArrayList;

public class CheckoutStep1Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<CheckoutStep1Model> checkoutStep1Model = new ArrayList<>();
    CheckoutStep1Adapter checkoutStep1Adapter;
    String addressname;
    String addressaddress;
    int pos=0,rec=0;

    //"rec" is used to add new address

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_step_1);

//        TextView nameofaddress = findViewById(R.id.nameofaddress);
//        TextView addressofaddress = findViewById(R.id.addressofaddress);

    /*    Bundle bundle = getIntent().getExtras();

        if(bundle!=null && bundle)
*/
        recyclerView = (RecyclerView) findViewById(R.id.checkoutstep1_recycler);

        CheckoutStep1Model checkoutStep1Model1 = new CheckoutStep1Model("Home","No.4, ITI Layout, Kathriguppe main road, Banashankari 3rd stage, Bengaluru, Karnataka, India",R.drawable.ic_select,0,0);
        checkoutStep1Model.add(checkoutStep1Model1);

        CheckoutStep1Model checkoutStep1Model2 = new CheckoutStep1Model("Work Address","No.4, ITI Layout, Kathriguppe main road, Banashankari 3rd stage, Bengaluru, Karnataka, India",R.drawable.ic_unselect,0,0);
        checkoutStep1Model.add(checkoutStep1Model2);

        checkoutstep1Adapter();

        //Calling previous page
        ImageView back = (ImageView) findViewById(R.id.backtopreviouspage);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        //go to Alert Dialog for adding new address
        Button addnewaddress = findViewById(R.id.addnewaddress);
        addnewaddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addnewaddress = new Intent(CheckoutStep1Activity.this, AlertDialogCheckoutStep1Activity.class);
                addnewaddress.putExtra("new",1);
                startActivity(addnewaddress);
            }
        });

        //go to checkout step 2 page
        TextView checkout = findViewById(R.id.checkoutstep2);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent checkout = new Intent(CheckoutStep1Activity.this, CheckoutStep2Activity.class);
                startActivity(checkout);
            }
        });

//        String addressname = getIntent().getStringExtra("NameOfEditedAddress");
//        if(addressname!=null && !addressname.equals("")){
//
////            checkoutStep1Model.get(position).setCheckoutstep1Address("");
//         //   address_name.setText(addressname);
//        }

//        String addressaddress = getIntent().getStringExtra("AddressOfEditedAddress");
//        if(addressaddress!=null && !addressaddress.equals("")){
//           // address_location.setText(addressaddress);
//        }

        TextView nameofaddress = findViewById(R.id.nameofaddress);
        String addressname = getIntent().getStringExtra("NameOfEditedAddress");
         pos = getIntent().getIntExtra("position",0);
         rec = getIntent().getIntExtra("new",0);
        if(addressname!=null && !addressname.equals("") && rec==0){
            checkoutStep1Model.get(pos).setCheckoutstep1Names(getIntent().getStringExtra("NameOfEditedAddress"));
//            nameofaddress.setText(addressname);
        }

        TextView addressofaddress = findViewById(R.id.addressofaddress);
        String addressaddress = getIntent().getStringExtra("AddressOfEditedAddress");
        if(addressaddress!=null && !addressaddress.equals("")&& rec==0){
            checkoutStep1Model.get(pos).setCheckoutstep1Address(getIntent().getStringExtra("AddressOfEditedAddress"));
//            addressofaddress.setText(addressaddress);
        }
        if(rec==1){
            CheckoutStep1Model checkoutStep1Model3 = new CheckoutStep1Model(addressname,addressaddress,R.drawable.ic_unselect,0,0);
            checkoutStep1Model.add(checkoutStep1Model3);

            checkoutStep1Adapter.notifyDataSetChanged();
//
//            System.out.println("Size-------------------------------"+checkoutStep1Model.size());

        }

    }

    ///MY CART///
    public void checkoutstep1Adapter(){

        checkoutStep1Adapter = new CheckoutStep1Adapter(this, checkoutStep1Model);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(checkoutStep1Adapter);

/////////////// TO REMOVE ADDRESS ///////////////////
        checkoutStep1Adapter.SetOnItemClickListener(new CheckoutStep1Adapter.OnItemClickProductCheckoutStep1() {
            @Override
            public void onItemClick(View view, int position, String type) {
                if(type.equals("remove")){
                    checkoutStep1Model.remove(position).setAddress_remove(1);
                }


                if(type.equals("edit")){
                  //  checkoutStep1Model.get(position).setAddress_edit(1);
                    Intent intent = new Intent(CheckoutStep1Activity.this, AlertDialogCheckoutStep1Activity.class);
                    intent.putExtra("NameOfAddress",checkoutStep1Model.get(position).getCheckoutstep1Names());
                    intent.putExtra("AddressOfAddress",checkoutStep1Model.get(position).getCheckoutstep1Address());
                    intent.putExtra("position",position);
                    startActivity(intent);

                }


                checkoutStep1Adapter.notifyDataSetChanged();
            }
        });
/////////////// TO REMOVE ADDRESS ///////////////////

        String addressname = getIntent().getStringExtra("NameOfEditedAddress");
        String addressaddress = getIntent().getStringExtra("AddressOfEditedAddress");

//        if(addressname!=null && !addressname.equals("")){
//            nameofaddress.setText(addressname);
//        }
//
//        if(addressaddress!=null && !addressaddress.equals("")){
//            addressofaddress.setText(addressaddress);
////            checkoutStep1Adapter.addressaddress.equals(addressaddress);
//        }

//        String addressname = getIntent().getStringExtra("NameOfEditedAddress");
//        if(addressname!=null && !addressname.equals("")){
//            nameofaddress.setText(addressname);
//        }
//
//        String addressaddress = getIntent().getStringExtra("AddressOfEditedAddress");
//        if(addressaddress!=null && !addressaddress.equals("")){
//            addressofaddress.setText(addressaddress);
//        }

    }


}
