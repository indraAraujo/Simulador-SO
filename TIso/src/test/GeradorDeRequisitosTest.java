package test;

import tiso.GeradorDeRequisitos;
import tiso.Requisicao;

public class GeradorDeRequisitosTest {

    GeradorDeRequisitos gera = new GeradorDeRequisitos(10, 1);
    int i;

    //Requisicao req = new Requisicao(10,"i");
    
    public void testGerarRequisicao(){
        for(i = 0; i<10; i++){

            if(gera.gerarRequisicao()!= null){
                System.out.println("Requisitos criados, SUCESSO");
                
            }
            else{
                System.out.println("Gerador de Requisitos possui falha!");
            }
        }
    }
    public void testGerarRequisicoes(int quantidade){

        gera.gerarRequisicoes(quantidade);
        if(gera.getReqGeradas()==quantidade+i){
            System.out.println("SUCESSO NO TESTE DE GERAR REQUISIÇOES");
        }
        else{
            System.out.println(gera.getReqGeradas());
        }
    }

}
