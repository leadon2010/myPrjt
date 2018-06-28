package com.yedam.web.emp.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yedam.web.emp.EmpVO;

@Repository
public class EmpDAO {

	@Autowired
	SqlSessionTemplate mybatis;

	public List<Map<String, Object>> getEmpList(EmpVO vo) {
		return mybatis.selectList("com.yedam.web.emp.EmpDAO.getEmpList", vo);
	}

	public List<Map<String, Object>> getEmpList() {
		return mybatis.selectList("com.yedam.web.emp.EmpDAO.getEmpList");
	}

	public List<EmpVO> getEmpList2() {
		return null;
	}

	public EmpVO getEmp(String id) {
		return mybatis.selectOne("com.yedam.web.emp.EmpDAO.getEmp", id);
	}

	public void insertEmp(EmpVO vo) {
		mybatis.insert("com.yedam.web.emp.EmpDAO.insertEmp", vo);
	}

	public void updateEmp(EmpVO vo) {
		mybatis.update("com.yedam.web.emp.EmpDAO.updateEmp", vo);
	}

	public void deleteEmp(String id) {
		mybatis.delete("com.yedam.web.emp.EmpDAO.deleteEmp", id);
	}

	public void deleteEmpList(List<String> list) {
		mybatis.delete("com.yedam.web.emp.EmpDAO.deleteEmpList", list);
	}

	public List<Map<String, Object>> getDeptCnt() {
		return mybatis.selectList("com.yedam.web.emp.EmpDAO.getDeptCnt");
	}
}
