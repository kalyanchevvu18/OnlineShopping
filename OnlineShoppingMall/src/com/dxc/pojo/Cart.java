package com.dxc.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cart {

	@Id
	private int sno;
	private int id;
	private int ProductNo;
	private int quantity;
	private double totdiscount;
	private double grandtotal;
	private double payamount;
	
	
	
		public Cart() {
			}



		public int getSno() {
			return sno;
		}



		public void setSno(int sno) {
			this.sno = sno;
		}



		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getProductNo() {
			return ProductNo;
		}

		public void setProductNo(int productNo) {
			ProductNo = productNo;
		}
		public int getQuantity() {
			return quantity;
		}



		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}



		public double getTotdiscount() {
			return totdiscount;
		}



		public void setTotdiscount(double totdiscount) {
			this.totdiscount = totdiscount;
		}



		public double getGrandtotal() {
			return grandtotal;
		}



		public void setGrandtotal(double grandtotal) {
			this.grandtotal = grandtotal;
		}



		public double getPayamount() {
			return payamount;
		}



		public void setPayamount(double payamount) {
			this.payamount = payamount;
		}



		public Cart(int sno, int id, int productNo, int quantity, double totdiscount, double grandtotal,
				double payamount) {
			super();
			this.sno = sno;
			this.id = id;
			ProductNo = productNo;
			this.quantity = quantity;
			this.totdiscount = totdiscount;
			this.grandtotal = grandtotal;
			this.payamount = payamount;
		}



		@Override
		public String toString() {
			return "Cart [sno=" + sno + ", id=" + id + ", ProductNo=" + ProductNo + ", quantity=" + quantity
					+ ", totdiscount=" + totdiscount + ", grandtotal=" + grandtotal + ", payamount=" + payamount + "]";
		}
		
		

	
	
}
