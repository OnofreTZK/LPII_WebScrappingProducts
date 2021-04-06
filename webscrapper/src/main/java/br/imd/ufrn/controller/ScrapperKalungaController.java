package br.imd.ufrn.controller;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

public class ScrapperKalungaController extends ScrapperController {

	public ScrapperKalungaController(String searchKey) {
		super(searchKey);
	}
	
	// Methods
	@Override
	public void makeRequest() {
		try {
            document = Jsoup.connect("https://www.kalunga.com.br/busca/1?q=" + searchKey).get();
        } catch (IOException e) {

         }

        Elements links = document.body().getElementsByTag("span");

        for (int i = 0; i < links.size(); i++) {
            if(links.get(i).toString().contains("R$")) {
                System.out.println("Preço: " + links.get(i).text());
            }
        }

        Elements links2 = document.body().getElementsByTag("h2");

        for (int i = 0; i < links2.size(); i++) {
        	System.out.println("Nome: " + links2.get(i).text());
        }
		
	}

}
