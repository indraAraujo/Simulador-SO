package tiso;
/**
 * 
 * @author WillianS
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

    public void setRegBase(int rgB, int rgF){
        this.regBase = rgB;
        this.regTamanho = rgF;
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

    public String getConteudo(){
        return conteudo;
    }

    public String toString(){
        return "\n VARIAVEL ----  \n " + conteudo + "\n Registrador Base -> " + regBase + "\n Registrador Limite -> " + regTamanho;
    }
}
