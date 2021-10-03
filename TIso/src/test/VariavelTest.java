package test;

import tiso.Variavel;

public class VariavelTest{
    Variavel variavel = new Variavel(10, "kloplkjhuj");

    //Teste do registrador base
    public void registrador_base(int valor, int valor2){
      System.out.println("Teste Registrador Base - Variavel.....");
      variavel.setRegBase(valor, valor2);
      if(valor == variavel.getRegBase()){
        System.out.println("Sucesso");
      }else{
        System.out.println("Falha");        
      }
    }



    //teste do registrador tamanho
    public void registrador_tamanho(int valor, int valor2){
      System.out.println("Teste Registrador tamanho - Variavel.....");
      variavel.setRegBase(valor, valor2);
    
      if(valor == variavel.getRegTamanho()){
         System.out.println("Sucesso");
      }
      else{
         System.out.println("Falha");
      }
    }

    //Teste de conteúdo
    public void conteudo(){
      System.out.println("Teste Conteudo - Variavel.....");
      if("kloplkjhuj" == variavel.getIdentificador()){
        System.out.println("Sucesso");
      }else{
        System.out.println("Falha");
      }
    }
  

    //Teste de tamanho
    public void tamanho(){
      System.out.println("Teste Tamanho - Variavel.....");
      if(10 == variavel.getTam()){
        System.out.println("Sucesso");
      }else{
        System.out.println("Falha");
      }
    }

    //Teste de impressão da variavel
    public void imprimir(){
      System.out.println("Teste Impressão - Variavel.....");
      System.out.println(variavel.toString());
    }
}