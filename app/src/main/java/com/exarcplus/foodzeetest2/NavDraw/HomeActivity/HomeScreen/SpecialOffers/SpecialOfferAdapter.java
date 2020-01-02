package com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.SpecialOffers;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.exarcplus.foodzeetest2.R;

import java.util.ArrayList;

public class SpecialOfferAdapter extends RecyclerView.Adapter<SpecialOfferAdapter.MyViewHolder> {

    ArrayList<SpecialOffersModel>  specialOffersModels = new ArrayList();
    Context context;


    public SpecialOfferAdapter(Context context, ArrayList<SpecialOffersModel> specialOffersModels) {
        this.context = context;
        this.specialOffersModels = specialOffersModels;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout_home_specialoffer, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.name.setText(specialOffersModels.get(position).getSpecialofferNames());
        holder.image.setImageResource(specialOffersModels.get(position).getSpecialofferImages());

    }
    @Override
    public int getItemCount() {
        return specialOffersModels.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView image;
        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            image = (ImageView) itemView.findViewById(R.id.image);
        }
    }

}
