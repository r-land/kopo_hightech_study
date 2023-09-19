package kr.ac.kopo.bookstore.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.kopo.bookstore.dao.OrdersDao;
import kr.ac.kopo.bookstore.model.Detail;
import kr.ac.kopo.bookstore.model.Orders;
import kr.ac.kopo.bookstore.pager.Pager;
@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	OrdersDao dao;	

	@Override
	public List<Orders> list(Pager pager) {
		int total = dao.total(pager);
		pager.setTotal(total);
		return dao.list(pager);
	}
	@Transactional
	@Override
	public void order(String custid, HashMap<Long, Integer> cart) {
		Orders item = new Orders();
		item.setCustid(custid);
		item.setSaleprice(0L);
		
		dao.add(item);
		
		System.out.println(item.getOrderid());
		
		for(Long bookid : cart.keySet()) {
			Detail detail = new Detail();
			detail.setBookid(bookid);
			detail.setOrderid(item.getOrderid());
			detail.setAmount(0L);
			
			dao.addDetail(detail);
			
		}
		
	}
	@Override
	public Orders item(Long orderid) {
		return dao.item(orderid);
	}


}
