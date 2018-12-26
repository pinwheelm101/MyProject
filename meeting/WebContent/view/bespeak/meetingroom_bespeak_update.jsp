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
			var meusernm = "";//参加会议人员姓名
			var meuserid="";//参加会议人员id
			$('input[name="meuerqu"]:checked').each(function(){
				var meuserqu =$(this).val().split(",");
				meusernm=meusernm+meuserqu[1]+',';
				meuserid=meuserid+meuserqu[0]+',';
			});
			
			$("#meuserIds").val(meuserid);
			$("#info").html(meusernm);
		});	
		
	});

</script>

</head>

<body>
<div  >
	<h4 class="page-header">会议室预约<small>预约修改</small></h4>
    <div style="color: red;" class="">${info }</div>
    <form class="form-horizontal" action="MeetingroomBespeakUpdateServlet" method="post">
       <input type="text"  name="meuserIds" id="meuserIds" value=""/>
       <input type="text"  name="bespeakId" id="userIds" value="${bespeak.bespeakId }"/>
        <div class="form-group"> 
        	<label  class="col-xs-2 control-label " > 预约编号</label>
            <div class="col-xs-4">
            	<p class=" form-control-static">${bespeak.bespeakId }</p>           	
             </div>
        </div>
       <div class="form-group"> 
        	<label  class="col-xs-2 control-label " > 会议名称</label>
            <div class="col-xs-4">
            	<input type="text" name="meetingName"  placeholder="${bespeak.meetingName }" value=""  class="form-control" />
             </div>
        </div>
    	<div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 会议室 </label>
            <div class="col-xs-3">
            		<select class="form-control" name="meetingroomId">                   	
                        <c:forEach items="${meetroomlist}" var="meet">
   						<option value="${meet.meetingroomId}"${bespeak.meetingroomId==meet.meetingroomId?'selected':'' } >${meet.meetingroomName}</option>
   						</c:forEach>
                    </select>
             </div>
        </div>
        <div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label "  > 开始时间</label>
            <div class="col-xs-4">
            	<input type="text" name="stratTime" id="" placeholder="${bespeak.stratTime }" value="${bespeak.stratTime }" class="form-control" value="" />
             </div>
        </div>
        <div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 结束时间</label>
            <div class="col-xs-4">
            	<input type="text" name="endTime" id="" placeholder="${bespeak.endTime }"  value="${bespeak.endTime }" class="form-control" />
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
                  <c:forEach items="${meuserlist }" var="meuser">
                    <tr>
                        <td><input type="checkbox" name="meuerqu"  value="${meuser.userId },${meuser.userName}"></td>
                        <td>${meuser.userId} </td>
                        <td>${meuser.userName} </td>
                        <td>${meuser.userSex}</td>
                  		<td>${meuser.userAge} </td>
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
            	<textarea class="form-control" rows="3"></textarea>
             </div>
        </div>
          <div class="form-group"> 
        	
            <div class="col-sm-offset-1 col-xs-4">
            	<input class="btn btn-default" type="submit" value="修改"/>
             </div>
        </div>
        
    </form>
    
</div>

</body>
</html>
