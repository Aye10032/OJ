package test02_divide_and_conquer.UltraQuicksort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @program: OJ
 * @description: POJ 2299
 * @author: Aye10032
 * @create: 2023-10-17 23:33
 **/

class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /**
     * call this method to initialize reader for InputStream
     */
    static void init(InputStream input) {
        reader = new BufferedReader(
                new InputStreamReader(input));
        tokenizer = new StringTokenizer("");
    }

    /**
     * get next word
     */
    static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(
                    reader.readLine());
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}

public class Main {
    static long[] a;
    static long[] aux;

    static long count;

    Main() {

    }

    void run() throws IOException {
        Reader.init(System.in);

        while (true) {
            int n = Reader.nextInt();
            if (n == 0)
                break;

            a = new long[n];
            aux = new long[n];
            count = 0;

            for (int i = 0; i < n; i++) {
                a[i] = Reader.nextInt();
            }

            sort(a, 0, n - 1);
            System.out.println(count);
        }
    }

    void merge(long[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                a[k] = aux[j++];
                count += mid - i + 1;
            } else
                a[k] = aux[i++];
        }
    }

    void sort(long[] a, int lo, int hi) {
        if (hi <= lo)
            return;

        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
//        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        Main demo = new Main();

        try {
            demo.run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
