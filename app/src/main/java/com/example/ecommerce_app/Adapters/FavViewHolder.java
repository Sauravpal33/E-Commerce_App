package com.example.ecommerce_app.Adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerce_app.R;

public class FavViewHolder extends RecyclerView.ViewHolder {

    ImageView img,deleteImg;
    TextView ft1,ft2,ft3,ft4;
    public FavViewHolder(@NonNull View itemView) {
        super(itemView);
        deleteImg = (ImageView)itemView.findViewById(R.id.deleteImage);
        img = (ImageView)itemView.findViewById(R.id.fvtImg);
        ft1 = (TextView)itemView.findViewById(R.id.fvtTitle);
        ft2 = (TextView)itemView.findViewById(R.id.fvtPrice);
        ft3 = (TextView)itemView.findViewById(R.id.fvtDiscount);
        ft4 = (TextView)itemView.findViewById(R.id.fvtStock);
    }
}
