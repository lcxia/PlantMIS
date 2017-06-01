package com.lhhy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lhhy.bean.UserBean;
import com.lhhy.dao.UserDao;
import com.lhhy.util.Rand;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		String way = request.getParameter("way");
		switch (way) {
		case "register":
			this.register(request, response);
			break;
		case "update":
			this.update(request, response);
			break;
		case "login":
			this.login(request, response);
			break;
		case "exit":
			this.exit(request, response);
			break;
		default:
			request.getRequestDispatcher("error.jsp").forward(request, response);
			break;
		}
	}

	protected void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		UserBean userBean = new UserBean();
		userBean.setUserName(request.getParameter("username"));
		userBean.setPassword(request.getParameter("password"));
		userBean.setPhone(request.getParameter("phone"));
		userBean.setRoleName("用户");

		UserDao dao = new UserDao();
		String forword;
		if (dao.queryUserIsSame(userBean.getUserName()).size() > 0) {
			request.setAttribute("msg", "用户姓名已存在");
			forword = "register.jsp";
		} else {
			UserDao userDao = new UserDao();
			boolean bool = userDao.insertUser(userBean);
			if (bool == true) {
				forword = "login.jsp";
			} else {
				forword = "register.jsp";
			}
		}

		request.getRequestDispatcher(forword).forward(request, response);
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		Rand rand = new Rand();
		String str = rand.rand(6);

		UserBean userBean = new UserBean();
		userBean.setUserName(request.getParameter("username"));
		userBean.setPassword(str.toString());

		UserDao userDao = new UserDao();
		if (userDao.updateUser(userBean) == true) {
			request.setAttribute("userBean", userBean);
		} else {
			request.setAttribute("msg", "用户名不存在");
		}
		request.getRequestDispatcher("update.jsp").forward(request, response);
	}

	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		// 取得参数的值
		UserBean userBean = new UserBean();
		userBean.setUserName(request.getParameter("username"));
		userBean.setPassword(request.getParameter("password"));

		UserDao userDao = new UserDao();
		userBean = userDao.selectUser(userBean);
		request.setAttribute("userBean", userBean);

		// String forward;
		HttpSession session = request.getSession();
		if ("用户".equals(userBean.getRoleName())) {
			session.setAttribute("userBean", userBean);
			// forward="IndexServlet";
			response.sendRedirect("IndexServlet");
		} else {
			if ("管理员".equals(userBean.getRoleName())) {
				session.setAttribute("userBean", userBean);
				// forward="admin/index.jsp";
				response.sendRedirect("admin/index.jsp");
			} else {
				request.setAttribute("msg", "用户名或者密码错误");
				// forward="login.jsp";
				response.sendRedirect("login.jsp");
			}
		}
		// request.getRequestDispatcher(forward).forward(request, response);
	}

	protected void exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getSession().invalidate();
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

}
