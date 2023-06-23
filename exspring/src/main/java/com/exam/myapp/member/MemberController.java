package com.exam.myapp.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String addform() {
		return "member/memAdd";
	}
	
	@RequestMapping(value = "/member/add.do",method = RequestMethod.POST)
	public String add(MemberVo vo) {
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
		return "redirect:/member/list.do";
	}

	
}
	@RequestMapping(value = "/member/logout.do",method = RequestMethod.GET)
	public String logout(HttpSession session) {	
		session.invalidate(); 
		return "redirect:/member/login.do";
	
	}
}


	

