package com.example.ecommerce_app.Model;

import com.google.gson.annotations.SerializedName;

public class Meta{

	@SerializedName("createdAt")
	private String createdAt;

	@SerializedName("qrCode")
	private String qrCode;

	@SerializedName("barcode")
	private String barcode;

	@SerializedName("updatedAt")
	private String updatedAt;
}