<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String path=request.getContextPath();
	//获得项目地址，如“http://localhost:8080/test/”,赋值给basePath
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<!-- 引入分页标签display -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="di" uri="http://displaytag.sf.net/el"%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>设备添加</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.css" rel="stylesheet"/>
<script src="js/jquery-1.9.0.min.js"></script>
<script src="js/bootstrap.js"></script>
</head>

<body>
<div  >
	<h4 class="page-header">&nbsp;&nbsp;设备管理<small>查询</small></h4>

<div class="container">
<form class="form-inline" role="form" action="EnquipmentListServlet" method="post">
  <div class="form-group">
    <label class=" col-xs-6" for="">名称</label>
    
    <input type="text" name="enquipmentName" class="form-control" id="" placeholder="请输入设备名称">
  </div>
  <div class="form-group">
    <label class="col-xs-6" for="">所属会议室</label>
   	<select name="meetingroomId" class="form-control">
   		<option value="">请选择</option>
   		<c:forEach items="#{meetroomlist }" var="meet">
   		<option value="${meet.meetingroomId }">${meet.meetingroomName }</option>
   		</c:forEach>
   	</select>
  </div>
   <div class="form-group">
    <label class="col-xs-6" for="">&nbsp;</label>
    <button type="submit" class="btn btn-default">查询</button>
  </div>
  
</form>
<di:table name="list" class="table table-striped" pagesize="4" requestURI="EnquipmentMainServlet">
	<di:column property="enquipmentId" title="编号"></di:column>
	<di:column property="enquipmentName" title="设备名称"></di:column>
	<di:column property="enquipmentPrice" title="价格"></di:column>
	<di:column property="procurementTime" format="{0,date,yyyy-MM-dd hh:mm:ss}" title="采购时间"></di:column>
	<di:column property="userName" title="采购人"></di:column>	
	<di:column property="meetingroomName" title="所属会议室"></di:column>
	<di:column href="EnzhequipmentShowServlet"  paramId="enquipmentId" paramProperty="enquipmentId" value="查看" title="查看"></di:column>		
</di:table>

</div>

    
</div>

</body>
</html>
