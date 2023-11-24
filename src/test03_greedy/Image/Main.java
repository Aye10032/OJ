package test03_greedy.Image;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @program: OJ
 * @description: CF1721A
 * @author: Aye10032
 * @create: 2023-11-23 23:12
 **/

public class Main {

    public static Set<Character> set;

    Main(){
        set = new HashSet<>();
    }

    void run() throws IOException {
        Reader.init(System.in);

        int n = Reader.nextInt();

        for (int t = 0; t < n; t++) {

            for (int i = 0; i < 2; i++) {
                char[] chars = Reader.next().toCharArray();
                set.add(chars[0]);
                set.add(chars[1]);
            }

            if (set.size()==1)
                System.out.println(0);
            else if (set.size() == 2)
                System.out.println(1);
            else if (set.size()==3)
                System.out.println(2);
            else
                System.out.println(3);

            set.clear();
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
