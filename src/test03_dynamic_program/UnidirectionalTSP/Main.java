package test03_dynamic_program.UnidirectionalTSP;

import java.util.Scanner;

/**
 * @program: OJ
 * @description: UVA 116
 * @author: Aye10032
 * @create: 2023-11-08 02:20
 **/

public class Main {
    static int[][] opt;
    static int[][] path;

    static int[] min_choice;
    static int INF = Integer.MAX_VALUE;

    Main() {
    }

    void run() {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();

            int min = INF;
            int index = -1;

            if (cols == 1) {
                for (int i = 0; i < rows; i++) {
                    int next_num = scanner.nextInt();
                    if (min > next_num) {
                        min = next_num;
                        index = i;
                    }
                }
                System.out.println(index + 1);
                System.out.println(min);
                continue;
            }

            if (rows == 1) {
                min = 0;
                for (int i = 0; i < cols - 1; i++) {
                    System.out.print(1 + " ");
                    min += scanner.nextInt();
                }
                min += scanner.nextInt();
                System.out.println(1);
                System.out.println(min);
                continue;
            }

            opt = new int[rows][cols];
            path = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    opt[i][j] = scanner.nextInt();
                }
            }

            for (int i = cols - 2; i >= 0; i--) {
                for (int j = 0; j < rows; j++) {
                    int up = j - 1, right = j, down = j + 1;

                    if (j == 0) {
                        up = rows - 1;
                        min_choice = getMinNum(i, right, down, up);
                    } else if (j == rows - 1) {
                        down = 0;
                        min_choice = getMinNum(i, down, up, right);
                    } else {
                        min_choice = getMinNum(i, up, right, down);
                    }


                    opt[j][i] += min_choice[0];
                    path[j][i] = min_choice[1];

                    if (i == 0 && min > opt[j][0]) {
                        min = opt[j][0];
                        index = j;
                    }
                }
            }

            System.out.print((index + 1));
            for (int i = 0; i < cols - 1; i++) {
                index = path[index][i];
                System.out.print(" " + (index + 1));
            }

            System.out.println();
            System.out.println(min);
        }

        scanner.close();

    }

    int[] getMinNum(int col, int line1, int line2, int line3) {
        int a = opt[line1][col + 1];
        int b = opt[line2][col + 1];
        int c = opt[line3][col + 1];

        int min = Math.min(a, Math.min(b, c));
        int index;

        if (min == a)
            index = line1;
        else if (min == b)
            index = line2;
        else
            index = line3;

        return new int[]{min, index};
    }

    public static void main(String[] args) {
        Main demo = new Main();
        demo.run();
    }

}