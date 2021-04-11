package br.imd.ufrn.webscrapper;

import br.imd.ufrn.controller.*;


public class App 
{
    public static void main( String[] args )
    {
    	Banco banco = Banco.getInstance();

    	banco.provedor("Monitor");
    	
    	banco.ordenaBaratos();
    	
    	banco.ordenaCaros();
    	
    	banco.calculaMedia();
    }
}
