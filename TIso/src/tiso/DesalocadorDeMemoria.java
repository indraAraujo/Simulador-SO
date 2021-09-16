
public class DesalocadorDeMemoria
{
	private Heap heap;

	public DesalocadorDeMemoria(Heap heap)
	{
		this.heap = heap;
	}

	public void desalocarVar (VariavelAlocada variavel)
	{
		for (int i = 0; i < variavel.getTamanho(); i ++) {
			heap.removeHeap (variavel.getInicio() + i);
		}
	}
}
