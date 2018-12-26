package com.abandon.web.servlet.meetingroom;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abandon.domain.EnquipmentInfo;
import com.abandon.domain.MeetingroomInfo;
import com.abandon.service.EnqiupmentService;
import com.abandon.service.MeetingroomService;
import com.abandon.service.impl.EnqiupmentServiceImpl;
import com.abandon.service.impl.MeetingroomServiceImpl;

/**
 * Servlet implementation class MeetingroomDeleteServlet
 */
@WebServlet("/MeetingroomDeleteServlet")
public class MeetingroomDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MeetingroomDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取会议室id
		String id = request.getParameter("meetingroomId");
	
		
		//会议室业务 
		MeetingroomService service = new MeetingroomServiceImpl();
		
		boolean isDo = service.deleteMetingroomInfo(id);
		if(isDo) {
			request.setAttribute("info", "删除会议室信息成功");
		}else {
			request.setAttribute("info", "删除会议室信息失败");
		}				
		
		
		
		request.getRequestDispatcher("MeetingroomMainServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
