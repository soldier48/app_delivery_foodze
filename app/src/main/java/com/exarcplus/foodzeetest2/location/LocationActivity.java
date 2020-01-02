package com.exarcplus.foodzeetest2.location;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.HomeActivity;
import com.exarcplus.foodzeetest2.R;

public class LocationActivity extends AppCompatActivity {
    TextView gotomaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        gotomaps = findViewById(R.id.searchbar_location);
        String address = getIntent().getStringExtra("address");

        if(address!=null && !address.equals("")){
            gotomaps.setText(address);

        }

        //got to maps

        gotomaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent maps = new Intent(LocationActivity.this, MapsActivity.class);
                startActivity(maps);
            }
        });

        //got to login screen
        Button go_to_home = findViewById(R.id.go_to_home);
        go_to_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_to_home = new Intent(LocationActivity.this, HomeActivity.class);
                go_to_home.putExtra("address",gotomaps.getText().toString());
                startActivity(go_to_home);
            }
        });


        SharedPreferences sp = getSharedPreferences("key", 0);
        SharedPreferences.Editor sedt = sp.edit();
        sedt.putString("addresspin", gotomaps.getText().toString());
        sedt.commit();


    }
}
