package test;

import tiso.Variavel;
import tiso.VariavelAlocada;
import tiso.Threads.Heap;

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
        variavel.registrador_base(0);
        variavel.registrador_tamanho(56);
        variavel.conteudo();
        variavel.tamanho();
        variavel.imprimir();
        
        //CLASSSE DE TESTE PARA A REQUISIÇÃO
        RequisicaoTest requisicao = new RequisicaoTest();
        requisicao.getVariavel();
        requisicao.imprimir(); 
         
        //CLASSE DE TESTE PARA DESALOCADOR DE MEMÓRIA
        DesalocadorDeMemoriaTest desalocadortest = new DesalocadorDeMemoriaTest();
        VariavelAlocada variavel2 = new VariavelAlocada(1, 5,   "1");
        desalocadortest.desalocarVartest(variavel2);

        //CLASSE DE TESTE PARA GERADOR DE REQUISITOS
        GeradorDeRequisitosTest geradorDeRequisitosTest = new GeradorDeRequisitosTest();
        geradorDeRequisitosTest.testGerarRequisicao();
        geradorDeRequisitosTest.testGerarRequisicoes(10);
  
        //CLASSE DE TESTE PARA BURACOS
        BuracoTest holeTest = new BuracoTest();
        holeTest.getInicioTest();
        holeTest.getFimTest();
        holeTest.getTamanhoTest();

        //CLASSE DE TESTE PARA ANALISADOR
        Heap heap_real = new Heap(200);
        for(int i=0; i<89; i++){
            heap_real.addHeap('x', i);
        }
        AnalisadorTest analisador = new AnalisadorTest(heap_real);
        analisador.first_fit();
        analisador.monitorar_fragmentacao();
        analisador.monitorar_ocupacao();


     }
    }

