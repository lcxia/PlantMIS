package com.lhhy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lhhy.bean.AnalysisBean;
import com.lhhy.dao.AnalysisDao;

/**
 * Servlet implementation class AnalysisServlet
 */
@WebServlet("/AnalysisServlet")
public class AnalysisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AnalysisServlet() {
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		if (session.getAttribute("userBean") != null) {
			/*
			 * UserBean userBean = (UserBean) session.getAttribute("userBean");
			 * if (userBean != null) { System.out.println(userBean.getUserId());
			 * }
			 */
		} else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

		String way = request.getParameter("way");
		if (way != null && way.equals("initial")) {
			this.initial(request, response);
		} else if (way != null && way.equals("analysis")) {
			this.analysis(request, response);
		} else {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

	protected void initial(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		AnalysisBean analysisBean = new AnalysisBean();
		analysisBean.setProblemId("1");

		AnalysisDao analysisDao = new AnalysisDao();

		List<AnalysisBean> list = analysisDao.selectProblemAll();
		request.setAttribute("list", list);

		analysisBean = analysisDao.selectProblemDetail(analysisBean);
		request.setAttribute("analysisBean", analysisBean);

		RequestDispatcher rd = request.getRequestDispatcher("analysis.jsp");
		rd.forward(request, response);
	}

	protected void analysis(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		AnalysisBean analysisBean = new AnalysisBean();
		analysisBean.setProblemId(request.getParameter("problemId"));

		AnalysisDao analysisDao = new AnalysisDao();

		List<AnalysisBean> list = analysisDao.selectProblemAll();
		request.setAttribute("list", list);

		analysisBean = analysisDao.selectProblemDetail(analysisBean);
		request.setAttribute("analysisBean", analysisBean);

		RequestDispatcher rd = request.getRequestDispatcher("analysis.jsp");
		rd.forward(request, response);
	}

}
