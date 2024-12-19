package com.jbedu.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  //어노테이션 Controller->컨트롤러 클래스로 지정
@RequestMapping("/sports") // 클래스와 컨트롤러 사이에 지정시 무조건 /sports 붙음
public class MemberController {


	@RequestMapping(value = "/") // root요청
	public String index() {
		return "index";
	}
	
	@RequestMapping(value ="sports/baseball") // value 값 ->요청 (request)값
	public String baseball() {
		return "sports/baseball";  
	}
	@RequestMapping(value ="sports/soccer") // value 값 ->요청 (request)값
	public String soccer() {
		return "sports/soccer";  
	}
//	@RequestMapping(value ="/baseball") // value 값 ->요청 (request)값
//	public String baseball() {
//		return "baseball";  
//	}


}	
