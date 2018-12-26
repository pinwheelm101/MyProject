package com.abandon.web.filter;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.abandon.domain.UserInfo;

/**
 * 防止非法登录
 */
@WebFilter(filterName="LofinFilter",urlPatterns= {"/*"})
public class LofinFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LofinFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//转化类型以获取session
		HttpServletRequest httpRequest=(HttpServletRequest)request;
		//获取session
		HttpSession session= httpRequest.getSession();
		//获取用户信息
		UserInfo user=(UserInfo)session.getAttribute("UserInfo");
		//获取url
		String url=httpRequest.getRequestURI();
		//剔除样式文件
		if(url.contains("/assets/")) {
			chain.doFilter(request, response);
		}else if(url.contains("/css/")) {
			chain.doFilter(request, response);
		}else if(url.contains("/login.jsp")) {
				chain.doFilter(request, response);
		}else if(url.contains("/font/")) {
			chain.doFilter(request, response);
		}else if(url.contains("/images/")) {
			chain.doFilter(request, response);
		}else if(url.contains("/js/")) {
			chain.doFilter(request, response);
		}else if(url.contains("/loginServlet")) {
			chain.doFilter(request, response);
		}else if(user!=null) {
			chain.doFilter(request, response);
		}else {
			httpRequest.getRequestDispatcher("/login_info.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
