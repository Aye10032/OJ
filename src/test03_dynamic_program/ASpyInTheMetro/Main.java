package test03_dynamic_program.ASpyInTheMetro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.min;

/**
 * @program: OJ
 * @description: uva1025
 * @author: Aye10032
 * @create: 2023-11-12 10:44
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

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}

public class Main {

    //第i站到第i+1站的时间
    static int[] t;

    //第i时刻在j站要等多久
    static int[][] opt = new int[10010][55];

    //第i站j时刻两个方向是否有车
    static boolean[][] trainL = new boolean[55][10010];
    static boolean[][] trainR = new boolean[55][10010];

    static int INF = 0x3f3f3f3f;

    Main() {
    }

    void run() throws IOException {
        Reader.init(System.in);

        int caseNum = 1;
        while (true) {
            int n = Reader.nextInt();
            if (n == 0)
                break;

            for (int i = 0; i < 55; i++) {
                Arrays.fill(trainL[i], false);
                Arrays.fill(trainR[i], false);
            }

            int T = Reader.nextInt();

            t = new int[n + 1];
            for (int i = 1; i <= n - 1; i++) {
                t[i] = Reader.nextInt();
            }
            t[n] = 0;

            int M1 = Reader.nextInt();
            for (int i = 1; i <= M1; i++) {
                int sum = Reader.nextInt();
                for (int j = 1; j <= n; j++) {
                    trainL[j][sum] = true;
                    sum += t[j];
                }
            }

            int M2 = Reader.nextInt();
//            System.out.println("n=" + n + ",T=" + T + ",M1=" + M1 + ",M2=" + M2);
            for (int i = 1; i <= M2; i++) {
                int sum = Reader.nextInt();
                for (int j = n; j >= 1; j--) {
                    trainR[j][sum] = true;
                    sum += t[j - 1];
                }
            }

            Arrays.fill(opt[T], INF);
            opt[T][n] = 0;

            for (int i = T - 1; i >= 0; i--) {
                for (int j = 1; j <= n; j++) {
                    opt[i][j] = opt[i + 1][j] + 1;
                    if (j < n && trainL[j][i] && i + t[j] <= T) {
                        opt[i][j] = min(opt[i][j], opt[i + t[j]][j + 1]);
                    }
                    if (j > 1 && trainR[j][i] && i + t[j - 1] <= T) {
                        opt[i][j] = min(opt[i][j], opt[i + t[j - 1]][j - 1]);
                    }
                }
            }

            System.out.println("Case Number " + caseNum + ": " + (opt[0][1] >= INF ? "impossible" : opt[0][1]));

            caseNum++;
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
