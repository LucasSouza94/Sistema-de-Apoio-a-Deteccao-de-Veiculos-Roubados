/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

/**
 *
 * @author fvsadmin
 */
import java.io.InputStream;
import java.io.OutputStream;
class Criar_Arquivo implements Runnable
{
public Criar_Arquivo(InputStream entrada, OutputStream saida) {
      entrada_ = entrada;
      saida_ = saida;
  }
  public void run() {
      try
      {
          final byte[] buffer = new byte[1024];
          for (int length = 0; (length = entrada_.read(buffer)) != -1; )
          {
              saida_.write(buffer, 0, length);
          }
      }
      catch (Exception e)
      {
          e.printStackTrace();
      }
  }
  private final OutputStream saida_;
  private final InputStream entrada_;
}