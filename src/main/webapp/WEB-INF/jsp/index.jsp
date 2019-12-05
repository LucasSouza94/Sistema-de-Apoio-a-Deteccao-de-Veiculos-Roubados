<%-- 
    Document   : index
    Created on : 02/11/2019, 10:58:24
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina Inicial</title>
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
                
                <section class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                   
                    <a href="<c:url value='/webcam'/>" class="btn btn-primary btn-lg btn-block" role="button" aria-pressed="true" 
                       id="iniciar" style="background: black; color: yellow; border-color: black;">Iniciar Sistema</a>
                  
                </section>
                
            </div>
        </div>
       <script type="text/javascript" src="../../resources/js/jquery.js"></script>
        <script type="text/javascript" src="../../resources/js/bootstrap.min.js"></script> 
        <script>document.getElementById("iniciar").focus();</script>    
    </body>
</html>
