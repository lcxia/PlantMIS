package com.lhhy.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.lhhy.bean.PlantBean;
import com.lhhy.dao.PlantDao;

/**
 * Servlet implementation class PlantServlet
 */
@WebServlet("/PlantServlet")
public class PlantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PlantServlet() {
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

		String way = null;
		if (request.getParameter("way") != null) {
			way = request.getParameter("way");
		}

		switch (way) {
		case "initial":
			this.initial(request, response);
			break;
		case "detail":
			this.detail(request, response);
			break;
		case "select":
			this.select(request, response);
			break;
		case "precise":
			this.precise(request, response);
			break;
		case "class":
			this.class1(request, response);
			break;
		case "order":
			this.order(request, response);
			break;
		case "family":
			this.family(request, response);
			break;
		case "genus":
			this.genus(request, response);
			break;
		case "plant":
			this.plant(request, response);
			break;
		default:
			request.getRequestDispatcher("error.jsp").forward(request, response);
			break;
		}
	}

	protected void initial(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		PlantDao plantDao = new PlantDao();
		List<PlantBean> list = plantDao.selectPlantQie();
		request.setAttribute("list", list);

		request.getRequestDispatcher("plant.jsp").forward(request, response);
	}

	protected void detail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		PlantBean plantBean = new PlantBean();
		plantBean.setPlantId(request.getParameter("plantId"));

		PlantDao plantDao = new PlantDao();
		plantBean = plantDao.selectPlantDetail(plantBean);
		request.setAttribute("plantBean", plantBean);

		request.getRequestDispatcher("plantDetail.jsp").forward(request, response);
	}

	protected void select(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		String str = request.getParameter("text");

		PlantDao plantDao = new PlantDao();
		List<PlantBean> list = plantDao.selectPlant(str);
		if (list.size() == 0) {
			request.setAttribute("msg", "没有查找到任何内容");
		}
		request.setAttribute("list", list);

		request.getRequestDispatcher("plant.jsp").forward(request, response);

	}

	protected void precise(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		PlantBean plantBean = new PlantBean();
		plantBean.setGenusName(request.getParameter("genus"));

		PlantDao plantDao = new PlantDao();
		List<PlantBean> list = plantDao.selectPlantPrecise(plantBean.getGenusName());
		request.setAttribute("list", list);

		request.getRequestDispatcher("plant.jsp").forward(request, response);

	}

	public void class1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String fileURL = request.getRealPath("/xml/plant.xml"); // 获取XML文件的路径
		File file = new File(fileURL);
		Document document = null; // 声明Document对象
		Element phylum = null; // 声明表示根节点的Element对象
		String result = "";
		if (file.exists()) { // // 判断文件是否存在，如果存在，则读取该文件
			SAXReader reader = new SAXReader(); // 实例化SAXReader对象
			try {
				document = reader.read(new File(fileURL)); // 获取XML文件对应的XML文档对象
				phylum = document.getRootElement(); // 获取根节点
				List<Element> classList = phylum.elements("class"); // 获取表示省份和直辖市的节点
				Element classElement = null;
				for (int i = 0; i < classList.size(); i++) {// 将获取的省份连接为一个以逗号分隔的字符串
					classElement = classList.get(i);
					result = result + classElement.attributeValue("name") + ",";
				}
				result = result.substring(0, result.length() - 1); // 去除最后一个逗号
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		}

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(result); // 输出获取的市县字符串
		out.flush();
		out.close();
	}

	public void order(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String fileURL = request.getRealPath("/xml/plant.xml"); // 获取XML文件的路径
		File file = new File(fileURL);
		Document document = null; // 声明Document对象
		String result = "";
		if (file.exists()) { // 判断文件是否存在，如果存在，则读取该文件
			SAXReader reader = new SAXReader(); // 实例化SAXReader对象
			try {
				document = reader.read(new File(fileURL)); // 获取XML文件对应的XML文档对象
				Element phylum = document.getRootElement(); // 获取根节点
				String selClass = request.getParameter("parClass"); // 获取选择的纲
				// String selOrder = request.getParameter("parOrder"); //
				// 获取选择的纲
				selClass = new String(selClass.getBytes("ISO-8859-1"), "UTF-8");
				// selOrder = new
				// String(selOrder.getBytes("ISO-8859-1"),"UTF-8");
				Element item = (Element) phylum.selectSingleNode("/phylum/class[@name='" + selClass + "']");// 获取指定name属性的纲节点
				List<Element> orderList = item.elements("order"); // 获取表示目的节点集合
				Element orderElement = null;
				for (int i = 0; i < orderList.size(); i++) {// 将获取的目连接成以逗号分隔的字符串
					orderElement = orderList.get(i);
					result = result + orderElement.attributeValue("name") + ",";
				}
				result = result.substring(0, result.length() - 1); // 去除最后一个逗号

			} catch (DocumentException e) {
				e.printStackTrace();
			}
		}

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(result); // 输出获取的目字符串
		out.flush();
		out.close();

	}

	public void family(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String fileURL = request.getRealPath("/xml/plant.xml"); // 获取XML文件的路径
		File file = new File(fileURL);
		Document document = null; // 声明Document对象
		String result = "";
		if (file.exists()) { // 判断文件是否存在，如果存在，则读取该文件
			SAXReader reader = new SAXReader(); // 实例化SAXReader对象
			try {
				document = reader.read(new File(fileURL)); // 获取XML文件对应的XML文档对象
				Element phylum = document.getRootElement(); // 获取根节点
				String selClass = request.getParameter("parClass"); // 获取选择的纲
				String selOrder = request.getParameter("parOrder"); // 获取选择的目
				// String selFamily = request.getParameter("parFamily"); //
				// 获取选择的省份
				selClass = new String(selClass.getBytes("ISO-8859-1"), "UTF-8");
				selOrder = new String(selOrder.getBytes("ISO-8859-1"), "UTF-8");
				// selFamily = new
				// String(selFamily.getBytes("ISO-8859-1"),"UTF-8");
				Element item = (Element) phylum.selectSingleNode("/phylum/class/order[@name='" + selOrder + "']");// 获取指定name属性的科节点
				List<Element> familyList = item.elements("family"); // 获取表示科的节点集合
				Element familyElement = null;
				for (int i = 0; i < familyList.size(); i++) {// 将获取的科连接成以逗号分隔的字符串
					familyElement = familyList.get(i);
					result = result + familyElement.attributeValue("name") + ",";
				}
				result = result.substring(0, result.length() - 1); // 去除最后一个逗号

			} catch (DocumentException e) {
				e.printStackTrace();
			}
		}

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(result); // 输出获取的科字符串
		out.flush();
		out.close();

	}

	/**
	 * 获取县、县级市或区
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void genus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String fileURL = request.getRealPath("/xml/plant.xml"); // 获取XML文件的路径
		File file = new File(fileURL);
		Document document = null; // 声明Document对象
		String result = "";
		if (file.exists()) { // 判断文件是否存在，如果存在，则读取该文件
			SAXReader reader = new SAXReader(); // 实例化SAXReader对象
			try {
				document = reader.read(new File(fileURL)); // 获取XML文件对应的XML文档对象
				Element phylum = document.getRootElement(); // 获取根节点
				String selClass = request.getParameter("parClass"); // 获取选择的纲
				String selOrder = request.getParameter("parOrder"); // 获取选择的目
				String selFamily = request.getParameter("parFamily"); // 获取选择的科
				selClass = new String(selClass.getBytes("ISO-8859-1"), "UTF-8");
				selOrder = new String(selOrder.getBytes("ISO-8859-1"), "UTF-8");
				selFamily = new String(selFamily.getBytes("ISO-8859-1"), "UTF-8");
				Element item = (Element) phylum
						.selectSingleNode("/phylum/class/order/family[@name='" + selFamily + "']");// 获取指定name属性的属节点
				List<Element> genusList = item.elements("genus"); // 获取表示属的节点集合
				Element genusElement = null;
				for (int i = 0; i < genusList.size(); i++) {// 将获取的属连接成以逗号分隔的字符串
					genusElement = genusList.get(i);
					result = result + genusElement.attributeValue("name") + ",";
				}
				result = result.substring(0, result.length() - 1); // 去除最后一个逗号

			} catch (DocumentException e) {
				e.printStackTrace();
			}
		}

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(result); // 输出获取的属字符串
		out.flush();
		out.close();

	}

	public void plant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String fileURL = request.getRealPath("/xml/plant.xml"); // 获取XML文件的路径
		File file = new File(fileURL);
		Document document = null; // 声明Document对象
		String result = "";
		if (file.exists()) { //// 判断文件是否存在，如果存在，则读取该文件
			SAXReader reader = new SAXReader(); // 实例化SAXReader对象
			try {
				document = reader.read(new File(fileURL)); // 获取XML文件对应的XML文档对象
				Element phylum = document.getRootElement(); // 获取根节点

				String selClass = request.getParameter("parClass"); // 获取选择的纲
				String selOrder = request.getParameter("parOrder"); // 获取选择的目
				String selFamily = request.getParameter("parFamily"); // 获取选择的科
				String selGenus = request.getParameter("parGenus"); // 获取选择的属
				selClass = new String(selClass.getBytes("ISO-8859-1"), "UTF-8");
				selOrder = new String(selOrder.getBytes("ISO-8859-1"), "UTF-8");
				selFamily = new String(selFamily.getBytes("ISO-8859-1"), "UTF-8");
				selGenus = new String(selGenus.getBytes("ISO-8859-1"), "UTF-8");
				Element item = (Element) phylum
						.selectSingleNode("/phylum/class/order/family/genus[@name='" + selGenus + "']");
				List<Element> genusList = item.elements("genus"); // 获取表示属的节点集合
				Element itemPlant = (Element) item.selectSingleNode("genus[@name='" + selGenus + "']");
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		}

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(result); // 输出获取的植物字符串
		out.flush();
		out.close();

	}

}
