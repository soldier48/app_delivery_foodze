package com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.SecondFreshItems;

import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.exarcplus.foodzeetest2.R;

import java.util.ArrayList;

public class SecondFreshItemExtraAdapter extends RecyclerView.Adapter<SecondFreshItemExtraAdapter.MyViewHolder> {

    ArrayList<SecondFreshItemExtraModel>  secondFreshItemExtraModels = new ArrayList();
    Context context;

    public SecondFreshItemExtraAdapter(Context context, ArrayList<SecondFreshItemExtraModel> secondFreshItemExtraModels) {
        this.context = context;
        this.secondFreshItemExtraModels = secondFreshItemExtraModels;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout_home_second_fresh_item_extra, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.name.setText(secondFreshItemExtraModels.get(position).getFreshitemviewNames());
        holder.image.setImageResource(secondFreshItemExtraModels.get(position).getFreshitemviewImages());
        holder.vnv.setImageResource(secondFreshItemExtraModels.get(position).getFreshitemviewVNV());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SecondFreshItemActivity.class);
                intent.putExtra("name", secondFreshItemExtraModels.get(position).getFreshitemviewNames());
                intent.putExtra("image", secondFreshItemExtraModels.get(position).getFreshitemviewImages());
                intent.putExtra("vnv", secondFreshItemExtraModels.get(position).getFreshitemviewVNV());
                context.startActivity(intent);
            }
        });



    }
    @Override
    public int getItemCount() {
        return secondFreshItemExtraModels.size();
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
