package test01.TruckHistory;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: OJ
 * @description: truck history
 * @author: Aye10032
 * @create: 2023-09-16 09:42
 **/

public class Main {
    int INF = Integer.MAX_VALUE;
    int case_num;
    static int[][] graph;
    static int[] minDist;
    static boolean[] visited;

    Main() {
    }

    void run() {
        Scanner scanner = new Scanner(System.in);


        String[] types;
        while (true) {
            case_num = scanner.nextInt();

            if (case_num == 0)
                System.exit(0);

            types = new String[case_num];

            for (int i = 0; i < case_num; i++)
                types[i] = scanner.next();

            creatGraph(types);
            System.out.println("The highest possible quality is 1/" + prim() + ".");
        }
    }


    void creatGraph(String[] types) {
        graph = new int[case_num][case_num];

        for (int i = 0; i < case_num; i++) {
            graph[i][i] = 0;

            for (int j = 0; j < i; j++) {
                graph[i][j] = graph[j][i] = getDiff(types[i].toCharArray(), types[j].toCharArray());
            }
        }
    }

    int getDiff(char[] str1, char[] str2) {
        int count = 0;

        for (int i = 0; i < 7; i++) {
            if (((int) str1[i] ^ (int) str2[i]) != 0) {
                count++;
            }
        }

        return count;
    }

    int prim() {
        minDist = new int[case_num];
        visited = new boolean[case_num];

        Arrays.fill(minDist, INF);
        minDist[0] = 0;

        for (int i = 0; i < case_num; i++) {
            int new_cheap = findMinIndex(minDist, visited);

            if (new_cheap == -1)
                continue;

            visited[new_cheap] = true;

            for (int j = 0; j < case_num; j++) {
                if (graph[new_cheap][j] != 0 && !visited[j]) {
                    minDist[j] = Math.min(graph[new_cheap][j], minDist[j]);
                }
            }
//            System.out.println(Arrays.toString(visited));
//            System.out.println(Arrays.toString(minDist));

        }

        int sum = 0;

        for (int num : minDist) {
            sum += num;
        }

        return sum;
    }

    int findMinIndex(int[] minDist, boolean[] visited) {
        int min = INF;
        int minIndex = -1;

        for (int i = 0; i < case_num; i++) {
            if (!visited[i] && minDist[i] < min) {
                min = minDist[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

}
