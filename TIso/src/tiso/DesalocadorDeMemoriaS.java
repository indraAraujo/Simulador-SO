package tiso;
public class DesalocadorDeMemoriaS
{
	private HeapS heap;

	public DesalocadorDeMemoriaS(HeapS heap)
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
