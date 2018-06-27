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
    <title>选课系统</title>
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
                  <a href="user_logout.action" style="color:#fff;">注销登录</a>  

                </span>
            </div>
        </div>
        <!-- /. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                
                    <li class="active-link">
                       <a href=""><i class="fa fa-desktop "></i>全部课程</a>
                    </li>
                   
                    <li>
                        <a href="class_findAll.action"><i class="fa fa-table "></i>我的选修课 </a>
                    </li>
                    <li>
                        <a href="student_findAll.action"><i class="fa fa-edit "></i>修改个人信息 </a>
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
                     <h2>欢迎使用，"  <s:property value="#session.User.u_usename"/>"用户</h2>   
                    </div>
                </div>              
                  <hr />
                  <% 
                  request.setCharacterEncoding("UTF-8");
                  String s = request.getParameter("c_search");
                   String c_search = "";
			      if(s!=null){
			       c_search = new String(s.getBytes("iso-8859-1"),"UTF-8");
                   %>
                <div class="row">
                    <div class="col-lg-12 ">
                        <div class="alert alert-info">
                             <strong>当前搜索:<%=c_search %></strong>
                        </div>
                    </div>
                </div>
                <%} %>
<!-- /.************************************* ROW  --> 
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<ul class="breadcrumb">
		<%
			
			if(c_search==null||c_search.equals("")){
			%>
				<li class="active">
					全部课程  <span class="divider"></span>
				</li>
				<li>
					<a href="course_add.action">添加课程信息</a> <span class="divider"></span>
				</li>
			<%
			}else{
			 %>
				<li>
					<a href="course_findAllTeacher.action">全部课程</a>  <span class="divider"></span>
				</li>
				<li  class="active">
					课程搜索结果
				</li>
			 <%
			}
			 %>
			</ul>
		</div>
	</div>
</div>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<s:form action ="course_search" method = "get" namespace ="/" them ="simple">
				<input class="input-medium search-query" type="text"  name="c_search" /> 
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button type="submit" class="btn">搜索</button>
			</s:form>
			<br>
			<br>
			<br>
			<table class="table table-hover table-bordered">
				<thead>
					<tr>
						<th>
							序号
						</th>
						<th>
							课程名称
						</th>
						<th>
							课程介绍
						</th>
						<th>
							开课人数
						</th>
						<th>
							选课人数
						</th>
						<th>
							开课老师
						</th>
						<th>
							我要报名
						</th>
					</tr>
				</thead>
				<tbody>
			    <%int i=1;%>
				<s:iterator value="list" var="s">
					<tr class="success">
						<td><%=i++ %></td>
						<td><s:property value="#s.c_name" /></td>
						<td><s:property value="#s.c_info"/></td>
						<td><font style="color:red;"><s:property value="#s.c_num"/></font></td>
						<td><s:property value="#s.c_numChoice"/></td>
						<td><s:property value="#s.user.u_name"/></td>
						<td>
							 <button class="btn" type="button" herf="XXXXXX">报名</button>
						</td>		
					</tr>
				</s:iterator>
				</tbody>
			</table>
			
			<table border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td align="right">
   					<span>第<s:property value="indexPage" />/<s:property value="indexCount" />页</span>
  					<span>总记录数：<s:property value="pageCount" />&nbsp;&nbsp;每页显示：<s:property value="pageSize" /></span>
  					<span>
  					<% if(c_search==null||c_search.equals("")){%>
  					<s:if test="indexPage != 1">
       				<a href="${pageContext.request.contextPath}/course_findAllStudent.action?indexPage=1">[首页]</a>&nbsp;&nbsp;
       				<a href="${pageContext.request.contextPath}/course_findAllStudent.action?indexPage=<s:property value="indexPage-1" />">[上一页]</a>&nbsp;&nbsp;
      				</s:if>
      				<s:if test="indexPage !=indexCount">
       				<a href="${pageContext.request.contextPath}/course_findAllStudent?indexPage=<s:property value="indexPage+1" />">[下一页]</a>&nbsp;&nbsp;
       				<a href="${pageContext.request.contextPath}/course_findAllStudent?indexPage=<s:property value="indexCount" />">[尾页]</a>&nbsp;&nbsp;
       				</s:if> 
       				<%}else{ %>
       				<s:if test="indexPage != 1">
       				<a href="${pageContext.request.contextPath}/course_search.action?indexPage=1&c_search=<%=c_search %>">[首页]</a>&nbsp;&nbsp;
       				<a href="${pageContext.request.contextPath}/course_search.action?indexPage=<s:property value="indexPage-1" />&c_search=<%=c_search %>">[上一页]</a>&nbsp;&nbsp;
      				</s:if>
      				<s:if test="indexPage !=indexCount">
       				<a href="${pageContext.request.contextPath}/course_search.action?indexPage=<s:property value="indexPage+1" />&c_search=<%=c_search %>">[下一页]</a>&nbsp;&nbsp;
       				<a href="${pageContext.request.contextPath}/course_search.action?indexPage=<s:property value="indexCount" />&c_search=<%=c_search %>">[尾页]</a>&nbsp;&nbsp;
       				</s:if> 	
       				<%} %>
   					</span>
					</td>
				</tr>
			</table>
		</div>
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
