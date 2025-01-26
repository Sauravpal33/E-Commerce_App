package com.example.ecommerce_app.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface Cart_Dao {

    @Query("select * from Cart_Table")
    List<Cart_Table> getAllCart();

    @Insert
    void addToCart(Cart_Table cart_table);

    @Delete
    void deleteCart(Cart_Table cart_table);

    @Update
    void updateCart(Cart_Table cart_table);
}
