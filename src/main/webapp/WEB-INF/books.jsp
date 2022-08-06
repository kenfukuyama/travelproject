<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 
import="java.util.Date" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <!-- bootstrap -->
    <!-- <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" /> -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"  crossorigin="anonymous">
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


<h1>All Books</h1>
<table class="table">
    <thead>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Language</th>
            <th>Number of Pages</th>
        </tr>
    </thead>
    <tbody>
         <!-- loop over all the books to show the details as in the wireframe! -->
         <c:forEach var="book" items="${books}">
         	<tr>
        		<td><a href="/books/${book.id }">${book.id }</a></td>
        		<td><a href="/books/${book.id }">${book.title }</td>
        		<td>${book.language }</td>
        		<td>${book.numberOfPages }</td>
				<td>
					<form action="/books/${book.id}" method="post">
						<input type="hidden" name="_method" value="delete"> 
						<input type="submit" value="Delete">
					</form>
				</td>
				</tr>
    	</c:forEach>
         
    </tbody>
</table>

    
    
    
    
    



</body>

</html>