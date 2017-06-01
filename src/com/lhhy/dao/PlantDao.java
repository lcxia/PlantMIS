package com.lhhy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lhhy.bean.Page;
import com.lhhy.bean.PlantBean;
import com.lhhy.util.Conn;
import com.lhhy.util.DBConn;

public class PlantDao {

	private DBConn conn;

	// 查询所有植物
	public List<PlantBean> selectPlantAll() {
		String sql = "select * from tb_plant";
		Conn dBConn = new Conn();
		List<PlantBean> list = new ArrayList<PlantBean>();
		try {
			ResultSet rs = dBConn.select(sql);
			while (rs.next()) {
				PlantBean plantBean = new PlantBean();
				plantBean.setPlantId(rs.getString("plant_id"));
				plantBean.setPlantName(rs.getString("plant_name"));
				plantBean.setPicture(rs.getString("picture"));
				plantBean.setPhylumName(rs.getString("phylum"));
				plantBean.setClassName(rs.getString("class"));
				plantBean.setOrderName(rs.getString("order_name"));
				plantBean.setFamilyName(rs.getString("family"));
				plantBean.setGenusName(rs.getString("genus"));
				plantBean.setPlantText(rs.getString("plant_text"));
				list.add(plantBean);
			}
			dBConn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	// 查询所有植物
	public List<PlantBean> selectPlantQie() {
		String sql = "select * from tb_plant where genus='茄属'";
		Conn dBConn = new Conn();
		List<PlantBean> list = new ArrayList<PlantBean>();
		try {
			ResultSet rs = dBConn.select(sql);
			while (rs.next()) {
				PlantBean plantBean = new PlantBean();
				plantBean.setPlantId(rs.getString("plant_id"));
				plantBean.setPlantName(rs.getString("plant_name"));
				plantBean.setPicture(rs.getString("picture"));
				plantBean.setPhylumName(rs.getString("phylum"));
				plantBean.setClassName(rs.getString("class"));
				plantBean.setOrderName(rs.getString("order_name"));
				plantBean.setFamilyName(rs.getString("family"));
				plantBean.setGenusName(rs.getString("genus"));
				plantBean.setPlantText(rs.getString("plant_text"));
				list.add(plantBean);
			}
			dBConn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	// 查询植物详情
	public PlantBean selectPlantDetail(PlantBean plantBean) {
		String sql = "select * from tb_plant where plant_id='" + plantBean.getPlantId() + "'";
		Conn dBConn = new Conn();
		ResultSet rs = dBConn.select(sql);
		try {
			while (rs.next()) {
				plantBean.setPlantName(rs.getString("plant_name"));
				plantBean.setPicture(rs.getString("picture"));
				plantBean.setPhylumName(rs.getString("phylum"));
				plantBean.setClassName(rs.getString("class"));
				plantBean.setOrderName(rs.getString("order_name"));
				plantBean.setFamilyName(rs.getString("family"));
				plantBean.setGenusName(rs.getString("genus"));
				plantBean.setPlantText(rs.getString("plant_text"));
			}
			dBConn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return plantBean;
	}

	// 根据输入内容进行查询
	public List<PlantBean> selectPlant(String str) {
		String sql = "select * from tb_plant where plant_text like '%" + str + "%'";
		Conn dBConn = new Conn();
		List<PlantBean> list = new ArrayList<PlantBean>();
		try {
			ResultSet rs = dBConn.select(sql);
			while (rs.next()) {
				PlantBean plantBean = new PlantBean();
				plantBean.setPlantId(rs.getString("plant_id"));
				plantBean.setPlantName(rs.getString("plant_name"));
				plantBean.setPlantText(rs.getString("plant_text"));
				plantBean.setPicture(rs.getString("picture"));
				list.add(plantBean);
			}
			dBConn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	// 根据条件进行查询
	public List<PlantBean> selectPlantPrecise(String str) {
		String sql = "select * from tb_plant where genus='" + str + "'";
		Conn dBConn = new Conn();
		List<PlantBean> list = new ArrayList<PlantBean>();
		try {
			ResultSet rs = dBConn.select(sql);
			while (rs.next()) {
				PlantBean plantBean = new PlantBean();
				plantBean.setPlantId(rs.getString("plant_id"));
				plantBean.setPlantName(rs.getString("plant_name"));
				plantBean.setPlantText(rs.getString("plant_text"));
				plantBean.setPicture(rs.getString("picture"));
				list.add(plantBean);
			}
			dBConn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	// 查询所有植物
	public List<PlantBean> queryAllPlant(Page page) {
		List<PlantBean> list = new ArrayList<PlantBean>();
		String sql = "select * from tb_plant limit ?,?";
		conn = new DBConn();
		ResultSet rs = conn.query(sql, page.getStartIndex(), page.getRows());
		try {
			while (rs.next()) {
				PlantBean u = new PlantBean(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(4), rs.getString(8), rs.getString(9));
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

	// 查询总的植物数目
	public int plantCount() {
		int count = 0;
		String sql = "select count(*) from tb_plant";
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

	// 添加前查询数据库中是否存在同名的植物
	public List<PlantBean> queryPlantIsSame(String name) {
		List<PlantBean> list = new ArrayList<PlantBean>();
		String sql = "select * from tb_plant where plant_name=?";
		conn = new DBConn();
		ResultSet rs = conn.query(sql, name);
		try {
			while (rs.next()) {
				PlantBean u = new PlantBean(rs.getString(1), rs.getString(2), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(3), rs.getString(8), rs.getString(9));
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

	// 添加植物
	public int addPlant(PlantBean u) {
		int temp = -1;
		String sql = "insert into tb_plant(plant_name,plant_text,phylum,class,order_name,family,genus,picture) values(?,?,?,?,?,?,?,?)";
		conn = new DBConn();
		temp = conn.update(sql, u.getPlantName(), u.getPlantText(), u.getPhylumName(), u.getClassName(),
				u.getOrderName(), u.getFamilyName(), u.getGenusName(), u.getPicture());
		conn.closeAll();
		return temp;
	}

	// 修改植物
	public int editPlant(PlantBean u) {
		int temp = -1;
		String sql = "update tb_plant set plant_name=?,plant_text=?,phylum=?,class=?,order_name=?,family=?,genus=?,picture=? where plant_id=?";
		conn = new DBConn();
		temp = conn.update(sql, u.getPlantName(), u.getPlantText(), u.getPhylumName(), u.getClassName(),
				u.getOrderName(), u.getFamilyName(), u.getGenusName(), u.getPicture(), u.getPlantId());
		conn.closeAll();
		return temp;
	}

	// 删除植物
	public int deletePlant(String id) {
		int temp = -1;
		String sql = "delete from tb_plant where plant_id=" + id;
		conn = new DBConn();
		temp = conn.update(sql);
		conn.closeAll();
		return temp;
	}

}
