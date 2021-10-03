package test;

import tiso.Requisicao;
import tiso.Variavel;

public class RequisicaoTest{
  Requisicao requisicao = new Requisicao(10, "ejiolepsjk");
  

  //Teste de retornar a variavel inserida na requisição
  public void getVariavel(){
    System.out.println("Teste Variavel - Requisição.....");
    Variavel temp = new Variavel(10, "ejiolepsjk");
    if(temp.getIdentificador()==requisicao.getVariavel().getIdentificador()){
      System.out.println("Sucesso");
    }else{
      System.out.println("Falha");
      System.out.println(requisicao.getVariavel());
      System.out.println(temp);
    }
  }



  // Teste do identificador
  public void identificador(String valor){
    System.out.println("Teste Identificador - Requisicao.....");
    requisicao.setIdentificador(valor);
    if(valor == requisicao.getIdentificador()){
       System.out.println("Sucesso");
     }else{
        System.out.println("Falha");
      }
    }

  //Teste de impressão da requisição
  public void imprimir(){
    System.out.println("Teste Impressão - Requisicao.....");    
    requisicao.toString();
  }
}

