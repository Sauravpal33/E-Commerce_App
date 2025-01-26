package com.example.ecommerce_app.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Favourite_Products")
public class Product_Table {

    @PrimaryKey(autoGenerate = true)
    private Integer id;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "thumbnail")
    private String thumbnail;

    @ColumnInfo(name = "price")
    private double price;

    @ColumnInfo(name = "brand")
    private String brand;

    @ColumnInfo(name = "stock")
    private int stock;

    public Product_Table(Integer id, String title, String thumbnail, double price, String brand, int stock) {
        this.id = id;
        this.title = title;
        this.thumbnail = thumbnail;
        this.price = price;
        this.brand = brand;
        this.stock = stock;
    }

    @Ignore
    public Product_Table(String title, String thumbnail, double price, String brand, int stock) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.price = price;
        this.brand = brand;
        this.stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}