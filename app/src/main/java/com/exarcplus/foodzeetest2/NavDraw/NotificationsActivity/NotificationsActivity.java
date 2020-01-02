package com.exarcplus.foodzeetest2.NavDraw.NotificationsActivity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.exarcplus.foodzeetest2.R;

import java.util.ArrayList;

public class NotificationsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<NotificationsModel> notificationsModel = new ArrayList<>();
    NotificationsAdapter notificationsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_notifications);
        notificationsAdapter();

        NotificationsModel notificationsModel1 = new NotificationsModel("Your Order Delivered Just Now", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam id velit aliquam tortor sodales convallis nec ac nulla.", R.drawable.ic_notification);
        notificationsModel.add(notificationsModel1);

        NotificationsModel notificationsModel2 = new NotificationsModel("Your Rating Has Been Posted", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam id velit aliquam tortor sodales convallis nec ac nulla.", R.drawable.ic_notification);
        notificationsModel.add(notificationsModel2);

        NotificationsModel notificationsModel3 = new NotificationsModel("Your Order Delivered Just Now", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam id velit aliquam tortor sodales convallis nec ac nulla.", R.drawable.ic_notification);
        notificationsModel.add(notificationsModel3);

        NotificationsModel notificationsModel4 = new NotificationsModel("Your Order Confirmed", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam id velit aliquam tortor sodales convallis nec ac nulla.", R.drawable.ic_notification);
        notificationsModel.add(notificationsModel4);


        //Calling home fragment
        ImageView back = (ImageView) findViewById(R.id.backtopreviouspage);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    ///Notifications///
    public void notificationsAdapter(){
        NotificationsAdapter notificationsAdapter = new NotificationsAdapter(this, notificationsModel);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(notificationsAdapter);
    }
}
