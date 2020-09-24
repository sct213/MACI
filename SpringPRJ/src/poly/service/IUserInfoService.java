package poly.service;

import poly.dto.UserInfoDTO;

public interface IUserInfoService {
	
	int insertUserInfo(UserInfoDTO pDTO) throws Exception;
	// 회원가입하기(회원정보 등록하기)
}
