package com.abandon.web.servlet.bespeak;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.abandon.domain.MeetingroomSetting;
import com.abandon.domain.UserInfo;
import com.abandon.service.BespeakService;
import com.abandon.service.impl.BespeakServiceImpl;

/**
 * Servlet implementation class stagingServlet
 */
@WebServlet("/stagingServlet")
public class stagingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public stagingServlet() {
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
		//获取当前用户登录信息
		HttpSession session = request.getSession();
		UserInfo user = (UserInfo)session.getAttribute("UserInfo");
		
		BespeakService service  = new BespeakServiceImpl();
		
		MeetingroomSetting bespeak = new MeetingroomSetting();
		//放入查询条件 当前用户申请且未审核
		bespeak.setUserId(user.getUserId());
		bespeak.setBespeakState("0");
		List<MeetingroomSetting> mylist = service.getAllMeetingroomSetting(bespeak);
		
		request.setAttribute("mylist", mylist);
		//放入查询条件 当前用户申请且审核通过
		MeetingroomSetting bespeak1 = new MeetingroomSetting();
		bespeak1.setUserId(user.getUserId());
		bespeak1.setBespeakState("1");
		List<MeetingroomSetting> myyeslist = service.getAllMeetingroomSetting(bespeak1);
		
		request.setAttribute("myyeslist", myyeslist);
		//放入查询条件 当前用户申请且审核不通过
		MeetingroomSetting bespeak2 = new MeetingroomSetting();
		bespeak2.setUserId(user.getUserId());
		bespeak2.setBespeakState("2");
		List<MeetingroomSetting> mynolist = service.getAllMeetingroomSetting(bespeak2);
		
		request.setAttribute("mynolist", mynolist);
		
		//查询未审核的预约全部
		MeetingroomSetting bespeak3 = new MeetingroomSetting();
		//bespeak3.setUserId(user.getUserId());
		bespeak3.setBespeakState("0");
		List<MeetingroomSetting> noaanditlist = service.getAllMeetingroomSetting(bespeak3);
		
		request.setAttribute("noaanditlist", noaanditlist);
		
		//查询所有状态不为0的预约 （当前用户审核过的）
		MeetingroomSetting bespeak4 = new MeetingroomSetting();
		bespeak4.setAuditingMan(user.getUserId());
		bespeak4.setMark("-1");
		List<MeetingroomSetting> yesaanditlist = service.getAllMeetingroomSetting(bespeak4);
		
		request.setAttribute("yesaanditlist", yesaanditlist);
		
		request.getRequestDispatcher("/staging.jsp").forward(request, response);
	}

}
