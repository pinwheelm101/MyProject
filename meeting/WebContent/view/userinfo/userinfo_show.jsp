<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String path=request.getContextPath();
	//获得项目地址，如“http://localhost:8080/test/”,赋值给basePath
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户信息管理</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.css" rel="stylesheet"/>
<script src="js/jquery-1.9.0.min.js"></script>
<script src="js/bootstrap.js"></script>



</head>

<body>
<div  >
	<h4 class="page-header">系统管理<small>用户查看</small></h4>
   	<div>${user.userId} </div>
    <form class="form-horizontal">
       <div class="form-group"> 
        	<label  class="col-xs-2 control-label " > 账号</label>
            <div class="col-xs-4">
            	<p class="form-control-static">${user.userId}</p>
             </div>
        </div>
    	<div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label "  > 密码 </label>
            <div class="col-xs-4">
            	<p class="form-control-static">${user.userPw}</p>
             </div>
        </div>
        <div class="form-group"> 
        	<label class="col-xs-2 control-label " >姓名</label>
            <div class="col-xs-4">
            	<p class="form-control-static">${user.userName}</p>
             </div>
        </div>
         <div class="form-group"> 
        	<label class="col-xs-2 control-label " > 性别</label>
            <div class="col-xs-4">
            	<p class="form-control-static">${user.userSex}</p>
             </div>
        </div>
         <div class="form-group"> 
        	<label class="col-xs-2 control-label " > 年龄</label>
            <div class="col-xs-4">
            	<p class="form-control-static">${user.userAge}</p>
             </div>
        </div>
         <div class="form-group"> 
        	<label class="col-xs-2 control-label " > 电话号码</label>
            <div class="col-xs-4">
            	<p class="form-control-static">${user.userPhone}</p>
             </div>
        </div>
         <div class="form-group"> 
        	<label class="col-xs-2 control-label " > 权限</label>
            <div class="col-xs-4">
            	<p class="form-control-static">
            	${user.userAnthority=='1'?'普通用户':''}
            	${user.userAnthority=='2'?'普通管理员':''}
            	${user.userAnthority=='3'?'系统管理员':''}
            	${user.userAnthority=='4'?'审核人员':''}
            	</p>
             </div>
        </div>
         <div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 备注</label>
            <div class="col-xs-4">
            	<p class="form-control-static">${user.userBeizhu}</p>
             </div>
        </div>
          <div class="form-group"> 
        	
            <div class="col-sm-offset-1 col-xs-4">
            	<a class="btn btn-default" href="UserInfoSelectServlet">返回上一级</a>
             </div>
        </div>
        
    </form>
    
</div>

</body>
</html>
