<%@page import="com.entity.note"%>
<%@page import="com.helper.factoryprovider"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_js_css.jsp" %>

</head>
<body>
<div class="container-fluid p-0 m-0  ">
		<%@include file="navbar.jsp"%>
		<br>
		<h1>Edit Your Note</h1>
		<%
		
		int noteid=Integer.parseInt(request.getParameter("nt_id"));
		
		Session s=factoryprovider.getfactory().openSession();
		
		note not=s.get(note.class, noteid);
		
		
		
		%>
		<form action="updateservelet" method="post">
		<input value="<%=not.getId() %>" name="noteid" type="hidden">
  <div class="form-group">
    <label for="title">Note title</label>
    <input required="required" type="text" name="title" class="form-control" id="title" aria-describedby="emailHelp" placeholder="Enter here" value="<%=not.getTitle() %>">
   </div>
  <div class="form-group">
    <label for="content">Note Content</label>
    <textarea name="content" required="required" id="content" placeholder="Enter your content" class="form-control" style="height: 200px" <%= not.getContent() %>></textarea>
   </div>
   <div class="container text-center">
     <button type="submit" class="btn btn-success">Updated</button>
   
   </div>
</form>
		</div>
</body>
</html>