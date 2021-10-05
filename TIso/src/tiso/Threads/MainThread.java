package tiso.Threads;

import tiso.VetorRequisicoes;

public class MainThread {

    private static long tempoI, tempoF, tempoR, tempoT;
	public static long dormir = 500, t_Alocador, t_Desalocador, t_Gerador, t_Analisador; // coloca as trheads para dormir por 3s
	public static int totalDeAlocacoes = 1500; // Quantidade de alocações a serem feitas
	public static int tamanhoHeap = 1000; 
	public static int minVariavel = 50; // minimo para variáveis dinâmicas
	public static int maxVariavel = 400; // maximo para ...
	public static int tamanho_vetor = 200; // vetor de requisições
	public static int limiteMinOcupacao = 20; // Limite minimo para ocupação da heap
	public static int limiteMaxOcupacao = 80; // Limite maximo para ...
	public static int limiteFragmentacao = 80; // indice de fragmentação
	public static boolean terminou = false;
    public static Heap userHeap = new Heap(tamanhoHeap);
    public static GeradorDeRequisitosTrhead geradorReq = new GeradorDeRequisitosTrhead(minVariavel, maxVariavel, totalDeAlocacoes, dormir);
    public static VetorRequisicoes vetor_Req = new VetorRequisicoes();
	public static AlocadorTrhead malloc = new AlocadorTrhead( dormir, totalDeAlocacoes);
	public static AnalisadorDeMemoriaThread analiser = new AnalisadorDeMemoriaThread();

    public static void main(String[] args) throws InterruptedException{
		tempoI = System.nanoTime();
		Thread ger_Req_Thread = new Thread(geradorReq);
		Thread aloc_Thread = new Thread(malloc);
		Thread analiser_Thread = new Thread(analiser);
		
		ger_Req_Thread.start();
		aloc_Thread.start();
		analiser_Thread.start();
		try {
			ger_Req_Thread.join();
			aloc_Thread.join();
			analiser_Thread.join();
		} catch (Exception e) {
			
		}

		tempoF = (System.nanoTime());
		tempoR = (tempoF - tempoI)/1000000;
		System.out.println("Tempo: "+ (int)tempoR + " ms");

    }
}
