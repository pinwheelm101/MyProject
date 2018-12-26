<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String path=request.getContextPath();
	//获得项目地址，如“http://localhost:8080/test/”,赋值给basePath
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>会议室管理</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.css" rel="stylesheet"/>
<script src="js/jquery-1.9.0.min.js"></script>
<script src="js/bootstrap.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		
		$("#xuanzhe").click(function(){
			var userIdstr = "";//用户id
			var userNamestr = "";//用户姓名
			$('input[name="uerqu"]:checked').each(function(){
				var uerqu = $(this).val().split(",");
				userIdstr+=uerqu[0]+",";
				userNamestr+=uerqu[1]+",";
				
			});
			$("#userIds").val(userIdstr);
			$("#info").html(userNamestr);
		});	
		
	});
	// 字符串转日期
	function formatDate(value) {
	    var date = new Date(value).format("yyyy-MM-dd HH:mm");
	    if (date == "1970-01-01 08:00")
	        return "--";
	    else
	        return date;
	}
	
</script>

</head>

<body>
<div  >
	<h4 class="page-header">会议室预约<small>预约</small></h4>
    <div style=" color: red;" >${info }</div>
    <form class="form-horizontal" action="MeetingroomBespeakServlet" method="post">
       <input type="text"  name="userIds" id="userIds" value=""/>
       <div class="form-group"> 
        	<label  class="col-xs-2 control-label " > 预约编号</label>
            <div class="col-xs-4">
            	<input type="text" name="bespeakId"  placeholder="请输预约编号"  class="form-control" />
             </div>
        </div>
       <div class="form-group"> 
        	<label  class="col-xs-2 control-label " > 会议名称</label>
            <div class="col-xs-4">
            	<input type="text" name="meetingName"  placeholder="请输会议名称"  class="form-control" />
             </div>
        </div>
    	<div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 会议室 </label>
            <div class="col-xs-3">
            		<select class="form-control" name="meetingroomId">                    	
                        <option value="">请选择</option>
                        <c:forEach items="${meetroomlist}" var="meet">
   						<option value="${meet.meetingroomId}">${meet.meetingroomName}</option>
   						</c:forEach>
                    </select>
             </div>
        </div>
        <div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 开始时间</label>
            <div class="col-xs-4">
            	<input type="date" name="stratTime" id="stratTime"   class="form-control" />
             </div>
        </div>
        <div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 结束时间</label>
            <div class="col-xs-4">
            	<input type="date" name="endTime" id="endTime" placeholder="请输会议结束时间"  class="form-control" />
             </div>
        </div>
        <div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 会议人员</label>
            <div class="col-xs-4">
            	<button class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                  请选择
                </button>

                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                    
                     <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">用户信息</h4>
                  </div>
                  <div class="modal-body">
                   <table class="table table-striped">
                <thead>
                <tr>
                <th></th>
                    <th>用户编号</th>
                    <th>用户姓名</th>
                    <th>用户性别</th>
              		<th>用户年龄</th>
                </tr>
                </thead>
                <tbody>
                  <c:forEach items="${userlist }" var="user">
                    <tr>
                        <td><input type="checkbox" name="uerqu"  value="${user.userId },${user.userName}"></td>
                        <td>${user.userId} </td>
                        <td>${user.userName} </td>
                        <td>${user.userSex}</td>
                  		<td>${user.userAge} </td>
                    </tr> 
                 </c:forEach>                     
            </table>
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" id="xuanzhe" class="btn btn-primary" data-dismiss="modal" >选择</button>
                  </div>
                 </div>
                 </div>   
                </div>
				<div id="info" style="display:inline"></div>
             </div>
        </div>
         <div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 备注</label>
            <div class="col-xs-4">
            	<textarea class="form-control" rows="3" name="meetingroomNote" ></textarea>
             </div>
        </div>
          <div class="form-group"> 
        	
            <div class="col-sm-offset-1 col-xs-4">
            	<input class="btn btn-default" type="submit" value="预约"/>
             </div>
        </div>
        
    </form>
    
</div>

</body>
</html>
