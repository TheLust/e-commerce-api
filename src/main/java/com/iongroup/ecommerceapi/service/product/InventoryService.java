package com.iongroup.ecommerceapi.service.product;

import com.iongroup.ecommerceapi.entity.product.Inventory;
import com.iongroup.ecommerceapi.repository.product.InventoryRepository;
import com.iongroup.ecommerceapi.service.interfaces.product.IInventoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class InventoryService implements IInventoryService {

    private final InventoryRepository inventoryRepository;

    @Override
    public Optional<Inventory> findById(Long id) {
        return inventoryRepository.findById(id);
    }

    @Override
    public List<Inventory> findAll() {
        return inventoryRepository.findAll();
    }

    @Override
    public void save(Inventory inventory) {
        inventoryRepository.save(inventory);
    }

    @Override
    public void update(Inventory inventory, Inventory updatedInventory) {
        BeanUtils.copyProperties(updatedInventory, inventory, "id", "product");
        inventoryRepository.save(inventory);
    }

    @Override
    public void delete(Long id) {
        inventoryRepository.deleteById(id);
    }
}
