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
import com.lhhy.bean.PlantBean;
import com.lhhy.dao.PlantDao;

public class PlantBiz {

	private PlantDao dao;
	private ObjectMapper mapper;

	public PlantBiz() {
		dao = new PlantDao();
		mapper = new ObjectMapper();
	}

	// 查询所有植物，抛出json字符串
	public String queryAllPlant(Page page) {
		String data = "";
		List<PlantBean> list = dao.queryAllPlant(page);
		int count = dao.plantCount();
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

	// 添加植物
	public String addPlant(PlantBean u) {
		Message msg = new Message();
		List<PlantBean> list = dao.queryPlantIsSame(u.getPlantName());
		if (list.size() > 0) {
			msg.setSuccess(false);
			msg.setErrorMsg("植物已经存在，不能添加");
		} else {
			int temp = dao.addPlant(u);
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

	// 修改植物
	public String editPlant(PlantBean u) {
		Message msg = new Message();
		int temp = dao.editPlant(u);
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

	// 删除植物
	public String deletePlant(String id) {
		Message msg = new Message();
		int temp = dao.deletePlant(id);
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
