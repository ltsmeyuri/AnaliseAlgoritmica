public class Fibonacci {

    public static long fibonacciRecursivo(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacciRecursivo(n - 1) + fibonacciRecursivo(n - 2);
        }
    }
    
    public static void main(String[] args) {
        int n = 40;  // Ajuste conforme necessário
        long startTime = System.nanoTime();
        long resultado = fibonacciRecursivo(n);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000; // convertendo para milissegundos
        System.out.println("Fibonacci Recursivo de " + n + ": " + resultado);
        System.out.println("Tempo de execução: " + duration + " ms");
    }
}
