package com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.MyCart.Checkout;

import android.content.Intent;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.exarcplus.foodzeetest2.R;

public class AlertDialogCheckoutStep1Activity extends AppCompatActivity {

    EditText nameofeditedaddress;
    EditText addressofeditedaddress;
    int position,rec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog_checkout_step1);

        nameofeditedaddress = (EditText) findViewById(R.id.addressname);
        addressofeditedaddress = (EditText) findViewById(R.id.addresslocation);

       // TextView address_name = findViewById(R.id.addressname);
        String addressname = getIntent().getStringExtra("NameOfAddress");
        if(addressname!=null && !addressname.equals("")){
            nameofeditedaddress.setText(addressname);
        }

     //   TextView address_location = findViewById(R.id.addresslocation);
        String addresslocation = getIntent().getStringExtra("AddressOfAddress");
        position = getIntent().getIntExtra("position",0);
        rec = getIntent().getIntExtra("new",0);
        if(addresslocation!=null && !addresslocation.equals("")){
            addressofeditedaddress.setText(addresslocation);
        }

        //Calling previous page
        ImageView back = (ImageView) findViewById(R.id.gobacktocheckout1);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        //Calling previous page by outside touch
        ConstraintLayout outsidepress1 = (ConstraintLayout) findViewById(R.id.checkoutstep1alertdialoglayout1);
        outsidepress1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        //Calling previous page by outside touch
        ConstraintLayout outsidepress2 = (ConstraintLayout) findViewById(R.id.checkoutstep1alertdialoglayout2);
        outsidepress2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        //Calling previous page by outside touch
        ConstraintLayout outsidepress3 = (ConstraintLayout) findViewById(R.id.checkoutstep1alertdialoglayout3);
        outsidepress3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        //Calling previous page by outside touch
        ConstraintLayout outsidepress4 = (ConstraintLayout) findViewById(R.id.checkoutstep1alertdialoglayout4);
        outsidepress4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        //Calling previous page
        Button submiteditedaddress = (Button) findViewById(R.id.submiteditedaddress);
        submiteditedaddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AlertDialogCheckoutStep1Activity.this, CheckoutStep1Activity.class);
                intent.putExtra("NameOfEditedAddress",nameofeditedaddress.getText().toString());
                intent.putExtra("AddressOfEditedAddress",addressofeditedaddress.getText().toString());
                intent.putExtra("new",rec);
                intent.putExtra("position",position);
                startActivity(intent);
                finish();
            }
        });




    }
}
