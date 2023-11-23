package test03_greedy.DragonOfLoowater;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @program: OJ
 * @description: UVA11292
 * @author: Aye10032
 * @create: 2023-11-19 09:26
 **/

public class Main {

    static Stack<Integer> dragons;
    static Stack<Integer> knights;

    Main() {
        dragons = new Stack<>();
        knights = new Stack<>();
    }

    void run() throws IOException {
        Reader.init(System.in);

        while (true) {
            int n = Reader.nextInt();
            int m = Reader.nextInt();

            if (m == 0 && n == 0)
                break;

            dragons.clear();
            knights.clear();

            for (int i = 0; i < n; i++) {
                dragons.push(Reader.nextInt());
            }

            for (int i = 0; i < m; i++) {
                knights.push(Reader.nextInt());
            }

            if (m < n) {
                System.out.println("Loowater is doomed!");
                continue;
            }

            dragons.sort((o1, o2) -> Integer.compare(o2, o1));
            knights.sort((o1, o2) -> Integer.compare(o2, o1));

            int sum = 0;

            while (!dragons.isEmpty()) {
                if (knights.size() < dragons.size()){
                    System.out.println("Loowater is doomed!");
                    break;
                }

                int knight = knights.pop();
                int dragon = dragons.peek();

                if (knight >= dragon) {
                    sum += knight;
                    dragons.pop();

                    if (dragons.isEmpty()) {
                        System.out.println(sum);
                        break;
                    }
                }
            }

//            System.out.println(sum);
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
