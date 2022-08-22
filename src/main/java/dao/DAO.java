package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import entity.Account;
import entity.Ordered;
import entity.Product;

public class DAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public Account login(String user, String pass) {
		String sql = "select * from account where user_mail=? and password=?" ;
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Account(rs.getString(1),
									rs.getString(2),
									rs.getInt(3),
									rs.getString(4),
									rs.getString(5),
									rs.getString(6));
			}
		} catch (Exception e) {
			
		}
		return null;
	}
	
	public List<Product> getAllProduct() {
		List<Product> list = new ArrayList<>();
		String sql = "select * from products";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getDouble(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7)));
			}
		} catch (Exception e) {
			
		}
		return list;
	}
	
	public List<Product> getNextProduct(int start) {
		List<Product> list = new ArrayList<>();
		String sql = "select * from products where product_id between ? and ?";
		int end = start + 5;
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, String.valueOf(start));
			ps.setString(2, String.valueOf(end));
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getDouble(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7)));
			}
		} catch (Exception e) {
			
		}
		return list;
	}
	
	public Product getProduct(String id) {
		Product p = new Product();
		String sql = "select * from products where product_id=?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				p = new Product(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getDouble(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7));
			}
		} catch (Exception e) {
			
		}
		return p;
	}
	
	public List<Product> getSearchProduct(String info) {
		List<Product> list = new ArrayList<>();
		String sql = "select * from products where product_name like ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + info + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getDouble(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7)));
			}
		} catch (Exception e) {
			
		}
		return list;
	}
	
	public void register(String user, String pass) {
		String sql = "insert into account values(?,?,0,'0','0','0')";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,user);
			ps.setString(2,pass);
			ps.executeUpdate();
		} catch (Exception e) {
			
		}
	}
	
	public void writeOrder(String name, String phone, String address, String info) {
		String sql = "insert into orders(user_name,user_phone,user_address,user_info) values(?,?,?,?)";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,name);
			ps.setString(2,phone);
			ps.setString(3,address);
			ps.setString(4,info);
			ps.executeUpdate();
		} catch (Exception e) {
			
		}
	}
	
	public Ordered getOrdered(String id) {
		Ordered o = new Ordered();
		String sql = "select * from orders where order_id=?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				o =  new Ordered(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5)
						);
			}
		} catch (Exception e) {
			
		}
		return o;
	}
	
}