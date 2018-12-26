<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String path=request.getContextPath();
	//获得项目地址，如“http://localhost:8080/test/”,赋值给basePath
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<script type="text/javascript">
	$(document).ready(function(){
		$("#xuanzhe").click(function(){
			var enid = "";//设备编号
			var enname = "";//设备名称
			$('input[name="enq"]:checked').each(function(){
				var enq=  $(this).val().split(",");
				enid+=enq[0]+",";
				enname+=enq[1]+",";
			});
			$('input[name="enqno"]:checked').each(function(){
				var enqno=  $(this).val().split(",");
				enid+=enqno[0]+",";
				enname+=enqno[1]+",";
			});
			$("#enquipmentId").val(enid);
			$("#info").html(enname);
		});	
		
	});

</script>

</head>

<body>
<div  >
	<h4 class="page-header">会议室管理<small>修改</small></h4>
    <div align="center" style=" color: red;">${info }</div>
    <form class="form-horizontal" action="MeetingroomUpdateServlet" method="post">       
       <input type="hidden" name="meetingroomId"    class="form-control" value="${meInfo.meetingroomId}" />
       <input type="text" name="enquipmentIds" id="enquipmentId" value=""/>
       <div class="form-group"> 
        	<label  class="col-xs-2 control-label " >编号</label>
            <div class="col-xs-4">
            	<p class="form-control-static">${meInfo.meetingroomId}</p>
             </div>
        </div>
    	<div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 名称 </label>
            <div class="col-xs-4">
            	<input type="text" name="meetingroomName" id="name" placeholder="请输入名称"  value="${meInfo.meetingroomName}" class="form-control" />
             </div>
        </div>
        <div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 大小</label>
            <div class="col-xs-4">
            	<input type="text" name="meetingroomSize" id="name" placeholder="请输会议室大小"   value="${meInfo.meetingroomSize}" class="form-control" />
             </div>
        </div>
        <div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 内置设备</label>
            <div class="col-xs-4">
            	<button class="btn btn-primary" data-toggle="modal" data-target="#myModal">
  请选择
</button>

                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                    
                     <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">设备信息</h4>
                  </div>
                  <div class="modal-body">
                   <table class="table table-striped">
                <thead>
                <tr>
                <th></th>
                    <th>设备编号</th>
                    <th>设备名称</th>
                    <th>设备价格</th>
                    <th>采购时间</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach items="${enlist }" var="eninfo">
                    <tr>
                        <td><input type="checkbox" name="enq"  checked="checked" value="${eninfo.enquipmentId },${eninfo.enquipmentName }"></td>
                        <td>${eninfo.enquipmentId }</td>
                        <td>${eninfo.enquipmentName }</td>
                        <td>${eninfo.enquipmentPrice }</td>
                        <td>${eninfo.procurementTime }</td>
                    </tr>
                    </c:forEach>
                     <c:forEach items="${noenlist }" var="eninfo">
                   <tr>
                   <td><input type="checkbox" name="enqno"   value="${eninfo.enquipmentId },${eninfo.enquipmentName }"></td>
                        <td>${eninfo.enquipmentId }</td>
                        <td>${eninfo.enquipmentName }</td>
                        <td>${eninfo.enquipmentPrice }</td>
                        <td>${eninfo.procurementTime }</td>           		
                    </tr>
                    </c:forEach>   
                </tbody>
            </table>
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" id="xuanzhe" class="btn btn-primary" data-dismiss="modal" >选择</button>
                  </div>
                 </div>
                 </div>   
                </div>
				<div id="info" style="display:inline"></div>
             </div>
        </div>
         <div class="form-group"> 
        	<label for="name" class="col-xs-2 control-label " > 备注</label>
            <div class="col-xs-4">
            	<textarea class="form-control" rows="3" name="meetingroomNote">${meInfo.meetingroomNote}</textarea>
             </div>
        </div>
          <div class="form-group"> 
        	
            <div class="col-sm-offset-1 col-xs-4">
            	<input class="btn btn-default" type="submit" value="修改"/>
            	<a href="MeetingroomMainServlet" class="btn btn-default">返回上一级</a>
             </div>
        </div>
        
    </form>
    
</div>

</body>
</html>
