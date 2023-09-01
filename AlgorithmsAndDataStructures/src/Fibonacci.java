import java.util.Arrays;

public class Fibonacci {

    // O(2^n)
    private static long fibNaive(int n, long[] mem) {
        if (mem[n] != -1)
            return mem[n];

        if (n <= 1)
            return n;

        long result = fibNaive(n - 1, mem) + fibNaive(n - 2, mem);

        mem[n] = result;

        return result;
    }

    // O(n)
    private static long fibEffective(int n) {
        long[] arr = new long[n + 1];

        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n];
    }

    public static void main(String[] args) {
        int n = 100;

        long[] mem = new long[n + 1];
        Arrays.fill(mem, -1);

        System.out.println(fibNaive(n, mem));
    }
}
