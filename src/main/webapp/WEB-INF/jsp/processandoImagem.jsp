<%-- 
    Document   : processandoImagem
    Created on : 15/11/2019, 10:16:52
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Processando Imagem</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="<c:url value='/resources/css/Css.css'/>">
        <link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.min.css'/>">       
        <script type="text/javascript" src="../../resources/js/javascript.js"></script>      
    </head>
    <body onload="proxima()">
        <div class="container-fluid">
            <div class="row" style="background: #000">               
                <header class=" col-lg-12 col-md-12 col-sm-12 col-xs-12 img-fluid">
                    <img src="<c:url value='/resources/img/logo3.JPG'/>" class="img-fluid" alt="Logotipo" style="width: 100%;">
                </header>
            </div>
                <br>
                <div class="row">
                    <h4 style="text-align: center"><b>Executando os Processos de: PDI - OCR - RI.</b></h4>
                </div>   
                <br>
            <div class="row">
                <section class="col-lg-3 col-md-3 col-sm-3 col-xs-3"></section>
                <section class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
                    <div>
                        <img src="<c:url value='/resources/img/processando.gif'/>" alt="Processando imagem">
                    </div>
                </section>
                <section class="col-lg-4 col-md-4 col-sm-4 col-xs-4"></section>
            </div>
        </div>
        
        
        <script type="text/javascript" src="../../resources/js/jquery.js"></script>
        <script type="text/javascript" src="../../resources/js/bootstrap.min.js"></script>
        
        <script>
            
           function proxima(){              
                window.location.href = "<c:url value="/informacaoVeiculo"/>";
            }
        </script>
    </body>
</html>
