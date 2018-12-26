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
import com.my.web.servlet.RequestBeanUtils;

/**
 * Servlet implementation class MeetingroomServlet
 */
@WebServlet("/MeetingroomAddServlet")
public class MeetingroomAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MeetingroomAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设备信息业务处理
		EnqiupmentService service= new EnqiupmentServiceImpl();
		List<EnquipmentInfo> list=service.getNotUseEnquipmentInfo();
		System.out.println(list);
		request.setAttribute("enlist", list);
		
		request.getRequestDispatcher("/view/meetingroom/meetingroom_add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//从页面获取信息
		MeetingroomInfo meetingroomInfo =RequestBeanUtils.requestToSimpleBean(request,MeetingroomInfo.class );
		//获取设备编号
		String enIds = request.getParameter("enquipmentIds");
//		System.out.println(meetingroomInfo);
//		System.out.println(id);
		//会议室信息业务处理
		MeetingroomService meetingroomService = new MeetingroomServiceImpl();
		boolean isDo = meetingroomService.AddMetingroomInfo(meetingroomInfo,enIds);
		
		if(isDo) {
			request.setAttribute("info","会议室信息添加成功" );
		}else {
			request.setAttribute("info", "会议室信息添加失败");
		}
		
		request.getRequestDispatcher("/view/meetingroom/meetingroom_add.jsp").forward(request, response);
	}

}
