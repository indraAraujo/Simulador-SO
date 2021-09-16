package tiso;

/*
* Objeto que irá desalocar uma variável da heap quando for necessário.
*
*/
public class DesalocadorDeMemoria
{
	private Heap heap;

	public DesalocadorDeMemoria(Heap heap)
	{
		this.heap = heap;
	}

	//Desalocação de uma variável da heap.
	public void desalocarVar (Variavel variavel)
	{
		for (int i = 0; i < variavel.getTam(); i ++) {
			heap.removeHeap (variavel.getRegBase() + i);
		}
	}
}
