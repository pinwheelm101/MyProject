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
 * Servlet implementation class MeetingroomBespeakListServlet
 */
@WebServlet("/MeetingroomBespeakListServlet")
public class MeetingroomBespeakListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MeetingroomBespeakListServlet() {
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
		
		//获取信息
		MeetingroomSetting bespeak = RequestBeanUtils.requestToSimpleBean(request, MeetingroomSetting.class);
		
		//业务
		BespeakService mapper = new BespeakServiceImpl();
		//只查询当前用户信息
		HttpSession session = request.getSession();
		UserInfo user = (UserInfo)session.getAttribute("UserInfo");
		bespeak.setUserId(user.getUserId());
		bespeak.setBespeakState("0");
		List<MeetingroomSetting> list = mapper.getAllMeetingroomSetting(bespeak);
		//去重
		// List list=belist.stream().distinct().collect(Collectors.toList());
		
		for(MeetingroomSetting mm:list) {
			System.out.println(mm);
		}
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("view/bespeak/meetingroom_bespeak_list.jsp").forward(request, response);
		
		
			
	}

}
