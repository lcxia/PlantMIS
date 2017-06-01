package com.lhhy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lhhy.bean.AnalysisBean;
import com.lhhy.bean.Page;
import com.lhhy.util.Conn;
import com.lhhy.util.DBConn;

public class AnalysisDao {

	private DBConn conn;

	// 查询所有植物问题
	public List<AnalysisBean> selectProblemAll() {
		String sql = "select * from tb_problem";
		Conn dBConn = new Conn();
		List<AnalysisBean> list = new ArrayList<AnalysisBean>();
		try {
			ResultSet rs = dBConn.select(sql);
			while (rs.next()) {
				AnalysisBean analysisBean = new AnalysisBean();
				analysisBean.setProblemId(rs.getString("problem_id"));
				analysisBean.setProblemName(rs.getString("problem_name"));
				analysisBean.setProblemText(rs.getString("problem_text"));
				analysisBean.setSolution(rs.getString("solution"));
				list.add(analysisBean);
			}
			dBConn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	// 查询植物问题详情
	public AnalysisBean selectProblemDetail(AnalysisBean analysisBean) {
		String sql = "select * from tb_problem where problem_id='" + analysisBean.getProblemId() + "'";
		Conn dBConn = new Conn();
		ResultSet rs = dBConn.select(sql);
		try {
			while (rs.next()) {
				analysisBean.setProblemText(rs.getString("problem_text"));
				analysisBean.setSolution(rs.getString("solution"));
				analysisBean.setProblemName(rs.getString("problem_name"));
				analysisBean.setPicture(rs.getString("picture"));
			}
			dBConn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return analysisBean;
	}

	// 查询所有问题
	public List<AnalysisBean> queryAllProblem(Page page) {
		List<AnalysisBean> list = new ArrayList<AnalysisBean>();
		String sql = "select * from tb_problem limit ?,?";
		conn = new DBConn();
		ResultSet rs = conn.query(sql, page.getStartIndex(), page.getRows());
		try {
			while (rs.next()) {
				AnalysisBean u = new AnalysisBean(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
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

	// 查询总的问题数目
	public int problemCount() {
		int count = 0;
		String sql = "select count(*) from tb_problem";
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

	// 添加前查询数据库中是否存在同名的问题
	public List<AnalysisBean> queryProblemIsSame(String name) {
		List<AnalysisBean> list = new ArrayList<AnalysisBean>();
		String sql = "select * from tb_problem where problem_name=?";
		conn = new DBConn();
		ResultSet rs = conn.query(sql, name);
		try {
			while (rs.next()) {
				AnalysisBean u = new AnalysisBean(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
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

	// 添加问题
	public int addProblem(AnalysisBean u) {
		int temp = -1;
		String sql = "insert into tb_problem(problem_name,problem_text,solution) values(?,?,?)";
		conn = new DBConn();
		temp = conn.update(sql, u.getProblemName(), u.getProblemText(), u.getSolution());
		conn.closeAll();
		return temp;
	}

	// 修改问题
	public int editProblem(AnalysisBean u) {
		int temp = -1;
		String sql = "update tb_problem set problem_name=?,problem_text=?,solution=? where problem_id=?";
		conn = new DBConn();
		temp = conn.update(sql, u.getProblemName(), u.getProblemText(), u.getSolution(), u.getProblemId());
		conn.closeAll();
		return temp;
	}

	// 删除问题
	public int deleteProblem(String id) {
		int temp = -1;
		String sql = "delete from tb_problem where problem_id=" + id;
		conn = new DBConn();
		temp = conn.update(sql);
		conn.closeAll();
		return temp;
	}

}
