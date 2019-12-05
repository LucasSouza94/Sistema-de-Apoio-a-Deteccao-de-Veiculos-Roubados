<%-- 
    Document   : camera
    Created on : 11/11/2019, 09:39:23
    Author     : User
href="<c:url value="/processarImagem"/>"
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Capturar Imagem</title>
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
                    
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 ">
                        <a class="btn btn-primary btn-lg btn-block" role="button" aria-pressed="true" id="capture"
                           style="background: black; color: yellow; border-color: black;">Capturar</a>
                    </div> 
                   
                </div>                    
                <br>
                <div class="row">
                    <section class="col-lg-6 col-md-6 col-sm-6 col-xs-6"><video id="player" controls autoplay></video></section>
                    <section class="col-lg-6 col-md-6 col-sm-6 col-xs-6"><canvas id="snapshot" width=620 height=480></canvas></section>
                </div>             
        </div>
        
        
        <script>  
          
          var player = document.getElementById('player'); 
          var snapshotCanvas = document.getElementById('snapshot');
          var captureButton = document.getElementById('capture');
          var videoTracks;

          var handleSuccess = function(stream) {
            // Attach the video stream to the video element and autoplay.
            player.srcObject = stream;
            videoTracks = stream.getVideoTracks();
          };

          captureButton.addEventListener('click', function() {
            var context = snapshot.getContext('2d');
            // Draw the video frame to the canvas.
            context.drawImage(player, 0, 0, snapshotCanvas.width, 
                snapshotCanvas.height);
                
                // Stop all video streams.
            videoTracks.forEach(function(track) {track.stop()});
            var obj = {};
            obj = salvarImagem('exemplo.jpg');
          });
        
          navigator.mediaDevices.getUserMedia({video: true})
              .then(handleSuccess);  
      

        function salvarImagem(a){
	   var meucanvas = document.getElementById('snapshot');
	   var arquivo = document.getElementById('capture');
	   /*Comentário: a variavel "a" será o nome do arquivo, use aspas para chamar a função */
	   arquivo.download = a;
	   arquivo.href = meucanvas.toDataURL();
          window.location.href = "<c:url value="/carregando"/>";
	}
        
        </script>
       <script>document.getElementById("capture").focus();</script>    
    </body>
</html>

