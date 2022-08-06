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


    <h2>Expenses</h2>
    <p>${expenses}</p>
    <table class="table">
        <thead>
            <tr>
                <th>ID</th>
                <th>Expense</th>
                <th>Vendor</th>
                <th>Ammout</th>
                <th>Edit</th>
                <th>Delete</th>
    
            </tr>
        </thead>
        <tbody>
            <!-- loop over all the expenses to show the details as in the wireframe! -->
            <c:forEach var="expense" items="${expenses}">
                <tr>
                    <td>${expense.id}</td>
                    <td><a href="/expenses/${expense.id }">${expense.title}</a></td>
                    <td>${expense.vendor}</td>
                    <td>${expense.amount}</td>
                    <td><a href="/expenses/${expense.id}/edit">Edit</td>
                    <td>					
                        <form action="/expenses/${expense.id}" method="post">
                            <input type="hidden" name="_method" value="delete">
                            <input class="btn btn-danger" type="submit" value="Delete">
                        </form>
                    </td>

                </tr>
            </c:forEach>

    
        </tbody>
    </table>
    
    <form:form action="/expenses" method="post" modelAttribute="expense">
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
            <!-- it has to match the Expense class -->
        </p>
        <input type="submit" value="Submit" />
    </form:form>


</body>

</html>