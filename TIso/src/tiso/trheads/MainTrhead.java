package tiso.trheads;

import tiso.Heap;
import tiso.Requisicao;
//import tiso.Requisicao;
import tiso.VetorRequisicoes;

public class MainTrhead {
    //Reader reader = new Reader("./simulador.conf");
		private static long tempoI, tempoF, tempoR, tempoT = 0;
		private static int totalDeAlocacoes = 100; // Quantidade de alocações a serem feitas
		private static int tamanhoHeap = 1500; 
		private static int minVariavel = 100; // minimo para variáveis dinâmicas
		private static int maxVariavel = 200; // maximo para ...
		private static int tamanho_vetor = 1000; // vetor de requisições
		private static int limiteMinOcupacao = 20; // Limite minimo para ocupação da heap
		private static int limiteMaxOcupacao = 80; // Limite maximo para ...
		private static int limiteFragmentacao = 80; // indice de fragmentação

		public static Heap userHeap = new Heap(tamanhoHeap);
		public static AnalisadorDeMemoriaTrhead analisadorMemoria = new AnalisadorDeMemoriaTrhead(tamanhoHeap, limiteMaxOcupacao, limiteMinOcupacao, limiteFragmentacao, userHeap);
		public static Requisicao vet_requisicoes[] = new Requisicao[tamanho_vetor];
		public static GeradorDeRequisitosTrhead geradorReq = new GeradorDeRequisitosTrhead(minVariavel, maxVariavel);
		public static AlocadorTrhead alocador = new AlocadorTrhead(tamanhoHeap, userHeap, analisadorMemoria);
        private static int maxReqPorIteracao = 3; // quant. máxima de requisições geradas por iteração;
		private static int maxProcPorIteracao = maxReqPorIteracao / 2; // quant. máxima de requisições processadas por iteração

    public static void main(String[] args){
        
		for (int k = 0; geradorReq.getReqGeradas() < totalDeAlocacoes; k ++) {
			tempoI = System.currentTimeMillis();
			System.out.println ("\n -> Na iteração " + k + ":\n");
			geradorReq.run();


            tempoF = System.currentTimeMillis();
            tempoR = tempoF - tempoI;
            System.out.println("Tempo: " + tempoR  + "s");
            tempoT += tempoR;
        }    
            
        System.out.println ("\nTodas as alocações foram realizadas:\n");
        System.out.println ("Chamadas ao desalocador: " + analisadorMemoria.getDesalocacoesFeitas());
        System.out.println ("Tempo Total: "+ tempoT + "ms");
    }
        
		
}

