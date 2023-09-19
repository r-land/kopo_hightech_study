package kr.ac.kopo.bookstore.dao;

import java.util.List;

import kr.ac.kopo.bookstore.model.Detail;
import kr.ac.kopo.bookstore.model.Orders;
import kr.ac.kopo.bookstore.pager.Pager;

public interface OrdersDao {

	int total(Pager pager);

	List<Orders> list(Pager pager);

	void add(Orders item);

	void addDetail(Detail detail);

	Orders item(Long orderid);

	

}
