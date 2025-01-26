package com.example.ecommerce_app.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ProductsItem{

	@SerializedName("images")
	private List<String> images;

	@SerializedName("thumbnail")
	private String thumbnail;

	@SerializedName("minimumOrderQuantity")
	private Integer minimumOrderQuantity;

	@SerializedName("rating")
	private Object rating;

	@SerializedName("returnPolicy")
	private String returnPolicy;

	@SerializedName("description")
	private String description;

	@SerializedName("weight")
	private Integer weight;

	@SerializedName("warrantyInformation")
	private String warrantyInformation;

	@SerializedName("title")
	private String title;

	@SerializedName("tags")
	private List<String> tags;

	@SerializedName("discountPercentage")
	private Object discountPercentage;

	@SerializedName("reviews")
	private List<ReviewsItem> reviews;

	@SerializedName("price")
	private Object price;

	@SerializedName("meta")
	private Meta meta;

	@SerializedName("shippingInformation")
	private String shippingInformation;

	@SerializedName("id")
	private Integer id;

	@SerializedName("availabilityStatus")
	private String availabilityStatus;

	@SerializedName("category")
	private String category;

	@SerializedName("stock")
	private Integer stock;

	@SerializedName("sku")
	private String sku;

	@SerializedName("dimensions")
	private Dimensions dimensions;

	@SerializedName("brand")
	private String brand;

	public ProductsItem(List<String> images, String thumbnail, Integer minimumOrderQuantity, Object rating, String returnPolicy, String description, Integer weight, String warrantyInformation, String title, List<String> tags, Object discountPercentage, List<ReviewsItem> reviews, Object price, Meta meta, String shippingInformation, Integer id, String availabilityStatus, String category, Integer stock, String sku, Dimensions dimensions, String brand) {
		this.images = images;
		this.thumbnail = thumbnail;
		this.minimumOrderQuantity = minimumOrderQuantity;
		this.rating = rating;
		this.returnPolicy = returnPolicy;
		this.description = description;
		this.weight = weight;
		this.warrantyInformation = warrantyInformation;
		this.title = title;
		this.tags = tags;
		this.discountPercentage = discountPercentage;
		this.reviews = reviews;
		this.price = price;
		this.meta = meta;
		this.shippingInformation = shippingInformation;
		this.id = id;
		this.availabilityStatus = availabilityStatus;
		this.category = category;
		this.stock = stock;
		this.sku = sku;
		this.dimensions = dimensions;
		this.brand = brand;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public Integer getMinimumOrderQuantity() {
		return minimumOrderQuantity;
	}

	public void setMinimumOrderQuantity(Integer minimumOrderQuantity) {
		this.minimumOrderQuantity = minimumOrderQuantity;
	}

	public Object getRating() {
		return rating;
	}

	public void setRating(Object rating) {
		this.rating = rating;
	}

	public String getReturnPolicy() {
		return returnPolicy;
	}

	public void setReturnPolicy(String returnPolicy) {
		this.returnPolicy = returnPolicy;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getWarrantyInformation() {
		return warrantyInformation;
	}

	public void setWarrantyInformation(String warrantyInformation) {
		this.warrantyInformation = warrantyInformation;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public Object getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(Object discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public List<ReviewsItem> getReviews() {
		return reviews;
	}

	public void setReviews(List<ReviewsItem> reviews) {
		this.reviews = reviews;
	}

	public Object getPrice() {
		return price;
	}

	public void setPrice(Object price) {
		this.price = price;
	}

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	public String getShippingInformation() {
		return shippingInformation;
	}

	public void setShippingInformation(String shippingInformation) {
		this.shippingInformation = shippingInformation;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAvailabilityStatus() {
		return availabilityStatus;
	}

	public void setAvailabilityStatus(String availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public Dimensions getDimensions() {
		return dimensions;
	}

	public void setDimensions(Dimensions dimensions) {
		this.dimensions = dimensions;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
}