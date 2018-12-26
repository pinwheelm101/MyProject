package com.abandon.web.servlet.userinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abandon.service.UserInfoService;
import com.abandon.service.impl.UserInfoServiceImpl;

/**
 * Servlet implementation class UserInfoDeleteServlet
 */
@WebServlet("/UserInfoDeleteServlet")
public class UserInfoDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id= request.getParameter("userId");
		System.out.println(id);
		//业务层
		UserInfoService service=new UserInfoServiceImpl();
		boolean isDo= service.deleteUser(id); 
		
		if(isDo) {
			request.setAttribute("info", "删除成功");
		} else {
			request.setAttribute("info", "删除失败");
		}
		 
		request.getRequestDispatcher("/userInfoListServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
