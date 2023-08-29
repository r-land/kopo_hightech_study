package kr.ac.kopo.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	@GetMapping("/")
	String index() {
				return "index";
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
