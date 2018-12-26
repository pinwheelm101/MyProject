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
	<h4 class="page-header">系统管理<small>权限变更</small></h4>
	<div align="center" style="color: red" >${info }</div>
    <form class="form-horizontal" action="UserAnthorityChangeServlrt" method="post" >
    <input type="text" name="userId" value="${user.userId }"/>   	
       <div class="form-group"> 
        	<label  class="col-xs-2 control-label " > 账号</label>
            <div class="col-xs-4">
            	<p class="form-control-static" >${user.userId }</p>
             </div>
        </div>
    	<div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 密码 </label>
            <div class="col-xs-4">
            	<p class="form-control-static">${user.userPw }</p>
             </div>
        </div>
        <div class="form-group"> 
        	<label class="col-xs-2 control-label " > 姓名</label>
            <div class="col-xs-4">
            	<p class="form-control-static">${user.userName }</p>
             </div>
        </div>
         <div class="form-group"> 
        	<label class="col-xs-2 control-label " > 性别</label>
            <div class="col-xs-4">
            	<p class="form-control-static">${user.userSex }</p>
             </div>
        </div>

         <div class="form-group"> 
        	<label class="col-xs-2 control-label " > 年龄</label>
            <div class="col-xs-4">
            	<p class="form-control-static">${user.userAge }</p>
             </div>
        </div>
         <div class="form-group"> 
        	<label class="col-xs-2 control-label " > 电话号码</label>
            <div class="col-xs-4">
            	<p class="form-control-static">${user.userPhone }</p>
         	</div>
         </div>
         <div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 备注</label>
            <div class="col-xs-4">
            	<p class="form-control-static">${user.userBeizhu }</p>
             </div>
        </div>
        
            <div class="form-group"> 
        	<label class="col-xs-2 control-label " > 权限</label>
            <div class="col-xs-6">
            	<div class=" radio-inline">
                	<label>
                    	<input type="radio" name="userAnthority" value="1"  ${user.userAnthority=='1'?'checked':''}/>普通用户
                    </label>
                </div>
                   	<div class=" radio-inline">
                	<label>
                    	<input type="radio" name="userAnthority" value="2"  ${user.userAnthority=='2'?'checked':''} />普通管理员
                    </label>
                </div>
                   	<div class=" radio-inline">
                	<label>
                    	<input type="radio" name="userAnthority" value="3" ${user.userAnthority=='3'?'checked':''}/>系统管理员
                    </label>
                </div>
                   	<div class=" radio-inline">
                	<label>
                    	<input type="radio" name="userAnthority" value="4" ${user.userAnthority=='4'?'checked':''}/>审核人员
                    </label>
                </div>
             </div>
        </div>
          <div class="form-group"> 
        	
            <div class="col-sm-offset-1 col-xs-4">
					<input type="submit" name="" value="变更"  class="btn btn-default"/>
             </div>
        </div>
        
    </form>
    
</div>

</body>
</html>
