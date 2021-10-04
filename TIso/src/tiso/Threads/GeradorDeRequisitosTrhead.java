package tiso.Threads;
import java.util.Random;

import tiso.Output;


public class GeradorDeRequisitosTrhead implements Runnable{
    //private int buffer; // tamanho max da fila circular
	//private int itens; // nº de itens não consumidos
	private int max; //Tamanho máximo da variável.
	private int min; //Tamanho mínimo da variável
	private int req_geradas;
	private int tamanho_variavel;
	private int total_reqs;
	private boolean controle;
	private long tempo;
	private long tempoR, tempoI, tempoF;
	Random gerador = new Random();
	Output output = new Output();


	//Construtor da classe.
	public GeradorDeRequisitosTrhead(int mx, int mn, int total, long t){
		this.max = mx;
		this.min = mn;
		this.total_reqs = total;
		this.req_geradas = 0;
		this.tempo = t;
	}

	//Geração do tamanho da variavel e instancia de uma nova requisição.
    @Override
    public void run() { //gerarRequisicao
	    int counter = 0;

	    while(req_geradas < total_reqs){
		    tempoI = System.nanoTime();
			counter ++;
		    tamanho_variavel = (int)Math.floor(Math.random()*(max - min + 1) + min);
		    RequisitosThread req = new RequisitosThread(tamanho_variavel, req_geradas, gerarConteudo());
		    req_geradas++;
		    // MainTrhead.gestorVet.acquire();
		    synchronized (MainThread.vetor_Req){
			    controle = MainThread.vetor_Req.inserir(req);
			    output.escrever("[Thread Gerador] Requisição inserida no vetor de requisições, counter: " + counter);
		    }
		    //MainTrhead.gestorVet.release();
		    if(controle){
			    // sleep();
			    output.escrever("[Thread Gerador] gerador dormiu:");
		    }
			tempoF = System.nanoTime();
			tempoR = ((tempoF - tempoI)/1000000);
			MainThread.t_Gerador += tempoR;
	    }
	    output.escrever("[Thread Gerador] Gerador finalizou. Total de Req_geradas: " + req_geradas);
	    //MainTrhead.userHeap.showHeap();

	}
	public int getReqGeradas(){ return req_geradas;}


	//Retorna uma string aleatória, de tamanho n; usada para o identificador da variável
	private String gerarConteudo(){
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "123456789";
		StringBuilder sb = new StringBuilder(tamanho_variavel);

		for (int i = 0; i < tamanho_variavel; i++) {
			int index = (int)(AlphaNumericString.length() * Math.random());
			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();
	}
	public void sleep(){
		long tI = System.currentTimeMillis();
		long tF, tR = 0;
		while(tR <= tempo){
			tF = System.currentTimeMillis();
			tR = tF - tI;
		}
	}
}
