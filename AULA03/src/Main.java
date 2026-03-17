import java.util.Random;

//BUBBLESORT: 97
//SELECTIONSORT: 49
//INSERTION: 21
//QUICKSORT: 2

public class Main {

    void main(){
        int[] numeros1 = gerarVetor(200000, false);
        int[] numeros2 = numeros1.clone();
        int[] numeros3 = numeros1.clone();
        int[] numeros4 = numeros1.clone();
        int[] numeros5 = numeros1.clone();
        int[] numeros6 = numeros1.clone();

        System.out.println("BUBBLESORT");
        long t1 = System.currentTimeMillis();
        bubbleSort(numeros1);
        long t2 = System.currentTimeMillis();
        long tempo = t2 - t1;
        System.out.println("BUBBLESORT: "+tempo);

        System.out.println("SELECTIONSORT");
        t1 = System.currentTimeMillis();
        selectionSort(numeros2);
        t2 = System.currentTimeMillis();
        tempo = t2 - t1;
        System.out.println("SELECTIONSORT: "+tempo);

        System.out.println("INSERTIONSORT");
        t1 = System.currentTimeMillis();
        insertionSort(numeros3);
        t2 = System.currentTimeMillis();
        tempo = t2 - t1;
        System.out.println("INSERTION: "+tempo);

        System.out.println("QUICKSORT");
        t1 = System.currentTimeMillis();
        quickSort(numeros4, 0, numeros4.length-1);
        t2 = System.currentTimeMillis();
        tempo = t2 - t1;
        System.out.println("QUICKSORT: "+tempo);

        System.out.println("MERGESORT");
        t1 = System.currentTimeMillis();
        mergeSort(numeros5, 0, numeros5.length-1);
        t2 = System.currentTimeMillis();
        tempo = t2 - t1;
        System.out.println("MERGESORT: "+tempo);

        System.out.println("HEAPSORT");
        t1 = System.currentTimeMillis();
        heapSort(numeros6);
        t2 = System.currentTimeMillis();
        tempo = t2 - t1;
        System.out.println("HEAPSORT: "+tempo);

    }

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

    public void selectionSort(int[] vetor) {
        for (int i = 0; i < vetor.length - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[menor]) {
                    menor = j;
                }
            }
            if (menor != i) {
                int aux = vetor[i];
                vetor[i] = vetor[menor];
                vetor[menor] = aux;
            }
        }
    }//Fim do SelectionSort

    public void insertionSort(int[] vetor) {
        for (int i = 1; i < vetor.length; i++) {
            int aux = vetor[i];
            int j = i;
            while ((j > 0) && (vetor[j - 1] > aux)) {
                vetor[j] = vetor[j - 1];
                j -= 1;
            }
            vetor[j] = aux;
        }
    }//Fim do Insertionsort

    public static void mergeSort(int[] v, int inicio, int fim) {

        if (inicio < fim) {

            int meio = (inicio + fim) / 2;

            // divide o vetor em duas partes
            mergeSort(v, inicio, meio);
            mergeSort(v, meio + 1, fim);

            // junta (merge) as partes ordenadas
            merge(v, inicio, meio, fim);
        }
    }

    private static void merge(int[] v, int inicio, int meio, int fim) {

        int n1 = meio - inicio + 1;
        int n2 = fim - meio;

        int[] esquerda = new int[n1];
        int[] direita = new int[n2];

        // copia os dados
        for (int i = 0; i < n1; i++) {
            esquerda[i] = v[inicio + i];
        }

        for (int j = 0; j < n2; j++) {
            direita[j] = v[meio + 1 + j];
        }
        int i = 0, j = 0;
        int k = inicio;
        // intercala os vetores
        while (i < n1 && j < n2) {

            if (esquerda[i] <= direita[j]) {
                v[k] = esquerda[i];
                i++;
            } else {
                v[k] = direita[j];
                j++;
            }

            k++;
        }
        // copia o restante da esquerda
        while (i < n1) {
            v[k] = esquerda[i];
            i++;
            k++;
        }
        // copia o restante da direita
        while (j < n2) {
            v[k] = direita[j];
            j++;
            k++;
        }
    }

    public static void heapSort(int[] v) {

        int n = v.length;

        // 1. Construir o Max-Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(v, n, i);
        }

        // 2. Extrair elementos do heap
        for (int i = n - 1; i > 0; i--) {

            // troca a raiz (maior) com o último elemento
            int temp = v[0];
            v[0] = v[i];
            v[i] = temp;

            // aplica heapify no heap reduzido
            heapify(v, i, 0);
        }
    }

    private static void heapify(int[] v, int n, int i) {

        int maior = i;          // raiz
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;

        // se filho esquerdo for maior
        if (esquerda < n && v[esquerda] > v[maior]) {
            maior = esquerda;
        }
        // se filho direito for maior
        if (direita < n && v[direita] > v[maior]) {
            maior = direita;
        }
        // se o maior não é a raiz
        if (maior != i) {

            int temp = v[i];
            v[i] = v[maior];
            v[maior] = temp;

            // aplica recursivamente
            heapify(v, n, maior);
        }
    }



    public static int[] gerarVetor(int n, boolean ordenado) {
        int[] vetor = new int[n];
        for (int i = 0; i < n; i++) {
            vetor[i] = i + 1;
        }
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
    }

}//Fim da Classe
