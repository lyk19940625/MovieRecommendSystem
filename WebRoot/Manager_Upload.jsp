<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
	<head>
	   <base href="<%=basePath%>">
		<title>电影推荐系统</title>
		<meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
		<link rel="stylesheet" href="css/fullcalendar.css" />	
		<link rel="stylesheet" href="css/unicorn.main.css" />
		<link rel="stylesheet" href="css/unicorn.grey.css" class="skin-color" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
	<body>
		
		
		<div id="header">
			<h1><a href="./Manager.jsp">Manager</a></h1>		
		</div>
		
		
		<div id="user-nav" class="navbar navbar-inverse">
            <ul class="nav btn-group">
                <li class="btn btn-inverse"><a title="" href="#"><i class="icon icon-user"></i> <span class="text">个人中心</span></a></li>
                <li class="btn btn-inverse dropdown" id="menu-messages"><a href="#" data-toggle="dropdown" data-target="#menu-messages" class="dropdown-toggle"><i class="icon icon-envelope"></i> <span class="text">消息</span> <span class="label label-important">5</span> <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a class="sAdd" title="" href="#">new message</a></li>
                        <li><a class="sInbox" title="" href="#">inbox</a></li>
                        <li><a class="sOutbox" title="" href="#">outbox</a></li>
                        <li><a class="sTrash" title="" href="#">trash</a></li>
                    </ul>
                </li>
                <li class="btn btn-inverse"><a title="" href="#"><i class="icon icon-cog"></i> <span class="text">设置</span></a></li>
                <li class="btn btn-inverse"><a title="" href="login.html"><i class="icon icon-share-alt"></i> <span class="text">注销</span></a></li>
            </ul>
        </div>
            
		<div id="sidebar">
			<a href="#" class="visible-phone"><i class="icon icon-home"></i> 首页</a>
			<ul>
				<li class="active"><a href="manager/info"><i class="icon icon-home"></i> <span>首页</span></a></li>
				
				<li><a href="manager/movie"><i class="icon icon-pencil"></i> <span>电影分析</span></a></li>
				<li class="submenu">
					<a href="#"><i class="icon icon-th-list"></i> <span>大数据结果</span> <span class="label">4</span></a>
					<ul>
						<li><a href="manager/step1">Step1结果</a></li>
						<li><a href="manager/step2">Step2结果</a></li>
						<li><a href="manager/step3">Step3结果</a></li>
						<li><a href="manager/step4">Step4结果</a></li>
					
					</ul>
				</li>
				<li><a href="manager/user"><i class="icon icon-th-list"></i> <span>人员信息</span></a></li>
				<li><a href="manager/minfo"><i class="icon icon-th-list"></i> <span>电影信息</span></a></li>
				<li><a href="manager/upload"><i class="icon icon-th-list"></i> <span>导入信息</span></a></li>
				
		</div>
		
		<div id="style-switcher">
			<i class="icon-arrow-left icon-white"></i>
			<span>Style:</span>
			<a href="#grey" style="background-color: #555555;border-color: #aaaaaa;"></a>
			<a href="#blue" style="background-color: #2D2F57;"></a>
			<a href="#red" style="background-color: #673232;"></a>
		</div>
		
		<div id="content">
			<div id="content-header">
				<h1>欢迎管理员</h1>
				<div class="btn-group">
					<a class="btn btn-large tip-bottom" title="Manage Files"><i class="icon-file"></i></a>
					<a class="btn btn-large tip-bottom" title="Manage Users"><i class="icon-user"></i></a>
					<a class="btn btn-large tip-bottom" title="Manage Comments"><i class="icon-comment"></i><span class="label label-important">5</span></a>
					<a class="btn btn-large tip-bottom" title="Manage Orders"><i class="icon-shopping-cart"></i></a>
				</div>
			</div>
				<div id="breadcrumb">
				<a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
				<a href="#" class="current"></a>
			</div>
		
							
									
 <form action="manager/update" method="POST"  style="height: 250; ">
				<table class="table table-bordered table-striped">
									
									<thead>
										<tr>
							
							<th>操作</th> 
					        
					        
										</tr>
									</thead>
									<tbody>
							
					            <tr>
					       <td style="vertical-align:middle; text-align:center;"> <input type="submit" class="btn btn-inverse" value="整理MapReduce结果" /> </td>         
					         
					            </tr>
					         
									</tbody>
									
								</table>	
								</form>
								 <div id="main" style="height:400px"></div>
    <!-- ECharts单文件引入 -->
    <script src="js/echarts-all.js"></script>
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts图表
        var myChart = echarts.init(document.getElementById('main')); 
        var array = new Array();
        var jsonObj =  JSON.parse("${chartjson3}");
        for(var i=0;i<jsonObj.length;i++){
        array.push(jsonObj[i]);
		}	
        var option = {
            tooltip: {
                show: true
            },
            legend: {
                data:['人数']
            },
            xAxis : [
                {
                    type : 'category',
                    data : ["101","102","103","104","105","106","107"]
                }
            ],
            yAxis : [
                {
                    type : 'value'
                }
            ],
            series : [
                {
                    "name":"分数",
                    "type":"bar",
                    "data":array
                }
            ]
        };

        // 为echarts对象加载数据 
        myChart.setOption(option); 
    </script>
		
						</div>

						</div>
					</div>
			
            
            <script src="js/jquery.min.js"></script>
            <script src="js/jquery.ui.custom.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <script src="js/bootstrap-colorpicker.js"></script>
            <script src="js/bootstrap-datepicker.js"></script>
            <script src="js/jquery.uniform.js"></script>
            <script src="js/select2.min.js"></script>
            <script src="js/unicorn.js"></script>
            <script src="js/unicorn.form_common.js"></script>
	</body>
</html>
