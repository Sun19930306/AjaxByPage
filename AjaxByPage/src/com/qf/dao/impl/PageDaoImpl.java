package com.qf.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.qf.dao.PageDao;
import com.qf.domain.Page;
import com.qf.utils.C3P0Utils;
import com.qf.utils.ManagerTransactionUtils;

public class PageDaoImpl  implements PageDao{

	@Override
	public List<Page> queryDataByLimit(int pageNo, int pageSize) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner queryRunner =new QueryRunner(C3P0Utils.getDataSource());
		return queryRunner.query(ManagerTransactionUtils.getConnection(),"select * from shop limit ?,?", new BeanListHandler<Page>(Page.class),
				(pageNo-1)*pageSize,pageSize);
	}

	@Override
	public long queryConutByData() throws SQLException {
		// TODO Auto-generated method stu
		QueryRunner queryRunner =new QueryRunner(C3P0Utils.getDataSource());
		Object object = queryRunner.query(ManagerTransactionUtils.getConnection(),"select count(*) from shop", new ScalarHandler());
		long totalCount=(long)object;
		return totalCount;
	}

}
