package com.example.ecommerce_app.Adapters;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerce_app.R;

public class CartViewHolder extends RecyclerView.ViewHolder {

    ImageView cartImg,cartDeleteImg;
    TextView cartTitle,cartPrice,cartQuantity,cartTotalPrice;
    Button increase,decrease;
    public CartViewHolder(@NonNull View itemView) {
        super(itemView);

        cartDeleteImg = (ImageView)itemView.findViewById(R.id.cartDeleteImage);
        cartImg = (ImageView)itemView.findViewById(R.id.cartImg);
        cartTitle = (TextView)itemView.findViewById(R.id.cartTitle);
        cartPrice = (TextView)itemView.findViewById(R.id.cartPrice);
        cartQuantity = (TextView)itemView.findViewById(R.id.cartQuantityText);
        cartTotalPrice = (TextView)itemView.findViewById(R.id.cartTotalPrice);
        increase = (Button)itemView.findViewById(R.id.cartIncreaseQuantity);
        decrease = (Button)itemView.findViewById(R.id.cartDecreaseQuantity);

    }
}
