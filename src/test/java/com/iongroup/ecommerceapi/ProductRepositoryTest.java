package com.iongroup.ecommerceapi;

import com.iongroup.ecommerceapi.entity.product.Category;
import com.iongroup.ecommerceapi.entity.product.Inventory;
import com.iongroup.ecommerceapi.entity.product.Product;
import com.iongroup.ecommerceapi.entity.enums.DiscountType;
import com.iongroup.ecommerceapi.repository.product.CategoryRepository;
import com.iongroup.ecommerceapi.repository.product.InventoryRepository;
import com.iongroup.ecommerceapi.repository.product.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Test
    void testSaveProductWithInventory() {
        Category category = new Category();
        category.setName("Suka");
        category.setDescription("Blyat");
        categoryRepository.save(category);

        // Create and persist an Inventory
        Inventory inventory = new Inventory();
        inventory.setQuantity(100);
        inventoryRepository.save(inventory);

        // Create a Product and establish relationships
        Product product = new Product();
        product.setCategory(category);
        product.setInventory(inventory);
        product.setTitle("Product");
        product.setPrice(200.0);
        product.setDiscountType(DiscountType.NONE);
        product.setDiscount(0);
        product.setSummary("idk");

        // Save the Product
        Product savedproduct = productRepository.save(product);

        System.out.println(savedproduct);
    }
}
