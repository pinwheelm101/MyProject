package com.abandon.web.servlet.enquipment;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abandon.domain.EnquipmentInfo;
import com.abandon.domain.MeetingroomInfo;
import com.abandon.domain.UserInfo;
import com.abandon.service.EnqiupmentService;
import com.abandon.service.MeetingroomService;
import com.abandon.service.UserInfoService;
import com.abandon.service.impl.EnqiupmentServiceImpl;
import com.abandon.service.impl.MeetingroomServiceImpl;
import com.abandon.service.impl.UserInfoServiceImpl;
import com.my.web.servlet.RequestBeanUtils;

/**
 * Servlet implementation class EnquipmentListServlet
 */
@WebServlet("/EnquipmentListServlet")
public class EnquipmentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnquipmentListServlet() {
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
		//获取页面信息
		EnquipmentInfo enquipmentInfo = RequestBeanUtils.requestToSimpleBean(request, EnquipmentInfo.class);
		
		//设备信息业务
		EnqiupmentService service = new EnqiupmentServiceImpl();
		List<EnquipmentInfo> list = service.selectALLEnquipmentInfo(enquipmentInfo);
		
		request.setAttribute("list", list);
		
		//会议室信息业务
		MeetingroomService serviceM=  new MeetingroomServiceImpl();
		MeetingroomInfo info =new MeetingroomInfo();
		List<MeetingroomInfo> meetroomlist = serviceM.getAllMeetingroomInfo(info);
		
		request.setAttribute("meetroomlist", meetroomlist);
		
		//参加会议人员
		UserInfoService usService = new UserInfoServiceImpl();
		List<UserInfo> userInfolist =  usService.selectUser(null);
		
		request.setAttribute("userInfolist", userInfolist);
		
		
		request.getRequestDispatcher("/view/enzhequipment/enzhequipment_list.jsp").forward(request, response);
	}

}
