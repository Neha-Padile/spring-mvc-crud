<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<html>
<head>

    <title>User Management Application</title>
    <link rel="stylesheet"
        href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">
</head>
<script>function deleteUser(userId) {
            fetch('/deleteUser/' + userId, {
                method: 'DELETE'
            }).then(response => {
                if (response.ok) {
                    window.location.href = "/users";
                } else {
                    alert('Failed to delete user.');
                }
            }).catch(error => {
                console.error('Error:', error);
                alert('An error occurred while deleting the user.');
            });
        }
        </script>
<body>
    <header>
        <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
            <div>
                <a href="https://www.javaguides.net" class="navbar-brand" style="font-weight: bold;"> User Management App </a>
            </div>
            <ul class="navbar-nav">
                <li><a href="<c:url value='/getalluser' />" class="nav-link">Users</a></li>
            </ul>
        </nav>
    </header>
    <br>

    <div class="row">
        <div class="container">
            <h3 class="text-center" style="color:#17a2b8;" >List of Users</h3>
            <hr>
            <a href="<c:url value='/addPage' />" class="btn btn-success"> Go To Add User</a>
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Address</th>
                        <th>Pincode</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Iterate over the list of users -->
                    <c:forEach var="user" items="${users}">
                        <tr>
                            <td><c:out value="${user.id}" /></td>
                            <td><c:out value="${user.name}" /></td>
                            <td><c:out value="${user.address}" /></td>
                            <td><c:out value="${user.pincode}" /></td>
                            <td>

                                <a href="${pageContext.request.contextPath}/editUser?id=${user.id}" class="btn btn-Warning">Edit</a>  |
                                <a href="${pageContext.request.contextPath}/deleteUser?id=${user.id}" class="btn btn-Info">Delete</a>

                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>


