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
import com.lhhy.bean.PredictBean;
import com.lhhy.dao.SurviveDao;

public class SurviveBiz {

	private SurviveDao dao;
	private ObjectMapper mapper;

	public SurviveBiz() {
		dao = new SurviveDao();
		mapper = new ObjectMapper();
	}

	// 查询所有存活率，抛出json字符串
	public String queryAllSurvive(Page page) {
		String data = "";
		List<PredictBean> list = dao.queryAllSurvive(page);
		int count = dao.surviveCount();
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

	// 添加存活率
	public String addSurvive(PredictBean s) {
		Message msg = new Message();
		List<PredictBean> list = dao.querySurviveIsSame(s.getPlantName(), s.getAreaName());
		if (list.size() > 0) {
			msg.setSuccess(false);
			msg.setErrorMsg("存活率已经存在，不能添加");
		} else {
			int temp = dao.addSurvive(s);
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

	// 修改存活率
	public String editSurvive(PredictBean s) {
		Message msg = new Message();
		int temp = dao.editSurvive(s);
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

	// 删除存活率
	public String deleteSurvive(String id) {
		Message msg = new Message();
		int temp = dao.deleteSurvive(id);
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
