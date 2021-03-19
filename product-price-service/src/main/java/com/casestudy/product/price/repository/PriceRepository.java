package com.casestudy.product.price.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casestudy.product.price.entity.Price;

public interface PriceRepository extends JpaRepository<Price, Long>{

}
