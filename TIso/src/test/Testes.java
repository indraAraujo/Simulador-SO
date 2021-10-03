package test;

import tiso.Variavel;
import tiso.VariavelAlocada;

/*
*   Conjunto de testes automatizados e manuais para o simulador
*/

public class Testes {
    public static void main(String[] args){

        //*------------------------ TESTES UNITÁRIOS ---------------------------------------

        //CLASSE DE TESTE PARA O VETOR DE REQUISIÇÕES
       VetorRequisicoesTest vetor_requisicoes = new VetorRequisicoesTest();
         vetor_requisicoes.inserir();
         vetor_requisicoes.remover();
         

         //CLASSE DE TESTE PARA A HEAP
        HeapTest heap = new HeapTest();
        heap.inserir('i', 56);
        heap.imprimir();
        heap.remover(56);
        heap.imprimir();
       
        //CLASSE DE TESTE PARA A VARIAVEL
        VariavelTest variavel = new VariavelTest();
        variavel.registrador_base(0, 56);
        variavel.registrador_tamanho(0, 56);
        variavel.conteudo();
        variavel.tamanho();
        variavel.imprimir();
        
        //CLASSSE DE TESTE PARA A REQUISIÇÃO
        RequisicaoTest requisicao = new RequisicaoTest();
        requisicao.getVariavel();
        requisicao.identificador("0");
        requisicao.imprimir(); //Verificar pois não esta imprimindo *************************************
         
        //CLASSE DE TESTE PARA DESALOCADOR DE MEMÓRIA
        DesalocadorDeMemoriaTest desalocadortest = new DesalocadorDeMemoriaTest();
        VariavelAlocada variavel2 = new VariavelAlocada(0, 5, "1");
        desalocadortest.desalocarVartest(variavel2);

        //CLASSE DE TESTE PARA GERADOR DE REQUISITOS
  


     }
    }

