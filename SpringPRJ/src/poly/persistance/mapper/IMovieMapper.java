package poly.persistance.mapper;

import config.Mapper;
import poly.dto.MovieDTO;

@Mapper("MovieMapper")
public interface IMovieMapper {

	int InsertMovieInfo(MovieDTO pDTO) throws Exception;
	
}
