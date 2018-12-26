package com.abandon.web.servlet.bespeak;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abandon.domain.MeetingUserinfo;
import com.abandon.domain.MeetingroomInfo;
import com.abandon.domain.MeetingroomSetting;
import com.abandon.service.BespeakService;
import com.abandon.service.MeetingUserinfoService;
import com.abandon.service.MeetingroomService;
import com.abandon.service.impl.BespeakServiceImpl;
import com.abandon.service.impl.MeetingUserinfoServiceImpl;
import com.abandon.service.impl.MeetingroomServiceImpl;
import com.my.web.servlet.RequestBeanUtils;

/**
 * Servlet implementation class MeetingroomBespeakUpdateServlet
 */
@WebServlet("/MeetingroomBespeakUpdateServlet")
public class MeetingroomBespeakUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MeetingroomBespeakUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//拿到会议预约编号id
		String id = request.getParameter("bespeakId");
		//业务层
		//会议预约信息查询
		BespeakService service = new BespeakServiceImpl();
		MeetingroomSetting bespeak= service.getMeetingroomSetting(id);
		
		request.setAttribute("bespeak", bespeak);
		//会议室信息查询
		MeetingroomService meService= new MeetingroomServiceImpl();
		MeetingroomInfo info =new MeetingroomInfo();
		List<MeetingroomInfo> meetroomlist = meService.getAllMeetingroomInfo(info);
		
		request.setAttribute("meetroomlist", meetroomlist);
		//参加会议人员信息查询
		MeetingUserinfoService muService = new MeetingUserinfoServiceImpl();
		List<MeetingUserinfo> meuserlist = muService.getAllMeetingUserinfo(id);
		
		request.setAttribute("meuserlist", meuserlist);
		
		request.getRequestDispatcher("/view/bespeak/meetingroom_bespeak_update.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取会议预约信息
		MeetingroomSetting bespeak = RequestBeanUtils.requestToSimpleBean(request, MeetingroomSetting.class);
		//获取参加会议人员id
		String ids = request.getParameter("meuserIds");
		
		//业务层
		BespeakService service = new BespeakServiceImpl();
		boolean isDo = service.updatemeetingroomSetting(bespeak, ids);
		
		if(isDo) {
			request.setAttribute("info", "修改会议信息成功");			
		}else {
			request.setAttribute("info", "修改会议信息失败");
		}
		
		this.doGet(request, response);
	}

}
