package tiso;
/* Coleta requisições do vetor homônimo, alocando-as com ajuda do
 * analisador de memória.
 * */

import java.util.ArrayList;

public class AlocadorS
{
	private int tamanhoHeap;
	private HeapS heap;
	private AnalisadorDeMemoriaS analisador;
	private ArrayList<VariavelAlocada> controle = new ArrayList<VariavelAlocada>();


	public AlocadorS (int tamanhoHeap, HeapS heap, AnalisadorDeMemoriaS analisador)
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
			VariavelAlocada nova_variavel =new VariavelAlocada(inicio, (inicio + r.tamanho - 1), r.getVariavel().getConteudo());
			controle.add (nova_variavel);
			for (int i = 0; i < nova_variavel.getTamanho(); i++)
				heap.addHeap ('a', inicio + i);
		}

		analisador.atualizarBuracos();

		return result;
	}
}

