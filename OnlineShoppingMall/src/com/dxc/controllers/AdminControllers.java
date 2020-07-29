package com.dxc.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dxc.pojo.Administrator;
import com.dxc.pojo.Customer;
import com.dxc.pojo.Product;
import com.dxc.service.AdminService;


@Controller
@RequestMapping("/views")
public class AdminControllers {

	AdminService adminService = new AdminService();
	Administrator admin = new Administrator();
	String message ;
	
	@RequestMapping(value="/login")
	public String adminLogin(@RequestParam("id") int id, @RequestParam("password") String password, Model m, HttpSession session) {
		
		session.setAttribute("id", id);
		//admin.setId(id);
		//admin.setPassword(password);
		boolean b = adminService.adminLogin(id, password);
		if(b == true) {
			return "AdminServices";
		} else {
			message =  "Admin Login Failed !!";
			m.addAttribute("message", message);
			return "result";
		}
	}
	
	@RequestMapping(value = "/addProduct")
	public String addProduct(@ModelAttribute Product product, Model m) {
		adminService.addProducts(product);
		message="Product Added";
		m.addAttribute("message", message);
		return "result";
	}
	
	@RequestMapping("/showAllProducts")
	public String showAllProduct(Model model) {
		List<Product> list = adminService.showAllProduct();
		model.addAttribute("list", list);
		return "ShowProducts";
	}
	
	@RequestMapping("/addCustomer")
	public String addCustomer(@ModelAttribute Customer customer, Model m) {
		adminService.addCustomer(customer);
		message="Customer added";
		m.addAttribute("message", message);
		return "result";
	}
	
	@RequestMapping("/RemoveCustomer")
	public String removeCustomer(@RequestParam("id") int id, @ModelAttribute Customer customer,Model m) {
		boolean b = adminService.removeCustomer(id, customer);
		if(b==true) {
			message = "Customer Removed";
			m.addAttribute("message", message);
			return "result";
		} else {
			message = "Customer Is Not Present";
			m.addAttribute("message", message);
			return "result";
		}
	}
	
	@RequestMapping("/viewAllCustomers")
	public String viewAllCustomers(Model m) {
		List<Customer> list = adminService.viewAllCustomers();
		m.addAttribute("list", list);
		return "viewAllCustomers";
	}
}
