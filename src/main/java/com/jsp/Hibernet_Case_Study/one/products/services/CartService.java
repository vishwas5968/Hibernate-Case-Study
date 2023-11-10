package com.jsp.Hibernet_Case_Study.one.products.services;

import java.util.Scanner;

import com.jsp.Hibernet_Case_Study.one.entity.Cart;
import com.jsp.Hibernet_Case_Study.one.productdoa.CartDoa;

public class CartService {
    public static void createCart() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter CartId");
        int cId = input.nextInt();
        System.out.println("Enter User Id");
        int userId = input.nextInt();
        CartDoa cartDoa = new CartDoa();
        String message = cartDoa.createCart(cId,userId);
        System.out.println(message);
    }

    public static void addProductToCart() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the CartId");
        int cartId = input.nextInt();
        CartDoa cartDoa = new CartDoa();
        Cart cart = cartDoa.getCartByID(cartId);
        ProductServices productServices=new ProductServices();
    	productServices.allProduct();
    	
        if (cart != null) {
            System.out.println("Enter the Product Id");
            int productId = input.nextInt();
            System.out.println("Enter the Product Qty");
            int qty = input.nextInt();
            cartDoa.addProductToCart(cartId, productId, qty);
        } else {
            System.out.println("CartId is Not Found");
        }
    }
    public static void removeProductToCart() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the CartId");
        int cartId = input.nextInt();
        CartDoa cartDoa = new CartDoa();
        Cart cart = cartDoa.getCartByID(cartId);
        if(cart!=null) {
        cartDoa.cartAllDetailsById(cartId);
        System.out.println("Enter the Product Id to Deleted");
        int pId=input.nextInt();
        cartDoa.removeProductFromCart(cartId, pId);
    }
        else {
            System.out.println("Cart with ID " + cartId + " not found.");
        }
}
}
