package com.qf.service.impl;

import javax.annotation.Resource;

import com.qf.dao.CustomerDao;
import com.qf.dao.impl.CustomerDaoImpl;
import com.qf.domain.Customer;
import com.qf.domain.LinkMan;
import com.qf.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{

	//新增客户(事务) 注解
	//@Resource(name="customerDao")  //读配置文件才可以查找指定对象
	
	
	private CustomerDao customerDao;
	@Override
	public void addCustomer(Customer customer, LinkMan linkMan) {
		// TODO Auto-generated method stub
		//调用dao层
		customerDao.insertCustomer(customer, linkMan);
	}
	
	
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
   
	
}
