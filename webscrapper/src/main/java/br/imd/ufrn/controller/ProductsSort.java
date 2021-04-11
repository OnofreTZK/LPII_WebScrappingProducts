package br.imd.ufrn.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import br.imd.ufrn.model.IProductInterface;

public class ProductsSort {

	// Attributes
	private ArrayList<Double> sortedArr;
	private HashMap<Double, IProductInterface> sortedProducts;
	private boolean sortStatus = false;
	
	// Constructor
	public ProductsSort(){
		sortedArr  = new ArrayList<Double>();
		sortedProducts = new HashMap<Double, IProductInterface>();
	};
	
	// Main method
	// General sort
	public ArrayList<Double> execSort(ArrayList<IProductInterface> arr) {
		
		
		for (int i = 0; i < arr.size(); i++) {
			sortedProducts.put(arr.get(i).getValue(), arr.get(i));
			sortedArr.add(i, arr.get(i).getValue());
		}
		
		// Sorting
		Collections.sort(sortedArr);
		
		sortStatus = true;
		
		return sortedArr;
		
	}
	
	
	// Getters
	public HashMap<Double, IProductInterface> getMap(){
		return sortedProducts;
	}

	public boolean isSorted() {
		return sortStatus;
	}
	
}
