package bit.com.a.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import bit.com.a.dto.MemberDto;

@Mapper
@Repository
public interface MemberDao {
	
	public MemberDto login(MemberDto dto);
	
	public int idcheck(MemberDto dto);
	
	public int addMember(MemberDto dto);
}
