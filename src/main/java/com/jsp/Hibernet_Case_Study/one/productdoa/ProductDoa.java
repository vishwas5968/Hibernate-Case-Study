package com.jsp.Hibernet_Case_Study.one.productdoa;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jsp.Hibernet_Case_Study.one.entity.Cart;
import com.jsp.Hibernet_Case_Study.one.entity.Product;

public class ProductDoa {
	Configuration cfg = new Configuration().configure().addAnnotatedClass(Product.class).addAnnotatedClass(Cart.class);
	org.hibernate.SessionFactory sf = cfg.buildSessionFactory();

	public String addProduct(Product product) {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(product);
		transaction.commit();
		sf.close();
		return "Product sucessfully added";
	}

	public Product getProduct(int id) {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		Product product = session.get(Product.class, id);
		transaction.commit();
//		sf.close();
		return product;
	}

	public List<Product> allProducts() {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		Query<Product> query = session.createQuery("FROM Product", Product.class);
		List<Product> productList = query.list();
		transaction.commit();
		sf.close();
		return productList;
	}

	public String updateProduct(Product product) {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(product);
		transaction.commit();
		sf.close();
		return "Product  sucessfully updated";
	}
	
	public String deleteProduct(Product product) {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		Product product2 = (Product) session.merge(product);
		session.delete(product2);
		transaction.commit();
		sf.close();
		return "Product  sucessfully deleted";
	}
	
	public  int deleteAllProduct() {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		int query = session.createQuery("delete from Product").executeUpdate();
		transaction.commit();
		sf.close();
		return query;
	}
	
}
