package com.exarcplus.foodzeetest2.NavDraw.MyOrdersActivity;

import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.SecondFreshItems.SecondFreshItemActivity;
import com.exarcplus.foodzeetest2.R;

import java.util.ArrayList;

public class MyOrdersCurrentAllAdapter extends RecyclerView.Adapter<MyOrdersCurrentAllAdapter.MyViewHolder> {

    ArrayList<MyOrdersCurrentModel>  myOrdersCurrentModels = new ArrayList();

    Context context;
    public MyOrdersCurrentAllAdapter(Context context, ArrayList<MyOrdersCurrentModel> myOrdersCurrentModels) {
        this.context = context;
        this.myOrdersCurrentModels = myOrdersCurrentModels;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout_myorders_current_all, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.name.setText(myOrdersCurrentModels.get(position).getMyordercurrentNames());
        holder.prices.setText(myOrdersCurrentModels.get(position).getMyordercurrentPrices());
        holder.item.setText(myOrdersCurrentModels.get(position).getMyordercurrentItem());
        holder.image.setImageResource(myOrdersCurrentModels.get(position).getMyordercurrentImages());
        holder.vnv.setImageResource(myOrdersCurrentModels.get(position).getMyordercurrentVNV());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SecondFreshItemActivity.class);
                intent.putExtra("name", myOrdersCurrentModels.get(position).getMyordercurrentNames());
                intent.putExtra("price", myOrdersCurrentModels.get(position).getMyordercurrentPrices());
                intent.putExtra("image", myOrdersCurrentModels.get(position).getMyordercurrentImages());
                intent.putExtra("vnv", myOrdersCurrentModels.get(position).getMyordercurrentVNV());
                context.startActivity(intent);
            }
        });



    }
    @Override
    public int getItemCount() {
        return myOrdersCurrentModels.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView prices;
        TextView item;
        ImageView image;
        ImageView vnv;
        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            prices = (TextView) itemView.findViewById(R.id.prices);
            item = (TextView) itemView.findViewById(R.id.item);
            image = (ImageView) itemView.findViewById(R.id.image);
            vnv = (ImageView) itemView.findViewById(R.id.vnv);
        }
    }

}
