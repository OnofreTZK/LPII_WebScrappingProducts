package br.imd.ufrn.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Banco {
	
	private ArrayList<Object> produtos;
	
	private static Banco banco;
	
	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	
	private Banco(){
		produtos        = new ArrayList<Object>();
	}
	
	// Singleton
	public static Banco getInstance() {
		if (banco == null) {
			banco = new Banco();
		}
		return banco;
	}
	
	public void inserirProduto(Object p)  {
		produtos.add(p);
		System.out.println("Produto Inserido com sucesso!!");
	}

}

