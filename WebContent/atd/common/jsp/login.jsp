<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type='text/javascript' src='http://code.jquery.com/jquery-1.9.1.min.js'></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="<%=request.getContextPath() %>/atd/common/js/login.js"></script>
<title>�n�J</title>
<s:head theme="xhtml" /> <!--�w�]�� xhtml --> <!--theme �i�� xhtml �� simple �� css_xhtml --> 
<style type="text/css">
			body{
				margin:0px;
				padding:0px;
				background:#fff url("../images/login.jpg") center center fixed no-repeat;
				background-size: cover;�@

			}    
</style>  
</head>
<body >
<OL>

<!--         <form action=""	method="post"> -->
<!-- 			 ���u�m�W:  -->
<!-- 			    <input type="text" name="emp_no" value="1" /><p> -->
<!-- 			 �K�X�G -->
<!-- 			  <input type="text" name="psw" value="111" /><p> -->
<!-- 				<input type="submit" /> -->
<!-- 		</form><BR>	</LI> -->
		
  
  <!-- �n�J�����}�l -->
<%-- 			<form METHOD="post" ACTION="<%=request.getContextPath()%>/atd/users/jsp/index.jsp" id="form1" namespace="/aaa">	 --%>
			<form METHOD="post" ACTION="<%=request.getContextPath()%>/atd/common/Index/init.action" id="form1">	
				<div class="container" style="width:500px;margin-top:100px; ">
						
					    <div class="panel" id="login" >
					    <div class="panel-heading" style="text-align: center;font-size: 24px;background-color:#99FF99;">���u�n�J</div>
					    	<div class="panel-body" style="color: black;text-align: left;font-size: 16px">
					   
							  <div class="form-group" id="form-group1">
							    <label for="exampleInputEmail1">�|���s��</label>
							    <input type="text" name="emp_no" id="emp_no" class="form-control" placeholder="�|���s��" value="1">
							  </div>
							  <div class="form-group" id="form-group1">
							    <label for="exampleInputPassword1">�K�X</label>
							    <input type="password" name="psw" id="psw" class="form-control" placeholder="�K�X" value="111">
							  </div>

							  <div class="modal-footer" style="text-align: left;">
							  <b id="loginError" style="color:red;">��r</b>
							  <div class="form-group" id="form-group1" id="btlogin" style="text-align: center;">
							  		<button type="button" id="btnLogin" class="btn btn-default" style="background-color:#FDF5E6;">�n�J</button>
<!-- 							  		<button type="submit" id="btnLogin" class="btn btn-default" style="background-color:#FDF5E6;">�n�J</button> -->
							  </div>
							  </div>
					    	</div>
						</div>
				</div> 
			</form>
			<!-- �n�J�������� -->
		
		

</OL>
</body>
</html>

