package com.example.ecommerce_app.Adapters;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.ecommerce_app.R;

public class ViewPagerViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    public ViewPagerViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = (ImageView)itemView.findViewById(R.id.viewPagerImage);
    }
}
