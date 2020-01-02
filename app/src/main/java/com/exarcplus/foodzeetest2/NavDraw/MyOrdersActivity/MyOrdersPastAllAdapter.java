package com.exarcplus.foodzeetest2.NavDraw.MyOrdersActivity;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.exarcplus.foodzeetest2.R;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import java.util.ArrayList;

public class MyOrdersPastAllAdapter extends RecyclerView.Adapter<MyOrdersPastAllAdapter.MyViewHolder> {

    ArrayList<MyOrdersPastModel>  myOrdersPastModels = new ArrayList();
//    ArrayList<MyOrdersPastModel.MyOrdersPastItem> myOrdersPastItems = new ArrayList<>();
    int item_disappear;
//    TextView past_more;
//    TextView past_less;
//    LinearLayout past_items_displayed;
//    ExpandableRelativeLayout expandableLayout2;


    Context context;
    public MyOrdersPastAllAdapter(Context context, ArrayList<MyOrdersPastModel> myOrdersPastModels) {
        this.context = context;
        this.myOrdersPastModels = myOrdersPastModels;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout_myorders_past_all, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;

    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

//        holder.name.setText(myOrdersPastModels.get(position).myOrdersPastItems.get(position).getMyorderpastNames());

        holder.name.setText(myOrdersPastModels.get(position).myOrdersPastItems.get(position).getMyorderpastNames());
        holder.prices.setText(myOrdersPastModels.get(position).myOrdersPastItems.get(position).getMyorderpastPrices());
        holder.item.setText(myOrdersPastModels.get(position).myOrdersPastItems.get(position).getMyorderpastItem());
        holder.item.setText(myOrdersPastModels.get(position).myOrdersPastItems.get(position).getMyorderpastItem());
        holder.pastorderid.setText(myOrdersPastModels.get(position).getPastorderID());
        holder.pastorderTime.setText(myOrdersPastModels.get(position).getPastorderTime());
        holder.pastdeliveryTime.setText(myOrdersPastModels.get(position).getPastdeliveryTime());
        holder.image.setImageResource(myOrdersPastModels.get(position).myOrdersPastItems.get(position).getMyorderpastImages());
        holder.vnv.setImageResource(myOrdersPastModels.get(position).myOrdersPastItems.get(position).getMyorderpastVNV());
//        holder.image.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(context, SecondFreshItemActivity.class);
//                intent.putExtra("name", myorderpastNames.get(position));
//                intent.putExtra("price", myorderpastPrices.get(position));
//                intent.putExtra("image", myorderpastImages.get(position));
//                intent.putExtra("vnv", myorderpastVNV.get(position));
//                context.startActivity(intent);
//            }
//        });
//        holder.rnr.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(context, SecondFreshItemActivity.class);
//                context.startActivity(intent);
//            }
//        });

//        if(item_disappear == 0){
//            past_items_displayed.setVisibility(View.GONE);
//        }else {
//            past_items_displayed.setVisibility(View.VISIBLE);
//
//        }

        holder.past_more.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {



//                expandableLayout2.toggle();
//                if(item_disappear == 0){
//                    past_items_displayed.setVisibility(View.GONE);
//
//                }else {
//                    past_items_displayed.setVisibility(View.VISIBLE);
//                    expandableLayout2.toggle();
//                }

                if(item_disappear == 0){
                    holder.expandableLayout2.toggle();
                    holder.past_items_displayed.setVisibility(View.VISIBLE);
                    holder.past_more.setVisibility(View.GONE);
                    holder.past_less.setVisibility(View.VISIBLE);

                }else {
                    holder.past_items_displayed.setVisibility(View.GONE);
                    holder.past_more.setVisibility(View.VISIBLE);
                    holder.past_less.setVisibility(View.GONE);
                }

            }

        });

        holder.past_less.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
//                past_more = (TextView) view.findViewById(R.id.past_more);
//                past_less = (TextView) view.findViewById(R.id.past_less);
//                past_items_displayed = (LinearLayout) view.findViewById(R.id.past_items_displayed);
//                expandableLayout2 = (ExpandableRelativeLayout) view.findViewById(R.id.expandableLayout2);


//                if(item_disappear == 0){
//                    past_items_displayed.setVisibility(View.GONE);
//                }else {
//                    past_items_displayed.setVisibility(View.VISIBLE);
//                }

                if(item_disappear == 0){
                    holder.expandableLayout2.toggle();
                    holder.past_items_displayed.setVisibility(View.GONE);
                    holder.past_more.setVisibility(View.VISIBLE);
                    holder.past_less.setVisibility(View.GONE);
                }else {
                    holder.past_items_displayed.setVisibility(View.VISIBLE);
                    holder.past_more.setVisibility(View.GONE);
                    holder.past_less.setVisibility(View.VISIBLE);
                }

            }

        });




    }

    @Override
    public int getItemCount() {
        return myOrdersPastModels.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView prices;
        TextView item;
        TextView pastorderid;
        TextView pastorderTime;
        TextView pastdeliveryTime;
        ImageView image;
        ImageView vnv;
        TextView rnr;
        TextView past_less;
        TextView past_more;
        LinearLayout past_items_displayed;
        ExpandableRelativeLayout expandableLayout2;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            prices = (TextView) itemView.findViewById(R.id.prices);
            item = (TextView) itemView.findViewById(R.id.item);
            pastorderid = (TextView) itemView.findViewById(R.id.pastorderid);
            pastorderTime = (TextView) itemView.findViewById(R.id.pastordertime);
            pastdeliveryTime = (TextView) itemView.findViewById(R.id.pastdeliverytime);
            image = (ImageView) itemView.findViewById(R.id.image);
            vnv = (ImageView) itemView.findViewById(R.id.vnv);
            rnr = (TextView) itemView.findViewById(R.id.rateandreview);
            past_less = (TextView) itemView.findViewById(R.id.past_less);
            past_more = (TextView) itemView.findViewById(R.id.past_more);
            past_items_displayed = (LinearLayout) itemView.findViewById(R.id.past_items_displayed);
            expandableLayout2 = (ExpandableRelativeLayout) itemView.findViewById(R.id.expandableLayout2);


        }

    }
//    public void expandableButton2(View view) {
//        expandableLayout2 = (ExpandableRelativeLayout) view.findViewById(R.id.expandableLayout2);
//        expandableLayout2.toggle(); // toggle expand and collapse
//    }


}
