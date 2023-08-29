package com.iongroup.ecommerceapi.repository.product;

import com.iongroup.ecommerceapi.entity.product.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
