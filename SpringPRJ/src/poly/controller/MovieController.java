package poly.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.service.IMovieService;

@Controller
public class MovieController {

	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "MovieService")
	private IMovieService movieService;
	
	@RequestMapping(value = "movie/RankForWEB")
	public String getMovieInfoFromWEB(HttpServletRequest request, HttpServletResponse response,
		ModelMap model) throws Exception {
		log.info(this.getClass().getName() + ".getMovieInfo Start!");
		
		int res = movieService.getMovieInfoFromWEB();
		
		model.addAttribute("res", String.valueOf(res));
		
		log.info(this.getClass().getName() + ".getMovieInfoFromWEB end !");
		
		return "/movie/RankForWEB";
	}

}
