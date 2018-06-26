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
    <title>班级管理</title>
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
                
                    <li>
                        <a href="school_findAll.action" ><i class="fa fa-desktop "></i>学校管理 </a>
                    </li>
                   

                    <li >
                        <a href="class_findAll.action" > <i class="fa fa-table"></i>班级管理 </a>
                    </li>
                    <li class="active-link">
                        <a href=""><i class="fa fa-edit "></i>学生管理 </a>
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
                  <% 
                  request.setCharacterEncoding("UTF-8");
                  String s = request.getParameter("st_search");
                   String st_search = "";
			      if(s!=null){
			       st_search = new String(s.getBytes("iso-8859-1"),"UTF-8");
                   %>
                <div class="row">
                    <div class="col-lg-12 ">
                        <div class="alert alert-info">
                             <strong>当前搜索:<%=st_search %></strong>
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
			
			if(st_search==null||st_search.equals("")){
			%>
				<li class="active">
					学生信息管理  <span class="divider"></span>
				</li>
				<li>
					<a href="student_add.action">添加学生信息</a> <span class="divider"></span>
				</li>
				
			<%
			}else{
			 %>
				<li>
					<a href=student_findAll.action">班级信息管理</a>  <span class="divider"></span>
				</li>
				<li>
					<a href="student_add">班级学校信息</a>  <span class="divider"></span>
				</li>
				<li  class="active">
					班级-搜索结果
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
			<s:form action ="student_search" method = "get" namespace ="/" them ="simple">
				<input class="input-medium search-query" type="text"  name="st_search" /> 
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button type="submit" class="btn">搜索</button>
			</s:form>
			<br>
			<br>
			<br>
			<table class="table table-hover table-bordered">
				<thead>
					<tr>
						<th>
							序&nbsp;&nbsp;号
						</th>
						<th>
							学&nbsp;&nbsp;校
						</th>
						<th>
							班&nbsp;&nbsp;级
						</th>
						<th>
							学&nbsp;&nbsp;生
						</th>
						<th>
							性&nbsp;&nbsp;别
						</th>
						<th>
							电&nbsp;&nbsp;话
						</th>
						<th>
							家庭地址
						</th>
						<th>
							状&nbsp;&nbsp;态
						</th>
					</tr>
				</thead>
				<tbody>
					 <%int i=1;%>
				<s:iterator value="list" var="c">
				
					<tr class="success">
						<td><%=i++ %> </td>
						<td><s:property value="#c.class1.school.s_name" /></td>
						<td><s:property value="#c.class1.c_name" /></td>
						<td><s:property value="#c.st_name"/></td>
						<td><s:property value="#c.st_sex"/></td>
						<td><s:property value="#c.st_phone"/></td>
						<td><s:property value="#c.st_address"/></td>
						<td>
							<a href="student_edit.action?st_id=${c.st_id}">编辑</a>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="student_delete.action?st_id=${c.st_id}">删除</a>
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
  					<% if(st_search==null||st_search.equals("")){%>
  					<s:if test="indexPage != 1">
       				<a href="${pageContext.request.contextPath}/student_findAll.action?indexPage=1">[首页]</a>&nbsp;&nbsp;
       				<a href="${pageContext.request.contextPath}/student_findAll.action?indexPage=<s:property value="indexPage-1" />">[上一页]</a>&nbsp;&nbsp;
      				</s:if>
      				<s:if test="indexPage !=indexCount">
       				<a href="${pageContext.request.contextPath}/student_findAll.action?indexPage=<s:property value="indexPage+1" />">[下一页]</a>&nbsp;&nbsp;
       				<a href="${pageContext.request.contextPath}/student_findAll.action?indexPage=<s:property value="indexCount" />">[尾页]</a>&nbsp;&nbsp;
       				</s:if> 
       				<%}else{ %>
       				<s:if test="indexPage != 1">
       				<a href="${pageContext.request.contextPath}/student_search.action?indexPage=1&st_search=<%=st_search %>">[首页]</a>&nbsp;&nbsp;
       				<a href="${pageContext.request.contextPath}/student_search.action?indexPage=<s:property value="indexPage-1" />&st_search=<%=st_search %>">[上一页]</a>&nbsp;&nbsp;
      				</s:if>
      				<s:if test="indexCount!=0">
       				<a href="${pageContext.request.contextPath}/student_search.action?indexPage=<s:property value="indexPage+1" />&st_search=<%=st_search %>">[下一页]</a>&nbsp;&nbsp;
       				<a href="${pageContext.request.contextPath}/student_search.action?indexPage=<s:property value="indexCount" />&st_search=<%=st_search %>">[尾页]</a>&nbsp;&nbsp;
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
