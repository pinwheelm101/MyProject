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
	<h4 class="page-header">会议室管理<small>查询</small></h4>

<div class="container">
<form class="form-inline" role="form" action="MeetingroomListServlet" method="post" >
  <div class="form-group">
    <label class="sr-only" for="">名称</label>
    <input type="text" class="form-control" id="" name="meetingroomName" placeholder="请输入会议室名称">
  </div>
  <button type="submit" class="btn btn-default">查询</button>
</form>
<di:table name="list" class="table table-striped" pagesize="4" requestURI="MeetingroomListServlet">
	<di:column property="meetingroomId" title="编号"></di:column>
	<di:column property="meetingroomName" title="会议室名称"></di:column>
	<di:column property="meetingroomSize" title="会议室大小"></di:column>
	<di:column property="meetingroomNote" title="备注信息"></di:column>	
	<di:column  href="MeetingroomShowServlet"  paramId="meetingroomId" paramProperty="meetingroomId"  value="查看" title="查看"></di:column>	
</di:table>

</div>

    
</div>

</body>
</html>
