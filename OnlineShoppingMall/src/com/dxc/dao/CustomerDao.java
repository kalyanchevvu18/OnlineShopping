package com.dxc.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dxc.pojo.Administrator;
import com.dxc.pojo.Cart;
import com.dxc.pojo.Customer;
import com.dxc.pojo.Product;

public class CustomerDao {

	private static SessionFactory sessionFactory;

	static {
		Configuration configuration = new Configuration().configure();
		sessionFactory = configuration.buildSessionFactory();
	}


	public boolean customerLogin(int id, String password) {
		Session session = sessionFactory.openSession();
		Query query1 = session.createQuery("from Customer where id=:id and password=:password");
		query1.setParameter("id", id);
		query1.setParameter("password", password);

		List<Customer> list = query1.getResultList();
		for (Customer l : list) {
			if (id == l.getId() && password.equals(l.getPassword())) {
				return true;
			}
		}

		return false;
	}


	public boolean addBalance(int i, double balance) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Customer where id=:id");
		query.setParameter("id", i);
		List<Customer> list = query.getResultList();
		for(Customer c : list) {
			balance = c.getBalance() + balance;
			Query query1 = session.createQuery("update Customer set balance=:balance where id=:id");
			query1.setParameter("id", i);
			query1.setParameter("balance", balance);
			query1.executeUpdate();
			return true;
		}
		return false;
	}

	
	public List<Product> avaiableProducts() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Product");
		return query.getResultList();
	}


	public boolean addcart(int id, int ProductNo, Product p, Cart c, int quantity) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Product where productNo=:ProductNo");
		query.setParameter("ProductNo", ProductNo);
		List<Product> list = query.getResultList();
		System.out.println(list);

		for(Product p1 : list )
		{
		//Product p1 = list.get(0);
		
		if (p1.getQuantity() >= quantity) {

			double discount = p1.getProductPrice() / p1.getDiscount();
			double grandtotal = quantity * p1.getProductPrice(); //
			double totdiscount = (quantity * discount) * 2;
			double payamount = grandtotal - totdiscount;


			c.setId(id);
			c.setProductNo(p1.getProductNo());
			c.setQuantity(quantity);
			c.setGrandtotal(grandtotal);
			c.setTotdiscount(totdiscount);
			c.setPayamount(payamount);

			System.out.println(p1.getQuantity());
			System.out.println(quantity);
	
			Session session1 = sessionFactory.openSession();
			session1.beginTransaction();
			session1.save(c);
			session1.getTransaction().commit();
			return true;
		}
		
		}
		
		return false;

	}
	
	public boolean find(int ProductNo) {
		Product v = null;
		Session session = sessionFactory.openSession();
		Query query4 = session.createQuery("from Product where  ProductNo=:ProductNo");
		query4.setParameter("ProductNo",ProductNo);
		List<Product> v1 = query4.getResultList();
		try {
			v = v1.get(0);
			return true;
		} catch (Exception e) {
			return false;

		}
	}

	
	
	public List<Cart> getCartList(int id, int productNo) {

		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Cart where id=:id AND productNo=:productNo");
		query.setParameter("id", id);
		query.setParameter("productNo", productNo);
		return query.getResultList();
	}
	
	public boolean payBill(int id, int pNo, double payamount, int quantity) {
		Cart cart = new Cart();
		Product product = new Product();
		Customer cust = new Customer();

		int quan ;
		double bal = 0;

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Product where productNo=:productNo");
		query.setParameter("productNo", pNo);
		
		List<Product> list = query.getResultList();
		for(Product p:list) {
			quan = p.getQuantity() - quantity;
			Query query1 = session.createQuery("update Product set quantity=:quantity where productNo=:productNo");
			query1.setParameter("productNo", pNo);
			query1.setParameter("quantity", quan);
			query1.executeUpdate();
		}
		session.getTransaction().commit();

		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		Query query2 = session2.createQuery("from Customer where id=:id");
		query2.setParameter("id", id);
		List<Customer> list1 = query2.getResultList();

		for(Customer c : list1) {
			bal = c.getBalance() - payamount;
			if (c.getBalance() >= payamount) {
				Query query3 = session2.createQuery("update Customer set balance=:bal where id=:id");
				query3.setParameter("id", id);
				query3.setParameter("bal", bal);
				query3.executeUpdate();
			} else {
				return false;
			}
		}
		session2.getTransaction().commit();

		Session session3 = sessionFactory.openSession();
		session3.beginTransaction();
		Query query4 = session3.createQuery("delete from Cart where id=:id AND ProductNo=:ProductNo");
		query4.setParameter("id", id);
		query4.setParameter("ProductNo", pNo);
		query4.executeUpdate();
		session3.getTransaction().commit();
		return true;
	}


	public List<Cart> displaycart() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Cart");
		return query.getResultList();
	}	}




