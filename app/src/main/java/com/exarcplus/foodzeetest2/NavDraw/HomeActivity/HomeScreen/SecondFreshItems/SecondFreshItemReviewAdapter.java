package com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.SecondFreshItems;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.exarcplus.foodzeetest2.R;

import java.util.ArrayList;

public class SecondFreshItemReviewAdapter extends RecyclerView.Adapter<SecondFreshItemReviewAdapter.MyViewHolder> {

    ArrayList<SecondFreshItemReviewModel>  secondFreshItemReviewModels = new ArrayList();
    Context context;

    public SecondFreshItemReviewAdapter(Context context, ArrayList<SecondFreshItemReviewModel> secondFreshItemReviewModels) {
        this.context = context;
        this.secondFreshItemReviewModels = secondFreshItemReviewModels;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout_home_second_fresh_item_reviews, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.name.setText(secondFreshItemReviewModels.get(position).getFreshitemreviewNames());
        holder.rating.setText(secondFreshItemReviewModels.get(position).getFreshitemreviewRating());
        holder.text.setText(secondFreshItemReviewModels.get(position).getFreshitemreviewText());
        holder.image.setImageResource(secondFreshItemReviewModels.get(position).getFreshitemreviewImages());
    }

    @Override
    public int getItemCount() {
        return secondFreshItemReviewModels.size();
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
