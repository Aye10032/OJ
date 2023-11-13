package test03_dynamic_program.TheBattleOfChibi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.StringTokenizer;

/**
 * @program: OJ
 * @description: UVA12983
 * @author: Aye10032
 * @create: 2023-11-09 23:21
 **/

public class Main {

    static int N, M;

    static Integer[] a = new Integer[1002];
    static Integer[] num = new Integer[1002];
    static long[][] f = new long[1002][1002];
    static long[][] opt = new long[1002][1002];

    static int MOD = 1000000007;

    Main() {
    }

    void run() throws IOException {
        Reader.init(System.in);

        int T = Reader.nextInt();

        for (int t = 0; t < T; t++) {
            N = Reader.nextInt();
            M = Reader.nextInt();

            for (int i = 0; i <= N; i++) {
                Arrays.fill(f[i], 0);
                Arrays.fill(opt[i], 0);
            }


            for (int i = 1; i <= N; i++) {
                a[i] = Reader.nextInt();
                num[i] = i;
            }

            Arrays.sort(num, 1, N + 1, new Comparator<Integer>() {
                @Override
                public int compare(Integer x, Integer y) {
                    if (Objects.equals(a[x], a[y])) {
                        return x.compareTo(y);
                    } else {
                        return Integer.compare(a[x], a[y]);
                    }
                }
            });

            for (int i = 1; i <= N; i++) {
                int id = num[i];
                opt[id][i] = 1;
                update(id, 1, 1);
                for (int j = 2; j <= Math.min(i, M); j++) {
                    opt[id][j] = opt[id][j] + ask(id - 1, j - 1);
                    update(id, j, opt[id][j]);
                }
            }

            long res = 0;
            for (int i = M; i <= N; i++) {
                res = (res + opt[i][M]) % MOD;
            }

            System.out.println("Case #" + (t + 1) + ": " + (res - 1));
        }
    }

    int lowBit(int x) {
        return x & -x;
    }

    void update(int i, int j, long value) {
        for (; i <= N; i += lowBit(i)) {
            f[i][j] = (f[i][j] + value) % MOD;
        }
    }

    long ask(int i, int j) {
        long sum = 0;
        for (; i != 0; i -= lowBit(i)) {
            sum = (sum + f[i][j]) % MOD;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        Main demo = new Main();
        demo.run();
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

