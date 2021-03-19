package com.casestudy.product.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casestudy.product.inventory.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

}
