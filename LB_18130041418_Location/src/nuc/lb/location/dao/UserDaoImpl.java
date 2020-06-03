package nuc.lb.location.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import nuc.lb.location.entity.User;

public class UserDaoImpl implements IUserDao {

	private final String url = "jdbc:mysql://localhost:3306/user?serverTimezone=UTC&characterEncoding=utf-8";
	private final String uname = "root";
	private final String upwd = "123456";
	private Connection connection = null;
	private PreparedStatement pre = null;
	private ResultSet rs = null;

	public UserDaoImpl() {
		connection();
	}

	private void connection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, uname, upwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 向user表中添加个人的信息
	@Override
	public void addUser(User u) {
		connection();
		int stuid = u.getStuid();
		String stuName = u.getName();
		String number = u.getNumber();
		String home = u.getHome();
		String WeChat = u.getWechat();
		String id = u.getId();
		String upassword = u.getPassword();
		String sql = "insert into users values(?,?,?,?,?,?,?)";
		try {
			pre = connection.prepareStatement(sql);
			pre.setInt(1, stuid);
			pre.setString(2, stuName);
			pre.setString(3, number);
			pre.setString(4, home);
			pre.setString(5, WeChat);
			pre.setString(6, id);
			pre.setString(7, upassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pre != null) {
					pre.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 从user中获取所有用户的信息
	@Override
	public Map<String, User> getUsers() {
		Map<String, User> map = new HashMap<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, uname, upwd);
			String sql = "select * from users";
			pre = connection.prepareStatement(sql);
			rs = pre.executeQuery();
			int count = -1;
		//	count = pre.
			while (rs.next()) {
				int stuid = rs.getInt("stuid");
				String stuName = rs.getString("stuName");
				String number = rs.getString("number");
				String home = rs.getString("home");
				String WeChat = rs.getString("WeChat");
				String id = rs.getString("id");
				String upassword = rs.getString("upassword");
				User u = new User(id, WeChat, upassword, stuName, home, number, stuid);
				//System.out.println(u);
				map.put(id, u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pre != null) {
					pre.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return map;
	}

	// 根据id查询 返回user
	@Override
	public User query(int ID) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, uname, upwd);
			String sql = "select * from users where stuid =?";
			User u = null;
			pre = connection.prepareStatement(sql);
			pre.setInt(1, ID);
			rs = pre.executeQuery();
			int count = -1;
			if (rs.next()) {
				int stuid = rs.getInt("stuid");
				String stuName = rs.getString("stuName");
				String number = rs.getString("number");
				String home = rs.getString("home");
				String WeChat = rs.getString("WeChat");
				String id = rs.getString("id");
				String upassword = rs.getString("upassword");
				u = new User(id, WeChat, upassword, stuName, home, number, stuid);
			}
			return u;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pre != null) {
					pre.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public boolean delete(int id) {
		connection();
		String sql = "delete from users where id =?";
		try {
			pre = connection.prepareStatement(sql);
			pre.setInt(1, id);
			int count = pre.executeUpdate();
			if (count == 1) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (pre != null) {
					pre.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
