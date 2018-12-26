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
import com.my.web.servlet.RequestBeanUtils;

/**
 * Servlet implementation class MyMeetingroomBespeakQueryServlet
 */
@WebServlet("/MyMeetingroomBespeakQueryServlet")
public class MyMeetingroomBespeakQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyMeetingroomBespeakQueryServlet() {
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
		//获取页面查询信息、
		MeetingroomSetting bespeak =  RequestBeanUtils.requestToSimpleBean(request, MeetingroomSetting.class);
		if(bespeak==null)  bespeak = new MeetingroomSetting();
		
		//业务处理
		BespeakService service = new BespeakServiceImpl();
		//放入当前用户id 申请人
		HttpSession session =request.getSession();
		UserInfo user = (UserInfo) session.getAttribute("UserInfo");
		bespeak.setUserId(user.getUserId());
		//查询该用户所预约信息
		List<MeetingroomSetting> list = service.getAllMeetingroomSetting(bespeak);
		for(MeetingroomSetting me:list) {
			if("0".equals(me.getBespeakState())) me.setBespeakState("未审核");
			if("1".equals(me.getBespeakState())) me.setBespeakState("通过");
			if("2".equals(me.getBespeakState())) me.setBespeakState("未通过");
		}
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/view/bespeak/mymeetingroom_bespeak_query.jsp").forward(request, response);
 	}

}
