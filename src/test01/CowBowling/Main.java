package test01.CowBowling;

/**
 * @program: OJ
 * @description: POJ 3176
 * @author: Aye10032
 * @create: 2023-09-20 17:05
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Class for buffered reading int and double values
 */
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

    static int[][] triangle;
    static List<Integer> search;

    Main() {
        search = new ArrayList<Integer>();
    }

    void run() throws IOException {
        Reader.init(System.in);

        int N = Reader.nextInt();

        triangle = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Reader.nextInt();
            }
        }

//        printGraph();

        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                triangle[i][j] += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
            }
        }

//        printGraph();

        System.out.println(triangle[0][0]);
    }

    void printGraph(){
        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j < triangle.length; j++) {
                System.out.print(triangle[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------");
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
