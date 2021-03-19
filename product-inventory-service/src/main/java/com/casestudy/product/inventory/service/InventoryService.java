package com.casestudy.product.inventory.service;

import com.casestudy.product.inventory.entity.Inventory;
import com.casestudy.product.inventory.exception.InventoryNotFound;

public interface InventoryService {
	
	public Inventory getQuantityById(long id) throws InventoryNotFound;
	
	public Inventory addQuantity(Inventory inven);
	
	public void deleteQuantityById(long id) throws InventoryNotFound;
	
	public void deleteAllQuantity();
}
