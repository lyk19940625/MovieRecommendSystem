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
			<a href="manager/info" class="visible-phone"><i class="icon icon-home"></i> 首页</a>
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
				<h1>用户信息管理</h1>
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
	<form method="post" action="manager/uploadU"
			enctype="multipart/form-data">
			<table class="table table-bordered table-striped">
									
									<thead>
										<tr>
										
										</tr>
									</thead>
									<tbody>
					            <tr>
					            <td>上传用户信息: </td>
					            <td><input type="file" name="uploadFile" /> </td> 
					            <td valign="top"><input type="submit" value="上传" /></td> 
					            </tr>
									</tbody>
									
								</table>	
								</form>
				<table class="table table-bordered table-striped">
									
									<thead>
										<tr>
							
							<th>用户账号</th> 
							<th>用户名</th>
							<th>密码</th> 
							<th>性别</th> 
							<th>101评分</th> 
							<th>102评分</th> 
							<th>103评分</th> 
							<th>104评分</th> 
							<th>105评分</th> 
							<th>106评分</th> 
							<th>107评分</th> 
							<th>推荐评分</th>	
							<th>操作</th> 
							
										</tr>
									</thead>
									<tbody>
							<c:forEach var="user" items="${userlist}"> 
					            <tr>
					         
					       <td style="vertical-align:middle; text-align:center;"><c:out value="${user.uid}"/>  </td>   
					       <td style="vertical-align:middle; text-align:center;"><c:out value="${user.uname}"/>  </td>          
					       <td style="vertical-align:middle; text-align:center;"><c:out value="${user.password}"/>  </td> 
					       <td style="vertical-align:middle; text-align:center;"><c:out value="${user.sex}"/>  </td>   
					       <td style="vertical-align:middle; text-align:center;"><c:out value="${user.score1}"/>  </td>    
					       <td style="vertical-align:middle; text-align:center;"><c:out value="${user.score2}"/>  </td>    
					       <td style="vertical-align:middle; text-align:center;"><c:out value="${user.score3}"/>  </td>    
					       <td style="vertical-align:middle; text-align:center;"><c:out value="${user.score4}"/>  </td>    
					       <td style="vertical-align:middle; text-align:center;"><c:out value="${user.score5}"/>  </td>    
					       <td style="vertical-align:middle; text-align:center;"><c:out value="${user.score6}"/>  </td>    
					       <td style="vertical-align:middle; text-align:center;"><c:out value="${user.score7}"/>  </td> 
					       <td style="vertical-align:middle; text-align:center;"><c:out value="${user.recommend}"/>  </td> 
					        <td style="vertical-align:middle; text-align:center;"><a><href = "#"/>删除  </td>                  
					            </tr>
					         </c:forEach>
									</tbody>
									
								</table>	
							
				

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
