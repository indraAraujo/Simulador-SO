package test;

import tiso.DesalocadorDeMemoria;
import tiso.Heap;
import tiso.Variavel;

public class DesalocadorDeMemoriaTest {

    Heap heap = new Heap(89);
    DesalocadorDeMemoria desalocador = new DesalocadorDeMemoria(heap);

    //Teste desaloca a variavel da heap
    public void desalocarVartest(Variavel variavel){

        System.out.println("Teste Desalocador - Desalocador de memória....."); 
        heap.addHeap('1', 1); //adiciona na heap uma variavel NO CAMPO 1
        heap.addHeap('1', 2);
        heap.addHeap('1', 3);
        heap.addHeap('1', 4);
        heap.addHeap('1', 5); //ADICIONA DO CAMPO 1 AO 5 VARIAVEL I
        System.out.println("ANTES DE DESALOCAR");
        heap.showHeap(); // MOSTRA A HEAP ANTES DA DESALOCAÇÃO
        desalocador.desalocarVar(variavel); //desaloca da heap uma variavel
        
        if(heap.consult(1) == 0){   // consulta no index 1 se esta
            System.out.println("DEPOIS DE DESALOCAR");
            heap.showHeap(); // MOSTRA A HEAP DEPOIS DA DESALOCAÇÃO
            System.out.println("Sucesso!");
        }
        else{
            System.out.println("Falha!");
            heap.showHeap(); // MOSTRA A HEAP DEPOIS DA DESALOCAÇÃO
        }

    }

    
    
}
