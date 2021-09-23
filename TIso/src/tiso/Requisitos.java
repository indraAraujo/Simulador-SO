/**
* Objeto que representa a requisição
*
*/
/**
 *
 * @author indra
 */
public class Requisitos {
    int identificador;
    int tamanho; //tamanho da variavel
    Variavel variavel;
 
    //Construtor da classe.
    public Requisitos(int tm, int id, String conteudo_variavel){
        this.tamanho = tm;
        this.identificador = id;
        variavel = new Variavel(tm, conteudo_variavel);
    }
 
    public void setIdentificador(int id){
        this.identificador = id;
    }
 
    public Variavel getVariavel(){
        return variavel;
    }
 
    public int getTamanho(){
        return tamanho;
    }
 
    public int getIdentificador(){
        return identificador;
    } 
 
    public String toString(){
        return " \n REQUISIÇÃO " + identificador + " ---- \n tamanho -> " + tamanho + variavel.toString();
    }

}
