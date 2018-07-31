package com.neuedu.entity;

import java.io.Serializable;

/**
 * ���ﳵʵ����
 * */
public class Cart  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5117733379863943502L;
	private  int id;

	private int productid;//����id
	private  int  productNum;//��Ʒ����

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
