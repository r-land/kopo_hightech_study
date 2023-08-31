package com.exam.myapp.member;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/member/list.do",method = RequestMethod.GET)
	public String list(Model model){
		List<MemberVo> list = memberService.selectMemberList();
		model.addAttribute("memberList", list);
		return "member/memList";
	}
	
	@RequestMapping(value = "/member/add.do",method = RequestMethod.GET)
	public String addform(MemberVo vo) {
		return "member/memAdd";
	}
	
	//스프링에 등록된 표준BeanValidator를 사용하여
	//저장된 값을 검증하고 싶은 객체 매개변수 앞에 @Valid적용
	//@Valid 매개변수 다음 위체에 매개검증결과를 저장하기 위한
	//BindingResult 또는 Errors 타입의 매개변수를 추가
	@RequestMapping(value = "/member/add.do",method = RequestMethod.POST)
	public String add(@Valid MemberVo vo, BindingResult result) {
		
		if(result.hasErrors()) {//검증결과 오류가 있다면
//			for(FieldError fe : result.getFieldErrors()) {
//				System.out.println("**" + fe.getField());
//				for(String c : fe.getCodes()){
//					System.out.println(c);
//				}	} 오류 내역 확인을 위한 코드 
			return "member/memAdd"; //회원정보 입력 화면(Jsp) 출력(실행)
		}
		int n = memberService.insertMember(vo);
		System.out.println(n + "명의 회원 추가 성공");
		return "redirect:/member/list.do";
				 	
	}
	
	@RequestMapping(value = "/member/edit.do",method = RequestMethod.GET)
	public String editform(String memId, Model model) {
		MemberVo vo =memberService.selectMember(memId);
		model.addAttribute("mvo", vo);
		return "member/memEdit";		
	}
	
	@RequestMapping(value = "/member/edit.do",method = RequestMethod.POST)
	public String edit(MemberVo vo) {			
		int n = memberService.updateMember(vo);
		System.out.println(n + "명의 회원 변경 성공");
		return "redirect:/member/list.do";
	}

	@RequestMapping(value = "/member/del.do",method = RequestMethod.GET)
		public String service(String memId) {
		int n = memberService.deleteMember(memId);
		System.out.println(n + "명의 회원 삭제 성공");
		return "redirect:/member/list.do";
	}
	
	@RequestMapping(value = "/member/login.do",method = RequestMethod.GET)
	public String loginform() {
		return "/member/login";
	}
	
	@RequestMapping(value = "/member/login.do",method = RequestMethod.POST)
	public String login(MemberVo vo, HttpSession session) {
	MemberVo mvo = memberService.selectLogin(vo);
		
		
	if(mvo==null) { 	//로그인 실패 로그인화면 이동 
		return "redirect:/member/login.do";

	}else { //로그인 성공
		session.setAttribute("loginUser", mvo);
		return "redirect:/bbs/list.do";
	}

	
}
	@RequestMapping(value = "/member/logout.do",method = RequestMethod.GET)
	public String logout(HttpSession session) {	
		session.invalidate(); 
		return "redirect:/member/login.do";
	
	}
}


	

