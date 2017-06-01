package com.lhhy.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jfree.chart.servlet.ServletUtilities;

import com.lhhy.bean.PredictBean;
import com.lhhy.dao.PredictDao;
import com.lhhy.util.Chart;

/**
 * Servlet implementation class PredictServlet
 */
@WebServlet("/PredictServlet")
public class PredictServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PredictServlet() {
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
		} else if (way != null && way.equals("predict")) {
			this.predict(request, response);
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

		PredictDao predictDao = new PredictDao();
		List<PredictBean> list = predictDao.selectPlantAll();

		request.setAttribute("list", list);
		PredictBean predictBean = new PredictBean();
		predictBean.setPlantName("小麦");

		request.setAttribute("predictBean", predictBean);

		List<PredictBean> list1 = new ArrayList<PredictBean>();
		list1 = predictDao.selectSurvive(predictBean);

		Chart chart = new Chart();
		String fileName = null; // 生成图片的文件名
		fileName = ServletUtilities.saveChartAsJPEG(chart.createChart(list1), 600, 400, null);
		String graphURL = request.getContextPath() + "/servlet/DisplayChart?filename=" + fileName;
		request.setAttribute("graphURL", graphURL);

		RequestDispatcher rd = request.getRequestDispatcher("predict.jsp");
		rd.forward(request, response);
	}

	protected void predict(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("image/jpeg");
		response.setCharacterEncoding("UTF-8");

		PredictDao predictService = new PredictDao();
		List<PredictBean> list = predictService.selectPlantAll();
		request.setAttribute("list", list);

		PredictBean predictBean = new PredictBean();
		predictBean.setPlantName(request.getParameter("plantName"));

		request.setAttribute("predictBean", predictBean);

		List<PredictBean> list1 = new ArrayList<PredictBean>();
		list1 = predictService.selectSurvive(predictBean);

		Chart chart = new Chart();
		String fileName = null; // 生成图片的文件名
		fileName = ServletUtilities.saveChartAsJPEG(chart.createChart(list1), 600, 400, null);
		String graphURL = request.getContextPath() + "/servlet/DisplayChart?filename=" + fileName;
		request.setAttribute("graphURL", graphURL);

		RequestDispatcher rd = request.getRequestDispatcher("predict.jsp");
		rd.forward(request, response);
	}

}
