package com.lhhy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lhhy.bean.Page;
import com.lhhy.bean.PredictBean;
import com.lhhy.util.DBConn;

public class SurviveDao {

	private DBConn conn;

	// 查询所有存活率
	public List<PredictBean> queryAllSurvive(Page page) {
		List<PredictBean> list = new ArrayList<PredictBean>();
		String sql = "select * from tb_survive limit ?,?";
		conn = new DBConn();
		ResultSet rs = conn.query(sql, page.getStartIndex(), page.getRows());
		try {
			while (rs.next()) {
				PredictBean s = new PredictBean(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4));
				list.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn.closeAll();
		}
		return list;
	}

	// 查询总的存活率数目
	public int surviveCount() {
		int count = 0;
		String sql = "select count(*) from tb_survive";
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

	// 添加前查询数据库中是否存在同名的存活率
	public List<PredictBean> querySurviveIsSame(String name1, String name2) {
		List<PredictBean> list = new ArrayList<PredictBean>();
		String sql = "select * from tb_survive where plant_name=? and area_name=?";
		conn = new DBConn();
		ResultSet rs = conn.query(sql, name1, name2);
		try {
			while (rs.next()) {
				PredictBean s = new PredictBean(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4));
				list.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn.closeAll();
		}
		return list;
	}

	// 添加存活率
	public int addSurvive(PredictBean s) {
		int temp = -1;
		String sql = "insert into tb_survive(survive_rate,plant_name,area_name) values(?,?,?)";
		conn = new DBConn();
		temp = conn.update(sql, s.getSurviveRate(), s.getPlantName(), s.getAreaName());
		conn.closeAll();
		return temp;
	}

	// 修改存活率
	public int editSurvive(PredictBean s) {
		int temp = -1;
		String sql = "update tb_survive set survive_rate=?,plant_name=?,area_name=? where survive_id=?";
		conn = new DBConn();
		temp = conn.update(sql, s.getSurviveRate(), s.getPlantName(), s.getAreaName(), s.getSurviveId());
		conn.closeAll();
		return temp;
	}

	// 删除存活率
	public int deleteSurvive(String id) {
		int temp = -1;
		String sql = "delete from tb_survive where survive_id=" + id;
		conn = new DBConn();
		temp = conn.update(sql);
		conn.closeAll();
		return temp;
	}

}
