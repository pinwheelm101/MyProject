<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String path=request.getContextPath();
	//获得项目地址，如“http://localhost:8080/test/”,赋值给basePath
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<!-- 引入分页标签display -->
<%@ taglib prefix="di" uri="http://displaytag.sf.net/el"%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户管理</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.css" rel="stylesheet"/>
<script src="js/jquery-1.9.0.min.js"></script>
<script src="js/bootstrap.js"></script>
</head>

<body>
<div  >
	<h4 class="page-header">用户管理<small>用户管理</small></h4>
	<div align="center" style="color: red" >${info }</div>
<div class="container">
<form   action="userInfoListServlet" method="post"  class="form-inline" role="form">
  <div class="form-group">
    <label  for="">姓名</label>
    <input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名">
  </div>
    <div class="form-group">    
    <label for="">性别</label><br/>
    <select name="sex" id="" class="form-control">
    	<option value="">请选择</option>
    	<option value="男">男</option>
    	<option value="女">女</option>
    </select>   
  </div>
  <div class="form-group">
  <label for="" >&nbsp;</label>
  <br/>
  <button type="submit" class="btn btn-default">查询</button>
  </div>
</form>
<di:table name="list" class="table table-striped" pagesize="4" requestURI="userInfoListServlet">
	<di:column property="userId" title="编号"></di:column>
	<di:column property="userName" title="姓名"></di:column>
	<di:column property="userSex" title="性别"></di:column>
	<di:column property="userAge" title="年龄"></di:column>
	<di:column property="userPhone" title="电话号码"></di:column>
	<di:column property="userTime"  format="{0,date,yyyy-MM-dd hh:mm:ss}" title="创建时间"></di:column>
	<di:column href="UserInfoUpdateServlet"  paramId="userId" paramProperty="userId" value="修改" title="修改"></di:column>
	<di:column  href="UserInfoDeleteServlet"  paramId="userId" paramProperty="userId"  value="删除" title="删除"></di:column>	
</di:table>
	




											
</div>

</div>    


</body>
</html>
