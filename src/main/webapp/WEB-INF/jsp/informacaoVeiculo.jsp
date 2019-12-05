<%-- 
    Document   : InformacaoVeiculo
    Created on : 23/09/2019, 13:59:19
    Author     : fvsadmin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informações do Veiculo</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="<c:url value='/resources/css/Css.css'/>">
        <link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.min.css'/>">       
        <script type="text/javascript" src="../../resources/js/javascript.js"></script>      
    </head>
    <body>
        <div class="container-fluid">
            <c:forEach items="${listaVeiculo}" var="veiculo">
                <div class="row" style="background: #000">               
                <header class=" col-lg-12 col-md-12 col-sm-12 col-xs-12 img-fluid">
                    <img src="<c:url value='/resources/img/logo3.JPG'/>" class="img-fluid" alt="Logotipo" style="width: 100%;">
                </header>
            </div>
                <br>
                
                <div class="row">
                    <section class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                        <c:set var="texto" value="RESTRICAO ROUBO/FURT"/>
                        <c:if test="${veiculo.getSituação() == texto}">
                            <img src="<c:url value='/resources/img/roubado.png'/>" alt="Imagem de Roubado" style="width: 100%; text-align: center;">
                        </c:if>
                        <c:if test="${veiculo.getSituação() != texto}">
                            <img src="<c:url value='/resources/img/certo.png'/>" alt="Imagem Certo" style="width: 100%; text-align: justify;">
                        </c:if>
                    </section>
                    <section class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                        <table class="table table-striped table-dark">
                            <thead class="thead-dark">
                                <tr>
                                    <th colspan="2" style="text-align: center; background: black;" scope="col"><b style="color: yellow">DADOS DO VEÍCULO</b></th>
                                </tr>
                            </thead>
                            <td>Ultimo Licenciamento</td>
                            <td>${veiculo.getUltimo_Licenciamento()}</td>
                            </tr>
                            <tr>
                                <td>Proprietário</td>
                                <td>${veiculo.getProprietário()}</td>
                            </tr>
                            <tr>
                                <td>Placa</td>
                                <td><b style="color: red">${veiculo.getPlaca()}</b></td>
                            </tr>
                            <tr>
                                <td>Combustível</td>
                                <td>${veiculo.getCombustível()}</td>
                            </tr>
                            <tr>
                                <td>Marca/Modelo</td>
                                <td>${veiculo.getMarcaModelo()}</td>
                            </tr>
                            <tr>
                                <td>Situação</td>
                                <td ><b style="color: red">${veiculo.getSituação()}</b></td>
                            </tr>
                            <tr>
                                <td>Espécie/Tipo</td>
                                <td>${veiculo.getEspécieTipo()}</td>
                            </tr>
                            <tr>
                                <td>Ano de Fabricação</td>
                                <td>${veiculo.getAnoFabricação()}</td>
                            </tr>
                            <tr>
                                <td>Ano do Modelo</td>
                                <td>${veiculo.getAnoModelo()}</td>
                            </tr>
                            <tr>
                                <td>Categoria</td>
                                <td>${veiculo.getCategoria()}</td>
                            </tr>
                            <tr>
                                <td>Cor Predominante</td>
                                <td>${veiculo.getCorPredominante()}</td>
                            </tr>
                            <tr>
                                <td>Vencimento da Licenciamento</td>
                                <td>${veiculo.getVencimentoLicenciamento()}</td>
                            </tr>
                            <tr>
                                <td>Restrição</td>
                                <td>
                                    <c:set var="sit" value=""/>
                                    <c:if test="${veiculo.getRestrição() == sit}">
                                    *******************
                                    </c:if>
                                    ${veiculo.getRestrição()}
                                </td>
                            </tr>
                            <tr>
                                <td>Financeira</td>
                                <td>
                                    <c:if test="${veiculo.getFinanceira() == sit}">
                                    *******************
                                    </c:if>
                                    ${veiculo.getFinanceira()}
                                </td>
                            </tr>
                            <tr>
                                <td>Município</td>
                                <td>${veiculo.getMunicípio()}</td>
                            </tr>                        
                            <tr>
                                <td>Data da Consulta</td>
                                <td>${veiculo.getDataConsulta()}</td>
                            </tr>
                        </table>
                    </c:forEach>
            </div>
                <div class="row">
                    <h4 style="text-align: center"><b>*Consulta Realiza na Base de Dados do Detran - PB.</b></h4>
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
