package poly.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.dto.UserInfoDTO;
import poly.service.IUserInfoService;
import poly.util.CmmUtil;
import poly.util.EncryptUtil;

@Controller
public class MainController {

	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "UserInfoService")
	private IUserInfoService userInfoService;
	
	@RequestMapping(value = "user/LoginForm")
	public String loginForm() {
		log.info(this.getClass().getName() + ".user/loginForm OK!");
		return "/user/LoginForm";
	}

	@RequestMapping(value = "user/getUserLoginCheck")
	public String getUserLoginCheck(HttpSession session, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws Exception {
		log.info(this.getClass().getName() + ".getUserLoginCheck Start! ");

		int res = 0;

		UserInfoDTO pDTO = null;

		try {

			/*
			 * 웹(회원정보 입력화면)에서 받는 정보를 String 변수에 저장 시작
			 * 
			 * 무조건 웹으로 받은 정보는 DTO에 저장하기 위해 임시로 String 변수에 저장함
			 */
			String user_id = CmmUtil.nvl(request.getParameter("user_id"));
			String password = CmmUtil.nvl(request.getParameter("password"));

			/*
			 * 웹(회원정보 입력화면)에서 받는 정보를 String 변수에 저장함
			 * 
			 * 무조건 웹으로 받은 정보는 DTO에 저장하기 위해 임시로 String 변수에 저장함
			 * 
			 * 
			 * 반드시, 값을 받았으면, 꼭 로그를 찍어서 값이 제대로 들어오는지 파악해야 함 반드시 작성할 것.
			 */
			log.info("user_id : " + user_id);
			log.info("password : " + password);

			/*
			 * 웹(회원정보 입력화면)에서 받은 정보를 DTO에 저장하기 시작 !
			 * 
			 * 무조건 웹으로 받은 정보는 DTO에 저장해야한다고 이해하기 바람
			 */

			pDTO = new UserInfoDTO();

			pDTO.setUser_id(user_id);

			pDTO.setPassword(EncryptUtil.encHashSHA256(password));

			/*
			 * 웹(회원정보 입력화면)에서 받는 정보를 DTO에 저장하기 끝
			 * 
			 * 무조건 웹으로 받은 정보는 DTO에 저장
			 */

			// 로그인을 위해 아이디와 비밀번호가 일치하는지 확인하기 위한 userInfoService 호출하기
			res = userInfoService.getUserLoginCheck(pDTO);

			/*
			 * 로그인을 성공한다면, 회원아이디 정보를 Session에 저장함
			 * 
			 * 세션은 톰켓(was)의 메모리에 존재하며, 웹사이트에 접속한 사람(연결된 객체)마다 메모리에 값을 올린다.
			 * 
			 * 스프링에서 세션을 사용하기 위해서는 함수명의 파라미터에 HttpSession session이 존재해 한다. 세션은 톰켓의 메모리에 저장되기
			 * 때문에 url마다 전달하는게 필요하지 않고, 그냥 메모리에서 부르면 되기 때문에 jsp, controller에서 쉽게 불러 사용 가능
			 */

			if (res == 1) {
				session.setAttribute("SS_USER_ID", user_id);
			}

		} catch (Exception e) {
			res = 2;
			log.info(e.toString());
			e.printStackTrace();
		} finally {
			log.info(this.getClass().getName() + ".insertUserInfo end");

			model.addAttribute("res", String.valueOf(res));

			pDTO = null;

		}

		return "/user/LoginResult";
	}
}
