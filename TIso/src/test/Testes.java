Trheads_Add
package test;

import tiso.GeradorDeRequisitos;
import tiso.VetorRequisicoes;

public class Testes {
    public static void main(String[] args){
        int tamanho_maximo_variavel = 1000;
        int tamanho_minimo_variavel = 30;
        GeradorDeRequisitos gerador = new GeradorDeRequisitos(tamanho_maximo_variavel, tamanho_minimo_variavel);
        //TESTE DO VETOR DE REQUISIÇÕES
        int tamanho_vetor = 100;
        VetorRequisicoes vetorRequisicoes = new VetorRequisicoes(tamanho_vetor);
        //Inserir no vetor de requisições uma requisição normal
        vetorRequisicoes.inserir(gerador.gerarRequisicao());
        vetorRequisicoes.inserir(gerador.gerarRequisicao());
        vetorRequisicoes.inserir(gerador.gerarRequisicao());
        vetorRequisicoes.inserir(gerador.gerarRequisicao());
        vetorRequisicoes.inserir(gerador.gerarRequisicao());
        vetorRequisicoes.getVetor();

        //Remover variáveis
        vetorRequisicoes.remover();
        vetorRequisicoes.remover();
        vetorRequisicoes.remover();
        vetorRequisicoes.getVetor();
    }
}
=======
package test;

import tiso.GeradorDeRequisitos;
import tiso.VetorRequisicoes;

public class Testes {
    public static void main(String[] args){
       VetorRequisicoesTest vetor_requisicoes = new VetorRequisicoesTest();
       vetor_requisicoes.inserir();
    }
}
main
