<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html>
<html lang="en">
    <head>
    <base href="<%=basePath%>">
        <title>注册</title>
		<meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />

		<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
        <link rel="stylesheet" href="css/unicorn.login.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
     <script language="javascript">
function checkform(){
	alert("注册成功！");
	}
	function checkform1(){
	var pw1 = document.getElementById('pw1').value;
	var pw2 = document.getElementById('pw2').value;
	if(pw1 != pw2){
	alert("两次密码输入不一致");
	}
	}
</script>
    
    </head>
    
    <body>
        <div id="logo">
            <img src="img/logo.png" alt="" />
        </div>
        <div id="loginbox" style="height: 359px; ">            
         <form action="register/save" method="post"  >
				<p>注册</p>
                <table class="table table-bordered table-striped" style="height: 259px; ">
            
					        <tr>
					           <td>账号</td>
					           <td><input type="text" name="Account" size=17 /></td>
					              <td>用户名</td>
					                  <td><input type="text" name="Name" size=17/></td>
					                
					        </tr>
					       
					         
					         <tr>
					           <td>班级</td>
					           <td><input type="text" name="Class" size=17 /></td>
					           <td>手机号</td>
					           <td><input type="text" name="Tel" size=17 /></td>
					        </tr>
					        <tr>
					           <td>密码</td>
					           <td><input type="text" name="Password" size=17 id = 'pw1'/></td>
					           <td>确认密码</td>
					           <td><input type="text" name="Password2" size=17 id = 'pw2'/></td>
					        </tr>
				
					          <tr>
					           <td colspan="2" align="center">性别</td>
					           <td colspan="5" align="center" onclick="checkform1()">
					               <input type="radio" name="Sex" value="男"id=Sex/>男
					               <input type="radio" name="Sex" value="女"id=Sex/>女
					           </td>
					          </tr>
					          <tr>
					           <td colspan="2" align="center">身份</td>
					           <td colspan="5" align="center"><input type="radio" name="Type" value="student" id=Type/>学生
					               <input type="radio" name="Type" value="teacher"id=Type/>老师
					             
					           </td>
					        					        
					          </tr>
                                   <tr>
					    <td colspan="7" align="center"><input type="submit" value="确认注册" onclick="checkform()"/></td>
								   </tr>
								   </table>	
								
            </form>
            
        </div>
        
        <script src="js/jquery.min.js"></script>  
        <script src="js/unicorn.login.js"></script> 
    </body>
</html>
