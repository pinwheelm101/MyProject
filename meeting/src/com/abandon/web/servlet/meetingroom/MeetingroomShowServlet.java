package com.abandon.web.servlet.meetingroom;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abandon.domain.EnquipmentInfo;
import com.abandon.domain.MeetingroomInfo;
import com.abandon.service.EnqiupmentService;
import com.abandon.service.MeetingroomService;
import com.abandon.service.impl.EnqiupmentServiceImpl;
import com.abandon.service.impl.MeetingroomServiceImpl;

/**
 * Servlet implementation class MeetingroomShowServlet
 */
@WebServlet("/MeetingroomShowServlet")
public class MeetingroomShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MeetingroomShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取id
		String id = request.getParameter("meetingroomId");
		//会议室信息业务
		MeetingroomService service = new MeetingroomServiceImpl();
		MeetingroomInfo meInfo =  service.getMetingroomInfo(id);
		System.out.println(meInfo);
		request.setAttribute("meinfo", meInfo);
		
		//设备信息业务
		EnqiupmentService enService = new EnqiupmentServiceImpl();
		List<EnquipmentInfo> enList = enService.getMroomIdEnquipmentInfo(id);
		
		request.setAttribute("enList", enList);
		
		
		//装发
		request.getRequestDispatcher("/view/meetingroom/meetingroom_show.jsp").forward(request, response);
	}

}
