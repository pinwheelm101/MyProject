package com.abandon.web.servlet.bespeak;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.abandon.domain.MeetingroomSetting;

import com.abandon.service.BespeakService;
import com.abandon.service.impl.BespeakServiceImpl;
import com.my.web.servlet.RequestBeanUtils;

/**
 * Servlet implementation class MeetingroomBespeakAuditingServlet
 */
@WebServlet("/MeetingroomBespeakAuditingServlet")
public class MeetingroomBespeakAuditingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MeetingroomBespeakAuditingServlet() {
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
	
		if(bespeak==null) {
		 bespeak=new MeetingroomSetting();
		}
		//业务
		BespeakService mapper = new BespeakServiceImpl();
		//查询未审核信息
		bespeak.setBespeakState("0");
		List<MeetingroomSetting> list = mapper.getAllMeetingroomSetting(bespeak);
			
		for(MeetingroomSetting mm:list) {
				System.out.println(mm);
		}
		request.setAttribute("list", list);
				
		request.getRequestDispatcher("view/bespeak/meetingroom_bespeak_auditing.jsp").forward(request, response);
				
	}

}
