package poly.service;

import poly.dto.UserInfoDTO;

public interface IUserInfoService {
	int insertUserInfo(UserInfoDTO pDTO) throws Exception;
}
