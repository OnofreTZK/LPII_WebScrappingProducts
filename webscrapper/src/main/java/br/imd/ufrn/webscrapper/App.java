package br.imd.ufrn.webscrapper;

import br.imd.ufrn.controller.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	// TESTANDO AS REQUEST --> RETORNOS NÃO PROCESSADOS.
    	ScrapperAmazonController AmazonController = new ScrapperAmazonController("Monitor");
    	ScrapperKalungaController KalungaController = new ScrapperKalungaController("Monitor");
    	ScrapperMagazineController MagazineController = new ScrapperMagazineController("Monitor");
    	
    	AmazonController.makeRequest();
    	KalungaController.makeRequest();
    	MagazineController.makeRequest();
    	
        System.out.println( "Hello World!" );
    }
}
