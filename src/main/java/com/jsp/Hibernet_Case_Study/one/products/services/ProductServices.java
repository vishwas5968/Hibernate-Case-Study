package com.jsp.Hibernet_Case_Study.one.products.services;

import java.util.List;
import java.util.Scanner;

import org.hibernate.query.Query;

import com.jsp.Hibernet_Case_Study.one.entity.Product;
import com.jsp.Hibernet_Case_Study.one.productdoa.ProductDoa;

public class ProductServices {

	public static void addProduct() {
		Scanner input = new Scanner(System.in);
		System.out.println("ENter how many product added");
		int n=input.nextInt();
		for(int i=1;i<=n;i++) {
		System.out.println("Enter the product name");
		String name = input.next();
		System.out.println("Enter the product price");
		double price = input.nextDouble();
		System.out.println("Enter the product quantity");
		int quantity = input.nextInt();

		Product product = new Product();
		product.setProductName(name);
		product.setProductPrice(price);
		product.setProductQuantity(quantity);

		ProductDoa productDao = new ProductDoa();
		String result = productDao.addProduct(product);
		System.out.println(result);
		}
	}

	public static void getProduct() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the product id");
		int id = input.nextInt();
		ProductDoa productDao = new ProductDoa();
		Product result = productDao.getProduct(id);
		if (result != null)
			System.out.println(result.getProductId() + " " + result.getProductName() + " " + result.getProductPrice()
					+ " " + result.getProductQuantity());
		else
			System.out.println("Product is not found");
	}

	public static void allProduct() {
		ProductDoa productDao = new ProductDoa();
		List<Product> result = productDao.allProducts();
		if(result!=null) {
		for (Product p : result)
			System.out.println(p.getProductId() + " " + p.getProductName() + " " + p.getProductPrice() + " "
					+ p.getProductQuantity());
		}
		else {
			System.out.println("Products is not found");
		}
	}

	public static void updateProduct() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the product id");
		int id = input.nextInt();
		ProductDoa productDao = new ProductDoa();
		Product product = productDao.getProduct(id);
		if (product != null) {
			System.out.println(
					product.getProductName() + " " + product.getProductPrice() + " " + product.getProductQuantity());
			System.out.println("Enter the product name");
			String name = input.next();
			System.out.println("Enter the product price");
			double price = input.nextDouble();
			System.out.println("Enter the product quantity");
			int quantity = input.nextInt();

			product.setProductName(name);
			product.setProductPrice(price);
			product.setProductQuantity(quantity);
			String message = productDao.updateProduct(product);
			System.out.println(message);
		} 
		else
			System.out.println("Product id not found");
	}
	
	public static void deleteProduct() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the product id");
		int id = input.nextInt();
		ProductDoa productDao = new ProductDoa();
		Product product = productDao.getProduct(id);
		if(product!=null) {
			String message = productDao.deleteProduct(product);
			System.out.println(message);
		}
		else
			System.out.println("Product id not found");
	}
	
	public static void deleteAllProduct() {
		ProductDoa productDao = new ProductDoa();
		int result = productDao.deleteAllProduct();
		if(result!=0) {
			System.out.println("All product is deleted");
		}
		else
			System.out.println("Products not found");
	}
}