package com.example.ecommerce_app.Model;

import com.google.gson.annotations.SerializedName;

public class ReviewsItem{

	@SerializedName("date")
	private String date;

	@SerializedName("reviewerName")
	private String reviewerName;

	@SerializedName("reviewerEmail")
	private String reviewerEmail;

	@SerializedName("rating")
	private Integer rating;

	@SerializedName("comment")
	private String comment;
}