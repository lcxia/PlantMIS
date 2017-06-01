package com.lhhy.biz;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.lhhy.bean.Message;
import com.lhhy.bean.Page;
import com.lhhy.bean.UserBean;
import com.lhhy.dao.UserDao;

public class UserBiz {

	private UserDao dao;
	private ObjectMapper mapper;

	public UserBiz() {
		dao = new UserDao();
		mapper = new ObjectMapper();
	}

	// 查询所有用户，抛出json字符串
	public String queryAllUser(Page page) {
		String data = "";
		List<UserBean> list = dao.queryAllUser(page);
		int count = dao.userCount();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", count);
		map.put("rows", list);
		try {
			data = mapper.writeValueAsString(map);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	// 添加用户
	public String addUser(UserBean u) {
		Message msg = new Message();
		List<UserBean> list = dao.queryUserIsSame(u.getUserName());
		if (list.size() > 0) {
			msg.setSuccess(false);
			msg.setErrorMsg("用户姓名已经存在，不能添加");
		} else {
			int temp = dao.addUser(u);
			if (temp > 0) {
				msg.setSuccess(true);
				msg.setErrorMsg(null);
			} else {
				msg.setSuccess(false);
				msg.setErrorMsg("添加失败");
			}
		}
		String rs = "";
		try {
			rs = mapper.writeValueAsString(msg);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	// 修改用户
	public String editUser(UserBean u) {
		Message msg = new Message();
		int temp = dao.editUser(u);
		if (temp > 0) {
			msg.setSuccess(true);
			msg.setErrorMsg(null);
		} else {
			msg.setSuccess(false);
			msg.setErrorMsg("修改失败");
		}
		String rs = "";
		try {
			rs = mapper.writeValueAsString(msg);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	// 删除用户
	public String deleteUser(String id) {
		Message msg = new Message();
		int temp = dao.deleteUser(id);
		if (temp > 0) {
			msg.setSuccess(true);
			msg.setErrorMsg("已删除");
		} else {
			msg.setSuccess(false);
			msg.setErrorMsg("删除失败");
		}
		String rs = "";
		try {
			rs = mapper.writeValueAsString(msg);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

}
