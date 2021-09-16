
/* Coleta requisições do vetor homônimo, alocando-as com ajuda do
 * analisador de memória.
 * */

import java.util.ArrayList;

public class Alocador
{
	private int tamanhoHeap;
	private Heap heap;
	private AnalisadorDeMemoria analisador;
	private ArrayList<VariavelAlocada> controle = new ArrayList<VariavelAlocada>();


	public Alocador (int tamanhoHeap, Heap heap, AnalisadorDeMemoria analisador)
	{
		this.tamanhoHeap = tamanhoHeap;
		this.heap = heap;
		this.analisador = analisador;
		analisador.setControle(controle);
	}

	// recebe uma requisição, inserindo a variável na heap, byte a byte;
	// retorna true se tudo der certo, caso contrário, false
	public boolean processarRequisicao (Requisicao r)
	{
		int inicio = analisador.primeiroEncaixe (r.tamanho);
		boolean result = false;

		if (inicio != -1) {
			result = true;
			controle.add (new VariavelAlocada(inicio, (inicio + r.tamanho - 1), r.identificador));
			for (int i = 0; i < r.tamanho; i++)
				heap.addHeap (1, inicio + i);
		}

		analisador.atualizarBuracos();

		return result;
	}
}

