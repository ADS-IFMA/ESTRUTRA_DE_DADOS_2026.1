import java.util.Random;

public class Main {

    public void main(){

        /**
         * BUSCANDO O ÚLTIMO ELEMENTO DO VETOR
         */

        int[] numeros = gerarVetor(1000000000, true);

        //TESTE DA BUSCA LINEAR
        long t1 = System.currentTimeMillis();
        int posicao = busca_linear(numeros[numeros.length-1], numeros);
        long t2 = System.currentTimeMillis();
        long tempo = t2 - t1;
        System.out.println("TEMPO LINEAR: "+tempo);

        //TESTE DA BUSCA BINÁRIA
        t1 = System.currentTimeMillis();
        posicao = busca_binaria(numeros[numeros.length-1], numeros);
        t2 = System.currentTimeMillis();
        tempo = t2 - t1;
        System.out.println("TEMPO BINÁRIA: "+tempo);

    }

    private static int busca_linear(int x, int[] lista){
        int passos = 0;
        for (int i = 0; i < lista.length; i++){
            passos++;
            if(lista[i] == x){
                System.out.println("Passos Linear: "+passos);
                return i;
            }
        }

        return -1;
    }//Fim da Busca Linear

    private static int busca_binaria(int x, int[] lista){
        int inicio = 0;
        int fim = lista.length - 1;
        int passos = 0;
        while (inicio <= fim) {
            passos++;
            int meio = (int)(((long)inicio + (long)fim) / 2);

            if (lista[meio] == x) {
                System.out.println("PASSOS BINARIA: "+passos);
                return meio; // valor encontrado
            }
            else if (lista[meio] < x) {
                inicio = meio + 1;
            }
            else {
                fim = meio - 1;
            }
        }

        return -1; // valor não encontrado
    }

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

}//Fim da Classe
