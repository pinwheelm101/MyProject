package com.abandon.web.servlet.userinfo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abandon.domain.UserInfo;
import com.abandon.service.UserInfoService;
import com.abandon.service.impl.UserInfoServiceImpl;

/**
 * Servlet implementation class UserInfoShowServlet
 */
@WebServlet("/UserInfoShowServlet")
public class UserInfoShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//根据编号查询用户信息
		//拿到id
		String id=request.getParameter("userId");
		
		System.out.println(id);
		
		
		//业务处理
		UserInfoService service=new UserInfoServiceImpl();
		//查询信息并接收
		UserInfo user=service.getUser(id);
		//设置参数
		request.setAttribute("user", user);						
		//跳转
		request.getRequestDispatcher("/view/userinfo/userinfo_show.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
