<%-- 
    Document   : agenda
    Created on : 16/12/2016, 10:06:00
    Author     : marcosvinicius
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agenda</title>
        <link rel="stylesheet" href="resources/css/bootstrap.css">
    </head>
    <body>
        <div class="container">
            <h3>Contatos</h3>

            <div class="row">
                <div class="col-md-2">
                    <label class="h5"> Pesquisar </label>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4">
                    <form action="pesquisar" method="POST">
                          <input type="text" class="form-control" name="searchTerm"/>
                    </form>
                </div>

                <div class="col-md-1 pull-right">
                    <a class="btn btn-primary" href="novo"> Novo </a>
                </div>
            </div>
            <br/>
            <div class="row">
                <div class="col-md-12">

                    <table class="table table-bordered table-striped">
                        <tr>
                            <th> Código </th>
                            <th> Nome   </th>
                            <th> Email  </th>
                            <th> Telefone </th>
                            <th> Endereço </th>
                            <th> Ações </th>
                        </tr>

                        <c:forEach var="contato" items="${listContatos}">
                            <tr>
                                <td>${contato.id}</td>
                                <td>${contato.nome}</td>
                                <td>${contato.email}</td>
                                <td>${contato.telefone}</td>
                                <td>${contato.endereco}</td>
                                <td> 
                                    <a class="btn btn-info btn-sm" href="alterarcontato?id=${contato.id}"> Alterar </a>
                                    <a class="btn btn-danger btn-sm" href="excluicontato?id=${contato.id}"> Excluir </a>
                                </td>
                            </tr>
                        </c:forEach>

                    </table>

                </div>
            </div>
        </div>

        <script src="resources/js-libs/jquery.js"></script>
        <script src="resources/js-libs/bootstrap.js"></script>
    </body>
</html>
