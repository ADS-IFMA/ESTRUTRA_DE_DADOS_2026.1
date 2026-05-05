package lista;

/**
 * LISTA COM VETOR
 * Lista de Inteiros
 */
public class Lista {

    private int[] vetor;
    private int qtd;

    public Lista(int n){
        this.vetor = new int[n];
        this.qtd = 0;
    }

    public void inserir(int v){
        if(this.qtd == this.vetor.length){
            System.out.println("Lista lotada!");
        }else{
            this.vetor[this.qtd] = v;
            this.qtd++;
        }
    }//Fim do inserir

    public void imprimir(){
        System.out.print("| ");
        for(int i=0;i<this.qtd;i++){
            System.out.print(this.vetor[i]+" | ");
        }
    }//Fim do imprimir

    public void remover(int p){
        if((p < 0) || (p >= this.qtd)){
            System.out.println("Posicao invalida!");
        }else{
            for(int i=p;i<this.qtd - 1;i++){
                this.vetor[i] = this.vetor[i+1];
            }
            this.qtd--;
        }
    }//Fim do remover

    public void editar(int p, int v){
        if((p < 0) || (p >= this.qtd)){
            System.out.println("Posicao invalida!");
        }else{
            this.vetor[p] = v;
        }
    }//Fim do editar

    public int getTamanho(){
        return this.qtd;
    }

}//Fim da Lista
