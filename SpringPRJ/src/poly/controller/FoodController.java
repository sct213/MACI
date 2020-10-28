package poly.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.service.IFoodService;

@Controller
public class FoodController {

	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "FoodService")
	private IFoodService foodService;
	
	@RequestMapping(value = "food/getFoodInfoFromWeb")
	public String getFoodInfo(HttpServletRequest request, HttpServletResponse response,
		ModelMap model) throws Exception {
		log.info(this.getClass().getName() + ".getFoodInfo Start!");
		
		int res = foodService.getFoodInfoFromWeb();
		
		model.addAttribute("res", String.valueOf(res));
		
		return "/food/FoodInfoFromWeb";
	}

}
