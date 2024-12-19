package com.ecom.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.pojos.Product;

public interface ProductDao extends JpaRepository<Product, Long> {

	List<Product> findByStatusTrue();
}
