package poly.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import poly.dto.NlpDTO;
import poly.persistance.mapper.INlpMapper;
import poly.service.INlpService;
import poly.util.CmmUtil;
import poly.util.StringUtil;

@Service("NlpService")
public class NlpService implements INlpService {

	@Resource(name = "NlpMapper")
	private INlpMapper nlpMapper;
	
	private Logger log = Logger.getLogger(this.getClass());
	
	/*
	 * NLP_DIC를 ㄱㄴㄷㄹ 순으로 나눠서 저장한 이유는
	 * 전체 약 몇만건의 데이터를 조회하는 것보다
	 * 일정한 범위를 지정하여 데이터 조회횟수를 감소하기 위함 
	 * 가나다 순으로 저장될 데이터 사전들(가~하까지) 
	 */
	private Map<String, List<NlpDTO>> NLP_DIC = new HashMap<String, List<NlpDTO>>();
	
	/*
	 * PostConstruct은 처음 한번만 실행되도록 하는 어노테이션 
	 * 
	 * 데이터 사전 변수 생성을 위한 함수 최초 스프링 호출이 발생할 때 함수가 실행 이후 더 이상 실행하지 않음 
	 * 
	 * NLP_DIC 변수에 값을 저장함
	 */
	@Override
	@PostConstruct
	public void getWord() throws Exception {
		
		log.info(this.getClass().getName() + ".getWord Start!");
		
		NlpDTO pDTO = new NlpDTO();
		
		List<NlpDTO> rList = null;
		
		pDTO.setWord("ㄱ");
		rList = nlpMapper.getWord(pDTO);
		
		if(rList == null) {
			rList = new ArrayList<NlpDTO>();
		}
		
		NLP_DIC.put("ㄱ", rList);
		
		pDTO.setWord("ㄴ");
		rList = nlpMapper.getWord(pDTO);
		
		if(rList == null) {
			rList = new ArrayList<NlpDTO>();
		}
		
		NLP_DIC.put("ㄴ", rList);
		
		pDTO.setWord("ㄷ");
		rList = nlpMapper.getWord(pDTO);
		
		if(rList == null) {
			rList = new ArrayList<NlpDTO>();
		}
		
		NLP_DIC.put("ㄷ", rList);
		
		pDTO.setWord("ㄹ");
		rList = nlpMapper.getWord(pDTO);
		
		if(rList == null) {
			rList = new ArrayList<NlpDTO>();
		}
		
		NLP_DIC.put("ㄹ", rList);
		
		pDTO.setWord("ㅁ");
		rList = nlpMapper.getWord(pDTO);
		
		if(rList == null) {
			rList = new ArrayList<NlpDTO>();
		}
		
		NLP_DIC.put("ㅁ", rList);
		
		pDTO.setWord("ㅂ");
		rList = nlpMapper.getWord(pDTO);
		
		if(rList == null) {
			rList = new ArrayList<NlpDTO>();
		}
		
		NLP_DIC.put("ㅂ", rList);
		
		pDTO.setWord("ㅅ");
		rList = nlpMapper.getWord(pDTO);
		
		if(rList == null) {
			rList = new ArrayList<NlpDTO>();
		}
		
		NLP_DIC.put("ㅅ", rList);
		
		pDTO.setWord("ㅇ");
		rList = nlpMapper.getWord(pDTO);
		
		if(rList == null) {
			rList = new ArrayList<NlpDTO>();
		}
		
		NLP_DIC.put("ㅇ", rList);
		
		pDTO.setWord("ㅈ");
		rList = nlpMapper.getWord(pDTO);
		
		if(rList == null) {
			rList = new ArrayList<NlpDTO>();
		}
		
		NLP_DIC.put("ㅈ", rList);
		
		pDTO.setWord("ㅊ");
		rList = nlpMapper.getWord(pDTO);
		
		if(rList == null) {
			rList = new ArrayList<NlpDTO>();
		}
		
		NLP_DIC.put("ㅊ", rList);
		
		pDTO.setWord("ㅋ");
		rList = nlpMapper.getWord(pDTO);
		
		if(rList == null) {
			rList = new ArrayList<NlpDTO>();
		}
		
		NLP_DIC.put("ㅋ", rList);
		
		pDTO.setWord("ㅌ");
		rList = nlpMapper.getWord(pDTO);
		
		if(rList == null) {
			rList = new ArrayList<NlpDTO>();
		}
		
		NLP_DIC.put("ㅌ", rList);
		
		pDTO.setWord("ㅍ");
		rList = nlpMapper.getWord(pDTO);
		
		if(rList == null) {
			rList = new ArrayList<NlpDTO>();
		}
		
		NLP_DIC.put("ㅍ", rList);
		
		pDTO.setWord("ㅎ");
		rList = nlpMapper.getWord(pDTO);
		
		if(rList == null) {
			rList = new ArrayList<NlpDTO>();
		}
		
		NLP_DIC.put("ㅎ", rList);
		
		pDTO.setWord("ㄲ");
		rList = nlpMapper.getWord(pDTO);
		
		if(rList == null) {
			rList = new ArrayList<NlpDTO>();
		}
		
		NLP_DIC.put("ㄲ", rList);
		
		pDTO.setWord("ㄸ");
		rList = nlpMapper.getWord(pDTO);
		
		if(rList == null) {
			rList = new ArrayList<NlpDTO>();
		}
		
		NLP_DIC.put("ㄸ", rList);
	
		pDTO.setWord("ㅃ");
		rList = nlpMapper.getWord(pDTO);
		
		if(rList == null) {
			rList = new ArrayList<NlpDTO>();
		}
		
		NLP_DIC.put("ㅃ", rList);
		
		pDTO.setWord("ㅆ");
		rList = nlpMapper.getWord(pDTO);
		
		if(rList == null) {
			rList = new ArrayList<NlpDTO>();
		}
		
		NLP_DIC.put("ㅆ", rList);
		
		pDTO.setWord("ㅉ");
		rList = nlpMapper.getWord(pDTO);
		
		if(rList == null) {
			rList = new ArrayList<NlpDTO>();
		}
		
		NLP_DIC.put("ㅉ", rList);
		
		log.info(this.getClass().getName() + ".getWord End!!");
	}

