package com.qf.dao;

import com.qf.domain.Customer;
import com.qf.domain.LinkMan;

public interface CustomerDao {

	public void insertCustomer(Customer customer,LinkMan linkMan);
}
