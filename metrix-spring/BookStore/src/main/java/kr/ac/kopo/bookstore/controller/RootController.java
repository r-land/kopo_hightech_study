package kr.ac.kopo.bookstore.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.bookstore.model.Customer;
import kr.ac.kopo.bookstore.service.CustomerService;

@Controller
public class RootController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping("/cart")
	String cart() {
		return "cart";
	}
	
	@GetMapping("/")
	String index(HttpSession session, Model model) {
		String msg = (String) session.getAttribute("msg");
		if(msg != null) {
			model.addAttribute("msg", msg);
			session.removeAttribute("msg");
		}
				return "index";
	}
	
	@GetMapping("/logout")
	String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/login")
	String login() {
		return "login";
	}
	@PostMapping("/login")
	String login(Customer item, HttpSession session) {
		Boolean result = customerService.login(item);
		if(result) {
			session.setAttribute("msg", "환영합니다");
			session.setAttribute("member", item);
		}else
			session.setAttribute("msg", "로그인에 실패하였습니다.");
			
		
		return "redirect:/";
	}
	
	@GetMapping("/signup")
	String signup() {
		return "signup";
	}
	
	@PostMapping("/signup")
	String signup(Customer item) {
		customerService.add(item);
		return "redirect:.";
	}
	
	@ResponseBody
	@GetMapping("/checkId/{custid}")
	String checkId(@PathVariable String custid) {
		if(customerService.item(custid) == null)
			return "OK";
		else
			return "FAIL";
	}
}
