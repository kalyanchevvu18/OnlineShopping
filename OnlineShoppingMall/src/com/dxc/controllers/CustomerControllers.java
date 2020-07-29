package com.dxc.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dxc.pojo.Cart;
import com.dxc.pojo.Customer;
import com.dxc.pojo.Product;
import com.dxc.service.CustomerService;

@Controller
@RequestMapping("/views")
public class CustomerControllers {

	CustomerService customerService = new CustomerService();
	Customer customer = new Customer();
	String message = "";
	Product product;
	int quantity;
	private int id = 0;
	private int ProductNo=0;

	@RequestMapping("/loginCustomer")
	public String customerLogin(@RequestParam("id") int id, @RequestParam("password") String password, Model model,
			HttpSession session) {
		customer.setId(id);
		customer.setPassword(password);
		this.id = id;
		session.setAttribute("id",id);
		boolean b = customerService.customerLogin(id, password);
		if (b == true) {
			return "CustomerServices";
		} else {
			message = "Customer Login Failed";
			model.addAttribute("message", message);
			return "result";
		}

	}

	@RequestMapping("/addBalance")
	public String addBalance(@RequestParam("balance") double balance,Model m) {
		int i = id;
		customer.setBalance(balance);
		boolean b = customerService.addBalance(i, balance);
		message="Amount Added";
		m.addAttribute("message", message);
		return "result";
	}
	@RequestMapping("/availableProducts")
	public String availablelProducts(Model model) {
		List<Product> list = customerService.avaiableProducts();
		model.addAttribute("list", list);
		return "ShowProducts";
	}

	@RequestMapping("/show")
	public String show(@ModelAttribute Product product) {
		this.product = product;
		return "quantity";
	}

	@RequestMapping("/quantity")
	public String quantity(@RequestParam int quantity, Model m) {
		this.quantity = quantity;
		if (quantity <= product.getQuantity() && quantity > 0) {
			product.setQuantity(quantity);
			m.addAttribute("product", product);
			return "Confirmation";
		} else {
			message = "Quantity Exceeded / You Are Giving Zero/Less Than Zero Quantity";
			m.addAttribute("message", message);
			return "result";
		}
	}

	@RequestMapping("/find")
	public String addToCart(@RequestParam("productNo") int productNo, Model m,HttpSession session) {
		
		session.setAttribute("productNo",productNo);
		boolean b = customerService.find(productNo);
		if (b == true) {
			return "quantity";
		}
		else
		{
			message="no such product";
		}
		m.addAttribute("message", message);
		return "result";
	}
	@RequestMapping("/cart")
	public String addcart(@ModelAttribute Product p,@ModelAttribute Cart c,HttpSession session,@RequestParam("quantity") int quantity,Model m)
	{
		int id=(int)session.getAttribute("id");
	  int ProductNo=(int)session.getAttribute("productNo");
		boolean b=customerService.addcart(id,ProductNo,p,c,quantity);
		if(b==true) {
			
				message="product added to cart";
			}
			else
			{
			
				message="You are giving high quantity ! Try giving less quantity";
			}
			m.addAttribute("message", message);
			return "result";
					}
	
	
	@RequestMapping("/displaycart")
	public String displaycart(Model model) {
		List<Cart> list = customerService.displaycart();
		model.addAttribute("list", list);
		return "displaycart";
	}
	@RequestMapping("/payBill")
	public String payBill(@RequestParam int ProductNo,HttpSession session, Model m) {
		session.setAttribute("ProductNo", ProductNo);
		List<Cart> list = customerService.getCartList(id, ProductNo);
		for (Cart c : list) {
			m.addAttribute("c", c);
		}
		return "PayBill";
	}
	
	

	@RequestMapping("/paidBill")
	public String paidBill(@RequestParam int ProductNo, @RequestParam double payamount, @RequestParam int quantity,
			HttpSession session,Model m) {
			int pNo = (int) session.getAttribute("ProductNo");
		boolean b = customerService.payBill(id, pNo, payamount, quantity);

		if (b == true) {
			message = "Successfully Paid Amount";
		} else {
			message = "You Don't Have Enough Money To Buy This Product..";
		}
		m.addAttribute("message", message);
		return "result";
	}
	
	
	
	
	
	
	
	
	
	@RequestMapping("/payFromCart")
	public String payCartBill(@RequestParam int productNo, Model m) {
		List<Cart> list = customerService.getCartList(id, productNo);
		for (Cart c : list) {
			m.addAttribute("c", c);
		}
		return "redirect:paidCart";
	}
	
	@RequestMapping("/paidCart")
	public String payFromCart(@RequestParam int productNo, @RequestParam double payableAmount, Model m) {
		boolean b = customerService.payBill(id, productNo, payableAmount, quantity);
		if (b == true) {
			message = "Successfully Paid Amount";
		} else {
			message = "You Don't Have Enough Money To Buy This Product..";
		}
		m.addAttribute("message", message);
		return "result";
	}

}
