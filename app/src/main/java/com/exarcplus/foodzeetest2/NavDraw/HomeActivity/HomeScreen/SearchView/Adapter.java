package com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.SearchView;

import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.SecondFreshItems.SecondFreshItemActivity;
import com.exarcplus.foodzeetest2.R;

import java.util.ArrayList;

/**
 * Created by Parsania Hardik on 26-Jun-17.
 */
public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private Context context;
    private ArrayList<Model> imageModelArrayList;
    private ArrayList<Model> arraylist;

    public Adapter(Context context, ArrayList<Model> imageModelArrayList){

        this.context = context;
        this.imageModelArrayList = imageModelArrayList;
        this.arraylist = new ArrayList<Model>();
        this.arraylist.addAll(SearchViewActivity.NamesArrayList);
    }

    @Override
    public Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_view_list_view_items, parent, false);
        MyViewHolder holder = new MyViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(Adapter.MyViewHolder holder, int position) {

        holder.food.setText(imageModelArrayList.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SecondFreshItemActivity.class);
                intent.putExtra("name", arraylist.get(position).getName());
//                intent.putExtra("image", beveragesVNV.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return imageModelArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView food;

        public MyViewHolder(View itemView) {
            super(itemView);

           food = (TextView) itemView.findViewById(R.id.name);
          }

    }
}

