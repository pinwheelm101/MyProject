package com.abandon.web.servlet.enquipment;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abandon.domain.EnquipmentInfo;
import com.abandon.service.EnqiupmentService;
import com.abandon.service.impl.EnqiupmentServiceImpl;

/**
 * Servlet implementation class EnquipmentMainServlet
 */
@WebServlet("/EnquipmentMainServlet")
public class EnquipmentMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnquipmentMainServlet() {
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
		String name=request.getParameter("enquipmentName");
		EnquipmentInfo enquipmentInfo = new EnquipmentInfo();
		enquipmentInfo.setEnquipmentName(name);
		EnqiupmentService service = new EnqiupmentServiceImpl();
		//查询所有
		List<EnquipmentInfo> list = service.getAllEnquipmentInfo(enquipmentInfo);
		request.setAttribute("list", list);
				
		request.getRequestDispatcher("/view/enzhequipment/enzhequipment_main.jsp").forward(request, response);
	}

}
