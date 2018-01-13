package com.qf.service;

import java.sql.SQLException;
import java.util.List;

import com.qf.domain.Page;
import com.qf.domain.PageBean;

public interface  PageService {

	/*public List<Page>  queryDataByPage(String pageNo,String pageSize) throws SQLException;*/
	
	public PageBean  queryDataByPage(String pageNo,String pageSize) throws SQLException;
}
