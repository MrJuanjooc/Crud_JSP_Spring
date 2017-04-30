<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title>Crud con Spring</title>
        
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    </head>
    <body>
        <div class="container">
             <div class="row">
                 <h1>Usuarios</h1>
                  <p> 
                      <a href="<c:url value="add.htm" />" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>AGREGAR</a>
                  </p>
                  <table class="table table-bordered table-striped table-hover">
                      <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>E-Mail</th>
                            <th>Telefono</th>
                            <th>Acciones</th>
                        </tr>
                      </thead> 
                      <tbody>
                          <c:forEach items="${datos}" var="dato">
                              <tr>
                                <td><c:out value="${dato.Id}" /></td>
                                <td><c:out value="${dato.Nombre}" /></td>
                                <td><c:out value="${dato.Correo}" /></td>
                                <td><c:out value="${dato.Telefono}" /></td>
                                <td>
                                    <a href="<c:url value="edit.htm?id=${dato.id}" />"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
                                    <a href="<c:url value="delete.htm?id=${dato.id}" />"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
                                </td>  
                              </tr>
                          </c:forEach>
                      </tbody>
                  </table>
            </div>
        </div>
    </body>
</html>
