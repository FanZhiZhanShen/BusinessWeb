package com.neuedu.entity;

import java.io.Serializable;

/**
 * 购物车实体类
 * */
public class Cart  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5117733379863943502L;
	private  int id;

	private int productid;//父类id
	private  int  productNum;//商品数量

	public Cart() {

	}
	public Cart(int productid, int productNum) {

		this.productid = productid;
		this.productNum = productNum;
	}
	public Cart(int id, int productid, int productNum) {
		this.id = id;
		this.productid = productid;
		this.productNum = productNum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public int getProductNum() {
		return productNum;
	}

	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}

	@Override
	public String toString() {
		return "Cart{" +
				"id=" + id +
				", productid=" + productid +
				", productNum=" + productNum +
				'}';
	}
}
