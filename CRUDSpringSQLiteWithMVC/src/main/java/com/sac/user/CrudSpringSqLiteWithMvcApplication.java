package com.sac.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sac.user.entities.Product;
import com.sac.user.services.ProductService;

@SpringBootApplication
public class CrudSpringSqLiteWithMvcApplication implements CommandLineRunner {

	@Autowired
	private ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringSqLiteWithMvcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		displayProductsList();
		searchProducts();
		findProduct();
		saveProduct();
		deleteProduct();

	}

	private void displayProductsList() {
		System.out.println("========Displayng Products==========");
		for (Product product : productService.findAll()) {
			System.out.println("ID: " + product.getId());
			System.out.println("Name: " + product.getName());
			System.out.println("Price: " + product.getPrice());
			System.out.println("=============================");
		}
	}

	private void searchProducts() {
		System.out.println("========Searching Products (5,15)==========");
		for (Product product : productService.search(5, 10)) {
			System.out.println("ID: " + product.getId());
			System.out.println("Name: " + product.getName());
			System.out.println("Price: " + product.getPrice());
			System.out.println("=============================");
		}
	}

	private void findProduct() {
		System.out.println("========Finding Product with ID 1 ==========");
		Product product = productService.find(1);
		if (product != null) {
			System.out.println("ID: " + product.getId());
			System.out.println("Name: " + product.getName());
			System.out.println("Price: " + product.getPrice());
			System.out.println("=============================");
		}
	}

	private void saveProduct() {

		Product product = new Product();
		product.setName("Meat");
		product.setPrice(14.00);
		product.setQuantity(2);
		product.setStatus(true);

		System.out.println("========Saved Product ==========");
		Product savedProduct = productService.save(product);
		if (savedProduct != null) {
			System.out.println("ID: " + savedProduct.getId());
			System.out.println("Name: " + savedProduct.getName());
			System.out.println("Price: " + savedProduct.getPrice());
			System.out.println("=============================");
		}
	}

	private void deleteProduct() {
		System.out.println("========Deleting Product with ID 6==========");
		productService.delete(6);
		System.out.println("Product with ID 6 is deleted successfully");
	}
}
