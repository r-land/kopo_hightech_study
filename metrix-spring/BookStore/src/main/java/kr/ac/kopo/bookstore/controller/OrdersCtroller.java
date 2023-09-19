package kr.ac.kopo.bookstore.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import kr.ac.kopo.bookstore.model.Customer;
import kr.ac.kopo.bookstore.model.Orders;
import kr.ac.kopo.bookstore.pager.Pager;
import kr.ac.kopo.bookstore.service.OrdersService;

@Controller
@RequestMapping("/orders")
public class OrdersCtroller {
	final String path = "orders/";
	
	@Autowired
	OrdersService service;
	
	@GetMapping("/detail/{orderid}")
	String detail(@PathVariable Long orderid, Model model) {
		Orders item = service.item(orderid);
		
		model.addAttribute("item", item);
		
		return path + "detail";
	}
	
	@GetMapping("/order")
	String order(@SessionAttribute("member") Customer customer, @SessionAttribute("cart") HashMap<Long, Integer> cart) {
		
		service.order(customer.getCustid(), cart);
		
		cart.clear();
		
			return "redirect:list";
		}
	
	@GetMapping("/list")
	String list(Pager pager, Model model) {
		List<Orders> list = service.list(pager);
		
		model.addAttribute("list", list);
		
		return path + "list";
	}

}
