package com.qf.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.domain.Page;
import com.qf.domain.PageBean;
import com.qf.service.PageService;
import com.qf.service.impl.PageServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 查询分页数据
 */
public class ShowDataByPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	     //1.获取请求参数
		 String pageNo=  request.getParameter("pageNo");
		 String pageSize=  request.getParameter("pageSize");
		 //2.调用业务逻辑处理数据
		  PageService pageService =new PageServiceImpl();
		  try {
			PageBean pageBean  = pageService.queryDataByPage(pageNo, pageSize);
			//以json形式响应数据到页面
			JSONObject object =JSONObject.fromObject(pageBean);
			response.getWriter().write(object.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
