package com.yedam.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.web.emp.EmpVO;
import com.yedam.web.emp.impl.EmpDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/applicationContext.xml", "classpath:config/transactionContext.xml" })
public class EmpServiceClient {
	@Autowired
	EmpDAO dao;

	@Test
	public void getEmpTest() {
		EmpVO empVO = new EmpVO();
		empVO.setDepartmentId("");
		empVO.setFirstName("");
		// System.out.println(empVO);
		List<String> list = new ArrayList<String>();
		list.add("904");
		list.add("903");
		list.add("902");

		String lists = "1,2,3,4,5";

		// dao.deleteEmpList(list);
		List<String> newlist = Arrays.asList(lists);
		for (String a : newlist) {
			System.out.println(a+":");
		}

		//List<Map<String, Object>> glist = dao.getEmpList(empVO);
		//System.out.println("총 건수: " + glist.size());

		/*for (Map<String, Object> elist : glist) {
			System.out.println(elist);
		}*/

	}
}
