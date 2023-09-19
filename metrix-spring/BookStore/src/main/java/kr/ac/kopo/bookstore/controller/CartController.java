package kr.ac.kopo.bookstore.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

@RestController
@RequestMapping("/cart")
public class CartController {
	

	@GetMapping("/add/{bookid}")
	String addCart(@PathVariable Long bookid, @SessionAttribute(name="cart", required=false) HashMap<Long, Integer> cart, HttpSession session) {
		if(cart == null) {
			cart = new HashMap<Long, Integer>();
			session.setAttribute("cart", cart);
		}
		Integer amount = cart.get(bookid);
		if(amount == null)
			amount = 0;
		
		cart.put(bookid, amount + 1);
			
		System.out.println("장바구니 담기 :" + bookid + "," + cart.get(bookid));
		return "OK";
	}
	
	@GetMapping("/update/{bookid}/{amount}")
	String update(@PathVariable Long bookid, @PathVariable int amount,
			@SessionAttribute("cart")HashMap<Long, Integer> cart) {
		if(cart.put(bookid, amount) != null)
			return "OK";
		
		return "FAIL";
	}
	
	
}
