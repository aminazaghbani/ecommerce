package com.example.ecommerce2.Sellers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.ecommerce2.R;

public class SellerProductCategoryActivity extends AppCompatActivity
{
 private ImageView tshirts, sportTshirts, femaledresses, vestes;
 private ImageView glasses, hats, shoes, bags;
 private  ImageView laptops, watches, mobiles,heatphones;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_product_category);

        tshirts=(ImageView) findViewById(R.id.t_shirts);
        sportTshirts=(ImageView) findViewById(R.id.sport_t_shirts);
        femaledresses=(ImageView) findViewById(R.id.female_dresses);
        vestes=(ImageView) findViewById(R.id.vestes);

        glasses=(ImageView) findViewById(R.id.glasses);
        hats=(ImageView) findViewById(R.id.hats);
        shoes=(ImageView) findViewById(R.id.shoes);
        bags=(ImageView) findViewById(R.id.bags);

        laptops=(ImageView) findViewById(R.id.latops);
        watches=(ImageView) findViewById(R.id.watches);
        mobiles=(ImageView) findViewById(R.id.mobiles);
        heatphones=(ImageView) findViewById(R.id.headphones);



        tshirts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
              Intent intent=new Intent(SellerProductCategoryActivity.this, SellerAddNewProductActivity.class);
              intent.putExtra("category", "tshirts");
              startActivity(intent);
            }
        });

        sportTshirts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(SellerProductCategoryActivity.this, SellerAddNewProductActivity.class);
                intent.putExtra("category", "sportTshirts");
                startActivity(intent);
            }
        });

        femaledresses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(SellerProductCategoryActivity.this, SellerAddNewProductActivity.class);
                intent.putExtra("category", "femaledresses");
                startActivity(intent);
            }
        });

        vestes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(SellerProductCategoryActivity.this, SellerAddNewProductActivity.class);
                intent.putExtra("category", "vestes");
                startActivity(intent);
            }
        });

        glasses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(SellerProductCategoryActivity.this, SellerAddNewProductActivity.class);
                intent.putExtra("category", "glasses");
                startActivity(intent);
            }
        });

        hats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(SellerProductCategoryActivity.this, SellerAddNewProductActivity.class);
                intent.putExtra("category", "hats");
                startActivity(intent);
            }
        });

        shoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(SellerProductCategoryActivity.this, SellerAddNewProductActivity.class);
                intent.putExtra("category", "shoes");
                startActivity(intent);
            }
        });

        bags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(SellerProductCategoryActivity.this, SellerAddNewProductActivity.class);
                intent.putExtra("category", "bags");
                startActivity(intent);
            }
        });

        heatphones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(SellerProductCategoryActivity.this, SellerAddNewProductActivity.class);
                intent.putExtra("category", "heatphones");
                startActivity(intent);
            }
        });

        laptops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(SellerProductCategoryActivity.this, SellerAddNewProductActivity.class);
                intent.putExtra("category", "laptops");
                startActivity(intent);
            }
        });

        watches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(SellerProductCategoryActivity.this, SellerAddNewProductActivity.class);
                intent.putExtra("category", "watches");
                startActivity(intent);
            }
        });

        mobiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(SellerProductCategoryActivity.this, SellerAddNewProductActivity.class);
                intent.putExtra("category", "mobiles");
                startActivity(intent);
            }
        });
    }
}