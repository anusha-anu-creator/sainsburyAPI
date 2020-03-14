package com.sainsbury.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name="Product")
public class Product {
	@Id
	private Integer id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="unit_price")
	private double unit_price;
	
	@JsonProperty("kcal_per_100g")
	@Column(name="kcal_per_100g")
	private int kcal;
	@Column(name="description")
	private String description;

	public Product() {
	}

	public Product(String title, double unit_price, int kcal, String description) {
		super();
		this.title = title;
		this.unit_price = unit_price;
		this.kcal = kcal;
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(double unit_price) {
		this.unit_price = unit_price;
	}

	public int getKcal() {
		return kcal;
	}

	public void setKcal(int kcal) {
		this.kcal = kcal;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
