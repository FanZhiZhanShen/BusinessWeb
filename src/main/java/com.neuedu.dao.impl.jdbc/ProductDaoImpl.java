package com.neuedu.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.ProductDao;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.utils.DBUtils;

public class ProductDaoImpl implements ProductDao {

	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBUtils.getConnection();
			
			String sql = "insert into product(name,pdesc,price,rule,image,stock) values (?,?,?,?,?,?)";
			st = conn.prepareStatement(sql);
			// 占位符赋值
			st.setString(1, product.getName());
			st.setString(2, product.getDesc());
			st.setDouble(3, product.getPrice());
			st.setString(4, product.getRule());
			st.setString(5, product.getImage());
			st.setInt(6, product.getStock());
			System.out.println(sql);
			st.execute();
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
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		List<Product> products = new ArrayList<Product>();
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "select id,name,pdesc,price,rule ,image,stock from  product";
			st = conn.prepareStatement(sql);
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String pdesc = rs.getString("pdesc");
				double price = rs.getDouble("price");
				String rule = rs.getString("rule");
				String image = rs.getString("image");
				int stock = rs.getInt("stock");
				Product product = new Product(id, name, pdesc, price, rule, image, stock);
				products.add(product);
			}
			return products;
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
	public Product findById(int id) {
		// TODO Auto-generated method stub
		//还差一步：判断id值是不是数据库中已有的id值（这里的id值一定是因为该id值是从表中获取的）
		Product product = new Product();
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "select id,name,pdesc,price,rule ,image,stock from  product where id=?";
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			System.out.println(sql);
			
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				
				int _id = rs.getInt("id");
				String name = rs.getString("name");
				String pdesc = rs.getString("pdesc");
				double price = rs.getDouble("price");
				String rule = rs.getString("rule");
				String image = rs.getString("image");
				int stock = rs.getInt("stock");

				product.setId(_id);
				product.setName(name);
				product.setPrice(price);
				product.setDesc(pdesc);
				product.setRule(rule);
				product.setImage(image);
				product.setStock(stock);
			}
			
			return product;

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
	public boolean updateProduct(Product product) {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "update product set name=?,pdesc=?,price=?,rule=?,image=?,stock=? where id=?";
			st = conn.prepareStatement(sql);
			st.setString(1, product.getName());
			st.setString(2, product.getDesc());
			st.setDouble(3, product.getPrice());
			st.setString(4, product.getRule());
			st.setString(5, product.getImage());
			st.setInt(6, product.getStock());
			st.setInt(7, product.getId());
			System.out.println(sql);
			st.execute();
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
	public boolean deleteProduct(int id) {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "delete from product where id=?";
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			System.out.println(sql);
			st.execute();
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

	@SuppressWarnings("resource")
	@Override
	public PageModel<Product> findEmpByPage(int pageNo, int pageSize) {
		// pageNo第几页 pageSize一页有多少条
		// TODO Auto-generated method stub
		PageModel<Product> pagemodel = new PageModel<Product>();

		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			String sqlcount = "select count(id) from product";
			st = conn.prepareStatement(sqlcount);
			rs = st.executeQuery();
			if (rs.next()) {
				int totalCount = rs.getInt(1);
				int totalPage = (totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1);
				pagemodel.setTotalPage(totalPage);
			}

			String sql = "select * from  product limit ?,?";
			st = conn.prepareStatement(sql);
			st.setInt(1, (pageNo - 1) * pageSize);
			st.setInt(2, pageSize);
			rs = st.executeQuery();
			List<Product> list = new ArrayList<Product>();
			while (rs.next()) {

				Product product = new Product(rs.getInt("id"), rs.getString("name"), rs.getString("pdesc"),
						rs.getDouble("price"), rs.getString("rule"), rs.getString("image"), rs.getInt("stock"));
				list.add(product);
			}
			pagemodel.setData(list);
			pagemodel.setCurrentPage(pageNo);
			

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

		return pagemodel;

	}

}
