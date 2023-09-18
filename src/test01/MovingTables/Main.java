package test01.MovingTables;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: OJ
 * @description: moving tables
 * @author: Aye10032
 * @create: 2023-09-16 09:39
 **/

public class Main {

    public Main() {
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        List<Plan> plans = new ArrayList<Plan>();

        int plan_count = scanner.nextInt();
        for (int i = 0; i < plan_count; i++) {
            int table_count = scanner.nextInt();

            for (int j = 0; j < table_count; j++) {
                int v1 = scanner.nextInt();
                int v2 = scanner.nextInt();

                int start = Math.min(v1, v2);
                int end = Math.max(v1, v2);

                Plan plan = new Plan(start / 2 - ((start % 2 == 0) ? 1 : 0), end / 2 - ((end % 2 == 0) ? 1 : 0));

                plans.add(plan);
            }

            System.out.println(cal(plans) * 10);
            plans.clear();
        }
        scanner.close();
    }

    public int cal(List<Plan> plans) {

        int[] arr = new int[200];

        for (int i = 0; i < 200; i++) {
            arr[i] = 0;
        }

        for (Plan plan : plans) {
            for (int i = plan.start; i <= plan.end; i++) {
                arr[i] += 1;
            }
        }

        int max = 0;

        for (int i = 0; i < 200; i++) {
            max = Math.max(max, arr[i]);
        }

        return max;
    }

    class Plan {
        private final int start;
        private final int end;

        Plan(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Main main_test = new Main();
        main_test.run();
    }

}
