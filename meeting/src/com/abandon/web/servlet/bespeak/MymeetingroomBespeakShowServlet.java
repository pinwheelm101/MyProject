package com.abandon.web.servlet.bespeak;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abandon.domain.MeetingUserinfo;
import com.abandon.domain.MeetingroomSetting;
import com.abandon.domain.UserInfo;
import com.abandon.service.BespeakService;
import com.abandon.service.MeetingUserinfoService;
import com.abandon.service.UserInfoService;
import com.abandon.service.impl.BespeakServiceImpl;
import com.abandon.service.impl.MeetingUserinfoServiceImpl;
import com.abandon.service.impl.UserInfoServiceImpl;

/**
 * Servlet implementation class MymeetingroomBespeakShowServlet
 */
@WebServlet("/MymeetingroomBespeakShowServlet")
public class MymeetingroomBespeakShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MymeetingroomBespeakShowServlet() {
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
		//获取会议预约信息id
		String id = request.getParameter("bespeakId");
		
		//业务处理 
		BespeakService service  = new BespeakServiceImpl();
		MeetingroomSetting bespeak = service.getMeetingroomSetting(id);
		//查询转换审核人姓名
		UserInfoService uService = new UserInfoServiceImpl();
		UserInfo user =  uService.getUser(bespeak.getAuditingMan());		
		if(user!=null)
		bespeak.setAuditingMan(user.getUserName());
				
		request.setAttribute("bespeak", bespeak);
		
		//查询参加会议人员名单
		MeetingUserinfoService meService = new MeetingUserinfoServiceImpl();
		List<MeetingUserinfo> mulist  =meService.getAllMeetingUserinfo(id);
		
		request.setAttribute("mulist", mulist);
		
		request.getRequestDispatcher("/view/bespeak/mymeetingroom_bespeak_show.jsp").forward(request, response);
		
	}

}
