package tiso;


public class DesalocadorDeMemoria
{
	private Heap heap;

	public DesalocadorDeMemoria(Heap heap)
	{
		this.heap = heap;
	}

	public void desalocarVar (Variavel variavel)
	{
		for (int i = 0; i < variavel.getTam(); i ++) {
			heap.removeHeap (variavel.getRegBase() + i);
		}
	}
}
