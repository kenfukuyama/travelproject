<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 
import="java.util.Date" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- for forms -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!--  mgiht show error-->
<%@ page isErrorPage="true" %>  


<!DOCTYPE html>
<html>
<head>
    <!-- bootstrap -->
    <!-- <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" /> -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <!-- regularcss -->
    <link rel="stylesheet" type="text/css" href="/css/style.css">

    <!-- bootstrap js -->
    <!-- <script src="/webjars/jquery/jquery.min.js"></script> -->
    <!-- <script src="/webjars/bootstrap/js/bootstrap.min.js"></script> -->

    <!-- regular js -->
    <script type="text/javascript" src="/javascript/script.js"></script>

    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>

<body>

	<div class="container">
	
	<h2>New Book</h2>
	<%-- <form action="/books" method="post">
		<div class="form-group">
			<label for="title"></label> 
			<input
				type="text" class="form-control" id="title" name="title"
				aria-describedby="emailHelp" placeholder="Enter email"> 
		</div>
		<div class="form-group">
			<label for="description"></label> 
			<input
				type="text" class="form-control" id="description"  name="description" placeholder="description"> 
		</div>
		
		<div class="form-group">
			<label for="language"></label> 
			<input
				type="text" class="form-control" id="language"    name="language" placeholder="language"> 
		</div>
		
		<div class="form-group">
			<label for="pages"></label> 
			<input
				type="text" class="form-control" id="pages"    name="pages" placeholder="pages"> 
		</div>
	
	
		<button type="submit" class="btn btn-primary">Submit</button>
	</form> --%>
		<form:form action="/books" method="post" modelAttribute="book">
			<p>
				<form:label path="title">Title</form:label>
				<form:errors path="title" />
				<form:input path="title" />
			</p>
			<p>
				<form:label path="description">Description</form:label>
				<form:errors path="description" />
				<form:textarea path="description" />
			</p>
			<p>
				<form:label path="language">Language</form:label>
				<form:errors path="language" />
				<form:input path="language" />
			</p>
			<p>
				<form:label path="numberOfPages">Pages</form:label>
				<form:errors path="numberOfPages" />
				<form:input type="number" path="numberOfPages" />
				<!-- it has to match the Book class -->
			</p>
			<input type="submit" value="Submit" />
		</form:form>



	</div>

</body>

</html>