package com.example.ecommerce_app.Adapters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerce_app.Fragments.Details_fragment;
import com.example.ecommerce_app.Model.ProductsItem;
import com.example.ecommerce_app.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<ViewHolder> implements Filterable {

    List<ProductsItem> data;
    List<ProductsItem> backup;
    FragmentManager fragmentManager;

    public MyAdapter(List<ProductsItem> data, List<ProductsItem> backup, FragmentManager fragmentManager) {
        this.data = data;
        this.backup = new ArrayList<>(data);
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.singlerowlayout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductsItem currentItem = data.get(position);

        holder.text.setText(data.get(position).getTitle());
        Picasso.get().load(data.get(position).getThumbnail()).into(holder.img);

        holder.itemCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new Details_fragment();
                Bundle bundle = new Bundle();

                bundle.putString("thumbnail",currentItem.getThumbnail().toString());
                bundle.putString("itemImages", currentItem.getImages() != null ? currentItem.getImages().toString() : "");
                bundle.putString("itemTitle", currentItem.getTitle() != null ? currentItem.getTitle() : "");

                float rating = currentItem.getRating() != null ? Float.parseFloat(currentItem.getRating().toString()) : 0.0f;
                bundle.putFloat("itemRating", rating);

                bundle.putString("itemPrice", currentItem.getPrice() != null ? currentItem.getPrice().toString() : "0");
                bundle.putString("itemDiscount", currentItem.getDiscountPercentage() != null ? currentItem.getDiscountPercentage().toString() : "0");
                bundle.putString("itemStock", currentItem.getStock() != null ? currentItem.getStock().toString() : "0");
                bundle.putString("itemWarranty", currentItem.getWarrantyInformation() != null ? currentItem.getWarrantyInformation() : "");
                bundle.putString("itemShipping", currentItem.getShippingInformation() != null ? currentItem.getShippingInformation() : "");
                bundle.putString("itemReturn", currentItem.getReturnPolicy() != null ? currentItem.getReturnPolicy() : "");
                bundle.putString("itemBrand", currentItem.getBrand() != null ? currentItem.getBrand() : "");
                bundle.putString("itemCategory", currentItem.getCategory() != null ? currentItem.getCategory() : "");
                bundle.putString("itemSku", currentItem.getSku() != null ? currentItem.getSku() : "");
                bundle.putString("itemWeight", currentItem.getWeight() != null ? currentItem.getWeight().toString() : "0");
                bundle.putString("itemDescription", currentItem.getDescription() != null ? currentItem.getDescription() : "");

                fragment.setArguments(bundle);

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container,fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence keyword)
        {
            ArrayList<ProductsItem> filterData = new ArrayList<>();
            if (keyword.toString().isEmpty())
                filterData.addAll(backup);
            else {
                for (ProductsItem obj : backup){
                    if (obj.getTitle().toString().toLowerCase().contains(keyword.toString().toLowerCase()))
                        filterData.add(obj);
                    if (obj.getCategory().toString().toLowerCase().contains(keyword.toString().toLowerCase()))
                        filterData.add(obj);
                }
            }
            FilterResults results = new FilterResults();
            results.values = filterData;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            data.clear();
            data.addAll((ArrayList<ProductsItem>)results.values);
            notifyDataSetChanged();
        }
    };
}
