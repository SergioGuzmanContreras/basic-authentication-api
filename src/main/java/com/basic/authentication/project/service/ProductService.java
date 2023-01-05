package com.basic.authentication.project.service;

import java.util.List;

import com.basic.authentication.project.models.Product;

public interface ProductService {

	List<Product> findAll();
	Product findByid(Integer id);
	Product newProduct(Product request);
	Product updateProduct(Product request);
	void delete(Integer id);

}
