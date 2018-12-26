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
<title>会议室管理</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.css" rel="stylesheet"/>
<script src="js/jquery-1.9.0.min.js"></script>
<script src="js/bootstrap.js"></script>
</head>

<body>
<div  >
	<h4 class="page-header">会议室管理<small>修改删除</small></h4>

<div class="container">
<div align="center" style=" color: red;">${info }</div>
<form class="form-inline" role="form" action="MeetingroomMainServlet" method="post">
  <div class="form-group">
    <label class="sr-only" for="">名称</label>
    <input type="text" class="form-control" id="" name="meetingroomName" placeholder="请输入名称">
  </div>
  <button type="submit" class="btn btn-default">查询</button>
</form>
<di:table name="list" class="table table-striped" pagesize="4" requestURI="MeetingroomMainServlet">
	<di:column property="meetingroomId" title="编号"></di:column>
	<di:column property="meetingroomName" title="会议室名称"></di:column>
	<di:column property="meetingroomSize" title="会议室大小"></di:column>	
	<di:column href="MeetingroomUpdateServlet"  paramId="meetingroomId" paramProperty="meetingroomId" value="修改" title="修改"></di:column>
	<di:column  href="MeetingroomDeleteServlet"  paramId="meetingroomId" paramProperty="meetingroomId"  value="删除" title="删除"></di:column>	
</di:table>

</div>

    
</div>

</body>
</html>
