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
import com.lhhy.bean.LibraryBean;
import com.lhhy.dao.LibraryDao;

public class LibraryBiz {

	private LibraryDao dao;
	private ObjectMapper mapper;

	public LibraryBiz() {
		dao = new LibraryDao();
		mapper = new ObjectMapper();
	}

	// 查询所有库资料，抛出json字符串
	public String queryAllLibrary(Page page) {
		String data = "";
		List<LibraryBean> list = dao.queryAllLibrary(page);
		int count = dao.libraryCount();
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

	// 添加库资料
	public String addLibrary(LibraryBean u) {
		Message msg = new Message();
		List<LibraryBean> list = dao.queryLibraryIsSame(u.getLibraryName());
		if (list.size() > 0) {
			msg.setSuccess(false);
			msg.setErrorMsg("库资料已经存在，不能添加");
		} else {
			int temp = dao.addLibrary(u);
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

	// 修改库资料
	public String editLibrary(LibraryBean u) {
		Message msg = new Message();
		int temp = dao.editLibrary(u);
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

	// 删除库资料
	public String deleteLibrary(String id) {
		Message msg = new Message();
		int temp = dao.deleteLibrary(id);
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
