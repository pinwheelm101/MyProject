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
<title>设备添加</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.css" rel="stylesheet"/>
<script src="js/jquery-1.9.0.min.js"></script>
<script src="js/bootstrap.js"></script>
</head>

<body>
<div  >
	<h4 class="page-header">设备管理<small>修改删除</small></h4>
<div align="center" style=" color: red;">${info }</div>
<div class="container">
<form class="form-inline" role="form" action="EnquipmentMainServlet" method="post">
  <div class="form-group">
    <label class="sr-only" for="">名称</label>
    <input type="text" class="form-control" id="" name="enquipmentName"  placeholder="请输入设备名称">
  </div>
  <button type="submit" class="btn btn-default">查询</button>
</form>
<di:table name="list" class="table table-striped" pagesize="4" requestURI="EnquipmentMainServlet">
	<di:column property="enquipmentId" title="编号"></di:column>
	<di:column property="enquipmentName" title="设备名称"></di:column>
	<di:column property="enquipmentPrice" title="价格"></di:column>
	<di:column property="procurementTime" title="采购时间"></di:column>	
	<di:column href="EnquipmentUpdateServlet"  paramId="enquipmentId" paramProperty="enquipmentId" value="修改" title="修改"></di:column>
	<di:column  href="EnquipmentDeleteServlet"  paramId="enquipmentId" paramProperty="enquipmentId"  value="删除" title="删除"></di:column>	
</di:table>

</div>

    
</div>

</body>
</html>
