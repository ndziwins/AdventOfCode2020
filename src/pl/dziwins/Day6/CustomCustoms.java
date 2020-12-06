package pl.dziwins.Day6;

import java.io.File;
import java.util.*;
import java.util.regex.Pattern;

public class CustomCustoms {

    private static List<String> input = new ArrayList<>();
    private static List<String> input2 = new ArrayList<>();

    private static void getInput(String url) {
        try {
            Scanner sc = new Scanner(new File((url)));
            while (sc.hasNextLine()) {
                input.add(sc.nextLine());
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int sumOfYes(List<String> input) {
        int result1 = 0;

        StringBuilder sb = new StringBuilder();
        for (String s : input) {

            if (s.isEmpty()) {
                input2.add(sb.toString());
                sb = new StringBuilder();
            } else {
                sb.append(s);
            }

            if (s.equals(input.get(input.size() - 1))) {
                input2.add(sb.toString());
                sb = new StringBuilder();
            }
        }

        Set<String> set = new HashSet<>();

        for (String s : input2) {

            String[] chars = s.split("");
            for (String ch : chars) {
                set.add(ch);
            }
            result1 += set.size();
            set = new HashSet<>();

        }
        return result1;
    }

    public static int isValid2(List<String> input) {
        int result2 = 0;

        Set<String> set = new HashSet<>();
        List<String> helper1 = new ArrayList<>();
        int counter = 0;
        for (String s : input) {

            counter++;


            if (s.isEmpty()) {
                result2 += set.size();
                set.clear();
                helper1.clear();
                continue;
            } else {
                String[] chars = s.split("");
                if ((set.isEmpty()) && (helper1.isEmpty()) && (!s.equals(input.get(input.size() - 1)))){
                    for (String ch : chars) {
                        set.add(ch);
                        continue;
                    }
                } else if ((!s.equals(input.get(input.size() - 1)))) {
                    for (String ch : chars) {
                        helper1.add(ch);
                    }
                    set.retainAll(helper1);
                    continue;
                }
            }

            if ((s.equals(input.get(input.size() - 1))) && (!s.isEmpty())) {
                String[] chars = s.split("");
                for (String ch : chars) {
                    helper1.add(ch);
                }
                set.retainAll(helper1);
                result2 += set.size();
                set.clear();
                helper1.clear();
            }

        }
        return result2;
    }


    public static void main(String[] args) {

        getInput("src/pl/dziwins/Day6/input");
        System.out.println("Result1: " + sumOfYes(input));
        System.out.println("Result2: " + isValid2(input));
    }

}
