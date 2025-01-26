package com.example.ecommerce_app.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecommerce_app.Database.Cart_Table;
import com.example.ecommerce_app.Database.RoomDatabase;
import com.example.ecommerce_app.R;
import com.squareup.picasso.Picasso;


public class Checkout_fragment extends Fragment {

   public Checkout_fragment() {
        // Required empty public constructor
    }

    Button increase,decrease,addToCart;
    TextView pTitle,pPrice,qText,tPrice;
    ImageView checkoutImg;

    int quantity = 1;
    private double pricePerUnit;
    private double total;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_checkout_fragment, container, false);
        increase = view.findViewById(R.id.increaseQuantity);
        decrease = view.findViewById(R.id.decreaseQuantity);
        pTitle = view.findViewById(R.id.productTitle);
        pPrice = view.findViewById(R.id.productPrice);
        qText = view.findViewById(R.id.quantityText);
        tPrice = view.findViewById(R.id.totalPrice);
        checkoutImg = view.findViewById(R.id.checkoutImg);
        addToCart = view.findViewById(R.id.addToCart);

        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = pTitle.getText().toString();
                String thumbnail = getArguments().getString("thumbnail", "");
                double price = pricePerUnit;
                String brand = getArguments().getString("brand","0");
                int productQuantity = quantity;
                double totalPrice = Double.valueOf(total);
                Cart_Table cartItem = new Cart_Table(title, thumbnail, price, brand, productQuantity, totalPrice);
                RoomDatabase roomDatabase = RoomDatabase.getDB(getContext());
                roomDatabase.cartDao().addToCart(cartItem);
                Toast.makeText(getContext(), "Add to Cart", Toast.LENGTH_SHORT).show();
            }
        });


        if (getArguments() != null) {
            String title = getArguments().getString("title");
            String thumbnail = getArguments().getString("thumbnail", "0");
            String price = getArguments().getString("price", "0");

            pricePerUnit = Double.parseDouble(price);

            pTitle.setText(title);
            Picasso.get().load(thumbnail).into(checkoutImg);
            pPrice.setText("Price: $" + price);
            updateTotalPrice();

            increase.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    quantity++;
                    qText.setText(String.valueOf(quantity));
                    updateTotalPrice();
                }
            });

            // Decrease quantity button
            decrease.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (quantity > 1) {
                        quantity--;
                        qText.setText(String.valueOf(quantity));
                        updateTotalPrice();
                    }
                }
            });
        }

        return view;

   }

    private void updateTotalPrice() {
        total = quantity * pricePerUnit;
        tPrice.setText("Total: $" + String.format("%.2f", total));
    }
}