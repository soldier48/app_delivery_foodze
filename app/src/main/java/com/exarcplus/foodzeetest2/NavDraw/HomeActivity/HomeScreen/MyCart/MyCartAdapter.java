package com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.MyCart;

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

public class MyCartAdapter extends RecyclerView.Adapter<MyCartAdapter.MyViewHolder> {

    ArrayList<MyCartModel>  myCartModels = new ArrayList();
    Context context;
    OnItemClickProductMyCart listener;
    int minteger = 0;

    public MyCartAdapter(Context context, ArrayList<MyCartModel> myCartModels) {
        this.context = context;
        this.myCartModels = myCartModels;

    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout_home_cart, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.name.setText(myCartModels.get(position).getMycartNames());
        holder.prices.setText(myCartModels.get(position).getMycartPrices());
        holder.vnvtext.setText(myCartModels.get(position).getMycartVNVText());

//        holder.itemquantity.setText(myCartModels.get(position).getItemquantity());

        holder.image.setImageResource(myCartModels.get(position).getMycartImages());
        holder.vnv.setImageResource(myCartModels.get(position).getMycartVNV());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SecondFreshItemActivity.class);
                intent.putExtra("name", myCartModels.get(position).getMycartNames());
                intent.putExtra("price", myCartModels.get(position).getMycartPrices());
                intent.putExtra("vnvtext", myCartModels.get(position).getMycartVNVText());
                intent.putExtra("image", myCartModels.get(position).getMycartImages());
                intent.putExtra("vnv", myCartModels.get(position).getMycartVNV());
                context.startActivity(intent);
            }
        });


/////////////// TO REMOVE FROM WISHLIST ///////////////////

        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myCartModels.get(position).getItem_remove()==0){
                    listener.onItemClick(v,position,"remove");
                    myCartModels.remove(position);
                }else {
                    listener.onItemClick(v,position,"dontremove");
                }
            }
        });

/////////////// TO REMOVE FROM WISHLIST ///////////////////

/////////////// TO INCREMENT ///////////////////

        holder.increaseitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myCartModels.get(position).getItemquantity()==0){
                    listener.onItemClick(v,position,"increment");
                    try{

                        minteger = Integer.parseInt(holder.itemquantity.getText().toString());
                    }catch(Exception e) {
                        minteger = 0;
                    }
                    minteger = minteger + 1;
                    holder.itemquantity.setText(String.valueOf(minteger));

                }else {
                    listener.onItemClick(v,position,"dontincrement");
                }

            }
        });

        holder.decreaseitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myCartModels.get(position).getItemquantity()==0){
                listener.onItemClick(v,position,"decrement");
                    try{

                        minteger = Integer.parseInt(holder.itemquantity.getText().toString());
                    }catch(Exception e) {
                        minteger = 0;
                    }
                    if(minteger>0) minteger--;

                holder.itemquantity.setText(String.valueOf(minteger));

                }else {
                    listener.onItemClick(v,position,"dontdecrement");
                }
            }
        });
/////////////// TO INCREMENT ///////////////////

    }
    @Override
    public int getItemCount() {
        return myCartModels.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView prices;
        TextView vnvtext;
        ImageView image;
        ImageView vnv;
        ImageView remove;
        TextView itemquantity;
        ImageView increaseitem;
        ImageView decreaseitem;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            prices = (TextView) itemView.findViewById(R.id.prices);
            vnvtext = (TextView) itemView.findViewById(R.id.vnvtext);

            image = (ImageView) itemView.findViewById(R.id.image);
            vnv = (ImageView) itemView.findViewById(R.id.vnv);
            remove = (ImageView) itemView.findViewById(R.id.removefrommycart);

            itemquantity = (TextView) itemView.findViewById(R.id.quantity_item);
            increaseitem = (ImageView) itemView.findViewById(R.id.increase_item);
            decreaseitem = (ImageView) itemView.findViewById(R.id.decrease_item);

        }
    }

    public interface OnItemClickProductMyCart {
        public void onItemClick(View view, int position,String type);
    }

    public void SetOnItemClickListener(final MyCartAdapter.OnItemClickProductMyCart mItemClickListener)
    {
        this.listener = mItemClickListener;
    }

}
