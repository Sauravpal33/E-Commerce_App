package com.example.ecommerce_app.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.ecommerce_app.Database.Product_Table;
import com.example.ecommerce_app.Database.RoomDatabase;
import com.example.ecommerce_app.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FavAdapter extends RecyclerView.Adapter<FavViewHolder> {

    List<Product_Table> fvtList;

    public FavAdapter(List<Product_Table> fvtList) {
        this.fvtList = fvtList;
    }

    @NonNull
    @Override
    public FavViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.favoriterowlayout,parent,false);
        return new FavViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavViewHolder holder, int position) {
        Product_Table fvtItem = fvtList.get(position);

        holder.ft1.setText(fvtItem.getTitle());
        holder.ft2.setText("Price : $"+String.valueOf(fvtItem.getPrice()));
        holder.ft3.setText("Brand : "+fvtItem.getBrand());
        holder.ft4.setText("Stock : "+fvtItem.getStock());
        Picasso.get().load(fvtItem.getThumbnail().toString()).into(holder.img);

        holder.deleteImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RoomDatabase roomDatabase = RoomDatabase.getDB(view.getContext());
                roomDatabase.dao().deleteFavorite(fvtItem);
                fvtList.remove(fvtItem);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return fvtList.size();
    }
}
