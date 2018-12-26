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
	<h4 class="page-header">系统管理<small>用户修改</small></h4>
    <div align="center" style="color: red" >${info }</div>
    <form action="UserInfoUpdateServlet" method="post"  class="form-horizontal" enctype="multipart/form-data">
       <div class="form-group"> 
        	<label  class="col-xs-2 control-label " > 账号</label>
            <div class="col-xs-4">
            	<input type="text" name="userId"  placeholder="${user.userId} " value="${user.userId}" class="form-control" />
             </div>
        </div>
    	<div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 密码 </label>
            <div class="col-xs-4">
            	<input type="text" name="userPw" id="name" placeholder="${user.userPw}" value="${user.userPw}" class="form-control" />            	
             </div>
        </div>
        <div class="form-group"> 
        	<label class="col-xs-2 control-label " > 姓名</label>
            <div class="col-xs-4">
            	<input type="text" name="userName"  placeholder="尚未填写" value="${user.userName}" class="form-control" />
             </div>
        </div>
         <div class="form-group"> 
        	<label class="col-xs-2 control-label " > 头像</label>
            <div class="col-xs-4">
            	<input type="file" name="userUrl"  class="form-control"  />
            	<img alt="" src="${user.userUrl }" width="50" height="50">
             </div>
        </div>
         <div class="form-group"> 
        	<label class="col-xs-2 control-label " > 性别</label>
            <div class="col-xs-4">
            	<div class="radio-inline" >
                	<label>
                    	<input type="radio" name="userSex" value="男"  ${user.userSex =="男"?'checked':'' } >男
                    </label>
                </div>
                          	<div class="radio-inline">
                	<label>
                    	<input type="radio" name="userSex" value="女" ${user.userSex =="女"?'checked':'' } >女
                    </label>
                </div>
             </div>
        </div>
         <div class="form-group"> 
        	<label class="col-xs-2 control-label " > 年龄</label>
            <div class="col-xs-4">
            	<input type="text" name="userAge"  placeholder="尚未填写" value="${user.userAge}" class="form-control" />
             </div>
        </div>
         <div class="form-group"> 
        	<label class="col-xs-2 control-label " > 电话号码</label>
            <div class="col-xs-4">
            	<input type="text" name="userPhone"  placeholder="尚未填写" value="${user.userPhone}" class="form-control" />
             </div>
        </div>
         <div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 备注</label>
            <div class="col-xs-4">
            	<textarea name="userBeizhu" placeholder="尚未填写" class="form-control" rows="3" placeholder="${user.userBeizhu}" ></textarea>
             </div>
        </div>
          <div class="form-group"> 
        	
            <div class="col-sm-offset-1 col-xs-4">
            	<input class="btn btn-default" type="submit" value="修改用户"/>
            	<a class="btn btn-default"  href="userInfoListServlet">返回上一级</a>
             </div>
        </div>
        
    </form>
    
</div>

</body>
</html>
