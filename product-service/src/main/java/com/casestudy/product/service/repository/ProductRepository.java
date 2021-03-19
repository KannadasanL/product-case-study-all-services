package com.casestudy.product.service.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.product.service.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	Product findByName(String name);
}
