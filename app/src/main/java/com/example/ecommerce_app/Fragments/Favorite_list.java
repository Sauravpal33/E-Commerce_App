package com.example.ecommerce_app.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.ecommerce_app.Adapters.FavAdapter;
import com.example.ecommerce_app.Database.Product_Table;
import com.example.ecommerce_app.Database.RoomDatabase;
import com.example.ecommerce_app.Model.ProductsItem;
import com.example.ecommerce_app.R;

import java.util.List;

public class Favorite_list extends Fragment {

    public Favorite_list() {
        // Required empty public constructor
    }
    RecyclerView favRecview;
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorite_list, container, false);
        favRecview = view.findViewById(R.id.favRecview);
        favRecview.setLayoutManager(new LinearLayoutManager(getContext()));
        getAllFavorite();
        return view;
    }

    private void getAllFavorite() {
        List<Product_Table> fvtList = RoomDatabase.getDB(getContext()).dao().getAllFavorite();
        FavAdapter favAdapter = new FavAdapter(fvtList);
        favRecview.setAdapter(favAdapter);
    }
}