Trheads_Add
package test;
/*
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import tiso.Requisicao;
import tiso.VetorRequisicoes;

public class VetorRequisicoesTest {
    int tamanho = 10;
    VetorRequisicoes vr = new VetorRequisicoes(tamanho);

    @Test 
    public void inserir(){
        assertTrue((vr.inserir(new Requisicao(10))));
    }
}
*/

package test;

import tiso.GeradorDeRequisitos;
import tiso.Requisicao;
import tiso.VetorRequisicoes;

public class VetorRequisicoesTest {
    int tamanho_maximo_variavel = 1000;
    int tamanho_minimo_variavel = 30;
    GeradorDeRequisitos gerador = new GeradorDeRequisitos(tamanho_maximo_variavel, tamanho_minimo_variavel);
    //TESTE DO VETOR DE REQUISIÇÕES
    int tamanho_vetor = 100;
    VetorRequisicoes vetorRequisicoes = new VetorRequisicoes(tamanho_vetor);

    public void inserir(){
         //Inserir no vetor de requisições uma requisição normal
        vetorRequisicoes.inserir(gerador.gerarRequisicao());
        vetorRequisicoes.inserir(gerador.gerarRequisicao());
        vetorRequisicoes.inserir(gerador.gerarRequisicao());
        vetorRequisicoes.inserir(gerador.gerarRequisicao());
        vetorRequisicoes.inserir(gerador.gerarRequisicao());

    }

    public void remover(){
        //Remover variáveis
        vetorRequisicoes.remover();
        vetorRequisicoes.remover();
        vetorRequisicoes.remover();
        vetorRequisicoes.getVetor();
    }
   
    
}
main
