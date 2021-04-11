package br.imd.ufrn.model;

public interface IProductInterface {

	// Setters
	public void setName(String name);
	public void setPrice(String price);
	public void setSite(String site);
	
	// Getters
	String getName();
	String getPrice();
	String getSite();
	double getValue();
	public void printProduct();
	
}
