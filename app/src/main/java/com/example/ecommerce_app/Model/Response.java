package com.example.ecommerce_app.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("total")
	private Integer total;

	@SerializedName("limit")
	private Integer limit;

	@SerializedName("skip")
	private Integer skip;

	@SerializedName("products")
	private List<ProductsItem> products;

	public Response(Integer total, Integer limit, Integer skip, List<ProductsItem> products) {
		this.total = total;
		this.limit = limit;
		this.skip = skip;
		this.products = products;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getSkip() {
		return skip;
	}

	public void setSkip(Integer skip) {
		this.skip = skip;
	}

	public List<ProductsItem> getProducts() {
		return products;
	}

	public void setProducts(List<ProductsItem> products) {
		this.products = products;
	}
}