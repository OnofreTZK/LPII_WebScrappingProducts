package br.imd.ufrn.model;

public class Clothes implements ProductInterface{
	
	// Attributes
	private String name;
	private double price;
	private String category;
	private String site;
	private int measureSize;
		
	
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
	
	public void setMeasureSize(int measureSize) {
		this.measureSize = measureSize;
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

	public int getMeasureSize() {
		return measureSize;
	}
	
	public String getSite() {
		return site;
	}
	//--------------------------------------------------------	



}
