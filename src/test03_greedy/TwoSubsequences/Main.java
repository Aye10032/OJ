package test03_greedy.TwoSubsequences;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @program: OJ
 * @description: CF1602A
 * @author: Aye10032
 * @create: 2023-11-24 09:20
 **/

public class Main {

    Main(){}

    void run() throws IOException {
        Reader.init(System.in);

        int T = Reader.nextInt();

        for (int t = 0; t < T; t++) {
            String s = Reader.next();

            char a = findSmallestChar(s);

            System.out.print(a + " ");
            System.out.println(removeChar(s, a));
        }
    }

    char findSmallestChar(String input) {
        char smallestChar = input.charAt(0);
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) < smallestChar) {
                smallestChar = input.charAt(i);
            }
        }
        return smallestChar;
    }

    String removeChar(String input, char c) {
        int index = input.indexOf(c);
        if (index != -1) {
            return input.substring(0, index) + input.substring(index + 1);
        }
        return input;
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
