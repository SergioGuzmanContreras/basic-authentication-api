package com.basic.authentication.project.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.authentication.project.dao.ProductDao;
import com.basic.authentication.project.dao.entity.ProductEntity;
import com.basic.authentication.project.models.Product;
import com.basic.authentication.project.service.ProductService;
import com.basic.authentication.project.utils.exceptions.ResponseBadRequestException;
import com.basic.authentication.project.utils.exceptions.ResponseInternalServerErrorException;
import com.basic.authentication.project.utils.exceptions.ResponseNotFoundException;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao product;

	@Override
	public List<Product> findAll() {
		return this.product.findAll().stream().map(this::transform).collect(Collectors.toList());
	}

	@Override
	public Product findByid(Integer id) {
		var response = this.product.findById(id).orElse(ProductEntity.builder().build());
		if(response.getId() == null)
			throw new ResponseNotFoundException("Product id: " + id + "not found in database.");
		return this.transform(response);
	}

	@Override
	public Product newProduct(Product request) {
		var response = this.product.findByName(request.getName()).orElse(ProductEntity.builder().build());
		if(response.getId() != null)
			throw new ResponseNotFoundException("Product: " + request.getName() + "exists with id: " + response.getId() + " in database.");
		response = this.product.save(this.transform(request));
		if(response == null)
			throw new ResponseInternalServerErrorException("Error saving the information in the database, please try again later.");
		return this.transform(response);
	}

	@Override
	public Product updateProduct(Product request) {
		var data = this.product.findByIdOrName(request.getId(), request.getName());
		if(data.size() > 1) {
			var prod = data.stream().filter(x -> x.getName().equalsIgnoreCase(request.getName())).collect(Collectors.toList()).get(0);
			throw new ResponseBadRequestException("Error the product you want to modify already exists with the id: " + prod.getId());			
		}
		var response = this.product.save(this.transform(request));
		if(response == null)
			throw new ResponseInternalServerErrorException("Error saving the information in the database, please try again later.");
		return this.transform(response);
		}

	@Override
	public void delete(Integer id) {
		var response = this.product.findById(id).orElse(ProductEntity.builder().build());
		if(response.getId() == null)
			throw new ResponseNotFoundException("Product id: " + id + "not found in database.");
		this.product.delete(response);
	}

	private Product transform(ProductEntity product) {
		return Product.builder()
				.id(product.getId())
				.name(product.getName())
				.price(product.getPrice())
				.createAt(product.getCreateAt())
				.build();
	}

	private ProductEntity transform(Product product) {
		return ProductEntity.builder()
				.id(product.getId())
				.name(product.getName())
				.price(product.getPrice())
				.createAt(product.getCreateAt())
				.build();
	}

}
