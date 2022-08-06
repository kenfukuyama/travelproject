<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 
import="java.util.Date" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <h2>Show Expense</h2>
    <p>${expense}</p>

        
    <h2>Expense: ${expense.title }</h2>
    <h3>Vendor: ${expense.vendor }</h3>
    <h3>Amount $${expense.amount }</h3>
    <h3>Description ${expense.description }</h3>

    <a href="/expenses">Back Home</a>
    
    
    
    
    

    
    
    



</body>

</html>