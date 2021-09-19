package test;

import tiso.Heap;

public class HeapTest{
  int tamanho_heap = 89;
  Heap heap = new Heap(tamanho_heap);

  //Teste de adição na heap (manual)
  public void inserir(char caracter, int indice){
     System.out.println("Teste Inserção- Heap....");
      heap.addHeap(caracter, indice);
      char[] temp = heap.getHeap();
      if(temp[indice] == caracter ){
         System.out.println("Sucesso");
      }else{
         System.out.println("Falha");
      }
  }

  //Teste de remoção na heap (automatizado)
  public void remover( int indice){
     System.out.println("Teste Remoção- Heap....");
      heap.removeHeap(indice);
      char[] temp = heap.getHeap();
      if(temp[indice] == '0' ){
         System.out.println("Sucesso");
      }else{
         System.out.println("Falha");
      }
  }

  //Teste de impressão da heap (manual)
  public void imprimir(){
    System.out.println("Teste Impressão- Heap....");
    heap.showHeap();
  }
  
}