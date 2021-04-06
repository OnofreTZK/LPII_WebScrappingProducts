package br.imd.ufrn.controller;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

public class ScrapperAmazonController extends ScrapperController {

	public ScrapperAmazonController(String searchKey) {
		super(searchKey);
	}

	
	// Methods
	@Override
    public void makeRequest() {

		try {
			document = Jsoup.connect("https://www.amazon.com.br/s?k=" + searchKey + "&__mk_pt_BR=%C3%85M%C3%85%C5%BD%C3%95%C3%91&ref=nb_sb_noss").get();			
		} catch (IOException e) {
			
 		}
		
		Elements links = document.body().getElementsByTag("span");
		
		for (int i = 0; i < links.size(); i++) {
			if(links.get(i).toString().contains("R$")) {
				System.out.println("Preço: " + links.get(i).text());
			}
		}
    	
    }
	
}
