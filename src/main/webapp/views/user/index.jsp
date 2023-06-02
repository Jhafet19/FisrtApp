<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>Usuarios</title>
    <jsp:include page="../../layouts/head.jsp"/>

</head>
<body>

<div class="container-fluid">
    <div class="row">
        <div class="col text-center mt-5">
            <h2>Usarios</h2>
            <p>Practica 1 servlets para realizar un CRUD de usuarios</p>
            <div class="card">
                <div class="card-header">
                    <div class="row">
                        <div class="col">Listado de usuarios </div>
                        <div class="col text-end">
                            <button class="btn btn-outline-success btn-sm">Agregar</button>
                        </div>
                    </div>

                </div>
                <div classs="card-body">
                    <table class="table table-stripped">
                        <thead>
                        <th>#</th>
                        <th>Nombre</th>
                        <th>Fecha Nacimiento</th>
                        <th>Usuario</th>
                        <th>Estado</th>
                        <th>Acciones</th>
                        </thead>
                        <tbody>
                        <c:forEach var="user " items="${users}" varStatus="s">
                            <tr>
                                <td>
                                    <c:out value="${s.count}"/>
                                </td>
                                <td>
                                    <c:out value="${user.name}"/> <c:out value="${user.surname}"/> <c:out value="${user.lastname}"/>
                                </td>
                                <td>
                                    <c:out value="${user.birthday}"/>
                                </td>
                                <td>
                                    <c:out value="${user.username}"/>
                                </td>
                                <td>
                                    <c:out value="${user.status}"/>

                                </td>
                                <td></td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td colspan="6">
                                Sin registros
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

    </div>
</div>

<jsp:include page="../../layouts/footer.jsp"/>
</body>
</html>