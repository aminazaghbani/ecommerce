package com.example.ecommerce2.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerce2.Interface.ItemClickListener;
import com.example.ecommerce2.R;


public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    public TextView txtProductName,txtProductDescription,txtProductPrice, txtProductState;
    public android.widget.ImageView ImageView;
    public ItemClickListener listener;
    public Object imageView;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);

        ImageView= (ImageView) itemView.findViewById(R.id.seller_product_image);
        txtProductName= (TextView) itemView.findViewById(R.id.seller_product_name);
        txtProductDescription= (TextView) itemView.findViewById(R.id.seller_product_description);
        txtProductPrice= (TextView) itemView.findViewById(R.id.seller_product_price);
        txtProductState= (TextView) itemView.findViewById(R.id.seller_product_state);
    }
    public void setItemClickListener(ItemClickListener listener)
    {
        this.listener=listener;

    }

    @Override
    public void onClick(View v)
    {
        listener.onClick(v, getAdapterPosition(),false);
    }
}

