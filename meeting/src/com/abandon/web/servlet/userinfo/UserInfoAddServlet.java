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

/**
 * 用户注册添加
 */
@WebServlet("/UserInfoAdd")
@MultipartConfig
public class UserInfoAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoAddServlet() {
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
		//获取添加用户信息
		//String userUrl=request.getParameter("userUrl");
		
		String userId=request.getParameter("userId");
		String userPw=request.getParameter("userPw");
		String userName=request.getParameter("userName");
		String userSex=request.getParameter("userSex");
		String userPhone=request.getParameter("userPhone");
		//转型方报错处理
		Integer userAge=0;
		try {
			if(userAge!=null && !"".equals(userAge)) {
				userAge = (Integer.parseInt(request.getParameter("userAge")));
			}			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		String userBeizhu=request.getParameter("userBeizhu");
		//添加信息
		UserInfo user=new UserInfo();
		user.setUserId(userId);
		user.setUserPw(userPw);
		user.setUserName(userName);
		user.setUserSex(userSex);
		user.setUserAge(userAge);
		user.setUserPhone(userPhone);
		user.setUserBeizhu(userBeizhu);
		
		//System.out.println(user);
		
		//上传文件操作  上传图片
		Part part=request.getPart("userUrl");
		//获取存储上传图片文件夹upload更目录 
		String root=request.getServletContext().getRealPath("\\upload");
		//获取上传文件完整路径
		String name=part.getHeader("content-disposition");
		//截取文件名		
		if(name.lastIndexOf(".")!=-1) {
			//截取文件名
			String ext=name.substring(name.lastIndexOf("."),name.length()-1);
			//完整url格式 root+userid+ext
			String rUrl=root+"\\"+userId+ext;
			//数据库使用url
			String url="upload\\" + userId + ext; 
			//添加数据库使用url
			user.setUserUrl(url);
//			System.out.println(url);
//			System.out.println(user);
			
			part.write(rUrl);
		}	
	
		
		//业务层处理
		UserInfoService service=new UserInfoServiceImpl();
		boolean isAdd=service.add(user);
		if(isAdd) {
			//提示信息
			request.setAttribute("info","用户添加成功");
		}else {
			request.setAttribute("info", "用户添加失败");
		}

		//转发回去
		request.getRequestDispatcher("/view/userinfo/userinfo_add.jsp").forward(request, response);
	}

}
