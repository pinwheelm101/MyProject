package com.abandon.web.servlet.bespeak;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.abandon.domain.MeetingUserinfo;
import com.abandon.domain.MeetingroomSetting;
import com.abandon.domain.UserInfo;
import com.abandon.service.BespeakService;
import com.abandon.service.MeetingUserinfoService;
import com.abandon.service.impl.BespeakServiceImpl;
import com.abandon.service.impl.MeetingUserinfoServiceImpl;
import com.my.web.servlet.RequestBeanUtils;

/**
 * Servlet implementation class BespeakAuditingServlet
 */
@WebServlet("/BespeakAuditingServlet")
public class BespeakAuditingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BespeakAuditingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取预约id 
		String id =request.getParameter("bespeakId");
		//业务  、
		//查询会议预约信息
		BespeakService bService = new BespeakServiceImpl();		 
		MeetingroomSetting bespeak = bService.getMeetingroomSetting(id);
		
		request.setAttribute("bespeak", bespeak);
		//查询参加会议人员
		MeetingUserinfoService  meService = new MeetingUserinfoServiceImpl();
		List<MeetingUserinfo> mulist = meService.getAllMeetingUserinfo(id);
		
		request.setAttribute("mulist", mulist);
		
		
		request.getRequestDispatcher("/view/bespeak/bespeak_auditing.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取页面预约信息
		MeetingroomSetting bespeak = RequestBeanUtils.requestToSimpleBean(request,MeetingroomSetting.class );
		//获取当前用户信息
		HttpSession session = request.getSession();
		UserInfo user = (UserInfo) session.getAttribute("UserInfo");
		
		//业务
		bespeak.setAuditingMan(user.getUserId());
		BespeakService service = new BespeakServiceImpl();
		
		boolean isDo = service.updateBespeakAuditing(bespeak);
		
		if(isDo) {
			request.setAttribute("info", "添加审核信息成功");			
		}else {
			request.setAttribute("info", "添加审核信息失败");	
		}
		
		this.doGet(request, response);
	}

}
