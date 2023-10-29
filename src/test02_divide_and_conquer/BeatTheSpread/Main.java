package test02_divide_and_conquer.BeatTheSpread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @program: OJ
 * @description: UVA10812
 * @author: Aye10032
 * @create: 2023-10-29 12:44
 **/

public class Main {

    Main() {

    }

    void run() throws IOException {
        Reader.init(System.in);

        int n = Reader.nextInt();

        for (int i = 0; i < n; i++) {
            int s = Reader.nextInt();
            int d = Reader.nextInt();

            if (d > s || (s + d) % 2 != 0) {
                System.out.println("impossible");
            } else {
                System.out.println((s + d) / 2 + " " + (s - d) / 2);
            }
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

    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}
