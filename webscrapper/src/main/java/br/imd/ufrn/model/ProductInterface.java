package br.imd.ufrn.model;

public interface ProductInterface {

	// Setters
	public void setName(String name);
	public void setPrice(double price);
	public void setCategory(String category);
	public void setSite(String site);
	
	// Getters
	String getName();
	double getPrice();
	String getCategory();
	String getSite();
}
