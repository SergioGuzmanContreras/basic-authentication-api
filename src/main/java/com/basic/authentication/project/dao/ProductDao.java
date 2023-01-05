package com.basic.authentication.project.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.basic.authentication.project.dao.entity.ProductEntity;

public interface ProductDao extends JpaRepository<ProductEntity, Integer>{

	Optional<ProductEntity> findByName(String name);	
	List<ProductEntity> findByIdOrName(Integer id, String name);
	
}
