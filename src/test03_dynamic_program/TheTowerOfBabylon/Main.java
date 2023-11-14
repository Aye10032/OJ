package test03_dynamic_program.TheTowerOfBabylon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @program: OJ
 * @description: UVA437
 * @author: Aye10032
 * @create: 2023-11-14 01:34
 **/

class Block {
    int length;
    int width;
    int height;

    Integer size;

    public Block(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.size = length * width;
    }

    @Override
    public String toString() {
        return "Block{" +
                "length=" + length +
                ", width=" + width +
                ", height=" + height +
                ", size=" + size +
                '}';
    }
}

public class Main {

    static List<Block> blocks;
    static int[] opt;

    Main() {
        blocks = new ArrayList<>();
    }

    void run() throws IOException {
        Reader.init(System.in);

        int caseNum = 1;

        while (true) {
            blocks.clear();

            int n = Reader.nextInt();
            if (n == 0)
                break;

            for (int i = 1; i <= n; i++) {
                int x = Reader.nextInt();
                int y = Reader.nextInt();
                int z = Reader.nextInt();

                blocks.add(new Block(Math.max(x, y), Math.min(x, y), z));
                blocks.add(new Block(Math.max(y, z), Math.min(y, z), x));
                blocks.add(new Block(Math.max(x, z), Math.min(x, z), y));
            }

            blocks.sort((o1, o2) -> o2.size - o1.size);

            opt = new int[blocks.size()];
            Arrays.fill(opt, 0);
            opt[0] = blocks.get(0).height;
            int max = 0;
            for (int i = 0; i < blocks.size(); i++) {
                opt[i] = blocks.get(i).height;
                for (int j = 0; j < i; j++) {
                    if (blocks.get(j).length > blocks.get(i).length && blocks.get(j).width > blocks.get(i).width) {
                        opt[i] = Math.max(opt[i], blocks.get(i).height + opt[j]);
                        max = Math.max(opt[i], max);
                    }
                }
            }

//            System.out.println(Arrays.toString(opt));

            System.out.println("Case " + caseNum + ": maximum height = " + max);
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
}
