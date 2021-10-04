package tiso;

/* Coleta requisições do vetor homônimo, alocando-as com ajuda do
 * analisador de memória.
 * */

import java.util.ArrayList;

public class Alocador
{
	private Heap heap;
	private AnalisadorDeMemoria analisador;
	private ArrayList<Variavel> controle = new ArrayList<>();
	Output output = new Output();



	public Alocador ( Heap heap, AnalisadorDeMemoria analisador)
	{
		this.heap = heap;
		this.analisador = analisador;
		analisador.setControle(controle);
	}

	// recebe uma requisição, inserindo a variável na heap, byte a byte;
	// retorna true se tudo der certo, caso contrário, false
	public boolean processarRequisicao (Requisicao r)
	{
		int inicio = analisador.primeiroEncaixe (r.getTamanho());
		boolean result = false;

		if (inicio != -1) {
			result = true;
			Variavel nova_variavel = r.getVariavel();
			nova_variavel.setRegBase(inicio);
			nova_variavel.setRegTamanho((inicio + r.getTamanho() - 1));
			controle.add (nova_variavel);
			char [] cont = nova_variavel.gerCont_Char();
			for (int i = 0; i < r.getTamanho(); i++)
				heap.addHeap (cont[i], inicio + i);
		}

		analisador.atualizarBuracos();

		return result;
	}
}

