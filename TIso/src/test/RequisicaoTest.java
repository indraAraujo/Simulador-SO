package test;

import tiso.Requisicao;
import tiso.Variavel;

public class RequisicaoTest{
  Requisicao requisicao = new Requisicao(10, 34,"ejiolepsjk");
  

  //Teste de retornar a variavel inserida na requisição
  public void getVariavel(){
    System.out.println("Teste Variavel - Requisição.....");
    Variavel temp = new Variavel(10, "ejiolepsjk");
    if(temp.getConteudo()==requisicao.getVariavel().getConteudo()){
      System.out.println("Sucesso");
    }else{
      System.out.println("Falha");
      System.out.println(requisicao.getVariavel());
      System.out.println(temp);
    }
  }


  //Teste de impressão da requisição
  public void imprimir(){
    System.out.println("Teste Impressão - Requisicao.....");    
    requisicao.toString();
  }
}

