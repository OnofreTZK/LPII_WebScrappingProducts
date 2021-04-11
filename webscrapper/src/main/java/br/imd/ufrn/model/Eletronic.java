package br.imd.ufrn.model;

import java.util.List;


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

	public double getValue() {
		
		if(price.contains(".")) {
			double value = Double.valueOf(price.split(",")[0]) * 1000;
			
			return value;
		}
		
		double value = Double.valueOf(price.split(",")[0]);

		return value;
	}
	
	public void printProduct() {
		System.out.println("|=================================================================================================");
		System.out.println("|Infos do Produto");
		System.out.println("|Nome: " + name);
		System.out.println("|Preco: R$" + price);
		System.out.println("|SiteUrl: " + site);
		System.out.println("|=================================================================================================");
	}

}
