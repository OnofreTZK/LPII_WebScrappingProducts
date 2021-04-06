package br.imd.ufrn.controller;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

public class ScrapperMagazineController extends ScrapperController {

	public ScrapperMagazineController(String searchKey) {
		super(searchKey);
	}
	
	 // Methods
	 @Override
	 public void makeRequest() {
		 
		 try {
			 document = Jsoup.connect("https://www.magazineluiza.com.br/busca/" + searchKey + "/").get();			
		 } catch (IOException e) {

		 }



		 Elements links = document.body().getElementsByTag("h3");

		 for (int i = 0; i < links.size(); i++) {
			 System.out.println("Produto: " + links.get(i).text());
		 }

		 Elements links2 = document.body().getElementsByTag("span");

		 for (int i = 0; i < links2.size(); i++) {
			 if(links2.get(i).toString().contains("R$")) {
				 System.out.println("Preço: " + links2.get(i).text());
			 }
		 }
	 }

}
