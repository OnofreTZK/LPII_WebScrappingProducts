package br.imd.ufrn.controller;

import java.io.IOException;
import javax.swing.text.Document;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

public class Scrapper {
	String produto = "rtx";

    Document document = null;

    String listaProdutos = null;
    String[] listaProdutos2 = null;
    String precoProduto = "";

    //Ainda trabalhando com páginas estáticas para pegar o jeito
    public void makeRequest() {
    	try {
        	document = (Document) Jsoup.connect("https://www.kalunga.com.br/prod/placa-de-video-nvidia-geforce-6gb-gtx-1060-n1060wf2oc6-gigabyte-cx-1-un/608705%22").get();
    	} catch (IOException e) {

     	}
    

    	Elements links = ((org.jsoup.nodes.Document) document).body().getElementsByTag("span");

    	for (int i = 0; i < links.size(); i++) {
        	if(links.get(i).toString().contains("R$")) {
            	System.out.println(links.get(i).toString());
        	}
    	}
    }
}
