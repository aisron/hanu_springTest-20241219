package com.jbedu.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DataController {
	
	

	@RequestMapping(value="/data")
	public String data(Model model) {  //Model 클래스 이용한 데이터 전달
		String name ="홍길동";
		
		
		model.addAttribute("memberName",name);  // name 값을 모델 객체에 담음-> data.jsp에  넣어줌
		
		
		return "data";
		
	}
	
	@RequestMapping(value ="/datamodel")
	public ModelAndView datamodel() {  // ModelAndView 클래스 이용한 데이터 전달 // 매개변수 없음
//		ModelAndView -> view에 전달해줄 갑과 view (jsp) 파일 이름을 동시에 전달해주는 객체
		int age = 27; // 홍길동의 나이
		
		ModelAndView mv = new ModelAndView(); //ModelAndView 객체 생성
		mv.addObject("age",age); // Model 객체에 데인터 담기
		mv.setViewName("datamodel"); // view 이름 (jsp 이름)
		
		return mv;
		
	}
	
	@RequestMapping(value = "/login") // login.jsp 실행 시키는 역할
	public String login() {
		
		return "login";
	}
	
	
	// form에서 잡아오기
	@RequestMapping(value = "/confirmID")  // 클라이언트의 로그인 요청을 여기서 catch (parameter 값도 함께)
	public String corfirmID(HttpServletRequest request, Model model) {  // 매개변수로 request 객체 넣어준다
		//HttpServletRequest request, Model model 무조건작성
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		
		
//		if(mid.equals("tiger")&& mpw.equals("12345")) {
//			model.addAttribute("idcheck", "memberOk");
//		} else {
//			model.addAttribute("idcheck","memberNo");
//			
//		}
		
		model.addAttribute("loginid", mid);
		model.addAttribute("loginpw", mpw);
		
		return "confirmID";
	}
}
