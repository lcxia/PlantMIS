package com.lhhy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhhy.bean.AnalysisBean;
import com.lhhy.bean.LibraryBean;
import com.lhhy.bean.Page;
import com.lhhy.bean.PlantBean;
import com.lhhy.bean.PredictBean;
import com.lhhy.bean.UserBean;
import com.lhhy.biz.LibraryBiz;
import com.lhhy.biz.PlantBiz;
import com.lhhy.biz.ProblemBiz;
import com.lhhy.biz.SurviveBiz;
import com.lhhy.biz.UserBiz;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/admin/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String way = null;
		if (request.getParameter("way") != null) {
			way = request.getParameter("way");
		}

		switch (way) {
		case "allLibrary":
			this.allLibrary(request, response);
			break;
		case "addLibrary":
			this.addLibrary(request, response);
			break;
		case "editLibrary":
			this.editLibrary(request, response);
			break;
		case "delLibrary":
			this.delLibrary(request, response);
			break;
		case "allPlant":
			this.allPlant(request, response);
			break;
		case "addPlant":
			this.addPlant(request, response);
			break;
		case "editPlant":
			this.editPlant(request, response);
			break;
		case "delPlant":
			this.delPlant(request, response);
			break;
		case "allProblem":
			this.allProblem(request, response);
			break;
		case "addProblem":
			this.addProblem(request, response);
			break;
		case "editProblem":
			this.editProblem(request, response);
			break;
		case "delProblem":
			this.delProblem(request, response);
			break;
		case "allSurvive":
			this.allSurvive(request, response);
			break;
		case "addSurvive":
			this.addSurvive(request, response);
			break;
		case "editSurvive":
			this.editSurvive(request, response);
			break;
		case "delSurvive":
			this.delSurvive(request, response);
			break;
		case "allUser":
			this.allUser(request, response);
			break;
		case "addUser":
			this.addUser(request, response);
			break;
		case "editUser":
			this.editUser(request, response);
			break;
		case "delUser":
			this.delUser(request, response);
			break;
		default:
			request.getRequestDispatcher("error.jsp").forward(request, response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void allLibrary(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Page page = new Page(request.getParameter("page"), request.getParameter("rows"));

		PrintWriter out = response.getWriter();
		LibraryBiz biz = new LibraryBiz();
		String data = biz.queryAllLibrary(page);
		out.println(data);
		out.flush();
	}

	protected void addLibrary(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		LibraryBean u = new LibraryBean();
		u.setPublish(request.getParameter("publish"));
		u.setUpdateDate(request.getParameter("updateDate"));
		u.setWriter(request.getParameter("writer"));
		u.setTheme(request.getParameter("theme"));
		u.setLibraryText(request.getParameter("libraryText"));
		u.setAbst(request.getParameter("abst"));
		u.setMainword(request.getParameter("mainword"));
		u.setCome(request.getParameter("come"));
		u.setLibraryName(request.getParameter("libraryName"));

		LibraryBiz biz = new LibraryBiz();
		String rs = biz.addLibrary(u);
		PrintWriter out = response.getWriter();
		out.println(rs);
		out.flush();
	}

	protected void editLibrary(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		LibraryBean u = new LibraryBean();
		u.setLibraryId(request.getParameter("libraryId"));
		u.setPublish(request.getParameter("publish"));
		u.setUpdateDate(request.getParameter("updateDate"));
		u.setWriter(request.getParameter("writer"));
		u.setTheme(request.getParameter("theme"));
		u.setLibraryText(request.getParameter("libraryText"));
		u.setAbst(request.getParameter("abst"));
		u.setMainword(request.getParameter("mainword"));
		u.setCome(request.getParameter("come"));
		u.setLibraryName(request.getParameter("libraryName"));

		LibraryBiz biz = new LibraryBiz();
		String rs = biz.editLibrary(u);
		PrintWriter out = response.getWriter();
		out.println(rs);
		out.flush();
	}

	protected void delLibrary(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("libraryId");
		LibraryBiz biz = new LibraryBiz();
		String rs = biz.deleteLibrary(id);
		PrintWriter out = response.getWriter();
		out.println(rs);
		out.flush();
	}

	protected void allPlant(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Page page = new Page(request.getParameter("page"), request.getParameter("rows"));

		PrintWriter out = response.getWriter();
		PlantBiz biz = new PlantBiz();
		String data = biz.queryAllPlant(page);
		out.println(data);
		out.flush();
	}

	protected void addPlant(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PlantBean u = new PlantBean();
		u.setPlantName(request.getParameter("plantName"));
		u.setPlantText(request.getParameter("plantText"));
		u.setPhylumName(request.getParameter("phylumName"));
		u.setClassName(request.getParameter("className"));
		u.setOrderName(request.getParameter("orderName"));
		u.setFamilyName(request.getParameter("familyName"));
		u.setGenusName(request.getParameter("genusName"));
		u.setPicture(request.getParameter("picture"));

		PlantBiz biz = new PlantBiz();
		String rs = biz.addPlant(u);
		PrintWriter out = response.getWriter();
		out.println(rs);
		out.flush();

	}

	protected void editPlant(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PlantBean u = new PlantBean();
		u.setPlantId(request.getParameter("plantId"));
		u.setPlantName(request.getParameter("plantName"));
		u.setPlantText(request.getParameter("plantText"));
		u.setPlantText(request.getParameter("password"));
		u.setPhylumName(request.getParameter("phylumName"));
		u.setClassName(request.getParameter("className"));
		u.setOrderName(request.getParameter("orderName"));
		u.setFamilyName(request.getParameter("familyName"));
		u.setGenusName(request.getParameter("genusName"));
		u.setPicture(request.getParameter("picture"));

		PlantBiz biz = new PlantBiz();
		String rs = biz.editPlant(u);
		PrintWriter out = response.getWriter();
		out.println(rs);
		out.flush();
	}

	protected void delPlant(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("plantId");
		PlantBiz biz = new PlantBiz();
		String rs = biz.deletePlant(id);
		PrintWriter out = response.getWriter();
		out.println(rs);
		out.flush();
	}

	protected void allProblem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Page page = new Page(request.getParameter("page"), request.getParameter("rows"));

		PrintWriter out = response.getWriter();
		ProblemBiz biz = new ProblemBiz();
		String data = biz.queryAllProblem(page);
		out.println(data);
		out.flush();
	}

	protected void addProblem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		AnalysisBean u = new AnalysisBean();
		u.setProblemName(request.getParameter("problemName"));
		u.setProblemText(request.getParameter("problemText"));
		u.setSolution(request.getParameter("solution"));

		ProblemBiz biz = new ProblemBiz();
		String rs = biz.addProblem(u);
		PrintWriter out = response.getWriter();
		out.println(rs);
		out.flush();

	}

	protected void editProblem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		AnalysisBean u = new AnalysisBean();
		u.setProblemId(request.getParameter("problemId"));
		u.setProblemName(request.getParameter("problemName"));
		u.setProblemText(request.getParameter("problemText"));
		u.setSolution(request.getParameter("solution"));

		ProblemBiz biz = new ProblemBiz();
		String rs = biz.editProblem(u);
		PrintWriter out = response.getWriter();
		out.println(rs);
		out.flush();

	}

	protected void delProblem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("problemId");
		ProblemBiz biz = new ProblemBiz();
		String rs = biz.deleteProblem(id);
		PrintWriter out = response.getWriter();
		out.println(rs);
		out.flush();
	}

	protected void allSurvive(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Page page = new Page(request.getParameter("page"), request.getParameter("rows"));

		PrintWriter out = response.getWriter();
		SurviveBiz biz = new SurviveBiz();
		String data = biz.queryAllSurvive(page);
		out.println(data);
		out.flush();
	}

	protected void addSurvive(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PredictBean s = new PredictBean();
		s.setSurviveRate(Integer.parseInt(request.getParameter("surviveRate")));
		s.setPlantName(request.getParameter("plantName"));
		s.setAreaName(request.getParameter("areaName"));

		SurviveBiz biz = new SurviveBiz();
		String rs = biz.addSurvive(s);
		PrintWriter out = response.getWriter();
		out.println(rs);
		out.flush();
	}

	protected void editSurvive(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PredictBean s = new PredictBean();
		s.setSurviveId(request.getParameter("surviveId"));
		s.setSurviveRate(Integer.parseInt(request.getParameter("surviveRate")));
		s.setPlantName(request.getParameter("plantName"));
		s.setAreaName(request.getParameter("areaName"));

		SurviveBiz biz = new SurviveBiz();
		String rs = biz.editSurvive(s);
		PrintWriter out = response.getWriter();
		out.println(rs);
		out.flush();
	}

	protected void delSurvive(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("surviveId");
		SurviveBiz biz = new SurviveBiz();
		String rs = biz.deleteSurvive(id);
		PrintWriter out = response.getWriter();
		out.println(rs);
		out.flush();
	}

	protected void allUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Page page = new Page(request.getParameter("page"), request.getParameter("rows"));

		PrintWriter out = response.getWriter();
		UserBiz biz = new UserBiz();
		String data = biz.queryAllUser(page);
		out.println(data);
		out.flush();
	}

	protected void addUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserBean u = new UserBean();
		u.setUserName(request.getParameter("userName"));
		u.setPassword(request.getParameter("password"));
		u.setRoleName("用户");
		u.setPhone(request.getParameter("phone"));

		UserBiz biz = new UserBiz();
		String rs = biz.addUser(u);
		PrintWriter out = response.getWriter();
		out.println(rs);
		out.flush();
	}

	protected void editUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserBean u = new UserBean();
		u.setUserId((request.getParameter("userId")));
		u.setUserName(request.getParameter("userName"));
		u.setPassword(request.getParameter("password"));
		u.setRoleName("用户");
		u.setPhone(request.getParameter("phone"));

		UserBiz biz = new UserBiz();
		String rs = biz.editUser(u);
		PrintWriter out = response.getWriter();
		out.println(rs);
		out.flush();
	}

	protected void delUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("userId");
		UserBiz biz = new UserBiz();
		String rs = biz.deleteUser(id);
		PrintWriter out = response.getWriter();
		out.println(rs);
		out.flush();
	}

}
