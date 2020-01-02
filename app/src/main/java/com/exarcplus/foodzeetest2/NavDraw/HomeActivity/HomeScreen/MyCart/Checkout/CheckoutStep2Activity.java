package com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.MyCart.Checkout;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.exarcplus.foodzeetest2.NavDraw.MyOrdersActivity.MyOrdersActivity;
import com.exarcplus.foodzeetest2.R;

import java.util.ArrayList;

public class CheckoutStep2Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<CheckoutStep2Model> checkoutStep2Model = new ArrayList<>();
    CheckoutStep2Adapter checkoutStep2Adapter;

    RecyclerView checkoutstep2recycler;
    Context context;


    //IMPORTANT//
    String payment_type="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_step_2);

//        this.overridePendingTransition(R.anim.ltr_checkout_step_2,
//                R.anim.rtl_checkout_step_2);

//        checkoutstep2recycler = (RecyclerView) findViewById(R.id.checkoutstep2_recycler);
//        checkoutstep2recycler.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if (hasFocus) {
//                    // run scale animation and make it bigger
//                    Animation anim = AnimationUtils.loadAnimation(context, R.anim.scale_in_tv);
//                    v.startAnimation(anim);
//                    anim.setFillAfter(true);
//                } else {
//                    // run scale animation and make it smaller
//                    Animation anim = AnimationUtils.loadAnimation(context, R.anim.scale_out_tv);
//                    v.startAnimation(anim);
//                    anim.setFillAfter(true);
//                }
//            }
//        });


        recyclerView = (RecyclerView) findViewById(R.id.checkoutstep2_recycler);
        checkoutstep2Adapter();

        CheckoutStep2Model checkoutStep2Model1 = new CheckoutStep2Model("SUNITHA","1234-5678-9876-5432","07/20",R.drawable.ic_select, 0);
        checkoutStep2Model.add(checkoutStep2Model1);

        CheckoutStep2Model checkoutStep2Model2 = new CheckoutStep2Model("SUNITHA","1234-5678-9876-5432","07/20",R.drawable.ic_unselect, 0);
        checkoutStep2Model.add(checkoutStep2Model2);

        //Calling previous page
        ImageView back = (ImageView) findViewById(R.id.backtopreviouspage);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        ImageView debitcard = (ImageView) findViewById(R.id.debitcard);
        ImageView creditcard = (ImageView) findViewById(R.id.creditcard);
        ImageView paypal = (ImageView) findViewById(R.id.paypal);
        ImageView cod = (ImageView) findViewById(R.id.cod);

        ///Debit Card
        debitcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                debitcard.setImageResource(R.drawable.ic_tick);
                creditcard.setImageResource(R.drawable.ic_untick);
                paypal.setImageResource(R.drawable.ic_untick);
                cod.setImageResource(R.drawable.ic_untick);
                payment_type = "debit";
            }
        });

        ///Credit Card
        creditcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                debitcard.setImageResource(R.drawable.ic_untick);
                creditcard.setImageResource(R.drawable.ic_tick);
                paypal.setImageResource(R.drawable.ic_untick);
                cod.setImageResource(R.drawable.ic_untick);
                payment_type = "credit";
            }
        });

        ///Paypal Card

        paypal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                debitcard.setImageResource(R.drawable.ic_untick);
                creditcard.setImageResource(R.drawable.ic_untick);
                paypal.setImageResource(R.drawable.ic_tick);
                cod.setImageResource(R.drawable.ic_untick);
                payment_type = "paypal";
            }
        });

        ///COD Card

        cod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                debitcard.setImageResource(R.drawable.ic_untick);
                creditcard.setImageResource(R.drawable.ic_untick);
                paypal.setImageResource(R.drawable.ic_untick);
                cod.setImageResource(R.drawable.ic_tick);
                payment_type = "cod";
            }
        });



    }

    ///MY CART///
    public void checkoutstep2Adapter(){
        checkoutStep2Adapter = new CheckoutStep2Adapter(this, checkoutStep2Model);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        gridLayoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(checkoutStep2Adapter);

/////////////// TO REMOVE CARD ///////////////////
        checkoutStep2Adapter.SetOnItemClickListener(new CheckoutStep2Adapter.OnItemClickProductCheckoutStep2() {
            @Override
            public void onItemClick(View view, int position, String type) {
                if(type.equals("remove")){
                    checkoutStep2Model.remove(position).setCard_remove(1);
                }else {
                    checkoutStep2Model.remove(position).setCard_remove(0);
                }

                checkoutStep2Adapter.notifyDataSetChanged();
            }
        });
/////////////// TO REMOVE CARD ///////////////////

    }


    public void buttonClicked(View view) {
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        view = layoutInflater.inflate(R.layout.alert_dialog_checkout_step_3_activity, null);
        final AlertDialog dialog = new AlertDialog.Builder(this).create();
        ImageView gobacktocheckout = (ImageView) view.findViewById(R.id.gobacktocheckout);
        Button gotomyorders = (Button) view.findViewById(R.id.gotomyorders);

        gobacktocheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        gotomyorders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotomyorders = new Intent(CheckoutStep2Activity.this, MyOrdersActivity.class);
                startActivity(gotomyorders);
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

}
