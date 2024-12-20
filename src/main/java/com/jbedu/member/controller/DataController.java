package com.jbedu.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jbedu.member.dto.MemberDto;

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
	
	@RequestMapping(value = "/login2") // login2.jsp 실행 시키는 역할
	public String login2() {
		
		return "login2";
	}
	@RequestMapping(value = "/login3") // login3.jsp 실행 시키는 역할
	public String login3() {
		
		return "login3";
	}
	
	@RequestMapping(value = "/join") // join.jsp 실행 시키는 역할
	public String join() {
		
		return "join";
	}
	
	
	@RequestMapping(value = "/join2") // join2.jsp 실행 시키는 역할
	public String join2() {
		
		return "join2";
	}
	
	@RequestMapping(value = "/join21") // join21.jsp 실행 시키는 역할
	public String join21() {
		
		return "join21";
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
	
	
	// 체크 아이디                           // method 방식 설정
	@RequestMapping(value = "/checkID", method = RequestMethod.POST )  // 클라이언트의 로그인 요청을 여기서 catch (parameter 값도 함께)
	public String  checkID(HttpServletRequest request, Model model) {  // 매개변수로 request 객체 넣어준다
		//HttpServletRequest request, Model model 무조건작성
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		
		
		if(mid.equals("tiger")&& mpw.equals("12345")) {// 로그인 성공
			model.addAttribute("idcheck", "memberOk");
			
			// 값 넘겨주기
			model.addAttribute("loginid", mid);
			model.addAttribute("loginpw", mpw);
			
		} else { // 로그인 실패
			model.addAttribute("idcheck","memberNo");
			
		}
		
		return "checkID";
	}
	
	// 체크 아이디 2                          // method 방식 설정
	@RequestMapping(value = "/checkID2")  // 클라이언트의 로그인 요청을 여기서 catch (parameter 값도 함께)
	public String  checkID2(@RequestParam("mid") String mid, @RequestParam("mpw") String mpw,   Model model) {  // 매개변수로 request 객체 넣어준다
		//넘길 값이 적을 때 유용
		
//		String mid = request.getParameter("mid");
//		String mpw = request.getParameter("mpw");
		
		
		if(mid.equals("tiger")&& mpw.equals("12345")) {// 로그인 성공
			model.addAttribute("idcheck", "memberOk");
			model.addAttribute("loginid", mid);
			model.addAttribute("loginpw", mpw);
			
		} else { // 로그인 실패
			model.addAttribute("idcheck","memberNo");
			
		}
		
		return "checkID";
	}
	
	// joinOk                  
	@RequestMapping(value = "/joinOk")// 클라이언트의 로그인 요청을 여기서 catch (parameter 값도 함께)
	public String joinOk(HttpServletRequest request, Model model) {
	
		
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname= request.getParameter("mname");
		String memail = request.getParameter("memail");
		
		// Dto를 만들어 보내기
		MemberDto memberDto = new MemberDto(mid, mpw, mname, memail);
		
		model.addAttribute("memberDto", memberDto); // model에 dto
//		
//		model.addAttribute("mid", mid);
//		model.addAttribute("mpw", mpw);
//		model.addAttribute("mname",mname);
//		model.addAttribute("memail", memail);
		
		
		return "joinOk";
	}
	// joinOk2                  
	@RequestMapping(value = "/joinOk2")  // 클라이언트의 로그인 요청을 여기서 catch (parameter 값도 함께)
	public String joinOk2(MemberDto memberDto, Model model) {
						           //memberDto  이름 같은게 좋음 -> 전에는 안되었다 함

//		// Dto를 만들어 보내기
//		MemberDto memberDto = new MemberDto(mid, mpw, mname, memail);
		
		model.addAttribute("memberDto", memberDto); // model에 dto
		// 생략가능
		
		return "joinOk";
	}
	
	// joinOk21                    
	@RequestMapping(value = "/joinOk21")  // 클라이언트의 로그인 요청을 여기서 catch (parameter 값도 함께)
	public String joinOk21(@ModelAttribute("ddd") MemberDto ddd, Model model) {
		// memberDto 객체의 이름을 ddd로 변경하여 model 객체에도 ddd 이름으로 memberDto객체를 실어 보냄
		// DTO 클래스의 이름이 너무 길어서 불편할 때 이름 변경
		
		return "joinOk2";
	}
	
	// js 값을 받는 경우 ex) page
	@RequestMapping(value = "/page/{pagevalue}") // js 등으로 넘어오는 매개변수 형식
	public String pagevalue(@PathVariable String pagevalue, Model model) {
		model.addAttribute("page", pagevalue);
		return "page";
	}
	
// 리다이렉트
	@RequestMapping(value="/redirect")
	public String redirect() {
		return "redirect";
	}

// 리다이렉트good
	@RequestMapping(value="/redirectGood")
	public String redirecrtGood(@RequestParam("number") String number, Model model) {
		
		// 형변환
		int number_int = Integer.parseInt(number); // 문자> 정수로 변환
		
		if(number_int > 10) {
			model.addAttribute("number", number); // 모델에 씌움
			return "redirectOk";
			// redirert:redirectOk 요청을 디비에서 가져와서 새로 넣는것(값을 넘겨주는 거)
		}else {
			model.addAttribute("number", "0000"); 
			return "redirectNo";
			// 단순히 jsp 파일 불러오기
		}
	
	}
	
	
	@RequestMapping(value = "/redirectOk")
	public String redirectOk(Model model) {
		
		model.addAttribute("number", "안녕하세요"); 
		
		return "redirectOk";
	}
	
	

    
	
}
