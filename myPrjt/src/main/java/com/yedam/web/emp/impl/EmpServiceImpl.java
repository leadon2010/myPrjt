package com.yedam.web.emp.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.web.emp.EmpService;
import com.yedam.web.emp.EmpVO;

@Service("empService")
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmpDAO dao;

	@Override
	public List<Map<String, Object>> getEmpList(EmpVO vo) {
		return dao.getEmpList(vo);
	}

	@Override
	public List<Map<String, Object>> getEmpList() {
		return dao.getEmpList();
	}

	@Override
	public List<Map<String, Object>> getDeptCnt() {
		return dao.getDeptCnt();
	}

}
