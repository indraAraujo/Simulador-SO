package tiso.trheads;

import java.util.ArrayList;
import tiso.Alocador;
import tiso.Heap;
import tiso.Requisicao;
import tiso.Variavel;
import tiso.VetorRequisicoes;


public class AlocadorTrhead implements Runnable{
   //private int tamanhoHeap;
	private Heap heap;
	private AnalisadorDeMemoriaTrhead analisador;
	private ArrayList<Variavel> controle = new ArrayList<>();

	//Construtor da classe.
	public AlocadorTrhead (int tamanhoHeap, Heap heap, AnalisadorDeMemoriaTrhead analisador){
		//this.tamanhoHeap = tamanhoHeap;
		this.heap = heap;
		this.analisador = analisador;
		analisador.setControle(controle);
	}

	// Recebe uma requisição, inserindo a variável na heap, byte a byte.
	// Retorna true se tudo der certo, caso contrário, retornará false.
	public void run(){
		Requisicao r = MainTrhead.vetor_requisicoes[0];
		int inicio = analisador.primeiroEncaixe (.getTamanho());
		boolean result = false;
		
		if (inicio != -1) {
			result = true;
			Variavel variavel_alocada = new Variavel(inicio, r.getVariavel().getConteudo());
			variavel_alocada.setRegTamanho((inicio + r.getTamanho() - 1));
			controle.add (variavel_alocada);
			for (int i = 0; i < r.getTamanho(); i++)
				MainTrhead.userHeap.addHeap ('a', inicio + i);
		}

		analisador.atualizarBuracos();
		if(result) ;

		
		//MainTrhead.userHeap.addHeap(partVariavel, index);;
	}

	public boolean processarRequisicao (Requisicao r){
		int inicio = analisador.primeiroEncaixe (r.getTamanho());
		boolean result = false;

		if (inicio != -1) {
			result = true;
			Variavel variavel_alocada = new Variavel(inicio, r.getVariavel().getConteudo());
			variavel_alocada.setRegTamanho((inicio + r.getTamanho() - 1));
			controle.add (variavel_alocada);
			for (int i = 0; i < r.getTamanho(); i++)
				MainTrhead.userHeap.addHeap ('a', inicio + i);
		}

		analisador.atualizarBuracos();

		return result;
	} 
}
