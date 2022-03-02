package com.sac.user.services;

import java.util.List;

import com.sac.user.entities.Product;

public interface ProductService {
	
	Iterable<Product> findAll();
	public List<Product> search(double min, double max);
	public Product find(int id);
	public Product save(Product product);
	public void delete(int id);
}
