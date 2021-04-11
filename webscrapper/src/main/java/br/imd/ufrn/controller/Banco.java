package br.imd.ufrn.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import br.imd.ufrn.model.IProductInterface;

public class Banco {
	
	private ArrayList<IProductInterface> produtos;
	private ArrayList<Double> sortedPrices;
	HashMap<Double, IProductInterface> sortedProducts;
	double mean = 0.0;
	ProductsSort sorter;
	
	private static Banco banco;
	
	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	
	private Banco(){
		produtos = new ArrayList<IProductInterface>();
		sortedPrices = new ArrayList<Double>();
		sortedProducts = new HashMap<Double, IProductInterface>();
		sorter = new ProductsSort();
	}	
	
	// Singleton
	public static Banco getInstance() {
		if (banco == null) {
			banco = new Banco();
		}
		return banco;
	}
	
	public void provedor(String searchKey) {
		
		// Com o aumento de sites seria necessário outro modelo:
		// Provider só para selecionar a loja e prover os dados.
		ScrapperKalungaController KalungaController = new ScrapperKalungaController(searchKey);
		KalungaController.makeScrapper();
		
		produtos = KalungaController.getProductsList();

	}
	
	public void ordenaBaratos() {
		if( sorter.isSorted() ){
			System.out.println("******************************************");
			System.out.println("ORDEM MAIS BARATOS");
			System.out.println("******************************************");
			for (int i = 0; i < sortedProducts.size(); i++) {
				sortedProducts.get(sortedPrices.get(i)).printProduct();
			}
			return;
		}
		// else
		sortedPrices = sorter.execSort(produtos);
		sortedProducts = sorter.getMap();
		
		System.out.println("******************************************");
		System.out.println("ORDEM MAIS BARATOS");
		System.out.println("******************************************");
		for (int i = 0; i < sortedProducts.size(); i++) {
			sortedProducts.get(sortedPrices.get(i)).printProduct();
		}

	}
	
	public void ordenaCaros() {
		if( sorter.isSorted() ) {
			System.out.println("******************************************");
			System.out.println("ORDEM MAIS CAROS");
			System.out.println("******************************************");
			for (int i = sortedProducts.size() - 1; i >= 0 ; i--) {
				sortedProducts.get(sortedPrices.get(i)).printProduct();
			}
			return;
		}
		// else
		sortedPrices = sorter.execSort(produtos);
		sortedProducts = sorter.getMap();
		
		System.out.println("******************************************");
		System.out.println("ORDEM MAIS CAROS");
		System.out.println("******************************************");
		for (int i = sortedProducts.size() - 1; i >= 0; i--) {
			sortedProducts.get(sortedPrices.get(i)).printProduct();
		}

		
	}

	public void calculaMedia() {

		
	    for (int i = 0; i < sortedPrices.size(); i++) {
	         mean = mean + sortedPrices.get(i);
	    }
	    
	    mean = mean/sortedPrices.size();
	      
	    System.out.println("\n\n\n------------------------------");
	    System.out.printf("Média de preco: R$%.2f\n", mean);
	    System.out.println("------------------------------");
	}


}

