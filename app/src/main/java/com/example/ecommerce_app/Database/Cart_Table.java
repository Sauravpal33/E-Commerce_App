package com.example.ecommerce_app.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Cart_Table")
public class Cart_Table {

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

    @ColumnInfo(name = "quantity")
    private Integer quantity;

    @ColumnInfo(name = "total price")
    private double total_price;

    public Cart_Table(Integer id, String title, String thumbnail, double price, String brand, Integer quantity, double total_price) {
        this.id = id;
        this.title = title;
        this.thumbnail = thumbnail;
        this.price = price;
        this.brand = brand;
        this.quantity = quantity;
        this.total_price = total_price;
    }

    @Ignore
    public Cart_Table(String title, String thumbnail, double price, String brand, Integer quantity, double total_price) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.price = price;
        this.brand = brand;
        this.quantity = quantity;
        this.total_price = total_price;
    }

    @Ignore
    public Cart_Table(Integer quantity, double total_price) {
        this.quantity = quantity;
        this.total_price = total_price;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }
}
