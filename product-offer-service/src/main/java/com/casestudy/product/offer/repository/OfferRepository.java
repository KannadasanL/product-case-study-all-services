package com.casestudy.product.offer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casestudy.product.offer.entity.Offer;

public interface OfferRepository extends JpaRepository<Offer, Long>{

}
