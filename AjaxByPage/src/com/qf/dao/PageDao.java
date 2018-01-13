package com.qf.dao;

import java.sql.SQLException;
import java.util.List;

import com.qf.domain.Page;

public interface PageDao {

	public List<Page> queryDataByLimit(int pageNo,int pageSize) throws  SQLException;
	
	public long queryConutByData() throws  SQLException;
}
