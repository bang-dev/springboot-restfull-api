<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Personal List</title>
</head>
<body>
<h1>Personal List</h1>
<c:if test="${not empty personalList}">
    <table>
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Major</th>
        </tr>
        <c:forEach items="${personalList}" var="personal">
            <tr>
                <td>${}</td>
                <td>${personal.id}</td>
                <td>${personal.firstName}</td>
                <td>${personal.lastName}</td>
                <td>${personal.mojor}</td>
                <td>
                    <a href="<c:url value='/products?action=edit&amp;id='/>${personal.id}">Edit</a>
                    <a href="<c:url value='/products?action=delete&amp;id='/>${personal.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<a href="<c:url value='/products?action=create'/>">Create Product</a>
</body>
</html>
