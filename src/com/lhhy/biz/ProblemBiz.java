package com.lhhy.biz;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.lhhy.bean.AnalysisBean;
import com.lhhy.bean.Message;
import com.lhhy.bean.Page;
import com.lhhy.dao.AnalysisDao;

public class ProblemBiz {

	private AnalysisDao dao;
	private ObjectMapper mapper;

	public ProblemBiz() {
		dao = new AnalysisDao();
		mapper = new ObjectMapper();
	}

	// 查询所有问题，抛出json字符串
	public String queryAllProblem(Page page) {
		String data = "";
		List<AnalysisBean> list = dao.queryAllProblem(page);
		int count = dao.problemCount();
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

	// 添加问题
	public String addProblem(AnalysisBean u) {
		Message msg = new Message();
		List<AnalysisBean> list = dao.queryProblemIsSame(u.getProblemName());
		if (list.size() > 0) {
			msg.setSuccess(false);
			msg.setErrorMsg("问题已经存在，不能添加");
		} else {
			int temp = dao.addProblem(u);
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

	// 修改问题
	public String editProblem(AnalysisBean u) {
		Message msg = new Message();
		int temp = dao.editProblem(u);
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

	// 删除问题
	public String deleteProblem(String id) {
		Message msg = new Message();
		int temp = dao.deleteProblem(id);
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
