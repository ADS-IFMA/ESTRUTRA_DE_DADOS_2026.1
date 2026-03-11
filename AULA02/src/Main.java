import java.util.Random;

public class Main {

    public void main(){
        int[] vetor = gerarVetor(1000000, false);
        int[] vetor2 = vetor.clone();

        //imprimirVetor(vetor);

        long t1 = System.currentTimeMillis();
        bubbleSort(vetor);
        long t2 = System.currentTimeMillis();
        System.out.println("BUBBLESORT: "+(t2 - t1));
        //imprimirVetor(vetor);

        t1 = System.currentTimeMillis();
        quickSort(vetor2, 0, vetor2.length - 1);
        t2 = System.currentTimeMillis();
        System.out.println("QUICKSORT: "+(t2 - t1));
        //imprimirVetor(vetor2);

    }//Fim do Main

    public static void bubbleSort(int[] lista) {
        int n = lista.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (lista[j] > lista[j + 1]) {
                    int temp = lista[j];
                    lista[j] = lista[j + 1];
                    lista[j + 1] = temp;
                }
            }
        }
    }//Fim do BubbleSort

    public static void quickSort(int[] lista, int inicio, int fim) {
        int e = inicio;
        int d = fim;
        int pivo = lista[(inicio + fim) / 2]; // escolha do pivô
        while (e <= d) {
            while (lista[e] < pivo) { // percorre da esquerda para direita
                e++;
            }
            while (lista[d] > pivo) { // percorre da direita para esquerda
                d--;
            }
            if (e <= d) { // troca os valores
                int temp = lista[e];
                lista[e] = lista[d];
                lista[d] = temp;
                e++;
                d--;
            }
        }
        if (inicio < d) { //Recursão para subvetor da esquerda
            quickSort(lista, inicio, d);
        }

        if (e < fim) { //Recursão para subvetor da direita
            quickSort(lista, e, fim);
        }
    }//Fim do QuickSort

    /**
     * FUNÇÃO AUXILIAR PARA GERAÇÃO DE VETORES
     * @param n - Quantidade de Elementos
     * @param ordenado - Define se os elementos serão já ordenados ou não
     * @return - Vetor gerado
     */
    public static int[] gerarVetor(int n, boolean ordenado) {
        int[] vetor = new int[n];

        // Preenche com valores sem repetição: 1 até n
        for (int i = 0; i < n; i++) {
            vetor[i] = i + 1;
        }

        // Se não for ordenado, embaralha o vetor
        if (!ordenado) {
            Random random = new Random();

            for (int i = 0; i < n; i++) {
                int j = random.nextInt(n);

                int temp = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = temp;
            }
        }

        return vetor;
    }//Fim do Gerador

    void imprimirVetor(int[] vetor){
        for(int v : vetor){
            System.out.print(v+ "  ");
        }
        System.out.println("");
    }

}//Fim da Classe

