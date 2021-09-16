package tiso;


/* 
* Coleta requisições do vetor homônimo, alocando-as com ajuda do
 * analisador de memória.
 * */

import java.util.ArrayList;

public class Alocador
{
	private int tamanhoHeap;
	private Heap heap;
	private AnalisadorDeMemoria analisador;
	private ArrayList<Variavel> controle = new ArrayList<>();

	//Construtor da classe.
	public Alocador (int tamanhoHeap, Heap heap, AnalisadorDeMemoria analisador)
	{
		this.tamanhoHeap = tamanhoHeap;
		this.heap = heap;
		this.analisador = analisador;
		analisador.setControle(controle);
	}

	// Recebe uma requisição, inserindo a variável na heap, byte a byte.
	// Retorna true se tudo der certo, caso contrário, retornará false.
	public boolean processarRequisicao (Requisicao r)
	{
		int inicio = analisador.primeiroEncaixe (r.tamanho);
		boolean result = false;

		if (inicio != -1) {
			result = true;
			Variavel variavel_alocada = new Variavel(inicio, r.getVariavel().getConteudo());
			variavel_alocada.setRegTamanho((inicio + r.tamanho - 1));
			controle.add (variavel_alocada);
			for (int i = 0; i < r.tamanho; i++)
				heap.addHeap (1, inicio + i);
		}

		analisador.atualizarBuracos();

		return result;
	}
}

