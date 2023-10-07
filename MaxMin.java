import java.util.Arrays;
//declaração da classe MaxMin, a qual implementará os 4 algoritmos em forma de métodos.
public class MaxMin {
//primeiramente, a implementação do algoritmo MaxMin 1.
    public void maxMin1(int[] vetor) {
        if (vetor.length == 0) {
            System.out.println("O array não possui elementos.");
            return;
        }
        int max = vetor[0];
        int min = vetor[0];
        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i] < min) {
                min = vetor[i];
            }
            if (vetor[i] > max) {
                max = vetor[i];
            }
        }
        System.out.println("Elemento máximo = " + max + ", elemento mínimo = " + min);
    }
//utilizando o MaxMin 1, o MaxMin2 é uma melhora para que haja menos comparações.
    public void maxMin2(int[] vetor) {
        if (vetor.length == 0) {
            System.out.println("O array não possui elementos.");
            return;
        }
        int max = vetor[0];
        int min = vetor[0];
        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i] > max) {
                max = vetor[i];
            } else if (vetor[i] < min) {
                min = vetor[i];

            }
        }
        System.out.println("Elemento máximo = " + max + ", elemento mínimo = " + min);
    }
//agora há a estratégia de organizar os elementos em pares, aplicada no MaxMin 3.
    public void maxMin3(int[] vetor) {
        if (vetor.length == 0) {
            System.out.println("O array não possui elementos.");
            return;
        }

        int max = vetor[0];
        int min = vetor[0];

        int length = vetor.length;

        if (length % 2 != 0) {
            length++;
            vetor = Arrays.copyOf(vetor, length);
            vetor[length - 1] = vetor[length - 2];
        }

        for (int i = 0; i < length; i += 2) {
            int elemento1 = vetor[i];
            int elemento2 = vetor[i + 1];

            if (elemento1 > elemento2) {
                if (elemento1 > max) {
                    max = elemento1;
                }
                if (elemento2 < min) {
                    min = elemento2;
                }
            } else {
                if (elemento2 > max) {
                    max = elemento2;
                }
                if (elemento1 < min) {
                    min = elemento1;
                }
            }
        }

        System.out.println("Elemento máximo = " + max + ", elemento mínimo = " + min);
    }
//por fim, o último algoritmo, que trabalha utilizando recursão.
    public void maxMin4(int[] vetor) {
        if (vetor.length == 0) {
            System.out.println("O array não possui elementos.");
            return;
        }

        int[] resultado = maxMinRecursivo(vetor, 0, vetor.length - 1);

        int max = resultado[0];
        int min = resultado[1];

        System.out.println("Elemento máximo = " + max + ", elemento mínimo = " + min);
    }
//implementação de um método privado para a facilitação da recursividade.
    private int[] maxMinRecursivo(int[] vetor, int inicio, int fim) {
        int[] resultado = new int[2];

        if (inicio == fim) {
            resultado[0] = vetor[inicio];
            resultado[1] = vetor[inicio];
            return resultado;
        }

        if (fim - inicio == 1) {
            resultado[0] = Math.max(vetor[inicio], vetor[fim]);
            resultado[1] = Math.min(vetor[inicio], vetor[fim]);
            return resultado;
        }

        int meio = (inicio + fim) / 2;
        int[] resultadoEsquerda = maxMinRecursivo(vetor, inicio, meio);
        int[] resultadoDireita = maxMinRecursivo(vetor, meio + 1, fim);

        resultado[0] = Math.max(resultadoEsquerda[0], resultadoDireita[0]);
        resultado[1] = Math.min(resultadoEsquerda[1], resultadoDireita[1]);

        return resultado;
    }
}
