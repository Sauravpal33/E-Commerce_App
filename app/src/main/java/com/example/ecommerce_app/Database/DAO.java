package com.example.ecommerce_app.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.ecommerce_app.Model.ProductsItem;

import java.util.List;

@Dao
public interface DAO {

    @Insert
    void addFavourite(Product_Table productTable);

    @Query("select * from Favourite_Products")
    List<Product_Table> getAllFavorite();

    @Delete
    void deleteFavorite(Product_Table productTable);
}
