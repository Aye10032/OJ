package test03_greedy.ShoemakersProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @program: OJ
 * @description: uva10026
 * @author: Aye10032
 * @create: 2023-11-23 09:12
 **/

public class Main {

    static Task[] tasks;

    Main() {
    }

    void run() throws IOException {
        Reader.init(System.in);

        int X = Reader.nextInt();

        for (int t = 0; t < X; t++) {
            int n = Reader.nextInt();

            tasks = new Task[n];
            for (int i = 0; i < n; i++) {
                int T = Reader.nextInt();
                int S = Reader.nextInt();
                tasks[i] = new Task(S, T, i);
            }

            Arrays.sort(tasks, (task1, task2) -> {
                long value1 = (long) task1.T * task2.S;
                long value2 = (long) task1.S * task2.T;

                if (value1 == value2) {
                    return Integer.compare(task1.index, task2.index);
                }
                return Long.compare(value1, value2);
            });

//            System.out.println(Arrays.toString(tasks));
            for (int i = 0; i < n; i++) {
                System.out.print(tasks[i].index);
                if (i < n - 1) {
                    System.out.print(" ");
                }
            }

            if (t < X - 1) {
                System.out.println();
                System.out.println();
            }
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

class Task {
    Integer S;
    Integer T;
    int index;

    public Task(int s, int t, int index) {
        S = s;
        T = t;
        this.index = index + 1;
    }

    @Override
    public String toString() {
        return "Task{" +
                "S=" + S +
                ", T=" + T +
                ", index=" + index +
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
