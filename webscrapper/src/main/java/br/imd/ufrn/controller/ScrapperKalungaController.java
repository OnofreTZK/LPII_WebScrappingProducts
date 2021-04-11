package br.imd.ufrn.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

import br.imd.ufrn.model.Eletronic;
import br.imd.ufrn.model.IProductInterface;

public class ScrapperKalungaController extends ScrapperController {

	// Attributes
	List<String> prices = new ArrayList<String>();
	ArrayList<String> names = new ArrayList<String>();
	HashMap<String, String> preset = new HashMap<String, String>();
	
	public ScrapperKalungaController(String searchKey) {
		super(searchKey);
	}
	
	// Methods
	@Override
	public void makeScrapper() {
		try {
            document = Jsoup.connect("https://www.kalunga.com.br/busca/1?q=" + searchKey).get();
        } catch (IOException e) {

         }

        Elements tagsPrice = document.body().getElementsByTag("span");
        Elements tagsName = document.body().getElementsByTag("h2");
        

        // Filtering prices
        for (int i = 0; i < tagsPrice.size(); i++) {
        	
        	
        	if(tagsPrice.get(i).toString().toLowerCase().contains("total a prazo")) {
        		continue;
        	}
        	
            if(tagsPrice.get(i).toString().contains("R$")) {
            	if(tagsPrice.get(i).toString().contains("à vista")) {
            		
            		String str = tagsPrice.get(i).text();
            	
            		prices.add(str.split(" ")[1]);
            	}
            }
        }
        
        // Filtering names
        for (int i = 0; i < tagsName.size(); i++) {
        	
        	//int pricesIndex = 0;
        	
        	String str = tagsName.get(i).text();
        	
        	if(str.regionMatches(0, searchKey, 0, searchKey.length())) {
       
        		names.add(str);
        		//pricesIndex += 1;
        	}
        	else {
        		//prices.remove(pricesIndex);
        	}
        }
        
        int setSize;
        
        if(names.size() == prices.size()) {
        	setSize = names.size();
        } else {
        	setSize = prices.size();
        }
        
        
        // Setting map for product
        for (int i = 0; i < setSize; i++) {
        	preset.put(names.get(i), prices.get(i));
        	
        	//System.out.println(names.get(i) + " | Preco: " + preset.get(names.get(i)));
        }
		
	}
	
	@Override
	public ArrayList<IProductInterface> getProductsList() {
		
		ArrayList<IProductInterface> products = new ArrayList<IProductInterface>(preset.size());
	        
		for (int i = 0; i < preset.size(); i++) {
			IProductInterface newProd = new Eletronic();
			newProd.setName(names.get(i));
			newProd.setPrice(preset.get(names.get(i)));
			newProd.setSite("https://www.kalunga.com.br");
			products.add(newProd);
		}
		
		return products;
		
	}

}
