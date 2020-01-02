package com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.SecondBeverages;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.exarcplus.foodzeetest2.R;

import java.util.ArrayList;

public class SecondBeveragesReviewAdapter extends RecyclerView.Adapter<SecondBeveragesReviewAdapter.MyViewHolder> {

    ArrayList<SecondBeveragesReviewModel>  secondBeveragesReviewModels = new ArrayList();
    Context context;

    public SecondBeveragesReviewAdapter(Context context, ArrayList<SecondBeveragesReviewModel> secondBeveragesReviewModels) {
        this.context = context;
        this.secondBeveragesReviewModels = secondBeveragesReviewModels;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout_home_second_beverages_reviews, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.name.setText(secondBeveragesReviewModels.get(position).getBeveragesreviewNames());
        holder.rating.setText(secondBeveragesReviewModels.get(position).getBeveragesreviewRating());
        holder.text.setText(secondBeveragesReviewModels.get(position).getBeveragesreviewText());
        holder.image.setImageResource(secondBeveragesReviewModels.get(position).getBeveragesreviewImages());
    }

    @Override
    public int getItemCount() {
        return secondBeveragesReviewModels.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView rating;
        TextView text;
        ImageView image;
        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            rating = (TextView) itemView.findViewById(R.id.rating);
            text = (TextView) itemView.findViewById(R.id.text);
            image = (ImageView) itemView.findViewById(R.id.image);
        }
    }

}
