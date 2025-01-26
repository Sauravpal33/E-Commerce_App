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
import android.widget.Toast;

import com.example.ecommerce_app.API.ApiController;
import com.example.ecommerce_app.Adapters.MyAdapter;
import com.example.ecommerce_app.Model.ProductsItem;
import com.example.ecommerce_app.Model.Response;
import com.example.ecommerce_app.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;


public class Product_list extends Fragment {

    public Product_list() {
        // Required empty public constructor
    }

    RecyclerView recview;
    SearchView searchView;
    MyAdapter adapter;
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product_list, container, false);
        recview = view.findViewById(R.id.recview);
        searchView = view.findViewById(R.id.searchView);
        recview.setLayoutManager(new LinearLayoutManager(getContext()));
        processData();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return view;
    }

    private void processData() {
        Call<Response> call = ApiController.getInstance().getApi().getProducts();
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                List<ProductsItem> list = response.body().getProducts();
                adapter = new MyAdapter(list,new ArrayList<>(list),getParentFragmentManager());
                recview.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

}