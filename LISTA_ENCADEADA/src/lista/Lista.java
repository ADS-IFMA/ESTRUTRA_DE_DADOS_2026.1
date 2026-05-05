package lista;

public class Lista {

    private No inicio;

    public Lista(){
        this.inicio = null;
    }

    public void inserir(int valor){
        if(this.inicio == null){
            this.inicio = new No(valor);
            return;
        }
        No atual = this.inicio;
        while(atual.getProximo() != null){
            atual = atual.getProximo();
        }
        atual.setProximo(new No(valor));

    }//Fim do inserir

    public No buscar(int n){
        No atual = this.inicio;
        while(atual.getDado() != n && atual != null){
            atual = atual.getProximo();
        }
        return atual;
    }

    public void imprimir(){
        No atual = this.inicio;
        System.out.print("| ");
        while(atual != null){
            System.out.print(atual.getDado()+ " | ");
            atual = atual.getProximo();
        }
        System.out.println("");
    }

    public void remover(int n){

        if(this.inicio == null){
            return;
        }
        if(this.inicio.getDado() == n){
            this.inicio = null;
            return;
        }
        No atual = this.inicio;
        while(atual.getProximo() != null && atual.getProximo().getDado() != n){
            atual = atual.getProximo();
        }
        if(atual.getProximo() != null){
            atual.setProximo(atual.getProximo().getProximo())   ;
        }
    }//Fim do Remover

    public int getTamanho(){
        int qtd = 0;
        No atual = this.inicio;
        while(atual != null){
            qtd++;
            atual = atual.getProximo();
        }
        return qtd;
    }//Fim do getTamanho

}//Fim da Classe
