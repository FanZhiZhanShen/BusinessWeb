package com.neuedu.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.CategoryDao;
import com.neuedu.entity.Category;
import com.neuedu.entity.PageModel;

import com.neuedu.utils.DBUtils;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public boolean addCategory(Category category) {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "insert into category(parent_id,name,status,sort_order,create_time,update_time) values (?,?,?,?,now(),now())";
			st = conn.prepareStatement(sql);
			// 占位符赋值
			st.setInt(1, category.getParent_id());
			st.setString(2, category.getName());
			st.setInt(3, category.getStatus());
			st.setInt(4, category.getSort_order());
			
			
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
	public List<Category> findAll() {
		List<Category> categorys = new ArrayList<Category>();
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "select * from  category";
			st = conn.prepareStatement(sql);
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				int parent_id = rs.getInt(2);
				String name = rs.getString(3);
				int status = rs.getInt(4);
				int sort_order = rs.getInt(5);
				String create_time = rs.getString(6);
				String update_time = rs.getString(7);
				Category category = new Category(id, parent_id, name, status, sort_order, create_time, update_time);
				categorys.add(category);
			}
			return categorys;
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
	public Category findById(int id) {
		Category category = new Category();
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "select id,parent_id,name,status,sort_order,create_time,update_time from  category where id=?";
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				
				int _id = rs.getInt("id");
				int parent_id = rs.getInt("parent_id");
				String name = rs.getString("name");
				int status = rs.getInt("status");
				int sort_order = rs.getInt("sort_order");
				String create_time = rs.getString("create_time");
				String update_time = rs.getString("update_time");

				category.setId(_id);
				category.setParent_id(parent_id);
				category.setName(name);
				category.setStatus(status);
				category.setSort_order(sort_order);
				category.setCreate_time(create_time);
				category.setUpdate_time(update_time);
			}
			
			return category;

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
	public boolean updateCategory(Category category) {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "update category set parent_id=?,name=?,status=?,sort_order=?,create_time=?,update_time=? where id=?";
			System.out.println(category.getName()+"3");
			st = conn.prepareStatement(sql);
			st.setInt(1, category.getParent_id());
			st.setString(2, category.getName());
			
			st.setInt(3, category.getStatus());
			st.setInt(4, category.getSort_order());
			st.setString(5, category.getCreate_time());
			st.setString(6, category.getUpdate_time());
			st.setInt(7, category.getId());
			System.out.println(category.getUpdate_time()+"3");
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
	public boolean deleteCategory(int id) {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "delete from category where id=?";
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
	public PageModel<Category> findEmpByPage(int pageNo, int pageSize) {
		PageModel<Category> pagemodel = new PageModel<Category>();

		//连接数据库
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			
			//获取totalPage
			String sqlcount = "select count(id) from category";
			st = conn.prepareStatement(sqlcount);
			rs = st.executeQuery();
			if (rs.next()) {
				int totalCount = rs.getInt(1);
				int totalPage = (totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1);
				pagemodel.setTotalPage(totalPage);
			}

			//获取
			String sql = "select * from  category limit ?,?";
			st = conn.prepareStatement(sql);
			st.setInt(1, (pageNo - 1) * pageSize);
			st.setInt(2, pageSize);
			rs = st.executeQuery();
			List<Category> list = new ArrayList<Category>();
			while (rs.next()) {

				Category category = new Category(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getString(7));
				list.add(category);
			}
			pagemodel.setData(list);
			pagemodel.setCurrentPage(pageNo);
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
