package bit.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.BbsDao;
import bit.com.a.dao.MemberDao;
import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsSerchDto;

@Service
@Transactional
public class BbsService {
	
	@Autowired
	private BbsDao dao;
	
	public List<BbsDto> bbslist(BbsSerchDto dto){
		return dao.bbslist(dto);
	}
	
	public int getAllBbs(BbsSerchDto dto) {
		return dao.getAllBbs(dto);
	}
	
	public int addBbs(BbsDto dto) {
		return dao.addBbs(dto);
	}
	
	public BbsDto getBbs(int seq) {
		return dao.getBbs(seq);
	}
	
	public int deleteBbs(int seq) {
		return dao.deleteBbs(seq);
	}
	
	public int updateBbs(BbsDto dto) {
		return dao.updateBbs(dto);
	}
	
	public int answer(BbsDto dto) {
		int count = dao.updateAnswer(dto);
		
		count += dao.insertAnswer(dto);
		
		return count;
	}
}
