<%-- 
    Document   : naoCadastrado
    Created on : 13/11/2019, 14:08:02
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Erro!!!</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="<c:url value='/resources/css/Css.css'/>">
        <link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.min.css'/>">       
        <script type="text/javascript" src="../../resources/js/javascript.js"></script>      
    </head>
    <body>
        <div class="container-fluid">

            <div class="row" style="background: #000">               
                <header class=" col-lg-12 col-md-12 col-sm-12 col-xs-12 img-fluid">
                    <img src="<c:url value='/resources/img/logo3.JPG'/>" class="img-fluid" alt="Logotipo" style="width: 100%;">
                </header>
            </div>
            <br>
            
            <div class="row">
                <div class=" col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <c:forEach items="${listaVeiculo}" var="veiculo">
                        <c:forEach items="${listaVeiculo2}" var="veiculo2">
                        <div class="alert alert-danger" role="alert">
                            <h4 class="alert-heading">Desculpe!</h4>
                            <hr>
                            <p>A placa <b style="color: red">${veiculo.getPlaca()}
                                    <c:if test="${veiculo.getPlaca() != veiculo2.getPlaca()}">
                            ou ${veiculo2.getPlaca()}
                        </c:if>     
                                    </b> não cadastrado na base de dados ou Não Existe!!!
                            <p>Provaveis motivo:</p>
                             <p>   A camera não estava na posição correta;</p>
                             <p>   O veiculo esta muito distante da camera;</p>
                             <p>   A iluminação do ambiente nao esta apropriado.</p>
                               
                            </p>                       
                        </div>                       
                    </c:forEach>
                        </c:forEach> 
                </div>
            </div>

            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                    <a href="<c:url value='/webcam'/>" class="btn btn-primary btn-lg btn-block" role="button" aria-pressed="true" 
                       id="iniciar" style="background: black; color: yellow; border-color: black;">Nova Consulta</a>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                    <a href="<c:url value='/'/>" class="btn btn-primary btn-lg btn-block" role="button" aria-pressed="true" 
                       id="iniciar" style="background: black; color: yellow; border-color: black;">Pagina Inicial</a>
                </div>
            </div>

            <br>
            <div class="row"></div>
        </div>
        <script>document.getElementById("iniciar").focus();</script>    
    </body>
</html>