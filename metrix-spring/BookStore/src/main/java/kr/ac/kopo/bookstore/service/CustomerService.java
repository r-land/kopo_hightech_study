package kr.ac.kopo.bookstore.service;

import java.util.List;

import kr.ac.kopo.bookstore.model.Customer;
import kr.ac.kopo.bookstore.pager.Pager;

public interface CustomerService {

	List<Customer> list(Pager pager);

	void add(Customer item);

	Customer item(String custid);

	void update(Customer item);

	void delete(String custid);

	Boolean login(Customer item);

}
