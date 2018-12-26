 <%@ page language="java" contentType="text/html; charset=UTF-8" import="com.abandon.domain.UserInfo"
    pageEncoding="UTF-8"%>
<%
 //获取当前用户登录权限
UserInfo user = (UserInfo)session.getAttribute("UserInfo");
if(user!=null){
	//普通用户
	if("1".equals(user.getUserAnthority())){		
		%>
		<li><a href="javascript:void(0)" target="mainframe"
						class="dropdown-toggle"> <i class="icon-desktop"></i> <span
							class="menu-text"> 会议管理 </span> <b class="arrow icon-angle-down"></b>
					</a>

						<ul class="submenu">
							
                            <li><a href="MeetingroomBespeakServlet" target="mainframe"> <i
									class="icon-double-angle-right"></i> 会议室预约
							</a></li>
                            <li><a  href="MeetingroomBespeakListServlet" target="mainframe"> <i
									class="icon-double-angle-right"></i> 会议室预约修改
							</a></li>
                            
                               <li><a  href="MyMeetingroomBespeakQueryServlet"target="mainframe"> <i
									class="icon-double-angle-right"></i> 我的预约查询
							</a></li>
                              
				</ul>
				</li>
		<%
	}
	//普通管理员
	if("2".equals(user.getUserAnthority())){		
		%>
		<li><a href="javascript:void(0)" target="mainframe"
						class="dropdown-toggle"> <i class="icon-desktop"></i> <span
							class="menu-text"> 设备管理 </span> <b class="arrow icon-angle-down"></b>
					</a>

						<ul class="submenu">
                            <li><a href="view\enzhequipment\enzhequipment_add.jsp" target="mainframe"> <i
									class="icon-double-angle-right"></i> 添加设备
							</a></li>
                            <li><a href="EnquipmentMainServlet" target="mainframe"> <i
									class="icon-double-angle-right"></i> 设备管理
							</a></li>
                             <li><a href="EnquipmentListServlet" target="mainframe"> <i
									class="icon-double-angle-right"></i> 设备查询
							</a></li>
						
				</ul>
				</li>
					<li><a href="javascript:void(0)" target="mainframe"
						class="dropdown-toggle"> <i class="icon-desktop"></i> <span
							class="menu-text"> 会议室管理 </span> <b class="arrow icon-angle-down"></b>
					</a>

						<ul class="submenu">
							
                            <li><a href="MeetingroomAddServlet" target="mainframe"> <i
									class="icon-double-angle-right"></i> 添加会议室
							</a></li>
                            <li><a href="MeetingroomMainServlet" target="mainframe"> <i
									class="icon-double-angle-right"></i> 会议室管理
							</a></li>
                             <li><a href="MeetingroomListServlet" target="mainframe"> <i
									class="icon-double-angle-right"></i> 会议室查询
							</a></li>
						
				</ul>
				</li>
				<li><a href="javascript:void(0)" target="mainframe"
						class="dropdown-toggle"> <i class="icon-desktop"></i> <span
							class="menu-text"> 会议管理 </span> <b class="arrow icon-angle-down"></b>
					</a>

						<ul class="submenu">
							
                            <li><a href="MeetingroomBespeakServlet" target="mainframe"> <i
									class="icon-double-angle-right"></i> 会议室预约
							</a></li>
                            <li><a  href="MeetingroomBespeakListServlet" target="mainframe"> <i
									class="icon-double-angle-right"></i> 会议室预约修改
							</a></li>
                             <li><a  href="MeetingroomBespeakAuditingServlet" target="mainframe"> <i
									class="icon-double-angle-right"></i> 会议室预约审核
							</a></li>
                               <li><a  href="MyMeetingroomBespeakQueryServlet"target="mainframe"> <i
									class="icon-double-angle-right"></i> 我的预约查询
							</a></li>
                              <li><a  href="MeetingroomBespeakQueryServlet"target="mainframe"> <i
									class="icon-double-angle-right"></i> 预约查询
							</a></li>
							 <li><a  href="MymeetingroomBespeakAudqueryServlet"target="mainframe"> <i
									class="icon-double-angle-right"></i> 我的审核
							</a></li>
				</ul>
				</li>
						<li><a href="javascript:void(0)" target="mainframe"
						class="dropdown-toggle"> <i class="icon-desktop"></i> <span
							class="menu-text"> 系统管理 </span> <b class="arrow icon-angle-down"></b>
					</a>

						<ul class="submenu">
							
                            <li><a href="view/userinfo/userinfo_add.jsp" target="mainframe"> <i
									class="icon-double-angle-right"></i> 添加用户
							</a></li>
                            <li><a  href="userInfoListServlet" target="mainframe"> <i
									class="icon-double-angle-right"></i> 用户信息管理
							</a></li>
                             <li><a  href="UserInfoSelectServlet" target="mainframe"> <i
									class="icon-double-angle-right"></i> 查询用户信息
							</a></li>
                            
						
				</ul>
				</li>
		<%
	}
	//系统管理员
	if("3".equals(user.getUserAnthority())){		
		%>
		<li><a href="javascript:void(0)" target="mainframe"
						class="dropdown-toggle"> <i class="icon-desktop"></i> <span
							class="menu-text"> 设备管理 </span> <b class="arrow icon-angle-down"></b>
					</a>

						<ul class="submenu">
                            <li><a href="view\enzhequipment\enzhequipment_add.jsp" target="mainframe"> <i
									class="icon-double-angle-right"></i> 添加设备
							</a></li>
                            <li><a href="EnquipmentMainServlet" target="mainframe"> <i
									class="icon-double-angle-right"></i> 设备管理
							</a></li>
                             <li><a href="EnquipmentListServlet" target="mainframe"> <i
									class="icon-double-angle-right"></i> 设备查询
							</a></li>
						
				</ul>
				</li>
					<li><a href="javascript:void(0)" target="mainframe"
						class="dropdown-toggle"> <i class="icon-desktop"></i> <span
							class="menu-text"> 会议室管理 </span> <b class="arrow icon-angle-down"></b>
					</a>

						<ul class="submenu">
							
                            <li><a href="MeetingroomAddServlet" target="mainframe"> <i
									class="icon-double-angle-right"></i> 添加会议室
							</a></li>
                            <li><a href="MeetingroomMainServlet" target="mainframe"> <i
									class="icon-double-angle-right"></i> 会议室管理
							</a></li>
                             <li><a href="MeetingroomListServlet" target="mainframe"> <i
									class="icon-double-angle-right"></i> 会议室查询
							</a></li>
						
				</ul>
				</li>
				<li><a href="javascript:void(0)" target="mainframe"
						class="dropdown-toggle"> <i class="icon-desktop"></i> <span
							class="menu-text"> 会议管理 </span> <b class="arrow icon-angle-down"></b>
					</a>

						<ul class="submenu">
							
                            <li><a href="MeetingroomBespeakServlet" target="mainframe"> <i
									class="icon-double-angle-right"></i> 会议室预约
							</a></li>
                            <li><a  href="MeetingroomBespeakListServlet" target="mainframe"> <i
									class="icon-double-angle-right"></i> 会议室预约修改
							</a></li>
                             <li><a  href="MeetingroomBespeakAuditingServlet" target="mainframe"> <i
									class="icon-double-angle-right"></i> 会议室预约审核
							</a></li>
                               <li><a  href="MyMeetingroomBespeakQueryServlet"target="mainframe"> <i
									class="icon-double-angle-right"></i> 我的预约查询
							</a></li>
                              <li><a  href="MeetingroomBespeakQueryServlet"target="mainframe"> <i
									class="icon-double-angle-right"></i> 预约查询
							</a></li>
							 <li><a  href="MymeetingroomBespeakAudqueryServlet"target="mainframe"> <i
									class="icon-double-angle-right"></i> 我的审核
							</a></li>
				</ul>
				</li>
						<li><a href="javascript:void(0)" target="mainframe"
						class="dropdown-toggle"> <i class="icon-desktop"></i> <span
							class="menu-text"> 系统管理 </span> <b class="arrow icon-angle-down"></b>
					</a>

						<ul class="submenu">
							
                            <li><a href="view/userinfo/userinfo_add.jsp" target="mainframe"> <i
									class="icon-double-angle-right"></i> 添加用户
							</a></li>
                            <li><a  href="userInfoListServlet" target="mainframe"> <i
									class="icon-double-angle-right"></i> 用户信息管理
							</a></li>
                             <li><a  href="UserInfoSelectServlet" target="mainframe"> <i
									class="icon-double-angle-right"></i> 查询用户信息
							</a></li>
                              <li><a  href="UserAnthorityServlet"  target="mainframe"> <i
									class="icon-double-angle-right"></i> 权限变更
							</a></li>
						
				</ul>
				</li>
		<%
	}
	//审核人员
	if("4".equals(user.getUserAnthority())){		
		%>
		
					
				<li><a href="javascript:void(0)" target="mainframe"
						class="dropdown-toggle"> <i class="icon-desktop"></i> <span
							class="menu-text"> 会议管理 </span> <b class="arrow icon-angle-down"></b>
					</a>

						<ul class="submenu">
							
                           
                             <li><a  href="MeetingroomBespeakAuditingServlet" target="mainframe"> <i
									class="icon-double-angle-right"></i> 会议室预约审核
							</a></li>
                               
                              <li><a  href="MeetingroomBespeakQueryServlet"target="mainframe"> <i
									class="icon-double-angle-right"></i> 预约查询
							</a></li>
							 <li><a  href="MymeetingroomBespeakAudqueryServlet"target="mainframe"> <i
									class="icon-double-angle-right"></i> 我的审核
							</a></li>
				</ul>
				</li>
						
		<%
	}
}
 
 %>
 