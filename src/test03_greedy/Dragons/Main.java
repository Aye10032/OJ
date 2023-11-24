package test03_greedy.Dragons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @program: OJ
 * @description: CF230A
 * @author: Aye10032
 * @create: 2023-11-24 10:13
 **/

public class Main {

    static Dragon[] dragons;

    Main() {
    }

    void run() throws IOException {
        Reader.init(System.in);

        int s = Reader.nextInt();
        int n = Reader.nextInt();

        dragons = new Dragon[n];

        for (int i = 0; i < n; i++) {
            dragons[i] = new Dragon(Reader.nextInt(), Reader.nextInt());
        }

        Arrays.sort(dragons, (o1, o2) -> {
            if (o1.strength == o2.strength)
                return o2.bonus - o1.bonus;
            return o1.strength - o2.strength;
        });

//        System.out.println(Arrays.toString(dragons));

        boolean live = true;
        for (Dragon dragon : dragons) {
            if (dragon.strength >= s) {
                live = false;
                break;
            } else {
                s += dragon.bonus;
            }
        }

        System.out.println(live ? "YES" : "NO");
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

class Dragon {
    int strength;
    int bonus;

    public Dragon(int strength, int bonus) {
        this.strength = strength;
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "Dragon{" +
                "strength=" + strength +
                ", bonus=" + bonus +
                '}';
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
