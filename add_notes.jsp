<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Notes</title>
<%@include file="all_js_css.jsp" %>

</head>
<body>
<div class="container-fluid p-0 m-0  ">
<%@include file="navbar.jsp" %>
<br>
<h1>Please Fill Your note deatil</h1>

<!-- this is add from -->

<form action="savenotesevlet" method="post">
  <div class="form-group">
    <label for="title">Note title</label>
    <input required="required" type="text" name="title" class="form-control" id="title" aria-describedby="emailHelp" placeholder="Enter here">
   </div>
  <div class="form-group">
    <label for="content">Note Content</label>
    <textarea name="content" required="required" id="content" placeholder="Enter your content" class="form-control" style="height: 200px"></textarea>
   </div>
   <div class="container text-center">
     <button type="submit" class="btn btn-primary">Add</button>
   
   </div>
</form>
</div>
</body>
</html>