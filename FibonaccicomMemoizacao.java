import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    private static Map<Integer, Long> memo = new HashMap<>();

    public static long fibonacciMemoizado(int n) {
        if (n <= 1) {
            return n;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        long resultado = fibonacciMemoizado(n - 1) + fibonacciMemoizado(n - 2);
        memo.put(n, resultado);

        return resultado;
    }
    
    public static void main(String[] args) {
        int n = 40;  // Ajuste conforme necessário
        long startTime = System.nanoTime();
        long resultado = fibonacciMemoizado(n);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000; // convertendo para milissegundos
        System.out.println("Fibonacci com Memoização de " + n + ": " + resultado);
        System.out.println("Tempo de execução: " + duration + " ms");
    }
}
