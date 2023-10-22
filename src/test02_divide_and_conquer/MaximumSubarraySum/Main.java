package test02_divide_and_conquer.MaximumSubarraySum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @program: OJ
 * @description: leetcode 53
 * @author: Aye10032
 * @create: 2023-10-22 11:52
 **/

public class Main {
    static long[] nums;

    Main(){

    }

    void run() throws IOException {
        Reader.init(System.in);

        int n = Reader.nextInt();
        nums = new long[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Reader.nextLong();
        }

        System.out.println(getMax(0, n-1).result);
    }

    SubArray getMax(int l, int r){
        SubArray t;
        if (l == r) {
            t = new SubArray(nums[l], nums[l], nums[l], nums[l]);
            return t;
        }
        int m = (l + r) >> 1;
        SubArray Lt = getMax( l, m);
        SubArray Rt = getMax( m + 1, r);
        t = new SubArray(
                Lt.sum + Rt.sum,
                Math.max(Lt.left, Lt.sum + Rt.left),
                Math.max(Rt.right, Rt.sum + Lt.right),
                Math.max(Math.max(Lt.result, Rt.result), Lt.right + Rt.left));
        return t;
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

class SubArray{
    long sum, left, right, result;

    public SubArray(long sum, long left, long right, long result) {
        this.sum = sum;
        this.left = left;
        this.right = right;
        this.result = result;
    }
}
