package com.lhhy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lhhy.bean.Page;
import com.lhhy.bean.LibraryBean;
import com.lhhy.util.Conn;
import com.lhhy.util.DBConn;

public class LibraryDao {

	private DBConn conn;

	// 查询所有库资料
	public List<LibraryBean> selectLibraryAll() {
		String sql = "select * from tb_library";
		Conn dBConn = new Conn();
		List<LibraryBean> list = new ArrayList<LibraryBean>();
		try {
			ResultSet rs = dBConn.select(sql);
			while (rs.next()) {
				LibraryBean libraryBean = new LibraryBean();
				libraryBean.setLibraryId(rs.getString("library_id"));
				libraryBean.setLibraryName(rs.getString("library_name"));
				libraryBean.setPublish(rs.getString("publish"));
				libraryBean.setUpdateDate(rs.getString("update_date"));
				libraryBean.setTheme(rs.getString("theme"));
				libraryBean.setWriter(rs.getString("writer"));
				libraryBean.setAbst(rs.getString("abstract"));
				libraryBean.setMainword(rs.getString("mainword"));
				libraryBean.setLibraryText(rs.getString("library_text"));
				libraryBean.setCome(rs.getString("come"));
				list.add(libraryBean);
			}
			dBConn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	// 根据输入内容查询库资料
	public List<LibraryBean> selectLibrary(LibraryBean libraryBean) {
		String sql = "select * from tb_library where library_text like '%" + libraryBean.getLibraryText() + "%'";
		List<LibraryBean> list = new ArrayList<LibraryBean>();
		try {
			Conn dBConn = new Conn();
			ResultSet rs = dBConn.select(sql);
			while (rs.next()) {
				LibraryBean libraryBean1 = new LibraryBean();
				libraryBean1.setLibraryId(rs.getString("library_id"));
				libraryBean1.setLibraryName(rs.getString("library_name"));
				libraryBean1.setPublish(rs.getString("publish"));
				libraryBean1.setUpdateDate(rs.getString("update_date"));
				libraryBean1.setWriter(rs.getString("writer"));
				libraryBean1.setTheme(rs.getString("theme"));
				libraryBean1.setLibraryText(rs.getString("library_text"));
				libraryBean1.setAbst(rs.getString("abstract"));
				libraryBean1.setMainword(rs.getString("mainword"));
				libraryBean1.setCome(rs.getString("come"));
				list.add(libraryBean1);
			}
			dBConn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	// 查询库资料详情
	public LibraryBean selectLibraryDetail(LibraryBean libraryBean) {
		String sql = "select * from tb_library where library_id='" + libraryBean.getLibraryId() + "'";
		try {
			Conn dBConn = new Conn();
			ResultSet rs = dBConn.select(sql);
			while (rs.next()) {
				libraryBean.setLibraryId(rs.getString("library_id"));
				libraryBean.setLibraryName(rs.getString("library_name"));
				libraryBean.setPublish(rs.getString("publish"));
				libraryBean.setUpdateDate(rs.getString("update_date"));
				libraryBean.setWriter(rs.getString("writer"));
				libraryBean.setTheme(rs.getString("theme"));
				libraryBean.setLibraryText(rs.getString("library_text"));
				libraryBean.setAbst(rs.getString("abstract"));
				libraryBean.setMainword(rs.getString("mainword"));
				libraryBean.setCome(rs.getString("come"));
			}
			dBConn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return libraryBean;
	}

	// 查询所有库资料
	public List<LibraryBean> queryAllLibrary(Page page) {
		List<LibraryBean> list = new ArrayList<LibraryBean>();
		String sql = "select * from tb_library limit ?,?";
		conn = new DBConn();
		ResultSet rs = conn.query(sql, page.getStartIndex(), page.getRows());
		try {
			while (rs.next()) {
				LibraryBean u = new LibraryBean(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10));
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

	// 查询总的库资料数目
	public int libraryCount() {
		int count = 0;
		String sql = "select count(*) from tb_library";
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

	// 添加前查询数据库中是否存在同名的库资料
	public List<LibraryBean> queryLibraryIsSame(String name) {
		List<LibraryBean> list = new ArrayList<LibraryBean>();
		String sql = "select * from tb_library where library_name=?";
		conn = new DBConn();
		ResultSet rs = conn.query(sql, name);
		try {
			while (rs.next()) {
				LibraryBean u = new LibraryBean(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10));
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

	// 添加库资料
	public int addLibrary(LibraryBean u) {
		int temp = -1;
		String sql = "insert into tb_library(publish,update_date,writer,theme,library_text,abstract,mainword,come,library_name) values(?,?,?,?,?,?,?,?,?)";
		conn = new DBConn();
		temp = conn.update(sql, u.getPublish(), u.getUpdateDate(), u.getWriter(), u.getTheme(), u.getLibraryText(),
				u.getAbst(), u.getMainword(), u.getCome(), u.getLibraryName());
		conn.closeAll();
		return temp;
	}

	// 修改库资料
	public int editLibrary(LibraryBean u) {
		int temp = -1;
		String sql = "update tb_library set publish=?,update_date=?,writer=?,theme=?,library_text=?,abstract=?,mainword=?,come=?,library_name=? where library_id=?";
		conn = new DBConn();
		temp = conn.update(sql, u.getPublish(), u.getUpdateDate(), u.getWriter(), u.getTheme(), u.getLibraryText(),
				u.getAbst(), u.getMainword(), u.getCome(), u.getLibraryName(), u.getLibraryId());
		conn.closeAll();
		return temp;
	}

	// 删除库资料
	public int deleteLibrary(String id) {
		int temp = -1;
		String sql = "delete from tb_library where library_id=" + id;
		conn = new DBConn();
		temp = conn.update(sql);
		conn.closeAll();
		return temp;
	}

}
