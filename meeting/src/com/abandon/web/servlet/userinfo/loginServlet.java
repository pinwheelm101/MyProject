package com.abandon.web.servlet.userinfo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.abandon.domain.UserInfo;
import com.abandon.service.UserInfoService;
import com.abandon.service.impl.UserInfoServiceImpl;


/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取session
		HttpSession session=request.getSession();
		//清空信息
		session.removeAttribute("UserInfo");
		//返回登录页面
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取账号密码
				String userId=request.getParameter("userId");
				String passWord=request.getParameter("passWord");
		
		//业务逻辑层接口定义
		UserInfoService service= new UserInfoServiceImpl();				
		//判断账号密码
		UserInfo user=service.isLogin(userId, passWord);
		//System.out.println("账号"+userId+"\n"+"密码"+passWord);
		//有查询结果
		if(user!=null) {
			//获取session
			HttpSession session=request.getSession();
			//把用户信息放入session中
			session.setAttribute("UserInfo", user);
			//转发登录成功页面
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		//无查询结果
		}else {
			//输入错误返回 
			request.setAttribute("info", "账号或密码错误");
			//回到登录页面
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
		
	}

}
