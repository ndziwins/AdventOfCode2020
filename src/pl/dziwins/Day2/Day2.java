package pl.dziwins.Day2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day2 {

    public static List<String> input = new ArrayList<>();
    public static List<Integer> min = new ArrayList<>();
    public static List<Integer> max = new ArrayList<>();
    public static List<Character> letters = new ArrayList<Character>();
    public static List<String> password = new ArrayList<>();

    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(new File("src/pl/dziwins/Day2/input"));
            while (sc.hasNext()) {
                String a = sc.nextLine();
                input.add(a);
            }
            sc.close();

            for (String a : input) {
                String[] b = a.split(" ");
                String num[] = b[0].split("-");
                min.add(Integer.valueOf(num[0]));
                max.add(Integer.valueOf(num[1]));
                letters.add((b[1]).charAt(0));
                password.add(b[2]);

            }

            int counter = 0;
            for (int i = 0; i < min.size(); i++) {
                int helper = 0;
                char result[] = password.get(i).toCharArray();

                for (int j = 0; j < result.length; j++) {
                    if (result[j] == letters.get(i)) {
                        helper++;
                    }
                }

                if ((helper >= min.get(i)) && (helper <= max.get(i))) {
                    counter++;
                }

            }

            System.out.println(counter);
            System.out.println();

            counter = 0;
            int norb = 0;
            for (int i = 0; i < min.size(); i++) {
                char result[] = password.get(i).toCharArray();

                if (((result[min.get(i)-1] == letters.get(i)) && (result[max.get(i)-1] != letters.get(i))) ||
                    ((result[min.get(i)-1] != letters.get(i)) && (result[max.get(i)-1] == letters.get(i))))
                {
                    counter++;
                }

            }

            System.out.println(counter);

        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("END.");
    }
}
