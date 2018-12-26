package com.abandon.web.servlet.bespeak;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.abandon.domain.MeetingroomInfo;
import com.abandon.domain.MeetingroomSetting;
import com.abandon.domain.UserInfo;
import com.abandon.service.BespeakService;
import com.abandon.service.MeetingroomService;
import com.abandon.service.UserInfoService;
import com.abandon.service.impl.BespeakServiceImpl;
import com.abandon.service.impl.MeetingroomServiceImpl;
import com.abandon.service.impl.UserInfoServiceImpl;
import com.my.web.servlet.RequestBeanUtils;

/**
 * Servlet implementation class MeetingroomBespeakServlet
 */
@WebServlet("/MeetingroomBespeakServlet")
public class MeetingroomBespeakServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MeetingroomBespeakServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//会议室信息查询
		MeetingroomService service = new MeetingroomServiceImpl();
		MeetingroomInfo info =new MeetingroomInfo();
		List<MeetingroomInfo> meetroomlist = service.getAllMeetingroomInfo(info);
		
		request.setAttribute("meetroomlist", meetroomlist);
		
		//用户信息查询 
		UserInfoService userService = new UserInfoServiceImpl();
		List<UserInfo> userlist = userService.selectUser(null);
		//System.out.println(userlist);
		request.setAttribute("userlist", userlist);
		
		
		//转发
		request.getRequestDispatcher("/view/bespeak/meetingroom_bespeak.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//拿到会议室预约页面信息
		MeetingroomSetting bespeak = RequestBeanUtils.requestToSimpleBean(request, MeetingroomSetting.class);
		System.out.println("会议室预约信息："+bespeak);
		//拿到时间数据
		/*Date stratTime =new Date();
		Date endTime = new Date();
		String stratTimes =request.getParameter("stratTimeD");
		String endTimeDs = request.getParameter("endTimeD");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			stratTime = sdf.parse(stratTimes);
			endTime=sdf.parse(endTimeDs);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		bespeak.setStratTime(stratTime);
		bespeak.setEndTime(endTime);
		System.out.println(bespeak);*/
		
		//参加会议人员信息
		String userIds =request.getParameter("userIds");
		System.out.println("参加会议人员"+userIds);
		
		//当前登录用户信息（预约人）
		HttpSession session = request.getSession();
		UserInfo user = (UserInfo)session.getAttribute("UserInfo");
		System.out.println("当前登录用户："+user.getUserId());
		//放如预约信息中
		bespeak.setUserId(user.getUserId());
		//业务信息处理
		BespeakService service = new BespeakServiceImpl();
		
		boolean isDo = service.AddBespeakInfo(bespeak, userIds);
		
		if(isDo) {
			request.setAttribute("info", "会议预约信息添加成功");
		}else {
			request.setAttribute("info", "会议预约信息添加失败");
		}
		
		//request.getRequestDispatcher("view/bespeak/meetingroom_bespeak.jsp").forward(request, response);
		this.doGet(request, response);
	}
	
}
