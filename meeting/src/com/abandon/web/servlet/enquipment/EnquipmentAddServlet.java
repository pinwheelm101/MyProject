package com.abandon.web.servlet.enquipment;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.abandon.domain.EnquipmentInfo;
import com.abandon.domain.UserInfo;
import com.abandon.service.EnqiupmentService;
import com.abandon.service.impl.EnqiupmentServiceImpl;
import com.my.web.servlet.RequestBeanUtils;

/**
 * Servlet implementation class EnquipmentAddServlet
 */
@WebServlet("/EnquipmentAddServlet")
public class EnquipmentAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnquipmentAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取数据
		EnquipmentInfo enquipment = RequestBeanUtils.requestToBean(request, EnquipmentInfo.class);
		
		//业务
		EnqiupmentService service = new EnqiupmentServiceImpl();
		
		//取出用户信息从session中
		HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo)session.getAttribute("UserInfo");
		//获取采购时间并设置类型
		String procurementDateTime = request.getParameter("procurementDateTime");
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date =sdf.parse(procurementDateTime);
			if(enquipment!=null) {
				enquipment.setProcurementTime(date);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//放入当前用户id
		if( enquipment!=null&&userInfo!=null) {
			enquipment.setUserId(userInfo.getUserId());
		}
		//添加设备信息
		boolean isDo = service.addEqiument(enquipment);
		if(isDo) {
			request.setAttribute("info", "设备信息添加成功");
		}else {
			request.setAttribute("info", "设备信息添加失败");
		}
			
		request.getRequestDispatcher("/view/enzhequipment/enzhequipment_add.jsp").forward(request, response);
	}

}
