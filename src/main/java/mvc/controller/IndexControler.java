/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import mvc.beans.Veiculo;
import static mvc.controller.InformacoesController.listarVeiculo;
import mvc.util.Ler_Arquivo;
import mvc.util.Morfologia;
import mvc.util.ShowWindow;
import mvc.util.Vizinhanca;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import static org.opencv.imgproc.Imgproc.THRESH_BINARY;
import static org.opencv.imgproc.Imgproc.threshold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author User
 */


@Controller
public class IndexControler {
    public Mat matImgFinal;
    public Mat matImgTrabalho;
    public String caminhoImgCarregada;
    public String texto;
    
    @RequestMapping("/")
    public String index() throws Throwable{        
        return "index";
    }
    
    @RequestMapping("/webcam")
    public String webcam(){
        deleteArquivo();      
        return "camera";
    }
    
    @RequestMapping("/carregando")
    public String processo(){
        return "processandoImagem";
    }
    
    
   
    public static void loadOpenCVNativeLibrary() {
        nu.pattern.OpenCV.loadLocally();
    }
    
    
    public String pdi() throws IOException, InterruptedException {
        Thread.sleep(3000);
        System.out.println("--------------------------------------->O tempo funcionou");
        loadOpenCVNativeLibrary();
        caminhoImgCarregada = "C:\\Users\\User.LUCAS\\Downloads\\exemplo.jpg";
        this.matImgTrabalho = Imgcodecs.imread(caminhoImgCarregada);
        matImgFinal = new Mat(matImgTrabalho.rows(), matImgTrabalho.cols(), CvType.CV_8UC1);
        Imgproc.cvtColor(matImgTrabalho, matImgFinal, Imgproc.COLOR_BGR2GRAY);
        threshold(matImgFinal, matImgFinal, 100, 255, THRESH_BINARY);
        BufferedImage converte = ShowWindow.matToBufferedImage(matImgFinal);
        BufferedImage erosao = Morfologia.erodir(converte);
        BufferedImage erosao1 = Morfologia.erodir(erosao);
        BufferedImage erosao2 = Morfologia.erodir(erosao1);
       // BufferedImage erosao3 = Morfologia.erodir(erosao2);
        BufferedImage vizinhaca = Vizinhanca.VizinhancaEstrela(erosao2);
        ImageIO.write(vizinhaca, "jpg", new File("C:\\PhotosNetbeans\\resultadofinal.jpg"));
        System.out.println("funcionou");
        deleteImagem();
        return caminhoImgCarregada;
    }
    
    public String ocr2() throws IOException, InterruptedException {
        String destinoPath = "C:\\PhotosNetbeans\\";
        String entrada_file = "C:\\PhotosNetbeans\\resultadofinal.jpg";
        String saida_file = destinoPath + "33";
        String tesseract_install_path = "C:\\Tesseract-OCR\\tesseract";
        String[] command
                = {
                    "cmd",};
        Process p;

        p = Runtime.getRuntime().exec(command);
        new Thread(new Criar_Arquivo(p.getErrorStream(), System.err)).start();
        new Thread(new Criar_Arquivo(p.getInputStream(), System.out)).start();
        PrintWriter stdin = new PrintWriter(p.getOutputStream());
        stdin.println("\"" + tesseract_install_path + "\" \"" + entrada_file + "\" \"" + saida_file + "\" -l eng");
        stdin.close();
        p.waitFor();

        String converte = Ler_Arquivo.lerArquivo(saida_file + ".txt");
        converte = converte.replace(" ", "");
        converte = removerAcentos(converte);
        converte = converte.replaceAll("[-_^~/;:,='!@#$%¨&*+§][^%^*?|=+`.}]", "");
        converte = converte.replaceAll("[^a-zA-Z0-9]", "");
        
        System.out.println("teste ocr-----------> " + converte);
        deleteImagem();
        texto = converte;
        return converte;

    }
    
    public String ocr() throws TesseractException {
        System.out.print("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("C:\\Tesseract-OCR\\tessdata");
        String text = tesseract.doOCR(new File("C:\\PhotosNetbeans\\resultadofinal.jpg"));
        System.out.print("?????????????????????????????????"+text);
        return text;
    }
    
    @RequestMapping("/informacaoVeiculo")
    public String listaVeiculo(String valor, Model model) throws IOException, InterruptedException{
         pdi();
         deleteImagem();
       
        List<Veiculo> recebe = new ArrayList();
        recebe = listarVeiculo(ocr2());
        for(Veiculo string : recebe)
            if(string.getAnoFabricação() == null){
                //teste
                List<Veiculo> recebe2 = new ArrayList();
                recebe2 = listarVeiculo(validacao());
                for(Veiculo string2 : recebe2)
                    if(string2.getAnoFabricação() != null){
                        model.addAttribute("listaVeiculo", recebe2);
                        return "informacaoVeiculo";
            }//ate aqui
                System.out.println("estamos aqui6");
                model.addAttribute("listaVeiculo", recebe);
                model.addAttribute("listaVeiculo2", recebe2);
                return "naoCadastrado";
            }else{
                System.out.println("estamos aqui7");
                model.addAttribute("listaVeiculo", recebe);
            return "informacaoVeiculo";
            }
             
        return "naoCadastrado";
    }
    
    public static void deleteImagem() {  
       File inFile = (new File("C:\\Users\\User.LUCAS\\Downloads\\exemplo.jpg"));
       inFile.delete();         
     } 
    
    public static void deleteArquivo() {  
       File inFile = (new File("C:\\PhotosNetbeans\\33.txt"));
       inFile.delete();         
     } 
   
    public static String removerAcentos(String valorAcentuado){
          return Normalizer
          .normalize(valorAcentuado, Normalizer.Form.NFD)
          .replaceAll("[^\\p{ASCII}]", "");
    }
    
    public String validacao(){
        String valor = texto;
        valor = valor.replaceAll("[a-z]", "");
        
        if (valor.length() == 0) {
            return "";
        }
        
        if (valor.length() == 8) {
            char chars[] = valor.toCharArray();
            chars [3] = ' '; 
             valor = new String (chars);
             valor = valor.replace(" ", "");
        }
        if (valor.length() == 6) {
            valor = valor.concat("1");
        }
        String texto3 = valor.substring(0, 3);
        if (texto3 != "") {
            texto3 = texto3.replace("U","Q");
            texto3 = texto3.replace("5","S");
            texto3 = texto3.replace("0", "O");
            texto3 = texto3.replace("1", "I");
            texto3 = texto3.replace("O", "Q");
            texto3 = texto3.replace("2", "Z");
        }
        
        String texto4 = valor.substring(3, valor.length());
        if (texto4 != "") {
            texto4 = texto4.replace("I","1");
            texto4 = texto4.replace("B","8");
            texto4 = texto4.replace("O","0");
            texto4 = texto4.replace("S","9");
            texto4 = texto4.replace("G","6");
        }
       
      //  System.out.println(texto4);
        String resultado = texto3.concat(texto4);
        System.out.println("---------->Valor da validacao "+resultado);
        return resultado;
    }
    
    /*public void Simulador(String valor) throws IOException {
        String url = "http://detran.pb.gov.br/portalparaiba/portal"
                + "_detranpb/veiculo/consulta-do-veiculo";
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        HtmlPage paginaPrincipal = webClient.getPage(url);

        paginaPrincipal.getElementById("placa").setAttribute("value", valor);

        HtmlSubmitInput anchor = (HtmlSubmitInput) paginaPrincipal.getElementById("st");
        anchor.click();
    }*/
    
    
}
