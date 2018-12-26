package com.abandon.web.servlet.meetingroom;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abandon.domain.MeetingroomInfo;
import com.abandon.service.MeetingroomService;
import com.abandon.service.impl.MeetingroomServiceImpl;
import com.my.web.servlet.RequestBeanUtils;

/**
 * Servlet implementation class MeetingroomListServlet
 */
@WebServlet("/MeetingroomListServlet")
public class MeetingroomListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MeetingroomListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//先做查询
		MeetingroomService service = new MeetingroomServiceImpl();
		MeetingroomInfo info =new MeetingroomInfo();
		List<MeetingroomInfo> list = service.getAllMeetingroomInfo(info);
				
		request.setAttribute("list", list);
				
		//转发
		request.getRequestDispatcher("/view/meetingroom/meetingroom_list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取页面信息（会议室名称）
		MeetingroomInfo mrInfo=RequestBeanUtils.requestToSimpleBean(request, MeetingroomInfo.class);
		//业务层
		MeetingroomService service = new MeetingroomServiceImpl();
		//查询会议室信息
		List<MeetingroomInfo> list=service.getAllMeetingroomInfo(mrInfo);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/view/meetingroom/meetingroom_list.jsp").forward(request, response);
		
	}

}
