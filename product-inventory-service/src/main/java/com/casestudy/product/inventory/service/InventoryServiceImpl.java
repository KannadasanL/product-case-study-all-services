package com.casestudy.product.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.product.inventory.entity.Inventory;
import com.casestudy.product.inventory.exception.InventoryNotFound;
import com.casestudy.product.inventory.repository.InventoryRepository;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryRepository invenRepo;
	
	
	@Override
	public Inventory getQuantityById(long id) throws InventoryNotFound {
		return invenRepo.findById(id)
				.orElseThrow(() -> new InventoryNotFound("Quantity is not found this product id::" + id));
	}

	@Override
	public Inventory addQuantity(Inventory inven) {
		return invenRepo.save(inven);
	}

	@Override
	public void deleteQuantityById(long id) throws InventoryNotFound {
		Inventory inven = getQuantityById(id);
		invenRepo.delete(inven);
	}

	@Override
	public void deleteAllQuantity() {
		invenRepo.deleteAll();
	}

}
