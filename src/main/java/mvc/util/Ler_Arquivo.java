/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.util;

/**
 *
 * @author fvsadmin
 */
import java.io.BufferedReader;
import java.io.FileReader;
public class Ler_Arquivo {
	public static String lerArquivo(String nome_arquivo) {
		BufferedReader br = null; 
		String ler_string="";
		try {
		String sCurrentLine;
		br = new BufferedReader(new FileReader(nome_arquivo));
		while ((sCurrentLine = br.readLine()) != null) {
		ler_string=ler_string+sCurrentLine;
		}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		try {
			if (br != null)br.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		}
		return ler_string;
	}
}