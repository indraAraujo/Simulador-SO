package tiso.Threads;


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
	public static Semaforo gestorVet = new Semaforo();
	public static Semaforo gestorHeap = new Semaforo();
    public static HeapThread userHeap = new HeapThread(tamanhoHeap);
    public static GeradorDeRequisitosTrhead geradorReq = new GeradorDeRequisitosTrhead(minVariavel, maxVariavel, totalDeAlocacoes, dormir);
    public static VetorRequisicoesThread vetor_Req = new VetorRequisicoesThread(tamanho_vetor);
	public static AlocadorTrhead malloc = new AlocadorTrhead(tamanhoHeap, dormir, totalDeAlocacoes);
	public static AnalisadorDeMemoriaThread analiser = new AnalisadorDeMemoriaThread();

    public static void main(String[] args) throws InterruptedException{
		tempoI = System.nanoTime();
		System.out.println("Tempo I: " + (tempoI));
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
		System.out.println("Tempo de trabalho do gerador: "+ t_Gerador + " ms");
		System.out.println("Tempo de trabalho do alocador: "+ t_Alocador + " ms");
		System.out.println("Tempo de trabalho do desalocador: "+ (t_Desalocador) + " ms");
		System.out.println("Tempo de trabalho do analisador: "+ t_Analisador + " ms");
		tempoT = t_Alocador+t_Analisador+t_Desalocador+t_Gerador;
		System.out.println("Somatório dos tempos: "+tempoT);

    }
}
