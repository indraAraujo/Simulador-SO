
public class Main
{
	public static void main(String[] args)
	{
		Reader reader = new Reader("./simulador.conf");

		int totalDeAlocacoes = reader.getTotalAlocacoes();
		int tamanhoHeap = reader.getTamHeap();
		int minVariavel = reader.getTamMinVar();
		int maxVariavel = reader.getTamMaxVar();
		int tamanho_vetor = reader.getTamVetorReq();
		int limiteMinOcupacao = reader.getLimMinOcupHeap();
		int limiteMaxOcupacao = reader.getLimMaxOcupHeap();
		int limiteFragmentacao = reader.getLimFragHeap();

		Heap userHeap = new Heap(tamanhoHeap);
		AnalisadorDeMemoria analisadorMemoria = new AnalisadorDeMemoria(tamanhoHeap, limiteMaxOcupacao, limiteMinOcupacao, limiteFragmentacao, userHeap);
		VetorRequisicoes vetor_requisicoes = new VetorRequisicoes(tamanho_vetor);
		GeradorDeRequisitos geradorReq = new GeradorDeRequisitos(minVariavel, maxVariavel);
		Alocador alocador = new Alocador (tamanhoHeap, userHeap, analisadorMemoria);

		/* Obs: na versão sequencial, há um loop pra simular um funcionamento concorrente;
		 * assim, as coisas vão acontecendo de forma intercalada, permitindo validar o
		 * funcionamento do desalocador, dos geradores de estatística, de um eventual compactador,
		 * etc. A quantidade de requisições gerada e processada numa iteração é arbitrária, devendo
		 * somente garantir que o vetor de requisições nunca fique vazio, tal qual na versão
		 * concorrente.
		 * */ 

		int maxReqPorIteracao = 3; // quant. máxima de requisições geradas por iteração;
		int maxProcPorIteracao = maxReqPorIteracao / 2; // quant. máxima de requisições processadas por iteração

		System.out.println ("\nAlocações a serem feitas: " + totalDeAlocacoes);
		analisadorMemoria.imprimeBuracos();
		for (int k = 0; geradorReq.getReqGeradas() < totalDeAlocacoes; k ++) {

			System.out.println ("\n -> Na iteração " + k + ":\n");

			// cria requisições novas, inserindo-as no vetor de requisições
			Requisicao[] tmp = geradorReq.gerarRequisicoes(Main.genRandom(1, maxReqPorIteracao));
			for (int i = 0; i < tmp.length; i++)
				vetor_requisicoes.inserir (tmp[i]);

			// alocador de memória entra em ação
			int j;
			for (j = 0; j < Main.genRandom(1, maxProcPorIteracao); j++) {
				if (alocador.processarRequisicao (vetor_requisicoes.remover()) == false) {
					System.out.println ("\tNão foi possível realizar uma alocação");
					break;
				}
			}
			System.out.println("\tForam realizadas " + j + " alocações");

			// analisador de memória é chamado, afim de monitorar estatísticas, atualizar tabela de buracos, etc
			analisadorMemoria.analisarMemoria(); 
			analisadorMemoria.imprimeBuracos();
		}
		reader.close();
		System.out.println ("\nTodas as alocações foram realizadas:\n");
		System.out.println ("Chamadas ao desalocador: " + analisadorMemoria.getDesalocacoesFeitas());
	}

	// retorna um número aleatório, dentro do intervalo especificado
	private static int genRandom (int min, int max)
	{
		return (int)Math.floor(Math.random()*(max-min+1)+min);
	}
}

