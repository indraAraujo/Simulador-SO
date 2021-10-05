package tiso;

import tiso.Threads.Heap;

public class Main
{
	public static void main(String[] args)
	{
		Reader reader = new Reader("simulador.conf");

		int totalDeAlocacoes = reader.getTotalAlocacoes();
		int tamanhoHeap = reader.getTamHeap();
		int minVariavel = reader.getTamMinVar();
		int maxVariavel = reader.getTamMaxVar();
		int tamanho_vetor = reader.getTamVetorReq();
		int limiteMinOcupacao = reader.getLimMinOcupHeap();
		int limiteMaxOcupacao = reader.getLimMaxOcupHeap();
		int limiteFragmentacao = reader.getLimFragHeap();

		HeapS userHeap = new HeapS(tamanhoHeap);
		AnalisadorDeMemoriaS analisadorMemoria = new AnalisadorDeMemoriaS(tamanhoHeap, limiteMaxOcupacao, limiteMinOcupacao, limiteFragmentacao, userHeap);
		VetorRequisicoes vetor_requisicoes = new VetorRequisicoes();
		GeradorDeRequisitosS geradorReq = new GeradorDeRequisitosS(minVariavel, maxVariavel);
		AlocadorS alocador = new AlocadorS(tamanhoHeap, userHeap, analisadorMemoria);

		/* 
		* Obs: na versão sequencial, há um loop pra simular um funcionamento concorrente;
		 * assim, as coisas vão acontecendo de forma intercalada, permitindo validar o
		 * funcionamento do desalocador, dos geradores de estatística, de um eventual compactador,
		 * etc. A quantidade de requisições gerada e processada numa iteração é arbitrária, devendo
		 * somente garantir que o vetor de requisições nunca fique vazio, tal qual na versão
		 * concorrente.
		 * */ 

		int maxReqPorIteracao = 3; // quant. máxima de requisições geradas por iteração;
		int maxProcPorIteracao = maxReqPorIteracao / 2; // quant. máxima de requisições processadas por iteração

		long timeI = System.nanoTime();
		for (int k = 0; geradorReq.getReqGeradas() < totalDeAlocacoes; k ++) {

			// cria requisições novas, inserindo-as no vetor de requisições
			Requisicao[] tmp = geradorReq.gerarRequisicoes(Main.genRandom(1, maxReqPorIteracao));
			for (int i = 0; i < tmp.length; i++)
				vetor_requisicoes.inserir (tmp[i]);

			// alocador de memória entra em ação
			int j;
			for (j = 0; j < Main.genRandom(1, maxProcPorIteracao); j++) {
				if (alocador.processarRequisicao (vetor_requisicoes.remover()) == false) {
					break;

				}
			}

			// analisador de memória é chamado, afim de monitorar estatísticas, atualizar tabela de buracos, etc
			analisadorMemoria.analisarMemoria(); 

		}
		long timeF = System.nanoTime();
		System.out.println("Tempo de execução: " + (timeF-timeI)/1000000);
		reader.close();
	}

	// retorna um número aleatório, dentro do intervalo especificado
	private static int genRandom (int min, int max)
	{
		return (int)Math.floor(Math.random()*(max-min+1)+min);
	}
}

