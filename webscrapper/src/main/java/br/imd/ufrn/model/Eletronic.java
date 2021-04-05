package br.imd.ufrn.model;

public class Eletronic implements ProductInterface {

	// Attributes
	private String name;
	private double price;
	private String category;
	private String site;
	
	
	// Setters
	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
		
	}

	public void setCategory(String category) {
		this.category = category;
		
	}
	
	public void setSite(String site) {
		this.site = site;
		
	}

	
	// Getters
	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public String getCategory() {
		return category;
	}

	public String getSite() {
		return site;
	}

}
