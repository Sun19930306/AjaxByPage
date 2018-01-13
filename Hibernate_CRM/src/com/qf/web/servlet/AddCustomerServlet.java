package com.qf.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.qf.domain.Customer;
import com.qf.domain.LinkMan;
import com.qf.service.CustomerService;
import com.qf.service.impl.CustomerServiceImpl;

/**
 * Servlet implementation class AddCustomerServlet
 */
@WebServlet("/AddCustomerServlet")
public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//单独取出联系人的名字
		String linkman_name=  request.getParameter("contact_name");
		LinkMan linkMan =new LinkMan();
		linkMan.setLinkman_name(linkman_name);
		 //1.获取请求参数
		Map<String, String[]> map = request.getParameterMap();
		Customer customer=new Customer();
		try {
			BeanUtils.populate(customer, map);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(customer);
		System.out.println(linkMan);
		 //2.调用业务逻辑
		//从Spring容器中获取CustomerService对象
		WebApplicationContext  wc= 
		WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		CustomerService customerService = (CustomerService)wc.getBean("customerService");
		customerService.addCustomer(customer,linkMan);
		//3.分发转向
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