	/**
	 * 감정 분석을 위한 문장을 나누는 전처리 단계
	 * 
	 * @param 분석할 문장 정보
	 * @return 감정 분석 평가 결과
	 */
	public int preProcessWordAnalysisForMind(NlpDTO pDTO) throws Exception {
		
		log.info(this.getClass().getName() + ".WordAnalysisForMind Start!!");
		
		int res = 0;
		
		//분석할 문장(특수문자 모두 제거)
		String text = CmmUtil.nvl(pDTO.getWord().replaceAll("[^\\uAC00-\\uD7A3xfe0-9a-zA-z\\\\s]"," "));
		
		// 연속된 스페이스 제거
		text = text.replaceAll("\\s{2,}"," ");
		
		log.info("text: " + text);
		
		// 공백으로 단어 나누기 
		String[] textArr = text.split(" ");
		
		log.info("textArr.length : " + textArr.length);
		
		// 데이터 사전의 단어 수가 최대 3으로 정의됨
		if(textArr.length < 4) {
			
			// 문장의 첫글자 
			String firstWord = textArr[0].substring(0,1);
			
			// 데이터 분석 진행 
			res = WordAnalysisForMind(firstWord, text);
			
		} else {
			
			// 최대 반복 횟수
			int maxCnt = textArr.length - 2;
			
			log.info("### textArr.length : " + textArr.length);
			log.info("### maxCnt : " + maxCnt);
			
			for(int i = 0; i < maxCnt; i++) {
				
				// 문장의 첫글자 
				String firstWord2 = textArr[i].substring(0,1);
				
				log.info("### 반복 횟수 : " + i);
				
				String text2 = textArr[i] + " " + textArr[i + 1] + " " + textArr[i + 2];
				
				res += WordAnalysisForMind(firstWord2, text2);
			}
		}
		
		log.info("Res : " + res);
		log.info(this.getClass().getName() + ".WordAnalysisForMind End!");
		
		return res;
	}

	@Override
	public int WordAnalysisForMind(String firstWord, String text) throws Exception {
		
		int res = 0;
		
		log.info("firstWord : " + firstWord);
		log.info("text :" + text);
		
		// 데이터 사전의 종류 
		String dicType = StringUtil.getFirstWord(firstWord);
		
		log.info("DIC Type : " + dicType);
		
		// 데이터 사전에 존재하는 것만 분석 수행
		if(dicType.length() > 0) {
			// 문장의 첫글자를 통해 해당되는 데이터 사전 가져오기
			List<NlpDTO> rList = NLP_DIC.get(StringUtil.getFirstWord(firstWord));
			
			if(rList == null) {
				rList = new ArrayList<NlpDTO>();
			}
			
			Iterator<NlpDTO> it = rList.iterator();
			
			while (it.hasNext()) {
				NlpDTO rDTO = it.next();
				
				if(rDTO == null) {
					rDTO = new NlpDTO();
				}
				
				// 일치하는 값이 존재한다면, 
				if(text.indexOf(CmmUtil.nvl(rDTO.getWord())) > -1) {
					log.info("DIC-Word : " + CmmUtil.nvl(rDTO.getWord()));
					log.info("DIC-Word getPolarity : " + CmmUtil.nvl(rDTO.getPolarity()));
					log.info("text : " + text);
					res += Integer.parseInt(CmmUtil.nvl(rDTO.getPolarity(), "0"));
					
					// 데이터 사전에 검색이 되어있기 때문에 더 이상 while을 실행하지 않는다.
					break;
				}
			}
		}
		
		return res;
	}

}

