package com.abandon.web.servlet.enquipment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abandon.service.EnqiupmentService;
import com.abandon.service.impl.EnqiupmentServiceImpl;

/**
 * Servlet implementation class EnquipmentDeleteServlet
 */
@WebServlet("/EnquipmentDeleteServlet")
public class EnquipmentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnquipmentDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("enquipmentId");
		
		//业务
		EnqiupmentService service = new EnqiupmentServiceImpl();
		boolean isDo = service.dateEnquipmentInfo(id);
		
		if(isDo) {
			request.setAttribute("info", "设备信息删除成功");
		}else {
			request.setAttribute("info", "设备信息删除失败");
		}
		
		request.getRequestDispatcher("EnquipmentMainServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
