package com.abandon.web.servlet.enquipment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abandon.domain.EnquipmentInfo;
import com.abandon.service.EnqiupmentService;
import com.abandon.service.impl.EnqiupmentServiceImpl;

/**
 * Servlet implementation class EnzhequipmentShowServlet
 */
@WebServlet("/EnzhequipmentShowServlet")
public class EnzhequipmentShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnzhequipmentShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取id
		String id =request.getParameter("enquipmentId");
		//业务 获取设备信息
		EnqiupmentService service = new EnqiupmentServiceImpl();
		EnquipmentInfo enquipmentInfo = service.gettTwoEnquipmentInfo(id);
		
		request.setAttribute("enInfo", enquipmentInfo);
		
		request.getRequestDispatcher("/view/enzhequipment/enzhequipment_show.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
