package com.abandon.web.servlet.userinfo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abandon.domain.UserInfo;
import com.abandon.service.UserInfoService;
import com.abandon.service.impl.UserInfoServiceImpl;

/**
 * Servlet implementation class UserInfoListServlet
 */
@WebServlet("/userInfoListServlet")
public class UserInfoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//点击过来先查询
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取查询字段
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		UserInfo  user=new UserInfo();
		System.out.println(name+sex);
		//放入查询字段
		user.setUserName(name);
		user.setUserSex(sex);
		//业务接口
		UserInfoService service=new UserInfoServiceImpl();
		
		List<UserInfo> list=service.selectUser(user);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/view/userinfo/userinfo_list.jsp").forward(request, response);
	}

}
