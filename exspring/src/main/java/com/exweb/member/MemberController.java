package com.exweb.member;

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

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	private MemberService memberService =  MemberServiceImpl.getInstance();
	
	@RequestMapping(value = "/member/list.do",method = RequestMethod.GET)
	public String list(Model model){
		
		List<MemberVo> list = memberService.selectMemberList();

		model.addAttribute("memberList", list);
		
		return "member/memList";
		
		}
	}



	

