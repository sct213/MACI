package poly.service.impl;

import java.util.Iterator;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import poly.dto.FoodDTO;
import poly.persistance.mapper.IFoodMapper;
import poly.service.IFoodService;
import poly.util.CmmUtil;
import poly.util.DateUtil;

@Service("FoodService")
public class FoodService implements IFoodService {

	@Resource(name = "FoodMapper")
	private IFoodMapper foodMapper;
	
	private Logger log = Logger.getLogger(this.getClass());
	@Override
	public int getFoodInfoFromWeb() throws Exception {
		
		log.info(this.getClass().getName() + ".getFoodInfo Start!");
		
		int res = 0;
		
		String url = "http://www.kopo.ac.kr/kangseo/content.do?menu=262";
		
		Document doc = null;
		
		doc = Jsoup.connect(url).get(); 
		 
		Elements element = doc.select("tbody tr");
		
		Iterator<Element> day = element.select("td:nth-child(1)").iterator();
		
		Iterator<Element> food_nm =  element.select("td:nth-child(3)").iterator();
		
		FoodDTO pDTO = null;
		
		
		while(day.hasNext()){
		
		pDTO = new FoodDTO();
		
		pDTO.setCollect_time(DateUtil.getDateTime("yyyyMMdd24hmmss"));
		
		pDTO.setDay(CmmUtil.nvl(day.next().text()).trim());
		
		pDTO.setFood_nm(CmmUtil.nvl(food_nm.next().text()).trim());
		
		pDTO.setReg_id("admin");
		
		res += foodMapper.InsertFoodInfo(pDTO);
		
		}
		
		log.info(this.getClass().getName() + ".getFoodInfo end!");
		
		return res;
	}

}
