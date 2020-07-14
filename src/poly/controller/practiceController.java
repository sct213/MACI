package poly.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static poly.util.CmmUtil.nvl;

import javax.servlet.http.HttpServletRequest;

@Controller
public class practiceController {

	@RequestMapping(value="table")
	public String table() {
		return "/table"; 
	}

	@RequestMapping(value="get")
	public String get(HttpServletRequest request, ModelMap model) {
		String name = nvl(request.getParameter("name"));
		// name에 매개변수 값을 저장, nvl은 null값을 빈 문자열로 변경후 저장
		model.addAttribute("name", name);
		// view(JSP)에 name이라는 문자열을 전달
		return "/get";
	}
	@RequestMapping(value="form")
	public String form() {
		return "/form";
	}
	@RequestMapping(value="doPost", method = RequestMethod.POST)
	// RequestMethod.POST 는 post 방식으로 전달하기 위함
	// 왠만해선 POST 방식을 사용할 것
	public String doPost(HttpServletRequest request, ModelMap model) {
		
		String name = nvl(request.getParameter("name"));
		model.addAttribute("name", name);
		// name 이라는 키에 name의 값이 들어감
		return "/doPost";
	}
	
	@RequestMapping(value="empList")
	public String empList(HttpServletRequest request, ModelMap model) {
		return "/empList";
	}
	
}
