package pl.dziwins.Day1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<Integer> input1 = new ArrayList<>();

    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(new File("src/pl/dziwins/Day1/input"));
            while (sc.hasNext()) {
                int a = sc.nextInt();
                input1.add(a);
            }
            sc.close();

            int first = 0;
            int second = 0;
            int third = 0;

            for (int i : input1) {
                for (int j : input1) {
                    if (j == (2020 - i)) {
                        first = i;
                        second = j;
                        break;
                    }
                }
            }

            int result = first * second;
            System.out.println(first);
            System.out.println(second);
            System.out.println(result);
            System.out.println(first+second);

            for (int i : input1) {
                for (int j : input1) {
                    for (int k : input1) {
                        if (k == (2020 - i - j)) {
                            first = i;
                            second = j;
                            third = k;
                            break;
                        }
                    }
                }
            }
            result = first*second*third;
            System.out.println(result);
            System.out.println(first+second+third);

        } catch (Exception e)
        {
            System.out.println(e);
        }




        // write your code here
    }
}