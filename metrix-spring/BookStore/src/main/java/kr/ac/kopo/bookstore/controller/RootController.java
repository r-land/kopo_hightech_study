package kr.ac.kopo.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

	
	
	@GetMapping("/")
	String index() {
				return "index";
	}
}
