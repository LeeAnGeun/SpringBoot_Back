package bit.com.a.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bit.com.a.dto.MemberDto;
import bit.com.a.service.MemberService;

@RestController		// = @Controller + @Responsbody	-> Restful
public class HelloController {
	
	@Autowired
	MemberService service;
	
	// 동작을 안함
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String base() {
		System.out.println("HelloController base() " + new Date());
		
		return "<h1>base</h1>";
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		System.out.println("HelloController test() " + new Date());
		
		return "<h1>test</h1>";
	}
	
	@RequestMapping(value = "/member", method = RequestMethod.GET)
	public MemberDto getMemberDto() {
		System.out.println("HelloController getMemberDto()" + new Date());
		MemberDto dto = new MemberDto("aaa", "111", "홍길이", "aaa@naver.com", 3);
		
		return dto;
	}
	
	@RequestMapping(value = "/conn_param", method = RequestMethod.GET)
	public String conn_param(String title) {
		System.out.println("HelloController conn_param()" + new Date());
		System.out.println("title = " + title);
		
		return "conn success";
	}
	
	@RequestMapping(value = "/conn_param_get", method = RequestMethod.GET)
	public String conn_param_get(MemberDto dto) {
		System.out.println("HelloController conn_param_get()" + new Date());
		System.out.println(dto.toString());
		
		return "conn_param_get success";
	}
	
	@RequestMapping(value = "/dbtest", method = RequestMethod.GET)
	public List<MemberDto> dbtest(){
		System.out.println("HelloController dbtest()" + new Date());
		
		List<MemberDto> list = service.allMember();
		
		return list;
	}
}














