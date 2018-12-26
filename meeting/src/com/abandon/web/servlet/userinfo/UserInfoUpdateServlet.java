package com.abandon.web.servlet.userinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.abandon.domain.UserInfo;
import com.abandon.service.UserInfoService;
import com.abandon.service.impl.UserInfoServiceImpl;
import com.my.web.servlet.RequestBeanUtils;

/**
 * 删改用户信息操作
 */
@WebServlet("/UserInfoUpdateServlet")
@MultipartConfig
public class UserInfoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//拿到id
		String id=request.getParameter("userId");
		
		System.out.println(id);
		
		
		//业务处理
		UserInfoService service=new UserInfoServiceImpl();
		//查询信息并接收
		UserInfo user=service.getUser(id);
		//设置参数
		request.setAttribute("user", user);						
		//跳转
		request.getRequestDispatcher("/view/userinfo/userinfo_update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//从request body中获取数据并存放到对象中 此方法需将bean中的属性名与页面中name对应
		UserInfo userInfo = RequestBeanUtils.requestToSimpleBean(request, UserInfo.class);
		System.out.println(userInfo);
		
		//业务处理
		UserInfoService service=new UserInfoServiceImpl();
		//上传图片操作
		Part part=request.getPart("userUrl");
		//获取存储上传图片文件夹upload更目录 
		String root=request.getServletContext().getRealPath("\\upload");
		//获取上传文件路径头文明
		String name=part.getHeader("content-disposition");
		//截取文件名		
		if(name.lastIndexOf(".")!=-1) {
			//截取文件名
			String ext=name.substring(name.lastIndexOf("."),name.length()-1);
			//完整url格式 root+userid+ext
			String rUrl=root+"\\"+ userInfo.getUserId() +ext;
			//数据库使用url
			String url="upload\\" + userInfo.getUserId() + ext; 
			//添加数据库使用url
			userInfo.setUserUrl(url);
			
			part.write(rUrl);
		}	
			
		
		//返回判断值
		boolean isDo=service.updateUser(userInfo);
		
		if(isDo) {
			//查询信息并接收
			UserInfo user=service.getUser(userInfo.getUserId());
			//设置参数
			request.setAttribute("user", user);		
			
			request.setAttribute("info", "修改用户信息成功");
		}else {
			request.setAttribute("info", "修改用户信息失败");
		}
		
		request.getRequestDispatcher("/view/userinfo/userinfo_update.jsp").forward(request, response);
	}

}
