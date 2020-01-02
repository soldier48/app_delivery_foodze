package com.exarcplus.foodzeetest2.NavDraw.NotificationsActivity;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.exarcplus.foodzeetest2.R;

import java.util.ArrayList;

public class NotificationsAdapter extends RecyclerView.Adapter<NotificationsAdapter.MyViewHolder> {

    ArrayList<NotificationsModel>  notificationsModels = new ArrayList();
    Context context;

    public NotificationsAdapter(Context context, ArrayList<NotificationsModel> notificationsModels) {
        this.context = context;
        this.notificationsModels = notificationsModels;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout_notifications, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.name.setText(notificationsModels.get(position).getNotificationsNames());
        holder.content.setText(notificationsModels.get(position).getNotificationsContent());
        holder.image.setImageResource(notificationsModels.get(position).getNotificationsImages());




    }
    @Override
    public int getItemCount() {
        return notificationsModels.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView content;
        ImageView image;
        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            content = (TextView) itemView.findViewById(R.id.content);
            image = (ImageView) itemView.findViewById(R.id.image);
        }
    }

}
