package tiso.Threads;

public class Semaforo {
    private int variavel;
    public Semaforo(){
        this.variavel = 1;
    }

    public void acquire(){
        while(variavel == 0){
            System.out.println("Bloqueado");
        }; // enquanto alguem não libera ele fica no while
        variavel = 0; // bloqueia o acesso enquanto alguem esta acessando

    }

    public void release(){
        variavel = 1;
    }

    public int getVariavel(){return variavel;}
}
