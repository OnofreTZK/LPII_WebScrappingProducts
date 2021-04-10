package br.imd.ufrn.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;

import br.imd.ufrn.model.IProductInterface;

public class Banco {
	
	private ArrayList<IProductInterface> produtos;
	private ArrayList<IProductInterface> minPrices;
	private ArrayList<IProductInterface> maxPrices;
	double media = 0.0;
	
	private static Banco banco;
	
	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	
	private Banco(){
		produtos = new ArrayList<IProductInterface>();
		minPrices = new ArrayList<IProductInterface>();
		maxPrices = new ArrayList<IProductInterface>();
	}
	
	// Singleton
	public static Banco getInstance() {
		if (banco == null) {
			banco = new Banco();
		}
		return banco;
	}
	
	public void inserirProduto(IProductInterface p)  {
		produtos.add(p);
		System.out.println("Produto Inserido com sucesso!!");
	}
	
	public void provedor(String searchKey) {
		// Com o aumento de sites seria necessário outro modelo:
		// Provider só para selecionar a loja e prover os dados.
		ScrapperKalungaController KalungaController = new ScrapperKalungaController(searchKey);
		KalungaController.makeScrapper();
		
		produtos = KalungaController.getProductsList();
	}
	
	public void ordenaBaratos() {
		System.out.println("Teste -> Mais baratos");
	}
	
	public void ordenaCaros() {
		System.out.println("Teste -> Mais caros");
	}

	public void calculaMedia() {
		System.out.println("Teste -> Calcula media");
	}


}

