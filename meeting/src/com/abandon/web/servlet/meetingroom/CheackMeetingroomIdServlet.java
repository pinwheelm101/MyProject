package com.abandon.web.servlet.meetingroom;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.abandon.domain.MeetingroomInfo;
import com.abandon.service.MeetingroomService;
import com.abandon.service.impl.MeetingroomServiceImpl;

/**
 * Servlet implementation class CheackMeetingroomIdServlet
 */
@WebServlet("/CheackMeetingroomIdServlet")
public class CheackMeetingroomIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheackMeetingroomIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取熟悉
		
		String meetingroomId= request.getParameter("meetingroomId");
		System.out.println(meetingroomId);
		//业务
		response.setCharacterEncoding("utf-8");
		//设置响应类型
		response.setContentType("text/html");
		//拿到流
		PrintWriter out= response.getWriter();
		MeetingroomService service = new MeetingroomServiceImpl();
		
		MeetingroomInfo meInfo=  service.getMetingroomInfo(meetingroomId);
		
		if(meInfo!=null) {
			out.println("<font size=\"2\" style=\"color: red;\">编号已存在，请重新输入编号</font>");	
		}else {
			out.println("<font size=\"2\" style=\"color:green;\">编号可以使用</font>");
		}
	}

}
