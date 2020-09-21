package poly.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poly.dto.MailDTO;
import poly.service.IMailService;
import poly.util.CmmUtil;


@Controller
public class MailController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="MailService")
	private IMailService mailService;
	
	@RequestMapping(value="mail/sendMail", method = RequestMethod.GET)
	public String sendMail(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		
		log.info(this.getClass().getName() + "mail.sendMail Start!");
		
		String toMail = CmmUtil.nvl(request.getParameter("toMail"));
		String title = CmmUtil.nvl(request.getParameter("title"));
		String contents = CmmUtil.nvl(request.getParameter("contents"));
		
		MailDTO pDTO = new MailDTO();
		
		pDTO.setToMail(toMail);
		pDTO.setTitle(title);
		pDTO.setContents(contents);
		
		int res = mailService.doSendMail(pDTO);
		
		if(res == 1) {
			log.info(this.getClass().getName() + "mail.sendMail success!!!");
		} else {
			log.info(this.getClass().getName() + "mail.sendMail end!!");
		}
		
		model.addAttribute("res", String.valueOf(res));
		
		log.info(this.getClass().getName() + "mail.sendMail End!");
		
		return "/mail/sendMailResult";
	}
	
	@RequestMapping(value="mail/sendMailForm", method = RequestMethod.GET)
	public String sendMailForm(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		
log.info(this.getClass().getName() + "mail.Form Start!");
		
		String toMail = CmmUtil.nvl(request.getParameter("toMail"));
		String title = CmmUtil.nvl(request.getParameter("title"));
		String contents = CmmUtil.nvl(request.getParameter("contents"));
		
		MailDTO pDTO = new MailDTO();
		
		pDTO.setToMail(toMail);
		pDTO.setTitle(title);
		pDTO.setContents(contents);
		
		int res = mailService.doSendMail(pDTO);
		
		if(res == 1) {
			log.info(this.getClass().getName() + "mail.sendMail success!!!");
		} else {
			log.info(this.getClass().getName() + "mail.sendMail end!!");
		}
		
		model.addAttribute("res", String.valueOf(res));
		
		log.info(this.getClass().getName() + "mail.Form End!");
		
		return "/mail/sendMailForm";
	}
}
