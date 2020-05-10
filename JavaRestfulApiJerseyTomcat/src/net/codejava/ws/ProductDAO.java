package net.codejava.ws;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
	private static ProductDAO instance; 
	private static List<Product> data = new ArrayList<>( ); 
	
	static { 
	data.add(new Product(1, "iPhone 11 Pro", 999.99f));
	data.add(new Product(2, "iPhone 11 ProMax", 888.99f));
	data.add(new Product(3, "iPhone 11", 777.99f));
	}
	
	private ProductDAO() {} // 
	
	public static ProductDAO getInstance() {
		if (instance == null) {
			instance = new ProductDAO(); 
		}
		return instance; 
	} 

	public List<Product> listAll() {
		return new ArrayList<Product>(data); 
	}
	
	// return the id of the newly added product 
	public int add(Product product) {
		int newId = data.size() +1; // List<Product> data, adds 1 to the existing ArrayList.   
		product.setId(newId);
		data.add(product); 
		
		return newId; 
	}
	  
	// writing a specific product to find in the list int id 
	public Product get(int id) {
		Product productToFind = new Product(id); // here adding new constructor on Product.java that has only int id as param. 
		int index = data.indexOf(productToFind); // returns the first element in the product list 
		if (index >= 0) {
			return data.get(index); 
		}
		
		return null; 
	}
	
	public boolean update(Product product) {
		int index = data.indexOf(product); 
		if (index >= 0) {
			data.set(index, product); 
			
			return true; 
		}
		return false; 
	}

	public boolean delete(int id) {
		Product productToFind = new Product(id); 
		
		int index = data.indexOf(productToFind); 
			if (index >= 0) {
				data.remove(index); 
				return true; 
			}
		
		return false; 
	}
}

