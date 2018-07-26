package com.neuedu.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.CartDao;
import com.neuedu.dao.ProductDao;
import com.neuedu.entity.Cart;
import com.neuedu.entity.PageModel;

import com.neuedu.utils.DBUtils;

public class CartDaoImpl implements CartDao {

	ProductDao productDao = new ProductDaoImpl();

	@Override
	public boolean addCart(Cart cart) {
		// TODO Auto-generated method stub

		Connection conn = null;
		Statement st = null;
		try {
			conn = DBUtils.getConnection();
			st = conn.createStatement();
			String sql = "insert into cart(productid,productnum) values (" + cart.getProductId().getId() + ","
					+ cart.getProductNum() + ")";
			System.out.println(sql);
			st.execute(sql);
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return false;
	}

	@Override
	public boolean deleteCart(int id) {
		// TODO Auto-generated method stub

		Connection conn = null;
		Statement st = null;
		try {
			conn = DBUtils.getConnection();
			st = conn.createStatement();
			String sql = "delete from cart where id=" + id + "";
			System.out.println(sql);
			st.execute(sql);
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return false;
	}

	@Override
	public boolean updataeCart(Cart cart) {
		// TODO Auto-generated method stub

		Connection conn = null;
		Statement st = null;
		try {
			conn = DBUtils.getConnection();
			st = conn.createStatement();
			String sql = "update cart set productid="+cart.getProductId().getId()+","+"productnum= "+cart.getProductNum()+" where id="+cart.getId();
			System.out.println(sql);
			st.execute(sql);
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return false;
	}

	@Override
	public List<Cart> findAllCart() {
		// TODO Auto-generated method stub

		List<Cart> carts = new ArrayList<Cart>();

		Connection conn = null;
		Statement st = null;
		try {
			conn = DBUtils.getConnection();
			st = conn.createStatement();
			String sql = "select id,productid,productnum from  cart";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				int productid = rs.getInt("productid");
				int num = rs.getInt("productnum");

				Cart cart = new Cart();
				cart.setId(id);
				cart.setProductNum(num);

				cart.setProductId(productDao.findById(productid));

				carts.add(cart);

			}

			return carts;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;
	}
    
	@Override
	public Cart findCartById(int id) {
		Connection conn = null;
		Statement st = null;
		Cart cart = new Cart();
		try {
			conn = DBUtils.getConnection();
			st = conn.createStatement();
			String sql = "select id,productid,productnum from  cart where id="+ id;
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				id = rs.getInt("id");
				int productid = rs.getInt("productid");
				int num = rs.getInt("productnum");

				
				cart.setId(id);
				cart.setProductNum(num);

				cart.setProductId(productDao.findById(productid));
			}

			return cart;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	@Override
	public int getCartNum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updateCart(int id, int num) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement st = null;
		try {
			conn = DBUtils.getConnection();
			st = conn.createStatement();
			String sql = "update cart set productnum=" + num + " where id=" + id + "";
			System.out.println(sql);
			st.execute(sql);
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return false;
	}

	@Override
	public void clearCart() {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("resource")
	@Override
	public PageModel<Cart> findEmpByPage(int pageNo, int pageSize) {
		// pageNo第几页 pageSize一页有多少条
		// TODO Auto-generated method stub
		PageModel<Cart> pagemodel = new PageModel<Cart>();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			String sqlcount = "select count(id) from cart";
			st = conn.prepareStatement(sqlcount);
			rs = st.executeQuery();
			if(rs.next()) {
				int totalCount = rs.getInt(1);
				int totalPage = (totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1);
				pagemodel.setTotalPage(totalPage);
			}

			String sql = "select * from  cart limit ?,?";
			st = conn.prepareStatement(sql);
			st.setInt(1, (pageNo - 1) * pageSize);
			st.setInt(2, pageSize);
			rs = st.executeQuery();
			List<Cart> list = new ArrayList<Cart>();
			while (rs.next()) {
				Cart cart = new Cart(rs.getInt("id"),productDao.findById(rs.getInt("productid")),rs.getInt("productnum"));
				list.add(cart);
			}
			
			pagemodel.setData(list);
			pagemodel.setCurrentPage(pageNo);
			return pagemodel;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;
	}

	

}
