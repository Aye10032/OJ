package test03_greedy.ArithmeticArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @program: OJ
 * @description: CF1537A
 * @author: Aye10032
 * @create: 2023-11-23 10:19
 **/

public class Main {

    Main() {
    }

    void run() throws IOException {
        Reader.init(System.in);

        int T = Reader.nextInt();

        for (int t = 0; t < T; t++) {
            int n = Reader.nextInt();

            int sum = 0;

            for (int i = 0; i < n; i++) {
                sum += Reader.nextInt();
            }

            if (sum == n)
                System.out.println(0);
            else if (sum > n)
                System.out.println(sum - n);
            else
                System.out.println(1);
        }
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

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}
