package br.imd.ufrn.model;

public class Eletronic implements IProductInterface {

	// Attributes
	private String name;
	private String price;
	private String site;
	
	
	// Setters
	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(String price) {
		this.price = price;
		
	}
	public void setSite(String site) {
		this.site = site;
		
	}

	
	// Getters
	public String getName() {
		return name;
	}

	public String getPrice() {
		return price;
	}

	public String getSite() {
		return site;
	}

}
