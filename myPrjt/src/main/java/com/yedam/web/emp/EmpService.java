package com.yedam.web.emp;

import java.util.List;
import java.util.Map;

public interface EmpService {
	// 목록조회
	List<Map<String, Object>> getEmpList(EmpVO vo);

	List<Map<String, Object>> getEmpList();

	public List<Map<String, Object>> getDeptCnt();

}
