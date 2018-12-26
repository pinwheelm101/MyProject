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
 * Servlet implementation class MeetingroomUpdateServlet
 */
@WebServlet("/MeetingroomUpdateServlet")
public class MeetingroomUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MeetingroomUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取会议室id
		
		String id = request.getParameter("meetingroomId");
	
		//设备信息业务处理
		EnqiupmentService service= new EnqiupmentServiceImpl();
		//获取此会议室中设备信息
		List<EnquipmentInfo> list=service.getMroomIdEnquipmentInfo(id);
		
		request.setAttribute("enlist", list);
		//获取空闲设备信息				
		List<EnquipmentInfo> islist=service.getNotUseEnquipmentInfo();
						
		request.setAttribute("noenlist", islist);
		
		//获取会议室信息业务
		MeetingroomService mService = new MeetingroomServiceImpl();
		
		MeetingroomInfo meInfo = mService.getMetingroomInfo(id);
		request.setAttribute("meInfo", meInfo);
		
		request.getRequestDispatcher("/view/meetingroom/meetingroom_update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//从页面中获取会议室信息
		MeetingroomInfo meetingroomInfo =RequestBeanUtils.requestToSimpleBean(request,MeetingroomInfo.class );
		//获取会议室id 并放入
		String id = request.getParameter("meetingroomId");
		MeetingroomInfo meInfo = new MeetingroomInfo();
		meInfo.setMeetingroomId((Integer.parseInt(id)));
		//获取设备信息id
		String enIds = request.getParameter("enquipmentIds");
		
		//会议室业务信息处理
		MeetingroomService service = new MeetingroomServiceImpl();
		//更新会议室信息 并更新设备信息
		boolean isDo = service.updateMetingroomInfo(meetingroomInfo, enIds);
		
		if(isDo) {
			request.setAttribute("info", "会议室信息修改成功");
		}else {
			request.setAttribute("info", "会议室信息修改失败");
		}
		
		this.doGet(request, response);
	}

}
