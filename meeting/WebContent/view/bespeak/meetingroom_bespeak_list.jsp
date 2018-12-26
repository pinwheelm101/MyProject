<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String path=request.getContextPath();
	//获得项目地址，如“http://localhost:8080/test/”,赋值给basePath
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<%@taglib prefix="d" uri="http://displaytag.sf.net" %>
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
	<h4 class="page-header">会议室预约<small>查询修改</small></h4>

<div class="container">
<form class="form-inline" role="form" action="MeetingroomBespeakListServlet" method="post">
  <div class="form-group">
    <label class="sr-only" for="">会议名称</label>
    <input type="text" class="form-control" id="" name="meetingName" placeholder="请输入名称">
  </div>
  <button type="submit" class="btn btn-default">查询</button>
</form>
<d:table class="table table-striped" name="list" pagesize="8" requestURI="MeetingroomBespeakListServlet">
		<d:column property="bespeakId" title="编号"></d:column>
		<d:column property="meetingName" title="会议名称"></d:column>
		<d:column property="stratTime" format="{0,date,yyyy-MM-dd hh:mm:ss}"  title="开始时间"></d:column>
		<d:column property="endTime" format="{0,date,yyyy-MM-dd hh:mm:ss}"  title="结束时间"></d:column>
		<d:column property="userName" title="申请人"></d:column>
		<d:column property="meetingroomName" title="申请会议室"></d:column>
		<d:column href="MeetingroomBespeakUpdateServlet" paramId="bespeakId" paramProperty="bespeakId" value="修改" title="修改"></d:column>
		
	</d:table>

</div>

    


</body>
</html>
