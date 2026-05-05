import lista.Lista;

public class Main {

    public void main(){
        Lista lista = new Lista();

        lista.inserir(10);
        lista.inserir(12);
        lista.inserir(20);
        lista.inserir(18);
        lista.inserir(23);
        lista.inserir(24);
        lista.inserir(8);

        lista.imprimir();

        lista.remover(18);
        lista.imprimir();
        lista.remover(8);
        lista.imprimir();

        System.out.println("Tamanho: "+lista.getTamanho());
    }

}
