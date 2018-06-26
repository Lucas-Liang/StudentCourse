<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix ="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
      <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>学校管理</title>
	<!-- BOOTSTRAP STYLES-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
     <!-- FONTAWESOME STYLES-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
        <!-- CUSTOM STYLES-->
    <link href="assets/css/custom.css" rel="stylesheet" />
     <!-- GOOGLE FONTS-->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>
<body>
     
     
    <div id="wrapper">
         <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="adjust-nav">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">
                        <img src="assets/img/logo.png" />

                    </a>
                    
                </div>
              
                <span class="logout-spn" >
                  <a href="#" style="color:#fff;">注销登录</a>  

                </span>
            </div>
        </div>
        <!-- /. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                
                    <li class="active-link">
                        <a href="" ><i class="fa fa-desktop "></i>学校管理 </a>
                    </li>
                   

                    <li>
                        <a href="class_findAll"><i class="fa fa-table "></i>班级管理 </a>
                    </li>
                    <li>
                        <a href="student_findAll"><i class="fa fa-edit "></i>学生管理 </a>
                    </li>                    
                </ul>
                            </div>

        </nav>
        <!-- /. NAV SIDE  -->
        <div class="copyrights">Collect from <a href="http://www.cssmoban.com/"  title="网站模板">网站模板</a></div>
        <div id="page-wrapper" >
            <div id="page-inner">
                <div class="row">
                    <div class="col-lg-12">
                     <h2>欢迎使用，尊敬的"  <s:property value="#session.User.u_usename"/>"用户</h2>   
                   
                    </div>
                </div>              
                 <!-- /. ROW  -->
                  <hr />
                 
             
<!-- /.************************************* ROW  --> 
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<ul class="breadcrumb">
	
				<li>
					<a href="findAll.action">学校信息管理  </a><span class="divider"></span>
				</li>
				<li class="active">
					添加学校信息<span class="divider"></span>
				</li>
			</ul>
		</div>
	</div>
</div>

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<h3 class="text-info">
				添加学校信息
			</h3>
			<br>
			<s:property value="%{model.s_name}" />
			<s:form action ="school_update" method = "post" namespace ="/" them ="simple">
				<div class="control-group">
				
					<s:hidden name="s_id" value="%{model.s_id}" />
					
					<div class="controls">
						 <label class="control-label" for="inputEmail">学校名称</label>
						 &nbsp;&nbsp;&nbsp;<input id="inputEmail" type="text" name="s_name" value="<s:property value="%{model.s_name}" />"/>
					</div>
				</div>
				<br>
				<div class="control-group">
			
					<div class="controls">
						 <label class="control-label" for="inputPassword">学校地址</label>
						 &nbsp;&nbsp;&nbsp;<input id="inputPassword" type="text" name="s_address" value="<s:property value="%{model.s_address}" />" />
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						  <button type="submit" class="btn">修改</button>
					</div>
				</div>
			</s:form>
			
		</div>
	</div>
</div>

    <div class="footer">
      
    
            <div class="row">
                <div class="col-lg-12" >
                    &copy;  2014 yourdomain.com | More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a>
                </div>
            </div>
        </div>
          

     <!-- /. WRAPPER  -->
    <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
    <!-- JQUERY SCRIPTS -->
    <script src="assets/js/jquery-1.10.2.js"></script>
      <!-- BOOTSTRAP SCRIPTS -->
    <script src="assets/js/bootstrap.min.js"></script>
      <!-- CUSTOM SCRIPTS -->
    <script src="assets/js/custom.js"></script>
    
   
</body>
</html>
