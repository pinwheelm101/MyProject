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
<title>设备添加</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.css" rel="stylesheet"/>
<script src="js/jquery-1.9.0.min.js"></script>
<script src="js/bootstrap.js"></script>
</head>
<script type="text/javascript">
	function getPtagParam(){
		
	}
</script>
<body>
<div  >
	<h4 class="page-header">设备管理<small>修改</small></h4>
   	<div align="center" style=" color: red;">${info }</div>
    <form class="form-horizontal" action="EnquipmentUpdateServlet" method="post">
        	<!-- 设置input隐藏 传递name -->
        	<input type="hidden" name="enquipmentId" value="${enquipmentInfo.enquipmentId}">
        	<div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 设备编号</label>           
            <div class="col-xs-4">
            	<p class="form-control-static"  >${enquipmentInfo.enquipmentId}</p>
             </div>
        </div>
    
    	<div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 设备名称</label>
            <div class="col-xs-4">
            	<input type="text" name="enquipmentName" id="name" placeholder="请输入设备名称" value="${enquipmentInfo.enquipmentName}"  class="form-control" />
             </div>
        </div>        
        <div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 价格</label>
            <div class="col-xs-4">
            	<input type="text" name="enquipmentPrice" id="name" placeholder="请输入价格" value="${enquipmentInfo.enquipmentPrice}"  class="form-control" />
             </div>
        </div>
         <div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 备注</label>
            <div class="col-xs-4">
            	<textarea class="form-control" rows="3" name="enquipmentRemerk" >${enquipmentInfo.enquipmentRemerk}</textarea>
             </div>
        </div>
          <div class="form-group"> 
        	
            <div class="col-sm-offset-1 col-xs-4">
            	<input class="btn btn-default" type="submit" value="修改"/>
                <a href="EnquipmentMainServlet" class="btn btn-default" >返回上一级</a>
                
             </div>
        </div>
        
    </form>
    
</div>

</body>
</html>
