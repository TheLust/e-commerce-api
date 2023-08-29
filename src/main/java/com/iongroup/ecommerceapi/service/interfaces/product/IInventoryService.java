package com.iongroup.ecommerceapi.service.interfaces.product;

import com.iongroup.ecommerceapi.entity.product.Inventory;

import java.util.List;
import java.util.Optional;

public interface IInventoryService {
    public abstract Optional<Inventory> findById(Long id);
    public abstract List<Inventory> findAll();
    public abstract void save(Inventory inventory);
    public abstract void update(Inventory inventory, Inventory updatedInventory);
    public abstract void delete(Long id);
}
