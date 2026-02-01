package com.example.demodeploy.Entity;

import org.springframework.stereotype.Component;

@Component
public class CarEntity {
	private String id;
	private String name;
	private String brand;
	private int price;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public CarEntity(String id, String name, String brand, int price) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.price = price;
	}
	public CarEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CarEntity [id=" + id + ", name=" + name + ", brand=" + brand + ", price=" + price + "]";
	}
	
}
