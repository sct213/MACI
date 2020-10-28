package poly.persistance.mapper;

import config.Mapper;
import poly.dto.FoodDTO;

@Mapper("FoodMapper")
public interface IFoodMapper {

	int InsertFoodInfo(FoodDTO pDTO) throws Exception;
	
}
