import java.util.*;

/**
 * @program: OJ
 * @description: OJ
 * @author: Aye10032
 * @create: 2023-09-14 19:19
 **/

class Point {
    double left;
    double right;

    Point(double left, double right) {
        this.left = left;
        this.right = right;
    }
}

public class Main {

    private static double getDis(double d, double y) {
        return Math.sqrt(Math.pow(d, 2) - Math.pow(y, 2));
    }

    private static int cal(List<Point> ranges) {
        int count = 1;
        double now_right = ranges.get(0).right;

        for (Point pos : ranges) {
            if (pos.left > now_right) {
                ++count;
                now_right = pos.right;
            } else {
                now_right = Math.min(now_right, pos.right);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        List<Point> ranges = new ArrayList<Point>();
        while (true) {
            count++;
            ranges.clear();

            int case_num = scanner.nextInt();
            int d = scanner.nextInt();

            if (case_num == 0 && d == 0)
                System.exit(0);

            boolean flag = true;
            for (int i = 0; i < case_num; ++i) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();

                if (y > d) {
                    flag = false;
                }

                ranges.add(new Point(x - getDis(d, y), x + getDis(d, y)));
            }

            if (flag) {
                Collections.sort(ranges, new Comparator<Point>() {
                    @Override
                    public int compare(Point o1, Point o2) {
                        return o1.left < o2.left ? -1 : 1;
                    }
                });

                System.out.println("Case " + count + ": " + cal(ranges));
            } else {
                System.out.println("Case " + count + ": -1");
            }
        }
    }
}
