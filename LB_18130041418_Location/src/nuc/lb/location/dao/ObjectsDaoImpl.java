package nuc.lb.location.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import nuc.lb.location.db.DataBaseConfig;
import nuc.lb.location.entity.object;

public class ObjectsDaoImpl implements IObjectsDao {
	private final String url = "jdbc:mysql://localhost:3306/user?serverTimezone=UTC&characterEncoding=utf-8";
	private final String uname = "root";
	private final String upwd = "libin666";

	// 根据失物向数据库,file中添加物品
	@Override
	public boolean addObject(object o) {
                  int a =2;
		// 写入文件
		File f = new File(DataBaseConfig.USER_FILE_PATH);
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(f, true);
			bw = new BufferedWriter(fw);
			bw.write(o.toString());
			bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Connection connection = null;
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			int count = 0;
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, uname, upwd);
			int uid = o.getUid();
			String otype = o.getOtype();
			String place = o.getPlace();
			String number = o.getNumber();
			String qq = o.getQq();
			String description = o.getDescription();
			String uname = o.getUname();
			String sql = "insert into object values(?,?,?,?,?,?,?)";
			pre = connection.prepareStatement(sql);

			pre.setString(1, otype);
			pre.setString(2, place);
			pre.setString(3, number);
			pre.setString(4, qq);
			pre.setString(5, description);
			pre.setString(6, uname);
			pre.setInt(7, uid);
			count = pre.executeUpdate();
			if (count > 0) {
				return true;
			} else {
				return false;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
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

	// 获得所有的失物
	@Override
	public Map<String, object> getObjects() {
		Connection connection = null;
		PreparedStatement pre = null;
		ResultSet rs = null;
		Map<String, object> maps = new HashMap<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, uname, upwd);
			String sql = "select * from object";
			pre = connection.prepareStatement(sql);
			rs = pre.executeQuery();
			while (rs.next()) {
				int uid = rs.getInt("uid");
				String otype = rs.getString("otype");
				String place = rs.getString("place");
				String number = rs.getString("number");
				String qq = rs.getString("qq");
				String description = rs.getString("description");
				String uname = rs.getString("uname");
				object o = new object(uid, otype, place, number, qq, description, uname);
				maps.put(uname, o);
			}
			return maps;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
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
		return maps;
	}

	// 根据物品的uid来查询返回物品
	@Override
	public object query(int id) {
		Connection connection = null;
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, uname, upwd);
			String sql = "select * from object where uid =?";
			object o = null;
			pre = connection.prepareStatement(sql);
			pre.setInt(1, id);
			rs = pre.executeQuery();
			int count = -1;
			if (rs.next()) {
				int uid = rs.getInt("uid");
				String otype = rs.getString("otype");
				String place = rs.getString("place");
				String number = rs.getString("number");
				String qq = rs.getString("qq");
				String description = rs.getString("description");
				String uname = rs.getString("uname");
				o = new object(uid, otype, place, number, qq, description, uname);
			}
			return o;
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

	// 返回boolean来判断是否删除成功
	@Override
	public boolean delete(int id) {
		Connection connection = null;
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, uname, upwd);
			String sql = "delete from users where id =?";
			pre = connection.prepareStatement(sql);
			pre.setInt(1, id);
			int count = pre.executeUpdate();
			if (count == 1) {
				return true;
			} else {
				return false;
			}
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
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
		return false;
	}

	@Override
	public Map<String, object> getObjectsByIo() {
		Map<String, object> map = new HashMap<>();
		File f = new File(DataBaseConfig.USER_FILE_PATH);
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String s = null;
			String[] o = null;
			while ((s = br.readLine()) != null) {
				o = s.split(":");
				object ob = new object(o);
				map.put(o[0], ob);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				if (br != null) {
					br.close();
				}
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return map;
	}
}
