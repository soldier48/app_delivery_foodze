package com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.SecondBeverages;

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

public class SecondBeveragesExtraAdapter extends RecyclerView.Adapter<SecondBeveragesExtraAdapter.MyViewHolder> {

    ArrayList<SecondBeveragesExtraModel>  secondBeveragesExtraModel = new ArrayList();
    Context context;

    public SecondBeveragesExtraAdapter(Context context, ArrayList<SecondBeveragesExtraModel> secondBeveragesExtraModel) {
        this.context = context;
        this.secondBeveragesExtraModel = secondBeveragesExtraModel;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout_home_second_beverages_extra, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.name.setText(secondBeveragesExtraModel.get(position).getBeveragesviewNames());
        holder.image.setImageResource(secondBeveragesExtraModel.get(position).getBeveragesviewImages());
        holder.vnv.setImageResource(secondBeveragesExtraModel.get(position).getBeveragesviewVNV());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SecondFreshItemActivity.class);
                intent.putExtra("name", secondBeveragesExtraModel.get(position).getBeveragesviewNames());
                intent.putExtra("image", secondBeveragesExtraModel.get(position).getBeveragesviewImages());
                intent.putExtra("vnv", secondBeveragesExtraModel.get(position).getBeveragesviewVNV());
                context.startActivity(intent);
            }
        });



    }
    @Override
    public int getItemCount() {
        return secondBeveragesExtraModel.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView image;
        ImageView vnv;
        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            image = (ImageView) itemView.findViewById(R.id.image);
            vnv = (ImageView) itemView.findViewById(R.id.vnv);
        }
    }

}
