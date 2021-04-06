package br.imd.ufrn.controller;

import org.jsoup.nodes.Document;

public class ScrapperController {
	
	@SuppressWarnings("unused")
	public String searchKey = "";
    public Document document = null;
    @SuppressWarnings("unused")
	public String productList = null;
    @SuppressWarnings("unused")
	public String[] productList2 = null;
    @SuppressWarnings("unused")
	public String productPrice = "";
    
    // Constructor
    public ScrapperController(String searchKey) {
    	this.searchKey = searchKey;
    }
    
    // Methods
    public void makeRequest() {}

}
