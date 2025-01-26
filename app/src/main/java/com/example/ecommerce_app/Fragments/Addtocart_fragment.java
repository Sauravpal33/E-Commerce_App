package com.example.ecommerce_app.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.ecommerce_app.Adapters.CartAdapter;
import com.example.ecommerce_app.Database.Cart_Table;
import com.example.ecommerce_app.Database.RoomDatabase;
import com.example.ecommerce_app.Order_placed;
import com.example.ecommerce_app.R;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class Addtocart_fragment extends Fragment implements PaymentResultListener {

    private RecyclerView cartRecview;
    private Button payWithRazorBtn;
    private TextView grandTotalText;
    private List<Cart_Table> cartList;
    private double grandTotal = 0.0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_addtocart_fragment, container, false);
        cartRecview = view.findViewById(R.id.cartRecview);
        cartRecview.setLayoutManager(new LinearLayoutManager(getContext()));
        payWithRazorBtn = view.findViewById(R.id.payWithRazorButton);
        grandTotalText = view.findViewById(R.id.grandTotalText);

        payWithRazorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startPayment();
            }
        });

        processCartData();
        return view;
    }

    private void calculateGrandTotal() {
        grandTotal = 0.0;
        for (Cart_Table item : cartList) {
            grandTotal += item.getTotal_price();
        }
        grandTotalText.setText("Grand Total: $" + String.format("%.2f", grandTotal));
    }

    private void processCartData() {
        RoomDatabase roomDatabase = RoomDatabase.getDB(getContext());
        cartList = roomDatabase.cartDao().getAllCart();

        if (cartList == null || cartList.isEmpty()) {
            cartList = new ArrayList<>();
        }

        CartAdapter cartAdapter = new CartAdapter(cartList, this::calculateGrandTotal);
        cartRecview.setAdapter(cartAdapter);

        calculateGrandTotal();
    }

    private void startPayment() {
        Checkout checkout = new Checkout();
        checkout.setKeyID("rzp_test_66Vg5DK3zGfMR2");

        try {
            JSONObject options = new JSONObject();
            options.put("name", "Ecommerce");
            options.put("description", "Order Payment");
            options.put("currency", "INR");
            options.put("amount", (int) (grandTotal * 100)); // Amount in paise

            options.put("prefill.email", "sauravpal33@gmail.com");
            options.put("prefill.contact", "9971737393");

            checkout.open(requireActivity(), options);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onPaymentSuccess(String razorpayPaymentId) {
        Intent intent = new Intent(requireActivity(), Order_placed.class);
        startActivity(intent);
    }

    @Override
    public void onPaymentError(int code, String response) {
        Toast.makeText(getContext(), "Payment Failed: " + response, Toast.LENGTH_LONG).show();
    }
}
