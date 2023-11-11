public class Fibonacci {

    public static long fibonacciIterativo(int n) {
        if (n <= 1) {
            return n;
        }

        long fibAtual = 1;
        long fibAnterior = 0;

        for (int i = 2; i <= n; i++) {
            long temp = fibAtual;
            fibAtual = fibAtual + fibAnterior;
            fibAnterior = temp;
        }

        return fibAtual;
    }
    
    public static void main(String[] args) {
        int n = 40;  // Ajuste conforme necessário
        long startTime = System.nanoTime();
        long resultado = fibonacciIterativo(n);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000; // convertendo para milissegundos
        System.out.println("Fibonacci Iterativo de " + n + ": " + resultado);
        System.out.println("Tempo de execução: " + duration + " ms");
    }
}
