package poly.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.UserInfoDTO;
import poly.persistance.mapper.IUserInfoMapper;
import poly.service.IUserInfoService;
import poly.util.CmmUtil;

@Service("UserInfoService")
public class UserInfoService implements IUserInfoService {

	@Resource(name = "UserInfoMapper")
	private IUserInfoMapper userInfoMapper;

	@Override
	public int insertUserInfo(UserInfoDTO pDTO) throws Exception {

		int res = 0;

		if (pDTO == null) {
			pDTO = new UserInfoDTO();
		}

		UserInfoDTO rDTO = userInfoMapper.getUserExists(pDTO);

		if (rDTO == null) {
			rDTO = new UserInfoDTO();
		}

		if (CmmUtil.nvl(rDTO.getExists_yn()).equals("Y")) {
			res = 2;

		} else {

			int success = userInfoMapper.insertUserInfo(pDTO);
			// 회원가입

			// DB에 데이터가 등록되었다면,
			if (success > 0) {
				res = 1;
			} else {
				res = 0;
			}
		}

		return res;
	}

	@Override
	public int getUserLoginCheck(UserInfoDTO pDTO) throws Exception {

		int res = 0; // 로그인 성공 : 1, 샐패 : 0

		UserInfoDTO rDTO = userInfoMapper.getUserLoginCheck(pDTO);
		// 로그인을 위해 아이디와 비밀번호가 일치하는지 확인하기 위한 Mapper 호출하기

		if (rDTO == null) {
			rDTO = new UserInfoDTO();
		}

		/*
		 * 로그인 성공 여부 체크시작 !
		 * 
		 * userInfoMapper로 부터 SELECT 쿼리의 결과로 회원아이디를 받아왔다면, 로그인 성공 !!
		 * 
		 * DTO의 변수에 값이 있는지 확인하기, 처리속도 측면에서 가장 좋은 방법은 변수의 길이를 가져오는 것이다. 따라서, .length()
		 * 함수를 통해 회원아이디의 글자수를 가져와 0보다 큰지 비교한다. 0보다 크다면, 글자가 존재하는 것이기 때문에 값이 존재한다.
		 */
		if (CmmUtil.nvl(rDTO.getUser_id()).length() > 0) {
			res = 1;
		}
		/*
		 * 로그인 성공 여부 체크 끝 !!
		 */
		return res;
	}
}
