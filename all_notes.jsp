<%@page import="com.entity.note"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="com.helper.factoryprovider"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Notes: Note taker</title>
<%@include file="all_js_css.jsp"%>

</head>
<body>
	<div class="container-fluid p-0 m-0  ">
		<%@include file="navbar.jsp"%>
		<br>
		<h1 class="text-uppercase">All Notes :</h1>

		<div class="row">
			<div class="col-12">


				<%
				Session s = factoryprovider.getfactory().openSession();

				Query q = s.createQuery("from note");
				List<note> list = q.list();
				for (note nt : list) {
				%>

				<div class="card mt-3">
					<img class="card-img-top m-4 mx-auto" style="max-width: 100px"
						src="img/notepad.png" alt="Card image cap">
					<div class="card-body px-5">
						<h5 class="card-title"><%=nt.getTitle()%></h5>
						<p class="card-text"><%=nt.getContent()%>
						</p>
						<p ><b class="text-primary"><%= nt.getAddedDate() %></b></p>
						<div class="container text-center mt-2">
						<a href="deletesevelet?nt_id=<%=nt.getId() %>" class="btn btn-danger">Delete</a> 
						<a href="edit.jsp?nt_id=<%= nt.getId()	%>"class="btn btn btn-primary">update</a>
						</div>

					</div>
				</div>
				<%
				}
			
				 %> 
 				</div>

		</div>

	</div>
</body>
</html>