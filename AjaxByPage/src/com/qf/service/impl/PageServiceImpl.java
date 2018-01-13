package com.qf.service.impl;
import java.util.List;

import com.qf.dao.PageDao;
import com.qf.dao.impl.PageDaoImpl;
import com.qf.domain.Page;
import com.qf.domain.PageBean;
import com.qf.service.PageService;
import com.qf.utils.ManagerTransactionUtils;

public class PageServiceImpl  implements PageService{

	PageDao pageDao =new PageDaoImpl();
	@Override
	public PageBean queryDataByPage(String pageNo, String pageSize) {
		// TODO Auto-generated method stub
		PageBean pageBean =new PageBean();
		try {
			ManagerTransactionUtils.startTransaction();
			int pageNo1 = Integer.parseInt(pageNo);
			int pageSize1 =Integer.parseInt(pageSize);
			List<Page> list = pageDao.queryDataByLimit(pageNo1, pageSize1);
			
			
			pageBean.setPageNo(pageNo1);
			pageBean.setPageSize(pageSize1);
			pageBean.setList(list);
			
			//所有数据
			long  totalCount = pageDao.queryConutByData();
			double totalPage = (double)totalCount/pageSize1;
			pageBean.setTotalPage(totalPage);
			ManagerTransactionUtils.closeTransaction();
		} catch (Exception e) {
			// TODO: handle exception
			ManagerTransactionUtils.rollBackTransaction();
		}
		
		
		
		return  pageBean;
	}

}
