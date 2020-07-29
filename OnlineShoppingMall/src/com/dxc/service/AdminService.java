package com.dxc.service;

import java.util.List;

import com.dxc.dao.AdminDao;
import com.dxc.pojo.Administrator;
import com.dxc.pojo.Customer;
import com.dxc.pojo.Product;

public class AdminService {

	AdminDao adminDao = new AdminDao();

	
	public boolean adminLogin(int id, String password) {
		return adminDao.adminLogin(id, password);
	}


	public void addProducts(Product product) {
		adminDao.addProducts(product);
	}


	public List<Product> showAllProduct() {
		return adminDao.showAllProduct();
	}

	public void addCustomer(Customer customer) {
		adminDao.addCustomer(customer);
	}

	public boolean removeCustomer(int id, Customer customer) {
		return adminDao.removeCustomer(id, customer);
	}

	public List<Customer> viewAllCustomers() {
		return adminDao.viewAllCustomers();
	}

}
