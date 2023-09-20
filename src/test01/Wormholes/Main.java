package test01.Wormholes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @program: OJ
 * @description: POJ3259
 * @author: Aye10032
 * @create: 2023-09-18 10:02
 **/

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

class Edge {
    int start;
    int end;
    int widget;

    public Edge(int start, int end, int widget) {
        this.start = start;
        this.end = end;
        this.widget = widget;
    }
}

public class Main {
    static List<Edge> edges;
    static int[] d;

    Main() {
        edges = new ArrayList<Edge>();
    }

    void run() throws IOException {
        Reader.init(System.in);
        int farm_num = Reader.nextInt();

        for (int i = 0; i < farm_num; i++) {
            edges.clear();

            int N = Reader.nextInt();
            int M = Reader.nextInt();
            int W = Reader.nextInt();

            int S, E, T;
            for (int j = 0; j < M; j++) {
                S = Reader.nextInt() - 1;
                E = Reader.nextInt() - 1;
                T = Reader.nextInt();

                edges.add(new Edge(S, E, T));
                edges.add(new Edge(E, S, T));
            }
            for (int j = 0; j < W; j++) {
                S = Reader.nextInt() - 1;
                E = Reader.nextInt() - 1;
                T = Reader.nextInt();

                edges.add(new Edge(S, E, -T));
            }

            System.out.println(bellman_ford(N) ? "YES" : "NO");
        }
    }

    boolean bellman_ford(int N) {
        d = new int[N];

        for (int i = 0; i < N; i++) {
            for (Edge edge : edges) {
                if (d[edge.end] > d[edge.start] + edge.widget) {
                    d[edge.end] = d[edge.start] + edge.widget;
                    if (i == N - 1)
                        return true;
                }
            }
        }

        return false;
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
