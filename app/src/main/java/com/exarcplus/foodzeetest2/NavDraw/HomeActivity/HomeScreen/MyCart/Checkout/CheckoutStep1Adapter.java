package com.exarcplus.foodzeetest2.NavDraw.HomeActivity.HomeScreen.MyCart.Checkout;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.exarcplus.foodzeetest2.R;

import java.util.ArrayList;

public class CheckoutStep1Adapter extends RecyclerView.Adapter<CheckoutStep1Adapter.MyViewHolder> {

    ArrayList<CheckoutStep1Model>  checkoutStep1Model = new ArrayList();
    Context context;

    String addressname;
    String addressaddress;

    OnItemClickProductCheckoutStep1 listener;

    public CheckoutStep1Adapter(Context context, ArrayList<CheckoutStep1Model> checkoutStep1Model) {
        this.context = context;
        this.checkoutStep1Model = checkoutStep1Model;

    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout_home_checkout_address, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;


    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.nameofaddress.setText(checkoutStep1Model.get(position).getCheckoutstep1Names());
        holder.addressofaddress.setText(checkoutStep1Model.get(position).getCheckoutstep1Address());
        holder.select.setImageResource(checkoutStep1Model.get(position).getCheckoutstep1Select());

//        Intent intent = ((Activity) context).getIntent();


/////////////// TO REMOVE ADDRESS ///////////////////

        if(checkoutStep1Model.get(position).getAddress_remove()==0){
            checkoutStep1Model.get(position);
        }else {
            checkoutStep1Model.remove(position);

        }

        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkoutStep1Model.get(position).getAddress_remove()==0){
                    listener.onItemClick(v,position,"remove");
                }else {
                    listener.onItemClick(v,position,"dontremove");
                }
            }
        });

/////////////// TO REMOVE ADDRESS ///////////////////

/////////////// TO EDIT ADDRESS ///////////////////

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(checkoutStep1Model.get(position).getAddress_edit()==0){
                    listener.onItemClick(v,position,"edit");

                }else {
                    listener.onItemClick(v,position,"dontedit");
                }


//                Intent intent = new Intent(context, AlertDialogCheckoutStep1Activity.class);
//                Intent intent = new Intent();
//                Intent intent = ((Activity) context).getIntent();
//                Intent intent = ((AlertDialogCheckoutStep1Activity) context).getIntent();

//                TextView nameofaddress = v.findViewById(R.id.name);
//                String name = intent.getStringExtra("NameOfAddress");
//                if(name!=null && !name.equals("")){
//                    nameofaddress.setText(name);
//                }

//                TextView nameofaddress = (TextView) v.findViewById(R.id.nameofaddress);
//                TextView addressofaddress = (TextView) v.findViewById(R.id.addressofaddress);
//                intent.putExtra("NameOfAddress",holder.nameofaddress.getText().toString());
//                intent.putExtra("AddressOfAddress",holder.addressofaddress.getText().toString());
//                context.startActivity(intent);
            }
        });

//        String addressname = getIntent().getStringExtra("NameOfEditedAddress");
//        String addressaddress = getIntent().getStringExtra("AddressOfEditedAddress");


/////////////// TO EDIT ADDRESS //////////////////
    }

    @Override
    public int getItemCount() {
        return checkoutStep1Model.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nameofaddress;
        TextView addressofaddress;
        ImageView select;
        Button remove;
        Button edit;

        TextView username_profile;

        public MyViewHolder(View itemView) {
            super(itemView);
            nameofaddress = (TextView) itemView.findViewById(R.id.nameofaddress);
            addressofaddress = (TextView) itemView.findViewById(R.id.addressofaddress);
            select = (ImageView) itemView.findViewById(R.id.select);
            remove = (Button) itemView.findViewById(R.id.removemyaddress);
            edit = (Button) itemView.findViewById(R.id.editmyaddress);
            username_profile = itemView.findViewById(R.id.username_profile);



        }
    }

    public interface OnItemClickProductCheckoutStep1 {
        public void onItemClick(View view, int position,String type);
    }

    public void SetOnItemClickListener(final CheckoutStep1Adapter.OnItemClickProductCheckoutStep1 mItemClickListener)
    {
        this.listener = mItemClickListener;
    }

}
