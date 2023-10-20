package test02_divide_and_conquer.HanoiTowerTroublesAgain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @program: OJ
 * @description: UVA10276
 * @author: Aye10032
 * @create: 2023-10-20 12:17
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

    static int[] result;

    Main() {
        result = new int[]{0, 1, 3, 7, 11, 17, 23, 31, 39, 49, 59, 71, 83, 97, 111, 127, 143, 161, 179, 199, 219, 241, 263, 287, 311, 337, 363, 391, 419, 449, 479, 511, 543, 577, 611, 647, 683, 721, 759, 799, 839, 881, 923, 967, 1011, 1057, 1103, 1151, 1199, 1249, 1299};
    }

    void run() throws IOException {
        Reader.init(System.in);

        int n = Reader.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println(result[Reader.nextInt()]);
        }
    }

    public static void main(String[] args) {
        Main demo = new Main();

        try {
            demo.run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        GetResult getResult = new GetResult();
//        for (int i = 0; i < 51; i++) {
//            getResult.get(i);
//        }

    }

}

//class GetResult {
//    void get(int N) {
//
//        List<Stack<Integer>> pegs = new ArrayList<>();
//
//        for (int i = 0; i < N; i++) {
//            pegs.add(new Stack<>());
//        }
//
//        int index = 1;
//        while (true) {
//            boolean flag = false;
//            for (int i = 0; i < N; i++) {
//                Stack<Integer> peg = pegs.get(i);
//                if (peg.isEmpty()) {
//                    peg.push(index);
//                    pegs.set(i, peg);
//                    index++;
//                    flag = true;
//                    break;
//                }
//
//                int top = peg.peek();
//                if (Math.pow((int) Math.sqrt(index + top), 2) == top + index) {
//                    peg.push(index);
//                    pegs.set(i, peg);
//                    index++;
//                    flag = true;
//                    break;
//                }
//            }
//
//            if (!flag)
//                break;
//        }
//        System.out.println(index - 1);
//    }
//}
