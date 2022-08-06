<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 
import="java.util.Date" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!-- for forms -->
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
    <title>Edit</title>
</head>
		
<body>

	<div class="container">


        <h3>${expense}</h3>

        <form:form action="/expenses/${expense.id}" method="post" modelAttribute="expense">
            <input type="hidden" name="_method"  value="put">

            <p>
                <form:label path="title">Title: </form:label>
                <form:input path="title" />
                <form:errors  class="text-danger" path="title" />
            </p>
            <p>
                <form:label path="vendor">vendor:</form:label>
                <form:textarea path="vendor" />
                <form:errors class="text-danger" path="vendor" />
            </p>
            <p>
                <form:label path="amount">amount: </form:label>
                <form:input type="number" path="amount" />
                <form:errors class="text-danger" path="amount" />
            </p>
            <p>
                <form:label path="description">Description: </form:label>
                <form:input type="text" path="description" />
                <form:errors class="text-danger" path="description" />
                <!-- it has to match the Book class -->
            </p>
            
            <input type="submit" value="Submit"/>

            
        </form:form>

	</div>

</body>

</html>