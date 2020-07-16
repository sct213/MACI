package poly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.EmpDTO;
import poly.persistance.mapper.IEmpMapper;
import poly.service.IEmpService;

@Service("EmpService")
public class EmpService implements IEmpService {
	
	@Resource(name = "EmpMapper")
	IEmpMapper empMapper;
	// service 대신에 Mapper를 적었어야 함.

	@Override
	public List<EmpDTO> getEmpList() throws Exception {
		// TODO Auto-generated method stub
		return empMapper.getEmpList();
	}

	@Override
	public List<EmpDTO> getManagerList() throws Exception {
		// TODO Auto-generated method stub
		return empMapper.getManagerList();
	}


	
}
