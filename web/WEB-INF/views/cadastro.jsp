<%-- 
    Document   : cadastro
    Created on : 16/12/2016, 10:34:06
    Author     : marcosvinicius
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="resources/css/bootstrap.css">
    </head>
    <body>
        <div class="container">
            <h3>Novo contato</h3>

            <c:if test="${msgErro ne null}">
                <div class="alert-danger col-md-12">
                    <span class="h4"> ${msgErro}</span>
                </div>
            </c:if>

            <form action="salvacontato" method="POST">

                <div class="row">
                    <div class="col-md-1">
                        <label class="h5"> Código </label>
                        <input type="number" class="form-control" readonly="true" name="id" value="${contato.id}" />
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-5">
                        <label class="h5">Nome</label>
                        <input type="text" class="form-control" name="nome" value="${contato.nome}"/>
                    </div>

                    <div class="col-md-5">
                        <label class="h5"> Email </label>
                        <input type="email" class="form-control" name="email" value="${contato.email}"/>
                    </div>

                    <div class="col-md-2">
                        <label class="h5"> Telefone </label>
                        <input type="tel" class="form-control" name="telefone" value="${contato.telefone}"/>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-12">
                        <label class="h5"> Endereço </label>
                        <input type="text" class="form-control" name="endereco" value="${contato.endereco}"/>
                    </div>
                </div>

                <br/>

                <div class="row">
                    <div class="col-md-4">
                        <input type="submit" class="btn btn-primary" value="Salvar"/>
                    </div>
                </div>

            </form>

        </div>
        <script src="resources/js-libs/jquery.js"></script>
        <script src="resources/js-libs/bootstrap.js"></script>
    </body>
</html>
