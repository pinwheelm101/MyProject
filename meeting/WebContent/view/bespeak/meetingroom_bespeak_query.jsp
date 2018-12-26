<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String path=request.getContextPath();
	//获得项目地址，如“http://localhost:8080/test/”,赋值给basePath
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<%@ taglib prefix="d" uri="http://displaytag.sf.net"%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>会议管理</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.css" rel="stylesheet"/>
<script src="js/jquery-1.9.0.min.js"></script>
<script src="js/bootstrap.js"></script>
</head>

<body>
	<h4 class="page-header">会议室预约<small>审核</small></h4>

<div class="container">
<form class="form-inline" role="form" action="MeetingroomBespeakQueryServlet" method="post">
  <div class="form-group">
    <label class="sr-only" for="">会议名称</label>
    <input type="text" class="form-control" id="" name="meetingName" placeholder="请输入会议名称">
  </div>
  <div class="form-group">
    <label class="sr-only" for="">预约状态</label>
    <select name="bespeakState" class="form-control" >
    	<option value="">预约状态</option>
    	<option value="0">未审核</option>
    	<option value="1">审核通过</option>
    	<option value="2">审核不通过</option>
    </select>
  </div>
  <button type="submit" class="btn btn-default">查询</button>
</form>
<d:table class="table table-striped" name="list" pagesize="8"
			requestURI="MeetingroomBespeakQueryServlet">
			<d:column property="bespeakId" title="编号"></d:column>
			<d:column property="meetingName" title="会议名称"></d:column>
			<d:column property="meetingroomName" title="会议室"></d:column>
			<d:column property="stratTime" format="{0,date,yyyy-MM-dd hh:mm:ss}"  title="开始时间"></d:column>
			<d:column property="endTime" format="{0,date,yyyy-MM-dd hh:mm:ss}"  title="结束时间"></d:column>
			<d:column property="bespeakState"   title="预约状态"></d:column>
			<d:column href="MeetingroomBespeakShowServlet" paramId="bespeakId" paramProperty="bespeakId" value="查看" title="查看"></d:column>
		</d:table>

</div>

    


</body>
</html>
