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
 * Servlet implementation class MeetingroomBespeakQueryServlet
 */
@WebServlet("/MeetingroomBespeakQueryServlet")
public class MeetingroomBespeakQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MeetingroomBespeakQueryServlet() {
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
		MeetingroomSetting bespeakInfo =  RequestBeanUtils.requestToSimpleBean(request, MeetingroomSetting.class);
		if(bespeakInfo==null) {
			bespeakInfo = new MeetingroomSetting();
		}
		BespeakService sevice = new BespeakServiceImpl();
		
		List<MeetingroomSetting> list = sevice.getAllMeetingroomSetting(bespeakInfo);
		//替换显示
		for(MeetingroomSetting me:list) {
			if("0".equals(me.getBespeakState())) me.setBespeakState("<a href='BespeakAuditingServlet?bespeakId="+me.getBespeakId()+"'>未审核</a>");
			if("1".equals(me.getBespeakState())) me.setBespeakState("通过");
			if("2".equals(me.getBespeakState())) me.setBespeakState("未通过");
		}
		
		request.setAttribute("list",list);
		
		request.getRequestDispatcher("/view/bespeak/meetingroom_bespeak_query.jsp").forward(request, response);
	}

}
