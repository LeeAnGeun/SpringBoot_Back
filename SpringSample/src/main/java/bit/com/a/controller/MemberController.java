package bit.com.a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bit.com.a.dto.MemberDto;
import bit.com.a.service.MemberService;

@RestController		// = @Controller + @Responsbody	-> Restful
public class MemberController {
	
	@Autowired
	MemberService service;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public MemberDto login(MemberDto dto) {
		System.out.println("login dto = " + dto.toString());
		
		MemberDto mem = service.login(dto);
		
		return mem;
	}
	
	@RequestMapping(value = "/idcheck", method = RequestMethod.POST)
	public int idcheck(MemberDto dto) {
		System.out.println("idcheck dto = " + dto.toString());
		
		int count = service.idcheck(dto);
		
		return count;
	}
	
	@RequestMapping(value = "/regi", method = RequestMethod.POST)
	public int regi(MemberDto dto) {
		System.out.println("regi dto = " + dto.toString());
		
		int count = service.addMember(dto);
		return count;
	}
}




