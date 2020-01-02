package com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.MyCart.Checkout;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.exarcplus.foodzeetest2.R;

import java.util.ArrayList;

public class CheckoutStep2Adapter extends RecyclerView.Adapter<CheckoutStep2Adapter.MyViewHolder> {

    ArrayList<CheckoutStep2Model>  checkoutStep2Model = new ArrayList();
    Context context;
    CheckoutStep2Adapter.OnItemClickProductCheckoutStep2 listener;

    public CheckoutStep2Adapter(Context context, ArrayList<CheckoutStep2Model> checkoutStep2Model) {
        this.context = context;
        this.checkoutStep2Model = checkoutStep2Model;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout_home_checkout_card, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;

    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.name.setText(checkoutStep2Model.get(position).getCheckoutstep2Names());
        holder.cardnumber.setText(checkoutStep2Model.get(position).getCheckoutstep2CardNumber());
        holder.expirydate.setText(checkoutStep2Model.get(position).getCheckoutstep2ExpiryDate());
        holder.select.setImageResource(checkoutStep2Model.get(position).getCheckoutstep2Select());

/////////////// TO REMOVE CARD ///////////////////

        if(checkoutStep2Model.get(position).getCard_remove()==0){
            checkoutStep2Model.get(position);
        }else {
            checkoutStep2Model.remove(position);

        }

        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkoutStep2Model.get(position).getCard_remove()==0){
                    listener.onItemClick(v,position,"remove");
                }else {
                    listener.onItemClick(v,position,"dontremove");
                }
            }
        });

/////////////// TO REMOVE CARD ///////////////////



    }
    @Override
    public int getItemCount() {
        return checkoutStep2Model.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView cardnumber;
        TextView expirydate;
        ImageView select;
        Button remove;
        RecyclerView checkoutstep2recycler;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            cardnumber = (TextView) itemView.findViewById(R.id.cardnumber);
            expirydate = (TextView) itemView.findViewById(R.id.expirydate);
            select = (ImageView) itemView.findViewById(R.id.select);
            remove = (Button) itemView.findViewById(R.id.removemycard);
            checkoutstep2recycler = (RecyclerView) itemView.findViewById(R.id.checkoutstep2_recycler);

            itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (hasFocus) {
                        // run scale animation and make it bigger
                        Animation anim = AnimationUtils.loadAnimation(context, R.anim.scale_in_tv);
                        v.startAnimation(anim);
                        anim.setFillAfter(true);
                    } else {
                        // run scale animation and make it smaller
                        Animation anim = AnimationUtils.loadAnimation(context, R.anim.scale_out_tv);
                        v.startAnimation(anim);
                        anim.setFillAfter(true);
                    }
                }
            });
        }
    }

    public interface OnItemClickProductCheckoutStep2 {
        public void onItemClick(View view, int position,String type);
    }

    public void SetOnItemClickListener(final CheckoutStep2Adapter.OnItemClickProductCheckoutStep2 mItemClickListener)
    {
        this.listener = mItemClickListener;
    }

}
