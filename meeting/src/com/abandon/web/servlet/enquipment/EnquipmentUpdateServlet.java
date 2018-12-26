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
import com.my.web.servlet.RequestBeanUtils;

/**
 * Servlet implementation class EnquipmentUpdateServlet
 */
@WebServlet("/EnquipmentUpdateServlet")
public class EnquipmentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnquipmentUpdateServlet() {
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
		EnquipmentInfo enquipmentInfo =  service.getEnquipmentInfo(id);
		
		request.setAttribute("enquipmentInfo", enquipmentInfo);
		
		request.getRequestDispatcher("/view/enzhequipment/enzhequipment_update.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收信息
		EnquipmentInfo enquipmentInfo = RequestBeanUtils.requestToSimpleBean(request,EnquipmentInfo.class );
		
		System.out.println(enquipmentInfo);
		
		//业务
		
		EnqiupmentService service =  new EnqiupmentServiceImpl();
		boolean isDo = service.updateEnquipmentInfo(enquipmentInfo);
		
		if(isDo) {
			request.setAttribute("info", "修改设备信息成功");
		}else {
			request.setAttribute("info", "修改设备信息失败");
		}
		
		
		this.doGet(request, response);
	}

}
