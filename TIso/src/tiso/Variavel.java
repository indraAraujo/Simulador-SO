package tiso;
/**
 * Determina os atributos que a variável precisa ter
 */

public class Variavel {
    private String conteudo; //conjunto de caracteres ou instrução 
    private int tam; //Tamanho na memória 
    private int regBase; //registrador que indica inicio do bloco
    private int regTamanho; //tamanho para ser acrescido no Base e encontrar final do bloco na memória.

    public Variavel(int tm, String conteudo){
        this.tam = tm;
	    this.conteudo = conteudo;
    }

    public void setRegBase(int rgB){
        this.regBase = rgB;
    }

    public int getTam(){
        return tam;
    }

    public int getRegBase(){
        return regBase;
    }

    public int getRegTamanho(){
        return regTamanho;
    }

    public void setRegTamanho(int fim){
        regTamanho=fim;
    }
    public String getConteudo(){
        return conteudo;
    }
    public char[] gerCont_Char(){
        char[] con = conteudo.toCharArray();
        return con;
    }
    public String toString(){
        return  "\n VARIAVEL ---- \n Tamanho -> " + tam + "\n " + conteudo;
    }

}
