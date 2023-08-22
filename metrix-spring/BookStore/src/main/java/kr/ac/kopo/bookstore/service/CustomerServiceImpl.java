package kr.ac.kopo.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.bookstore.dao.CustomerDao;
import kr.ac.kopo.bookstore.model.Customer;
import kr.ac.kopo.bookstore.pager.Pager;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao dao;
	
	@Override
	public List<Customer> list(Pager pager) {
		int total = dao.total(pager);
		
		pager.setTotal(total);
		return dao.list(pager);
	}

	@Override
	public void add(Customer item) {
		dao.add(item);
	}

	@Override
	public Customer item(Long custid) {
		return dao.item(custid);
	}

	@Override
	public void update(Customer item) {
		dao.update(item);
	}

	@Override
	public void delete(Long custid) {
		dao.delete(custid);
	}

}
