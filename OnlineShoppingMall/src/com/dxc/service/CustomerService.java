package com.dxc.service;

import java.util.List;

import com.dxc.dao.CustomerDao;
import com.dxc.pojo.Cart;
import com.dxc.pojo.Product;

public class CustomerService{

	CustomerDao customerDao = new CustomerDao();
	
	
	public boolean customerLogin(int id, String password) {
		return customerDao.customerLogin(id, password);
	}


	public boolean addBalance(int i, double balance) {
		return customerDao.addBalance(i, balance);
	}
	

	public List<Product> avaiableProducts() {
		return customerDao.avaiableProducts();
	}

public boolean find(int ProductNo)
{
	return customerDao.find(ProductNo);
}

	public List<Cart> getCartList(int id, int productNo) {
		return customerDao.getCartList(id, productNo);
	}

	
	public boolean payBill(int id, int pNo, double payamount, int quantity) {
		return customerDao.payBill(id, pNo, payamount, quantity);
	}


	

	public boolean addcart(int id, int productNo, Product p, Cart c, int quantity) {
		return customerDao.addcart(id, productNo, p, c, quantity);
	}


	public List<Cart> displaycart() {
		// TODO Auto-generated method stub
		return customerDao.displaycart();
	}

}
