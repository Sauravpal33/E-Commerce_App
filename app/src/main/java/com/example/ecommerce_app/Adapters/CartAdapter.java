package com.example.ecommerce_app.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.ecommerce_app.Database.Cart_Table;
import com.example.ecommerce_app.Database.RoomDatabase;
import com.example.ecommerce_app.R;
import com.squareup.picasso.Picasso;
import java.util.List;
public class CartAdapter extends RecyclerView.Adapter<CartViewHolder> {

    private List<Cart_Table> cart;
    private OnCartChangeListener onCartChangeListener;

    // Callback interface for notifying changes
    public interface OnCartChangeListener {
        void onCartUpdated();
    }

    public CartAdapter(List<Cart_Table> cart, OnCartChangeListener onCartChangeListener) {
        this.cart = cart;
        this.onCartChangeListener = onCartChangeListener;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.cartrowlayout, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        Cart_Table currentCart = cart.get(position);

        holder.cartTitle.setText(currentCart.getTitle());
        holder.cartPrice.setText("Price : $" + currentCart.getPrice());
        holder.cartQuantity.setText(String.valueOf(currentCart.getQuantity()));
        holder.cartTotalPrice.setText("Total : $" + currentCart.getTotal_price());
        Picasso.get().load(currentCart.getThumbnail()).into(holder.cartImg);

        holder.increase.setOnClickListener(view -> {
            int newQuantity = currentCart.getQuantity() + 1;
            double newTotalPrice = currentCart.getPrice() * newQuantity;

            // Update the Cart_Table object
            currentCart.setQuantity(newQuantity);
            currentCart.setTotal_price(newTotalPrice);

            // Update in the database
            RoomDatabase roomDatabase = RoomDatabase.getDB(view.getContext());
            roomDatabase.cartDao().updateCart(currentCart);

            // Update the UI
            holder.cartQuantity.setText(String.valueOf(newQuantity));
            holder.cartTotalPrice.setText("Total : $" + newTotalPrice);
            notifyItemChanged(position);

            // Notify fragment about the change
            if (onCartChangeListener != null) {
                onCartChangeListener.onCartUpdated();
            }
        });

        holder.decrease.setOnClickListener(view -> {
            if (currentCart.getQuantity() > 1) {
                int newQuantity = currentCart.getQuantity() - 1;
                double newTotalPrice = currentCart.getPrice() * newQuantity;

                // Update the Cart_Table object
                currentCart.setQuantity(newQuantity);
                currentCart.setTotal_price(newTotalPrice);

                // Update in the database
                RoomDatabase roomDatabase = RoomDatabase.getDB(view.getContext());
                roomDatabase.cartDao().updateCart(currentCart);

                // Update the UI
                holder.cartQuantity.setText(String.valueOf(newQuantity));
                holder.cartTotalPrice.setText("Total : $" + newTotalPrice);
                notifyItemChanged(position);

                // Notify fragment about the change
                if (onCartChangeListener != null) {
                    onCartChangeListener.onCartUpdated();
                }
            }
        });

        holder.cartDeleteImg.setOnClickListener(view -> {
            RoomDatabase roomDatabase = RoomDatabase.getDB(view.getContext());
            roomDatabase.cartDao().deleteCart(currentCart);
            cart.remove(currentCart);
            notifyDataSetChanged();

            // Notify fragment about the change
            if (onCartChangeListener != null) {
                onCartChangeListener.onCartUpdated();
            }
        });
    }

    @Override
    public int getItemCount() {
        return cart.size();
    }
}