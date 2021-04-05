package br.imd.ufrn.model;

public class Shoes implements ProductInterface {
	
	// Attributes
	private String name;
	private double price;
	private String category;
	private String site;
	private int feetSize;
		
	
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
	
	public void setFeetSize(int feetSize) {
		this.feetSize = feetSize;
	}
	
	public void setSite(String site) {
		this.site = site;
	}
	//--------------------------------------------------------	
	
	
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

	public int getFeetSize() {
		return feetSize;
	}
	
	public String getSite() {
		return site;
	}
	//--------------------------------------------------------	



	

}
