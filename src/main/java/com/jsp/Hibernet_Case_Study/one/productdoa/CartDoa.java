package com.jsp.Hibernet_Case_Study.one.productdoa;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jsp.Hibernet_Case_Study.one.entity.Cart;
import com.jsp.Hibernet_Case_Study.one.entity.Product;
import com.jsp.Hibernet_Case_Study.one.products.services.ProductServices;

public class CartDoa {
    Configuration cfg = new Configuration().configure().addAnnotatedClass(Cart.class).addAnnotatedClass(Product.class);
    org.hibernate.SessionFactory sf = cfg.buildSessionFactory();

    public String createCart(int cId, int userId) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        Cart cart = new Cart();
        cart.setUserId(userId);
        cart.setcId(cId);
        session.save(cart);
        transaction.commit();
        session.close();
        return "Cart created Successfully";
    }

    public Cart getCartByID(int cartId) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        Cart cart = session.get(Cart.class, cartId);
        transaction.commit();
        session.close();
        return cart;
    }

    
    public void cartAllDetailsById(int cId) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        Cart cartDetails = session.get(Cart.class, cId);

        if (cartDetails != null) {
            for (Product product : cartDetails.getpList()) {
                System.out.println("Product Name: " + product.getProductId()+"Product Name: " + product.getProductName()+"Product Price: " + product.getProductPrice()+"Quantity: " + product.getProductQuantity());
            }
        } 
    else{
            System.out.println("Cart with ID " + cId + " not found.");
        }
        transaction.commit();
        session.close();
    }

    public void addProductToCart(int cartId, int productId, int qty) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        Cart cart = getCartByID(cartId);
         
        if (cart != null) {
            Product product = session.get(Product.class, productId);

            if (product != null) {
                cart.setQty(qty);
                product.getCarts().add(cart);
                cart.getpList().add(product);
            } else {
                System.out.println("Product not found.");
            }
        } else {
            System.out.println("Cart not found.");
        }

        session.saveOrUpdate(cart);
        transaction.commit();
        session.close();
    }

    public void removeProductFromCart(int cId, int productId) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        Cart cart = session.get(Cart.class, cId); 

        if (cart != null) {
            Product product = session.get(Product.class, productId);
            
            if (product != null && cart.getpList().contains(product)) {
                cart.getpList().remove(product);
                session.update(cart);
                transaction.commit();
                session.close();
                System.out.println("Product with ID " + productId + " has been removed from the cart.");
            } else {
                System.out.println("Product with ID " + productId + " not found in the cart.");
            }
        } else {
            System.out.println("Cart with ID " + cId + " not found.");
        }
    }


}
