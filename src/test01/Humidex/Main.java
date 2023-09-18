package test01.Humidex;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @program: OJ
 * @description: OJ
 * @author: Aye10032
 * @create: 2023-09-14 19:19
 **/

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder builder = new StringBuilder();
        while (true) {
            String input = scanner.nextLine();

            if (input.equals("E")) {
                break;
            }

            String[] inputs = input.split(" ");
            String char1 = inputs[0];
            double value1 = Double.parseDouble(inputs[1]);
            String char2 = inputs[2];
            double value2 = Double.parseDouble(inputs[3]);

            double T = 0, D = 0, H = 0;
            boolean T_f = false, D_f = false, H_f = false;

            if (char1.equals("T")) {
                T = value1;
                T_f = true;
            } else if (char1.equals("D")) {
                D = value1;
                D_f = true;
            } else {
                H = value1;
                H_f = true;
            }

            if (char2.equals("T")) {
                T = value2;
                T_f = true;
            } else if (char2.equals("D")) {
                D = value2;
                D_f = true;
            } else {
                H = value2;
                H_f = true;
            }

            if (!T_f) {
                T = getT(D, H);
            } else if (!D_f) {
                D = getD(T, H);
            } else {
                H = getH(T, D);
            }

            DecimalFormat format = new DecimalFormat("#0.0");
            format.setRoundingMode(RoundingMode.HALF_UP);
            builder.append("T ")
                    .append(format.format(T))
                    .append(" D ")
                    .append(format.format(D))
                    .append(" H ")
                    .append(format.format(H))
                    .append("\n");
        }
        scanner.close();
        System.out.println(builder.toString());
    }

    public static float getH(double T, double D) {
        double e = 6.11 * Math.exp(5417.7530 * ((1 / 273.16) - (1 / (D + 273.16))));
        double H = (0.5555) * (e - 10.0);
        return (float) (T + H);
    }

    public static float getD(double T, double H) {
        double e = (H - T) / (0.5555) + 10.0;
        double D = 1 / ((1 / 273.16) - (Math.log(e / 6.11) / 5417.7530)) - 273.16;
        return (float) D;
    }

    public static float getT(double D, double H) {
        double e = 6.11 * Math.exp(5417.7530 * ((1 / 273.16) - (1 / (D + 273.16))));
        double h = 0.5555 * (e - 10.0);
        double T = H - h;
        return (float) T;
    }

}

