package com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.FreshItemsRecycler;

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

public class FreshItemsAdapter2 extends RecyclerView.Adapter<FreshItemsAdapter2.MyViewHolder> {

    ArrayList<FreshItemsModell>  freshItemsModels2 = new ArrayList();
    Context context;
    OnItemClickProductFreshItem2 listener;

    public FreshItemsAdapter2(Context context, ArrayList<FreshItemsModell> freshItemsModels2) {
        this.context = context;
        this.freshItemsModels2 = freshItemsModels2;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout_home_freshitems, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.name.setText(freshItemsModels2.get(position).getFreshitemsNames2());
        holder.prices.setText(freshItemsModels2.get(position).getFreshitemsPrices2());
        holder.image.setImageResource(freshItemsModels2.get(position).getFreshitemsImages2());
        holder.vnv.setImageResource(freshItemsModels2.get(position).getFreshitemsVNV2());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SecondFreshItemActivity.class);
                intent.putExtra("name", freshItemsModels2.get(position).getFreshitemsNames2());
                intent.putExtra("price", freshItemsModels2.get(position).getFreshitemsPrices2());
                intent.putExtra("image", freshItemsModels2.get(position).getFreshitemsImages2());
//                intent.putExtra("image", beveragesVNV.get(position));
                context.startActivity(intent);
            }
        });

        if(freshItemsModels2.get(position).getLike_status2()==0){
            holder.prelike.setImageResource(R.drawable.ic_prelike);
        }else {
            holder.prelike.setImageResource(R.drawable.ic_like);

        }

        holder.prelike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(freshItemsModels2.get(position).getLike_status2()==0){
                        listener.onItemClick(v,position,"like");
                    }else {
                        listener.onItemClick(v,position,"un_like");
                    }
            }
        });


        /////////////// TO ADD TO CART ///////////////////

        if(freshItemsModels2.get(position).getAdd_status2()==0){
            holder.addtocart.setVisibility(View.VISIBLE);
            holder.removefromcart.setVisibility(View.GONE);

        }else {
            holder.addtocart.setVisibility(View.GONE);
            holder.removefromcart.setVisibility(View.VISIBLE);


        }

        holder.addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(freshItemsModels2.get(position).getAdd_status2()==0){
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
                if(freshItemsModels2.get(position).getAdd_status2()==0){
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
        return freshItemsModels2.size();
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

    public interface OnItemClickProductFreshItem2 {
        public void onItemClick(View view, int position, String type);
    }

    public void SetOnItemClickListener(final OnItemClickProductFreshItem2 mItemClickListener)
    {
        this.listener = mItemClickListener;
    }
}
