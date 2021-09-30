package tiso.Threads;
public class BuracosThread {
    private int inicio;
	private int fim;
	private int tamanho;

	public BuracosThread (int inicio, int fim)
	{
		this.inicio = inicio;
		this.fim = fim;
		this.tamanho = (fim - inicio) + 1;
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
}
