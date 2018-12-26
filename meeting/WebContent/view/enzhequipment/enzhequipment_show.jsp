<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String path=request.getContextPath();
	//获得项目地址，如“http://localhost:8080/test/”,赋值给basePath
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<h4 class="page-header">设备管理<small>设备信息查看</small></h4>
    <form class="form-horizontal">
       <div class="form-group"> 
        	<label  class="col-xs-2 control-label " > 设备编号</label>
            <div class="col-xs-4">
            	<p class="form-control-static">${enInfo.enquipmentId}</p>
             </div>
        </div>
    	<div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label "  >设备名称 </label>
            <div class="col-xs-4">
            	<p class="form-control-static">${enInfo.enquipmentName}</p>
             </div>
        </div>
        <div class="form-group"> 
        	<label class="col-xs-2 control-label " >设备价格</label>
            <div class="col-xs-4">
            	<p class="form-control-static">${enInfo.enquipmentPrice}</p>
             </div>
        </div>
         <div class="form-group"> 
        	<label class="col-xs-2 control-label " > 采购人</label>
            <div class="col-xs-4">
            	<p class="form-control-static">${enInfo.userName}</p>
             </div>
        </div>
         <div class="form-group"> 
        	<label class="col-xs-2 control-label " > 采购时间</label>
            <div class="col-xs-4">
            	<p class="form-control-static" >
            	<fmt:formatDate value="${enInfo.procurementTime}" type="both"/></p>
             </div>
        </div>
         <div class="form-group"> 
        	<label class="col-xs-2 control-label " > 所属会议室</label>
            <div class="col-xs-4">
            	<p class="form-control-static">${enInfo.meetingroomName}</p>
             </div>
        </div>       
         <div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 备注</label>
            <div class="col-xs-4">
            	<p class="form-control-static">
            	${enInfo.enquipmentRemerk}
            	</p>
             </div>
        </div>
          <div class="form-group"> 
        	
            <div class="col-sm-offset-1 col-xs-4">
            	<a class="btn btn-default" href="EnquipmentListServlet">返回上一级</a>
             </div>
        </div>
        
    </form>
    
</div>

</body>
</html>
