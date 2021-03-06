package bit.com.a.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsSerchDto;
import bit.com.a.service.BbsService;

@RestController		// = @Controller + @Responsbody	-> Restful
public class BbsController {

	@Autowired
	BbsService service;
	
	@RequestMapping(value = "/bbslist", method = RequestMethod.GET)
	public List<BbsDto> bbslist(BbsSerchDto dto){
		System.out.println("bbslist dto = " + dto.toString());
		
		List<BbsDto> list = service.bbslist(dto);
		
		return list;
	}
	
	@RequestMapping(value = "/bbslistCount", method = RequestMethod.GET)
	public int bbslistCount(BbsSerchDto dto) {
		System.out.println("bbslistCount dto = " + dto.toString());
		
		int len = service.getAllBbs(dto);
		System.out.println("len = " + len);
		return len;
	}
	
	@RequestMapping(value = "/addBbs", method = RequestMethod.GET)
	public int addBbs(BbsDto dto) {
		System.out.println("addBbs dto = " + dto.toString());
		
		int count = service.addBbs(dto);
		
		return count;
	}
	
	@RequestMapping(value = "/bbsDetail", method = RequestMethod.GET)
	public BbsDto bbsDetail(int seq) {
		System.out.println("bbsDetail seq = " + seq);
		
		BbsDto dto = service.getBbs(seq);
		
		return dto;
	}
	
	@RequestMapping(value = "/bbsDelete", method = RequestMethod.GET)
	public int bbsDelete(int seq) {
		System.out.println("bbsDelete seq = " + seq);
		
		int count = service.deleteBbs(seq);
		
		return count;
	}
	
	@RequestMapping(value = "/bbsUpdate", method = RequestMethod.GET)
	public int bbsUpdate(BbsDto dto) {
		System.out.println("bbsUpdate dto = " + dto.toString());
		
		int count = service.updateBbs(dto);
		
		return count;
	}
}





















