package poly.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.dto.EmpDTO;
import poly.service.IEmpService;

@Controller
public class EmpController {
	@Resource(name = "EmpService")
	IEmpService empService;

	private Logger log = Logger.getLogger(this.getClass());
	
	@RequestMapping(value="emp/managerList")
	public String managerList(ModelMap model) throws Exception {
		log.info("ManagerList 시작");

		List<EmpDTO> rList = empService.getManagerList();
		// Alt + Shift + R = 같은 단어들을 한꺼번에 변경할 수 있는 기능
		if (rList == null) {
			rList = new ArrayList();
		}
		model.addAttribute("rList", rList);

		for (EmpDTO e : rList) {
			log.info("ename : " + e.getEname());
			log.info("empno : " + e.getEmpno());
		}
		log.info("managerList 시작");
		return "/emp/empList";
	}
	
	@RequestMapping(value="emp/empList")
	public String empList(ModelMap model) throws Exception {
		log.info("empList 시작!");
		// <이곳에 문제가 있음.>
		List<EmpDTO> rList = empService.getEmpList();
		
		if(rList == null) {
			rList = new ArrayList<>();
		}
		model.addAttribute("rList", rList);
		
		for(EmpDTO e : rList) {
			log.info("ename : " + e.getEname());
			log.info("empno : " + e.getEmpno());
		}
		log.info("empList 시작");
		return "/emp/empList";
	
	}
	
}
