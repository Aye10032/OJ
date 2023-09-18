package test01.CounterfeitDollar;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @program: OJ
 * @description: OJ
 * @author: Aye10032
 * @create: 2023-09-14 19:19
 **/

public class Main {

    public Main() {
    }

    public void run() {
        Map<Character, Integer> coin = new HashMap<Character, Integer>();
        coin.put('A', 0);
        coin.put('B', 1);
        coin.put('C', 2);
        coin.put('D', 3);
        coin.put('E', 4);
        coin.put('F', 5);
        coin.put('G', 6);
        coin.put('H', 7);
        coin.put('I', 8);
        coin.put('J', 9);
        coin.put('K', 10);
        coin.put('L', 11);

        Scanner scanner = new Scanner(System.in);

        int plan_count = Integer.parseInt(scanner.nextLine().replace(" ", ""));
        for (int i = 0; i < plan_count; i++) {
            boolean[] coin_true = new boolean[12];
            int[] coin_heavy = new int[12];
            for (int j = 0; j < 12; j++) {
                coin_true[j] = false;
                coin_heavy[j] = 0;
            }

            for (int j = 0; j < 3; j++) {
                String input = scanner.nextLine();

                String[] inputs = input.split(" ");

                if (inputs[2].equals("even")) {
                    for (Character cha : inputs[0].toCharArray()) {
                        coin_true[coin.get(cha)] = true;
                        coin_heavy[coin.get(cha)] = 0;
                    }

                    for (Character cha : inputs[1].toCharArray()) {
                        coin_true[coin.get(cha)] = true;
                        coin_heavy[coin.get(cha)] = 0;
                    }
                } else if (inputs[2].equals("up")) {
                    for (Character cha : inputs[0].toCharArray()) {
                        int count = coin_heavy[coin.get(cha)] + (coin_true[coin.get(cha)] ? 0 : 1);
                        coin_heavy[coin.get(cha)] = count;
                    }

                    for (Character cha : inputs[1].toCharArray()) {
                        int count = coin_heavy[coin.get(cha)] - (coin_true[coin.get(cha)] ? 0 : 1);
                        coin_heavy[coin.get(cha)] = count;
                    }
                } else {
                    for (Character cha : inputs[0].toCharArray()) {
                        int count = coin_heavy[coin.get(cha)] - (coin_true[coin.get(cha)] ? 0 : 1);
                        coin_heavy[coin.get(cha)] = count;
                    }

                    for (Character cha : inputs[1].toCharArray()) {
                        int count = coin_heavy[coin.get(cha)] + (coin_true[coin.get(cha)] ? 0 : 1);
                        coin_heavy[coin.get(cha)] = count;
                    }
                }
            }

            int max = 0;
            char max_char = ' ';

            for (int j = 0; j < 12; j++) {
                if (Math.abs(coin_heavy[j]) > Math.abs(max)){
                    max = coin_heavy[j];
                    max_char = (char) ('A' + j);
                }
            }

            System.out.println(max_char + " is the counterfeit coin and it is " + (max > 0 ? "heavy." : "light."));
        }
        scanner.close();
    }

    public static void main(String[] args) {
        Main main_test = new Main();
        main_test.run();
    }

}
