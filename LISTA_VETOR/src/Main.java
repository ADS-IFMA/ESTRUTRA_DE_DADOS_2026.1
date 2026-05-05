import lista.Lista;

public class Main {

    public void main(){
        Lista lista = new Lista(5);
        lista.inserir(12);
        lista.inserir(34);
        lista.inserir(20);
        lista.inserir(18);
        lista.imprimir();
        lista.remover(2);
        lista.imprimir();
    }

}
