package pl.jwojciechowski.model;

import java.util.Date;

public class Product {

	private long product_id;
	private String product_name;
	private double product_price;
	private String category;
	private String description;
	private Date expiration_date;

	public long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public double getProduct_price() {
		return product_price;
	}

	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getExpiration_date() {
		return expiration_date;
	}

	public void setExpiration_date(Date expiration_date) {
		this.expiration_date = expiration_date;
	}

	@Override
	public String toString() {
		return "{ \n" + "product_id=" + product_id + ",\n" + "product_name=" + product_name.trim() + ",\n"
				+ "product_price=" + product_price + ",\n" + "category=" + category.trim() + ",\n" + "expiration_date="
				+ expiration_date + ",\n" + "}";
	}
}
