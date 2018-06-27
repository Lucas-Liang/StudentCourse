<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix ="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head >
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
   <script src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
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
                
                    <li class="active-link" >
                        <a href="course_findAllTeacher.action" ><i class="fa fa-desktop "></i>课程管理 </a>
                    </li>
                    <li >
                        <a href=""><i class="fa fa-table "></i>查看选课 </a>
                    </li>
                    <li>
                        <a href="user_update"><i class="fa fa-edit "></i>修改个人信息 </a>
                    </li>                    
                </ul>
           </div>

        </nav>
        <!-- /. NAV SIDE  -->
       <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
          <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                        <h2>欢迎使用，尊敬的"  <s:property value="#session.User.u_usename"/>"用户</h2>
                    </div>
                </div>
                <!-- /. ROW  -->
                <hr />
                <div class="row">
                    <div class="col-md-12">
                        <ul class="breadcrumb">
							<li>
								<a href="course_findAllTeacher.action">查看全部课程</a><span class="divider"></span>
							</li>
							<li>
								<a href="course_add.action">添加课程</a><span class="divider"></span>
							</li>
							<li class="active">
								修改课程信息<span class="divider"></span>
							</li>
						</ul>
                    </div>
                </div>
                <hr>
                <!-- /. ROW  -->
                <div class="row">
                    <div class="col-md-12">
                       <div class="alert alert-info">
                             <strong>当前修改课程为:<s:property value="model.c_name"/></strong>
                        </div>
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col-lg-6 col-md-6">
                        <h3 class="text-info">修改课程信息</h3>
						<br>
							<s:form action ="course_updateCourse" method = "post" namespace ="/" them ="simple">
								<s:hidden name="c_id" value="%{model.c_id}" />
								<s:hidden name="u_id" value="%{model.user.u_id}" />
								<s:hidden name="c_numChoice" value="%{model.c_numChoice}" />
								<s:hidden name="c_statu" value="%{model.c_statu}" />
								<div class="control-group">
									<div class="controls">
						 			<label class="control-label" for="inputEmail">课程名称<s:property value="%{model.user.u_id}" /></label>
						 			<input id="inputEmail" type="text" name="c_name" class="form-control" value="<s:property value="%{model.c_name}" />"/>
									</div>
								</div>
								<div class="control-group">
									<div class="controls">
						 			<label class="control-label" for="inputEmail">课程介绍</label>
						 			<input id="inputEmail" type="text" name="c_info" class="form-control" value="<s:property value="%{model.c_info}" />"/>
									</div>
								</div>
								<div class="control-group">
									<div class="controls">
						 				<label for="name" class="control-label"> 上课人数</label>
										<input id="inputEmail" type="text" name="c_num" class="form-control"  readonly  unselectable="on" value="<s:property value="%{model.c_num}" />"/>
									</div>
								</div>
								
					      
						<br>
				   			<div class="control-group">
							<div class="controls">
						  <button type="submit" class="btn">修改</button>
							</div>
				</div>
				
			</s:form>
                        
                    </div>
                    <div class="col-lg-6 col-md-6">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                              		 友情提示
                            </div>
                            <div class="panel-body">
                                <p>输入的信息一定要准确无误！</p>
                            </div>
                            <div class="panel-footer">
                                Panel Footer
                            </div>
                        </div>
                    </div>
	                
                    </div>

                </div>
                <!-- /. ROW  -->
                <hr />
                  <div class="row">
                    <div class="col-lg-12 col-md-12">
                        <h5>Information</h5>
                            This is a type of bare admin that means you can customize your own admin using this admin structured  template . For More Examples of bootstrap elements or components please visit official bootstrap website <a href="http://getbootstrap.com" target="_blank">getbootstrap.com</a>
                        . And if you want full template please download <a href="http://www.cssmoban.com/bootstrap-free-admin-dashboard-template/" target="_blank">FREE BCORE ADMIN </a>&nbsp;,&nbsp;  <a href="http://www.cssmoban.com/free-bootstrap-admin-template-siminta/" target="_blank">FREE SIMINTA ADMIN</a> and <a href="http://binarycart.com/" target="_blank">FREE BINARY ADMIN</a>.

                    </div>
                  </div>
                <!-- /. ROW  -->

            </div>
            </div>
         <!-- /. PAGE WRAPPER  -->
        </div>
    <div class="footer">
      
    
             <div class="row">
                <div class="col-lg-12" >
                    &copy;  2014 yourdomain.com | Design More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a>
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
