<%--
  Created by IntelliJ IDEA.
  User: hovhannes
  Date: 03.05.20
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>List Customers</title>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>CRM - Custom Relationship</h2>
    </div>
</div>

<div id="container">
    <div id="content">
        <!-- add out html table here-->
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
            </tr>
            <!-- loop over and print our customers-->
            <c:forEach var="tempCustomer" items="${customers}">
                <tr>
                    <td>${tempCustomer.firstName}</td>
                    <td>${tempCustomer.lastName}</td>
                    <td>${tempCustomer.email}</td>
                </tr>
            </c:forEach>

        </table>
    </div>
</div>
</body>
</html>
