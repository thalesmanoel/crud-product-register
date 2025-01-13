package com.cadastroproduto.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private Double price;
	private Boolean avaible;
	
	public Produto() {}

	public Produto(Long id, String name, String description, Double price, Boolean avaible) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.avaible = avaible;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public Boolean getAvaible() {
		return avaible;
	}


	public void setAvaible(Boolean avaible) {
		this.avaible = avaible;
	}
}
