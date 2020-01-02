package com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.BeveragesRecycler;

import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.SecondBeverages.SecondBeveragesActivity;
import com.exarcplus.foodzeetest2.R;

import java.util.ArrayList;

public class BeveragesAdapter2 extends RecyclerView.Adapter<BeveragesAdapter2.MyViewHolder> {

    ArrayList<BeveragesModell>  beveragesModels2 = new ArrayList();
    Context context;
    OnItemClickProductBeverages2 listener;

    public BeveragesAdapter2(Context context, ArrayList<BeveragesModell> beveragesModels2) {
        this.context = context;
        this.beveragesModels2 = beveragesModels2;

    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout_home_beverages, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.name.setText(beveragesModels2.get(position).getBeveragesNames2());
        holder.prices.setText(beveragesModels2.get(position).getBeveragesPrices2());
        holder.image.setImageResource(beveragesModels2.get(position).getBeveragesImages2());
        holder.vnv.setImageResource(beveragesModels2.get(position).getBeveragesVNV2());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SecondBeveragesActivity.class);
                intent.putExtra("name", beveragesModels2.get(position).getBeveragesNames2());
                intent.putExtra("price", beveragesModels2.get(position).getBeveragesPrices2());
                intent.putExtra("image", beveragesModels2.get(position).getBeveragesImages2());
//                intent.putExtra("image", beveragesVNV.get(position));
                context.startActivity(intent);
            }
        });

        if(beveragesModels2.get(position).getLike_status2()==0){
            holder.prelike.setImageResource(R.drawable.ic_prelike);
        }else {
            holder.prelike.setImageResource(R.drawable.ic_like);
        }

        holder.prelike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(beveragesModels2.get(position).getLike_status2()==0){
                        listener.onItemClick(v,position,"like");
                    }else {
                        listener.onItemClick(v,position,"un_like");
                    }
            }
        });


        /////////////// TO ADD TO CART ///////////////////

        if(beveragesModels2.get(position).getAdd_status2()==0){
            holder.addtocart.setVisibility(View.VISIBLE);
            holder.removefromcart.setVisibility(View.GONE);

        }else {
            holder.addtocart.setVisibility(View.GONE);
            holder.removefromcart.setVisibility(View.VISIBLE);


        }

        holder.addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(beveragesModels2.get(position).getAdd_status2()==0){
                    holder.addtocart.setVisibility(View.GONE);
                    holder.removefromcart.setVisibility(View.VISIBLE);
                }else {
                    holder.addtocart.setVisibility(View.VISIBLE);
                    holder.removefromcart.setVisibility(View.GONE);                }
            }
        });

        holder.removefromcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(beveragesModels2.get(position).getAdd_status2()==0){
                    holder.addtocart.setVisibility(View.VISIBLE);
                    holder.removefromcart.setVisibility(View.GONE);
                }else {
                    holder.addtocart.setVisibility(View.GONE);
                    holder.removefromcart.setVisibility(View.VISIBLE);                }
            }
        });



/////////////// TO ADD TO CART ///////////////////


    }
    @Override
    public int getItemCount() {
        return beveragesModels2.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView prices;
        ImageView image;
        ImageView vnv;
        ImageView prelike;
        TextView addtocart;
        TextView removefromcart;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            prices = (TextView) itemView.findViewById(R.id.prices);
            image = (ImageView) itemView.findViewById(R.id.image);
            vnv = (ImageView) itemView.findViewById(R.id.vnv);
            prelike = (ImageView) itemView.findViewById(R.id.prelike);
            addtocart = (TextView) itemView.findViewById(R.id.addtocart);
            removefromcart = (TextView) itemView.findViewById(R.id.removefromcart);
        }
    }

    public interface OnItemClickProductBeverages2 {
        public void onItemClick(View view, int position, String type);
    }

    public void SetOnItemClickListener(final BeveragesAdapter2.OnItemClickProductBeverages2 mItemClickListener)
    {
        this.listener = mItemClickListener;
    }
}
