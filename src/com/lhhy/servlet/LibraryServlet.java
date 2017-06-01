package com.lhhy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lhhy.bean.LibraryBean;
import com.lhhy.dao.LibraryDao;

/**
 * Servlet implementation class LibraryServlet
 */
@WebServlet("/LibraryServlet")
public class LibraryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LibraryServlet() {
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
		} else if (way != null && way.equals("select")) {
			this.select(request, response);
		} else if (way != null && way.equals("detail")) {
			this.detail(request, response);
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

		LibraryDao libraryDao = new LibraryDao();
		List<LibraryBean> list = libraryDao.selectLibraryAll();
		request.setAttribute("list", list);

		request.getRequestDispatcher("library.jsp").forward(request, response);
	}

	protected void select(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		LibraryBean libraryBean = new LibraryBean();
		libraryBean.setLibraryText(request.getParameter("libraryText"));

		LibraryDao libraryDao = new LibraryDao();
		List<LibraryBean> list = libraryDao.selectLibrary(libraryBean);
		if (list.size() == 0) {
			request.setAttribute("msg", "没有查找到任何内容");
		}
		request.setAttribute("list", list);

		request.getRequestDispatcher("library.jsp").forward(request, response);
	}

	protected void detail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		LibraryBean libraryBean = new LibraryBean();
		libraryBean.setLibraryId(request.getParameter("libraryId"));

		LibraryDao libraryDao = new LibraryDao();
		libraryBean = libraryDao.selectLibraryDetail(libraryBean);

		request.setAttribute("libraryBean", libraryBean);
		request.getRequestDispatcher("libraryDetail.jsp").forward(request, response);
	}

}
