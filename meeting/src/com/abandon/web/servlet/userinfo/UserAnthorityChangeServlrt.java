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
import com.my.web.servlet.RequestBeanUtils;

/**
 * Servlet implementation class UserAnthorityChangeServlrt
 */
@WebServlet("/UserAnthorityChangeServlrt")
public class UserAnthorityChangeServlrt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAnthorityChangeServlrt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * 根据userid查询单个用户信息
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
		request.getRequestDispatcher("/view/userinfo/userinfo_anthority_change.jsp").forward(request, response);
	}

	/**
	 * 获取信息修改权限
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*//获取页面信息
		String id=request.getParameter("userId");
		String Anthority=request.getParameter("userAnthority");
		System.out.println(id);
		UserInfo userInfo=new UserInfo();
		userInfo.setUserAnthority(Anthority);
		userInfo.setUserId(id);
		System.out.println(userInfo);*/
		UserInfo userInfo = RequestBeanUtils.requestToSimpleBean(request, UserInfo.class);
		//业务层
		UserInfoService service = new UserInfoServiceImpl();
		
		//返回判断值
		boolean isDo=service.changeAnthority(userInfo);
				
		if(isDo) {		  
			request.setAttribute("info", "修改权限成功");
		}else {
			request.setAttribute("info", "修改权限失败");
		}
		//查询
		UserInfo user=service.getUser(userInfo.getUserId());
		//设置参数
		request.setAttribute("user", user);
		
		request.getRequestDispatcher("/view/userinfo/userinfo_anthority_change.jsp").forward(request, response);
	}

}
