package br.imd.ufrn.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;


import br.imd.ufrn.model.Produto;

public class Banco {
	
	private ArrayList<Produto> produtos;
	
	private static Banco banco;
	
	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	
	private Banco(){
		produtos        = new ArrayList<Produto>();
	}
	
	// Singleton
	public static Banco getInstance() {
		if (banco == null) {
			banco = new Banco();
		}
		return banco;
	}
	
	public void inserirProduto(Produto p)  {
		produtos.add(p);
		System.out.println("Produto Inserido com sucesso!!");
	}

}

