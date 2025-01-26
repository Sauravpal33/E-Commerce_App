package com.example.ecommerce_app.Adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerce_app.R;

public class ViewHolder extends RecyclerView.ViewHolder {

    ImageView img;
    TextView text;
    CardView itemCardView;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        img = (ImageView)itemView.findViewById(R.id.itemImage);
        text = (TextView)itemView.findViewById(R.id.itemText);
        itemCardView = (CardView)itemView.findViewById(R.id.itemCardView);
    }
}
