package com.lhhy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lhhy.bean.Page;
import com.lhhy.bean.UserBean;
import com.lhhy.util.Conn;
import com.lhhy.util.DBConn;

public class UserDao {

	private DBConn conn;

	// 登录时查询用户
	public UserBean selectUser(UserBean userBean) {
		String sql = "select * from tb_user where user_name='" + userBean.getUserName() + "' and " + "pass_word='"
				+ userBean.getPassword() + "'";
		Conn dBConn = new Conn();
		ResultSet rs = dBConn.select(sql);
		try {
			while (rs.next()) {
				userBean.setUserName(rs.getString("user_name"));
				userBean.setRoleName(rs.getString("role_name"));
			}
			dBConn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userBean;
	}

	// 注册用户
	public boolean insertUser(UserBean userBean) {
		String sql = "insert into tb_user(user_name,role_name,pass_word,phone)" + " values('" + userBean.getUserName()
				+ "','" + userBean.getRoleName() + "'," + "'" + userBean.getPassword() + "','" + userBean.getPhone()
				+ "')";
		Conn dBConn = new Conn();
		int i = dBConn.update(sql);
		try {
			dBConn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (i != 0) {
			return true;
		}
		return false;
	}

	// 修改用户密码
	public boolean updateUser(UserBean userBean) {
		String sql = "update tb_user set pass_word='" + userBean.getPassword() + "' where user_name='"
				+ userBean.getUserName() + "'";
		Conn dBConn = new Conn();
		int i = dBConn.update(sql);
		try {
			if (i != 0) {
				dBConn.close();
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	// 查询所有用户
	public List<UserBean> queryAllUser(Page page) {
		List<UserBean> list = new ArrayList<UserBean>();
		String sql = "select * from tb_user where role_name='用户' limit ?,?";
		conn = new DBConn();
		ResultSet rs = conn.query(sql, page.getStartIndex(), page.getRows());
		try {
			while (rs.next()) {
				UserBean u = new UserBean(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5));
				list.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn.closeAll();
		}
		return list;
	}

	// 查询总的用户数目
	public int userCount() {
		int count = 0;
		String sql = "select count(*) from tb_user where role_name='用户'";
		conn = new DBConn();
		ResultSet rs = conn.query(sql);
		try {
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn.closeAll();
		}
		return count;
	}

	// 添加前查询数据库中是否存在同名的用户
	public List<UserBean> queryUserIsSame(String name) {
		List<UserBean> list = new ArrayList<UserBean>();
		String sql = "select * from tb_user where user_name=?";
		conn = new DBConn();
		ResultSet rs = conn.query(sql, name);
		try {
			while (rs.next()) {
				UserBean u = new UserBean(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5));
				list.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn.closeAll();
		}
		return list;
	}

	// 添加用户
	public int addUser(UserBean u) {
		int temp = -1;
		String sql = "insert into tb_user(user_name,pass_word,role_name,phone) values(?,?,?,?)";
		conn = new DBConn();
		temp = conn.update(sql, u.getUserName(), u.getPassword(), u.getRoleName(), u.getPhone());
		conn.closeAll();
		return temp;
	}

	// 修改用户
	public int editUser(UserBean u) {
		int temp = -1;
		String sql = "update tb_user set user_name=?,pass_word=?,role_name=?,phone=? where user_id=?";
		conn = new DBConn();
		temp = conn.update(sql, u.getUserName(), u.getPassword(), u.getRoleName(), u.getPhone(), u.getUserId());
		conn.closeAll();
		return temp;
	}

	// 删除用户
	public int deleteUser(String id) {
		int temp = -1;
		String sql = "delete from tb_user where user_id=" + id;
		conn = new DBConn();
		temp = conn.update(sql);
		conn.closeAll();
		return temp;
	}

}
