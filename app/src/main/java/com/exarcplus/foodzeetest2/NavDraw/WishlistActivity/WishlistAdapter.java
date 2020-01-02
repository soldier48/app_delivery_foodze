package com.exarcplus.foodzeetest2.NavDraw.WishlistActivity;

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

public class WishlistAdapter extends RecyclerView.Adapter<WishlistAdapter.MyViewHolder> {

    ArrayList<WishlistModel>  wishlistModels = new ArrayList();
    Context context;
    OnItemClickProductWishlist listener;
    OnItemClickProductWishlist listener2;

    public WishlistAdapter(Context context, ArrayList<WishlistModel> wishlistModels) {
        this.context = context;
        this.wishlistModels = wishlistModels;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout_wishlist, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.name.setText(wishlistModels.get(position).getWishlistNames());
        holder.prices.setText(wishlistModels.get(position).getWishlistPrices());
        holder.image.setImageResource(wishlistModels.get(position).getWishlistImages());
        holder.vnv.setImageResource(wishlistModels.get(position).getWishlistVNV());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SecondFreshItemActivity.class);
                intent.putExtra("image", wishlistModels.get(position).getWishlistImages());
                context.startActivity(intent);
            }
        });



/////////////// TO REMOVE FROM WISHLIST ///////////////////

        /*if(wishlistModels.get(position).getWishlist_remove()==0){
            wishlistModels.add(position);
        }else {
            wishlistModels.remove(position);
        }*/

        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wishlistModels.get(position).getWishlist_remove()==0){
                    listener.onItemClick(v,position,"remove");
                    wishlistModels.remove(position);
                }else {
                    listener.onItemClick(v,position,"dontremove");
                }
            }
        });

/////////////// TO REMOVE FROM WISHLIST ///////////////////

/////////////// TO ADD TO CART ///////////////////

        if(wishlistModels.get(position).getAdd_status()==0){
            holder.addtocart.setVisibility(View.VISIBLE);
            holder.removefromcart.setVisibility(View.GONE);

        }else {
            holder.addtocart.setVisibility(View.GONE);
            holder.removefromcart.setVisibility(View.VISIBLE);
        }

        holder.addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wishlistModels.get(position).getAdd_status()==0){
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
                if(wishlistModels.get(position).getAdd_status()==0){
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
        return wishlistModels.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView prices;
        ImageView image;
        ImageView vnv;
        TextView remove;
        TextView addtocart;
        TextView removefromcart;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            prices = (TextView) itemView.findViewById(R.id.prices);
            image = (ImageView) itemView.findViewById(R.id.image);
            vnv = (ImageView) itemView.findViewById(R.id.vnv);
            remove = (TextView) itemView.findViewById(R.id.removefromwishlist);
            addtocart = (TextView) itemView.findViewById(R.id.addtocart);
            removefromcart = (TextView) itemView.findViewById(R.id.removefromcart);

        }
    }

    public interface OnItemClickProductWishlist {
        public void onItemClick(View view, int position,String type);
    }

    public void SetOnItemClickListener(final OnItemClickProductWishlist mItemClickListener)
    {
        this.listener = mItemClickListener;
    }


}
