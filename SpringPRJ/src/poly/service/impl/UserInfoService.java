package poly.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.UserInfoDTO;
import poly.persistance.mapper.IUserInfoMapper;
import poly.service.IUserInfoService;
import poly.util.CmmUtil;

@Service("UserInfoService")
public class UserInfoService implements IUserInfoService{
	
	@Resource(name="UserInfoMapper")
	private IUserInfoMapper userInfoMapper;

	@Override
	public int insertUserInfo(UserInfoDTO pDTO) throws Exception {

		int res = 0;
		
		if (pDTO == null) {
			pDTO = new UserInfoDTO();
		}
		
		UserInfoDTO rDTO = userInfoMapper.getUserExists(pDTO);
		
		if(rDTO == null) {
			rDTO = new UserInfoDTO();
		}
		
		if(CmmUtil.nvl(rDTO.getExists_yn()).equals("Y")) {
			res = 2;
			
		} else {
			
			int success = userInfoMapper.insertUserInfo(pDTO);
			// 회원가입
			
			// DB에 데이터가 등록되었다면, 
			if(success > 0) {
				res = 1;
			} else {
				res = 0;
			}
		}
		
		return res;
	}

}
