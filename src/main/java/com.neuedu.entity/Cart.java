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
	private  Product  productId;
	private  int  productNum;//��Ʒ����
	
	
	public Cart(int id, Product productId, int productNum) {
		super();
		this.id = id;
		this.productId = productId;
		this.productNum = productNum;
	}
	public Cart() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Product getProductId() {
		return productId;
	}
	public void setProductId(Product productId) {
		this.productId = productId;
	}
	public int getProductNum() {
		return productNum;
	}
	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", product=" + productId + ", productNum=" + productNum + "]";
	}
	
	
	
	
	
	
}
