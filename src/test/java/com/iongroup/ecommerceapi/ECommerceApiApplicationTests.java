package com.iongroup.ecommerceapi;

import com.iongroup.ecommerceapi.entity.product.Category;
import com.iongroup.ecommerceapi.entity.product.Inventory;
import com.iongroup.ecommerceapi.entity.product.Product;
import com.iongroup.ecommerceapi.entity.enums.DiscountType;
import com.iongroup.ecommerceapi.repository.product.CategoryRepository;
import com.iongroup.ecommerceapi.repository.product.InventoryRepository;
import com.iongroup.ecommerceapi.repository.OrderItemRepository;
import com.iongroup.ecommerceapi.repository.product.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@Transactional
@SpringBootTest
class ECommerceApiApplicationTests {

	private final CategoryRepository categoryRepository;

	private final InventoryRepository inventoryRepository;

	private final ProductRepository productRepository;

	private final OrderItemRepository orderItemRepository;

	@Autowired
	ECommerceApiApplicationTests(CategoryRepository categoryRepository, InventoryRepository inventoryRepository, ProductRepository productRepository, OrderItemRepository orderItemRepository) {
		this.categoryRepository = categoryRepository;
		this.inventoryRepository = inventoryRepository;
		this.productRepository = productRepository;
		this.orderItemRepository = orderItemRepository;
	}

	@Test
	void contextLoads() {
	}

	@Test
	void checkPrecalcFunc() {
		Category category = new Category();
		category.setName("Suka");
		category.setDescription("Blyat");

		category = categoryRepository.save(category);

		Inventory inventory = new Inventory();
		inventory.setQuantity(100);

		inventory = inventoryRepository.save(inventory);

		Product product = new Product();
		product.setCategory(category);
		product.setInventory(inventory);
		product.setTitle("Product");
		product.setPrice(200.0);
		product.setDiscountType(DiscountType.NONE);
		product.setDiscount(0);
		product.setSummary("idk");

		product = productRepository.save(product);

//		OrderItem orderItem = new OrderItem();
//		orderItem.setId(1L);
//		orderItem.setQuantity(2);
//		orderItem.setProduct(product);


		System.out.println(product);
		System.out.println(inventory);
		System.out.println(category);
	}

}
