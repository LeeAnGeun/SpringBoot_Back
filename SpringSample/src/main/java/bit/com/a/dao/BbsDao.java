package bit.com.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsSerchDto;

@Mapper
@Repository
public interface BbsDao {

	public List<BbsDto> bbslist(BbsSerchDto dto);
	
	public int getAllBbs(BbsSerchDto dto);
	
	public int addBbs(BbsDto dto);
	
	public BbsDto getBbs(int seq);
	
	public int deleteBbs(int seq);
	
	public int updateBbs(BbsDto dto);
	
	public int updateAnswer(BbsDto dto);
	
	public int insertAnswer(BbsDto dto);
}
