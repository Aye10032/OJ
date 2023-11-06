package test03_dynamic_program.JinGeJinQuhao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @program: OJ
 * @description: UVA12563
 * @author: Aye10032
 * @create: 2023-11-03 18:53
 **/


public class Main {
    static int[] songs;
    static int[] result;

    Main() {
    }

    void run() throws IOException {
        Reader.init(System.in);

        int T = Reader.nextInt();

        for (int i = 0; i < T; i++) {
            int n = Reader.nextInt();
            int t = Reader.nextInt();

            songs = new int[n];
            for (int j = 0; j < n; j++) {
                songs[j] = Reader.nextInt();
            }

            result = new int[t];
            for (int j = 0; j < t; j++) {
                result[j] = -1;
            }
            result[0] = 0;

            for (int j = 0; j < n; j++) {
                for (int k = t - 1; k >= songs[j]; k--) {
                    result[k] = Math.max(result[k], result[k - songs[j]] + 1);
                }
            }

            int max_time = 0;
            for (int j = t - 1; j >= 0; j--) {
                if (result[j] > result[max_time]) {
                    max_time = j;
                }
            }


            System.out.println("Case " + (i+1) + ": " + (result[max_time] + 1) + " " + (max_time + 678));
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
