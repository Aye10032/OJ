package test03_dynamic_program.PartitioningByPalindromes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @program: OJ
 * @description: UVA11584
 * @author: Aye10032
 * @create: 2023-11-06 21:14
 **/

public class Main {

    static int[] dp;
    static char[] chars;

    Main() {

    }

    void run() throws IOException {
        Reader.init(System.in);

        int n = Reader.nextInt();

        for (int t = 0; t < n; t++) {
            String input = Reader.next();
            chars = input.toCharArray();

            int len = input.length();
            dp = new int[len];
            dp[0] = 1;
            if (isPalindrome(0, len - 1)) {
                System.out.println(1);
            } else {
                for (int i = 1; i < len; i++) {
                    dp[i] = dp[i - 1] + 1;
                    for (int j = 0; j <= i; j++) {
                        if (isPalindrome(j, i)) {
                            if (j==0){
                                dp[i] = 1;
                            }else {
                                dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                            }
                        }
                    }
                }

                System.out.println(dp[len - 1]);
            }
        }
    }

    boolean isPalindrome(int l, int r) {
        while (l < r) {
            if (chars[l] == chars[r]) {
                l++;
                r--;
            } else {
                return false;
            }
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
