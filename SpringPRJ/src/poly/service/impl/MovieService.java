package poly.service.impl;

import java.util.Iterator;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import poly.dto.MovieDTO;
import poly.persistance.mapper.IMovieMapper;
import poly.service.IMovieService;
import poly.util.CmmUtil;
import poly.util.DateUtil;

@Service("MovieService")
public class MovieService implements IMovieService {

	@Resource(name = "MovieMapper")
	private IMovieMapper movieMapper;

	private Logger log = Logger.getLogger(this.getClass());
	
	@Override
	public int getMovieInfoFromWEB() throws Exception {
		
		log.info(this.getClass().getName() + ".getMovieInfoFromWeb Start");
		
		int res = 0;
		
		String url = "http://www.cgv.co.kr/movies/";
		
		Document doc = null;
		
		doc = Jsoup.connect(url).get();
		
		Elements element = doc.select("div.sect-movie-chart");
		
		Iterator<Element> movie_rank = element.select("strong.rank").iterator();
		Iterator<Element> movie_name = element.select("strong.title").iterator();
		Iterator<Element> movie_reserve = element.select("strong.percent span").iterator();
		Iterator<Element> score = element.select("span.percent").iterator();
		Iterator<Element> open_day = element.select("span.txt-info").iterator();
		
		MovieDTO pDTO = null;
		
		while(movie_rank.hasNext()) {
			
			pDTO = new MovieDTO();
			
			pDTO.setRank_chkeck_time(DateUtil.getDateTime("yyyyMMdd24hmmss"));
			
			String rank = CmmUtil.nvl(movie_rank.next().text()).trim();
			pDTO.setMovie_rank(rank.substring(3, rank.length()));
			
			pDTO.setMovie_nm(CmmUtil.nvl(movie_name.next().text()).trim());
			
			pDTO.setMovie_reserve(CmmUtil.nvl(movie_reserve.next().text()).trim());
			
			pDTO.setScore(CmmUtil.nvl(score.next().text()).trim());
			
			pDTO.setOpen_day(CmmUtil.nvl(open_day.next().text()).trim().substring(0, 10));
			
			pDTO.setReg_id("admin");
			
			res += movieMapper.InsertMovieInfo(pDTO);
			
		}
		
		log.info(this.getClass().getName() + ".getMovieInfoFromWEB end!");
		
		return res;
	}
	
}
