/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import mvc.beans.Veiculo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;


/**
 *
 * @author fvsadmin
 */
@Controller
public class InformacoesController { 
    
    public static String TextoPlaca(String valor){
   //    String site = "http://wsdetran.pb.gov.br/DT_DUT_CLIENTE/ConsultaDUT?placaMask=qse-1706&display=web&placa=qse1706&display=web&st=";             
        String texto1 = valor.replace("-", ""); 
        System.out.println("teste texto 1 = "+texto1);
        StringBuffer texto2 = new StringBuffer(texto1);
        texto2.insert(3, "-");
        System.out.println("teste texto 2 = "+texto2);      
        String alterado = "http://wsdetran.pb.gov.br/DT_DUT_CLIENTE/ConsultaDUT?placaMask="+texto2+"&display=web&placa="+texto1+"&display=web&st=";
        System.out.println(alterado);
        return alterado;
   }
    
    
    
    public static List<Veiculo> listarVeiculo(String valor) throws IOException{       
        List<Veiculo> listaVeiculo = new ArrayList<Veiculo>();
        Veiculo carro = new Veiculo();
        List lista = new ArrayList();
        
        if("".equals(valor)){
            carro.setPlaca(valor);
            listaVeiculo.add(carro);
            return listaVeiculo;
        }else{
        
        Document doc = Jsoup.connect(TextoPlaca(valor)).get();
        
        String validar = null;
        Elements info = doc.select("h2");
        System.out.println("estamos aqui");
        for(Element p : info)
            validar = p.text();
        if(validar == null){
        
        Elements informacoes = doc.select("b");
        
        for(Element p : informacoes)
            lista.add(p.text());
         
        carro.setUltimo_Licenciamento(lista.get(16).toString());
        carro.setProprietário(lista.get(17).toString());
        carro.setPlaca(lista.get(18).toString());
        carro.setCombustível(lista.get(19).toString());
        carro.setMarcaModelo(lista.get(20).toString());
        carro.setEspécieTipo(lista.get(21).toString());
        carro.setAnoFabricação(lista.get(22).toString());
        carro.setAnoModelo(lista.get(23).toString());
        carro.setCategoria(lista.get(24).toString());
        carro.setCorPredominante(lista.get(25).toString());
        carro.setVencimentoLicenciamento(lista.get(26).toString());
        carro.setRestrição(lista.get(28).toString());
        carro.setFinanceira(lista.get(29).toString());
        carro.setMunicípio(lista.get(30).toString());
        carro.setSituação(lista.get(31).toString());
        carro.setDataConsulta(lista.get(32).toString());
        
        listaVeiculo.add(carro);
        System.out.println("-----------------"+carro.getPlaca()+"------------------");
        System.out.println("estamos aqui2");
        return listaVeiculo;
        
        }else{
            carro.setPlaca(valor);
            listaVeiculo.add(carro);
            return listaVeiculo;
        }
        }
    }
    
    /*
     public void Simulador(String valor) throws IOException {
        String url = "http://detran.pb.gov.br/portalparaiba/portal_detranpb/veiculo/consulta-do-veiculo";
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        HtmlPage paginaPrincipal = webClient.getPage(url);

        paginaPrincipal.getElementById("placa").setAttribute("value", valor);

        HtmlSubmitInput anchor = (HtmlSubmitInput) paginaPrincipal.getElementById("st");
        anchor.click();
    }*/
}
