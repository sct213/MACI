package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.EmpDTO;

@Mapper("EmpMapper")
public interface IEmpMapper {

	List<EmpDTO> getEmpList() throws Exception;

	List<EmpDTO> getManagerList() throws Exception;


}
