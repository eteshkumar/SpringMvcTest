package com.iris.daos;

import java.util.List;

import com.iris.models.Product;

public interface ProductDao {
	
	public boolean addProduct(Product pObj);
	public boolean deleteProduct(Product pObj);
	public boolean updateProduct(Product pObj);
	public Product getProductById(int pid);
	public List<Product> getAllProducts();
	public Product validateProduct(int productId, String productName);
	

}
