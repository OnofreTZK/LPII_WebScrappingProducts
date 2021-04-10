package br.imd.ufrn.controller;

// !> Unused

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

public class ScrapperAmazonController extends ScrapperController {

	public ScrapperAmazonController(String searchKey) {
		super(searchKey);
	}

	
	// Methods
	@Override
    public void makeScrapper() {

		try {
			document = Jsoup.connect("https://www.amazon.com.br/s?k=" + searchKey + "&__mk_pt_BR=%C3%85M%C3%85%C5%BD%C3%95%C3%91&ref=nb_sb_noss").get();			
		} catch (IOException e) {
			
 		}
		
		Elements tags = document.body().getElementsByTag("span");
		
		
		for (int i = 0; i < tags.size(); i++) {
			
			String str = tags.get(i).text();
			int logicalZero = str.indexOf(searchKey.charAt(0));
			
			if(str.toLowerCase().contains(searchKey.toLowerCase())) {
				
				if(logicalZero >= 0) {
					if(str.contains("R$")) {
						System.out.println(str.substring(logicalZero));
					}
				}
				
			}
			
		}
    	
    }
	
}
