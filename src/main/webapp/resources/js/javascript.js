function validarFC(){
    if(checkFC() == true){
        alert("Sua Mensagem foi Enviada!!");
    }    
}

function checkFC(){
    var nome = $("#nome").val();
    var email = $("#email").val();
    var fone = $("#fone").val();
    var comentario = $("#comentario").val();
    
    if(nome == ""){
        alert("Digite seu Nome");
        return false;
    } else if((email.indexOf("@") || email.indexOf(".com")) == -1){
            alert("Seu email tem que ter '@' e '.com'");
            return false; 
    } else if(fone.length > 11){
            alert("Seu numero de telefone tem mais digitos do que deveria");
            return false; 
    } else if(fone.length < 10){
            alert("Seu numero de telefone esta incompleto");
            return false; 
    } else if(comentario == ""){
        alert("Digite algum comentario");
        return false;
    } else{
        return true;
    }
}

function  addUsuario(){ 
    var usuarios = localStorage.getItem("usuarios");// Recupera os dados armazenados
    usuarios = JSON.parse(usuarios); // Converte string para objeto
    
    if(usuarios == null){ // Caso não haja conteúdo, iniciamos um vetor vazio
        usuarios = [];
    }
    usuario = JSON.stringify({
        Nome : $("#nomeC").val(),
        Usuario : $("#login").val(),
        Senha : $("#senha").val()
    });
       
       aux = JSON.parse(usuario);
       if (checkar(aux.Usuario) == true){
           usuarios.push(usuario);
           localStorage.setItem("usuarios", JSON.stringify(usuarios));
           alert("Cadastro realizado com sucesso!!");
       }else{
           alert("O login: "+ aux.Usuario+"ja existe!!");
       }
    
}

function checkar(login){
    if(!localStorage.getItem("usuarios")){
	return true;
    }else{
        itens = "";			
        usuarios = JSON.parse(localStorage.getItem("usuarios"));
        for(i=0; i < usuarios.length; i++){
            aux = JSON.parse(usuarios[i]);
            itens = aux.Usuario;
            if(login == aux.Usuario){
                return false;          
            }
        }
        return true;
    }
}

function vUsuario(){if (checkUsuarios()() == true){}}
function checkUsuarios(){
    var login = $("#login").val();
    var senha = $("#senha").val();
    
    itens = "";			
    usuarios = JSON.parse(localStorage.getItem("usuarios"));
        for(i=0; i < usuarios.length; i++){
            aux = JSON.parse(usuarios[i]);
            itens1 = aux.Usuario;
            itens2 = aux.Senha;
            
            if(login == itens1 && senha == itens2){
                $("#usuario").html(aux.Nome);
                alert("Seja Bem-Vindo!!");
                pegarUsuario(aux.Nome);
                return true;
                
            }
        }
        alert("Login ou Senha Invalida!!");
        return false;
}

function pegarUsuario(nome){
    window.localStorage.setItem("usu",nome);
}
function mostrarUsuario(){
    var usu = window.localStorage.getItem("usu");
    $("#usuario").html(usu);       
}
function deslogar(){
    window.localStorage.setItem("usu","Voce nao esta logado!!");
    var usu = window.localStorage.getItem("usu");
    $("#usuario").html(usu); 
    localStorage.removeItem("carC");
}

function pegarProduto(){
    pro = [];
    Produto = JSON.stringify({
        Nome : $("#produto").text(),
        Valor : $("#preco").text()
    });
       
    pro.push(Produto);
    localStorage.setItem("pro", JSON.stringify(pro));
}

function mostrarProduto(){
    nome = "";
    valor = "";
    pro = JSON.parse(localStorage.getItem("pro"));
        produto = JSON.parse(pro);
        nome = produto.Nome;
        valor = produto.Valor;
            			
        $("#rProduto").val(nome);
        $("#rValor").val(valor);
}

function verificarLogin(){
    var usu = window.localStorage.getItem("usu");
    if(usu == "Voce nao esta logado!!"){
        alert("Voce nao esta logado!!");
    }else{
        addCarrinho();
    }
}

function addCarrinho(){
    var carC = localStorage.getItem("carC");// Recupera os dados armazenados
    carC = JSON.parse(carC); // Converte string para objeto
    
    if(carC == null){ // Caso não haja conteúdo, iniciamos um vetor vazio
        carC = [];
    }
    Produto = JSON.stringify({
        Nome : $("#rProduto").val(),
        Valor : $("#rValor").val()
    });
    carC.push(Produto);
    localStorage.setItem("carC", JSON.stringify(carC));
    alert("Seu produto " +produto.Nome + " foi adicionado!!");
    
}
function listardeProdutos(){
    if(!localStorage.getItem("carC")){
	$("#carrinho").html("Voce nao tem produtos!!");
    }else{
        itens = "";			
        carC = JSON.parse(localStorage.getItem("carC"));
        for(i=0; i < carC.length; i++){
            produto = JSON.parse(carC[i]);
            itens = produto.Nome+ " - R$"+ produto.Valor+"<br>" + itens;
           
        }			
        $("#carrinho").html(itens);
    }
}


function fim(){
    alert("Sua compra foi realizada com sucesso!!");
    localStorage.removeItem("carC");
}
/*
function adicionar(){
    var tbP = localStorage.getItem("tbP");// Recupera os dados armazenados
    tbP = JSON.parse(tbP); // Converte string para objeto
    
    if(tbP == null){ // Caso não haja conteúdo, iniciamos um vetor vazio
        tbP = [];
    }
    listaProduto = JSON.stringify({
        Codigo : $("#codigo").val(),
        Nome : $("#nome").val(),
        Valor : $("#valor").val()
    });
    
    tbP.push(listaProduto);
    localStorage.setItem("tbP", JSON.stringify(tbP));
    alert("Produto add com sucesso");
}


function listarProdutos(){
    if(!localStorage.getItem("tbP")){
	document.getElementById("lista").innerHTML  = "Voce nao tem produtos!!";
    }else{
        itens = "";			
        tbP = JSON.parse(localStorage.getItem("tbP"));
        for(i=0; i < tbP.length; i++){
            produto = JSON.parse(tbP[i]);
        
            itens = produto.Nome+ " - R$"+ produto.Valor+"<br>" + itens;
        }			
        $("#lista").html(itens);
    }
}

function excluirProdutos(){
    localStorage.removeItem("tbP");
    listarProdutos();
}
*/
