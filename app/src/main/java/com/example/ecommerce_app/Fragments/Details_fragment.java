package com.example.ecommerce_app.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecommerce_app.Adapters.ViewPagerAdapter;
import com.example.ecommerce_app.Database.Product_Table;
import com.example.ecommerce_app.Database.RoomDatabase;
import com.example.ecommerce_app.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Details_fragment extends Fragment {

    public Details_fragment() {
        // Required empty public constructor
    }

    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;
    RatingBar ratingBar;
    ViewPager2 viewPager2;
    FloatingActionButton floatingActionButton;
    Button buyNowButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_details_fragment, container, false);
        t1 = view.findViewById(R.id.detailTitle);
        viewPager2 = view.findViewById(R.id.detailViewPager);
        ratingBar = view.findViewById(R.id.detailRating);
        t2 = view.findViewById(R.id.detailPrice);
        t3 = view.findViewById(R.id.detailsDiscount);
        t4 = view.findViewById(R.id.detailStock);
        t5 = view.findViewById(R.id.detailWarranty);
        t6 = view.findViewById(R.id.detailShipping);
        t7 = view.findViewById(R.id.detailReturnPolicy);
        t8 = view.findViewById(R.id.detailBrand);
        t9 = view.findViewById(R.id.detailCategory);
        t10 = view.findViewById(R.id.detailSku);
        t11 = view.findViewById(R.id.detailWeight);
        t12 = view.findViewById(R.id.detailDescription);
        floatingActionButton = view.findViewById(R.id.floatingActionButton);
        buyNowButton = view.findViewById(R.id.buyNowButton);

        buyNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new Checkout_fragment();

                Bundle bundle = new Bundle();
                bundle.putString("title",getArguments().getString("itemTitle"));
                bundle.putString("thumbnail",getArguments().getString("thumbnail"));
                bundle.putString("price",getArguments().getString("itemPrice"));
                bundle.putString("brand",getArguments().getString("itemBrand"));


                fragment.setArguments(bundle);

                FragmentManager fm = requireActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.container,fragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = getArguments().getString("itemTitle");
                String thumbnail = getArguments().getString("thumbnail");
                double price = Double.valueOf(getArguments().getString("itemPrice"));
                String brand = getArguments().getString("itemBrand");
                int stock = Integer.parseInt(getArguments().getString("itemStock"));

                RoomDatabase.getDB(getContext()).dao()
                        .addFavourite(new Product_Table(title,thumbnail,price,brand,stock));
                Toast.makeText(getContext(), "Add to Favorite's", Toast.LENGTH_SHORT).show();
            }
        });

        t1.setText(getArguments().getString("itemTitle"));
        ratingBar.setRating(getArguments().getFloat("itemRating"));
        t2.setText("Price : $"+getArguments().getString("itemPrice"));
        t3.setText("Discount Price : $"+getArguments().getString("itemDiscount"));
        t4.setText("Stock : "+getArguments().getString("itemStock"));
        t5.setText("Warranty : "+getArguments().getString("itemWarranty"));
        t6.setText("Shipping Information : "+getArguments().getString("itemShipping"));
        t7.setText("Return Policy : "+getArguments().getString("itemReturn"));
        t8.setText("Brand : "+getArguments().getString("itemBrand"));
        t9.setText("Category : "+getArguments().getString("itemCategory"));
        t10.setText("Sku : "+getArguments().getString("itemSku"));
        t11.setText("Weight : "+getArguments().getString("itemWeight"));
        t12.setText("Description : "+getArguments().getString("itemDescription"));

        Bundle bundle = getArguments();
        if (bundle != null){
            String itemImages = bundle.getString("itemImages");
            if (itemImages != null){
                List<String> images = parseImageUrls(itemImages);
                viewPager2.setAdapter(new ViewPagerAdapter(images,getContext()));
            }
        }


        return view;
    }

    private List<String> parseImageUrls(String imageUrlString) {
        return Arrays.asList(imageUrlString.replace("[","").replace("]","").split("\\s*,\\s*"));
    }
}