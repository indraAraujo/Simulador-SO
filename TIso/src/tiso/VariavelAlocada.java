
/* Compõe o arraylist que o alocador deve manter,
 * afim de ter controle sobre quais variáveis foram
 * alocadas, e onde elas se encontram na memória
 *
 * */

public class VariavelAlocada
{
	private int inicio;
	private int fim;
	private int tamanho;
	private String identificador;

	public VariavelAlocada (int inicio, int fim, String identificador)
	{
		this.inicio = inicio;
		this.fim = fim;
		this.tamanho = (fim - inicio) + 1;
		this.identificador = identificador;
	}

	public int getInicio ()
	{
		return inicio;
	}

	public int getFim ()
	{
		return fim;
	}

	public int getTamanho ()
	{
		return tamanho;
	}

	public String getIdentificador()
	{
		return identificador;
	}
}



