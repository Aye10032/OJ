package test02_divide_and_conquer.FireNet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @program: OJ
 * @description: ZOJ 1002，HDU 1045
 * @author: Aye10032
 * @create: 2023-10-21 20:53
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

    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}

public class Main {

    static char[][] city;
    static int ans, n;

    Main(){

    }

    void run() throws IOException {
        Reader.init(System.in);

        while (true){
            n = Reader.nextInt();

            if (n==0)
                break;

            city = new char[n][n];

            for (int i = 0; i < n; i++) {
                String line = Reader.next();
                for (int j = 0; j < n; j++) {
                    city[i][j] = line.charAt(j);
                }
            }

            ans = 0;
            dfs(0,0);
            System.out.println(ans);
        }
    }

    void dfs(int k, int sum) {
        if(k == n * n) {
            ans = Math.max(ans, sum);
            return;
        }

        int x = k / n;
        int y = k % n;

        if(city[x][y] == '.' && check(x, y)) {
            city[x][y] = '0';
            dfs(k + 1, sum + 1);
            city[x][y] = '.';
        }

        dfs(k + 1, sum);
    }

    private static boolean check(int x, int y) {
        for(int i = x - 1; i >= 0; i--) {
            if(city[i][y] == '0') return false;
            if(city[i][y] == 'X') break;
        }

        for(int j = y - 1; j >= 0; j--) {
            if(city[x][j] == '0') return false;
            if(city[x][j] == 'X') break;
        }

        return true;
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
