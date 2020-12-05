package pl.dziwins.Day4;

import java.io.File;
import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Pattern;

public class PassportProcessing {

    private static List<String> input = new ArrayList<>();
    private static List<String> cards = new ArrayList<>();
    //not has to contain "cid"
    private static String[] codes = new String[]{"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"};
    private static Pattern hairPattern = Pattern.compile("[a-f]||[0-9]");
    private static Pattern digitsPattern = Pattern.compile("[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]");
    private static String[] eyeColor = new String[]{"amb","blu","brn","gry","grn","hzl","oth"};

    private static void getInput(String url) {
        try {
            Scanner sc = new Scanner(new File((url)));
            while (sc.hasNextLine()) {

                input.add(sc.nextLine());
            }
            sc.close();

            StringBuilder sb = new StringBuilder();
            for (String s : input) {

                if (s.equals(input.get(input.size() - 1)))
                    cards.add(s);

                if (s.isEmpty()) {
                    cards.add(sb.toString());
                    sb = new StringBuilder();
                } else {
                    sb.append(s);
                    sb.append(" ");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int isValid(List<String> cards) {
        int result1 = 0;

        for (String s : cards) {

            int valid = 0;
            for (String c : codes) {
                if (s.contains(c)) {
                    valid++;
                }
            }
            if (valid == codes.length) {
                result1++;
            }
        }
        return result1;
    }

    public static int isValid2(List<String> cards) {
        int result2 = 0;

        for (String s : cards) {
            boolean hasAll = false;
            int valid = 0;
            for (String c : codes) {
                if (s.contains(c)) {
                    valid++;
                }
            }
            if (valid == codes.length) {
                hasAll = true;
            }

            if (hasAll) {
                String[] splitted = s.split(" ");
                int value = 0;
                for (String spl : splitted) {
                    switch (spl.substring(0, 3)) {
                        case "byr":
                            int byr = Integer.valueOf(spl.substring(4));
                            if ((byr >= 1920) && (byr <= 2002)) {
                                value++;
                            }
                            break;
                        case "iyr":
                            int iyr = Integer.valueOf(spl.substring(4));
                            if ((iyr >= 2010) && (iyr <= 2020)) {
                                value++;
                            }
                            break;
                        case "eyr":
                            int eyr = Integer.valueOf(spl.substring(4));
                            if ((eyr >= 2020) && (eyr <= 2030)) {
                                value++;
                            }
                            break;
                        case "hgt":
                            String measure = spl.substring(spl.length() - 2);
                            if (measure.equals("cm")) {
                                int height = Integer.valueOf(spl.substring(4, spl.length() - 2));
                                if ((height >= 150) && (height <= 193)) {
                                    value++;
                                }
                            }
                            if (measure.equals("in")) {
                                int height = Integer.valueOf(spl.substring(4, spl.length() - 2));
                                if ((height >= 59) && (height <= 76)) {
                                    value++;
                                }
                            }

                        case "hcl":
                            if (spl.substring(4,5).equals("#")){
                                String hcl = spl.substring(5);
                                if (hcl.length()==6) {
                                    int helper = 0;
                                    for (int i =0; i<hcl.length(); i++){
                                        if (hairPattern.matcher(String.valueOf(hcl.charAt(i))).matches()){
                                            helper++;
                                        }
                                    }
                                    if (helper == 6){
                                        value++;
                                    }
                                }
                            }
                            break;

                        case "ecl":
                            String ecl = spl.substring(4);
                            for (String color : eyeColor)
                            {
                                if (color.equals(ecl)){
                                    value++;
                                }
                            }
                            break;
                        case "pid":
                            String pidS = spl.substring(4);
                            if ((pidS.length() == 9) && digitsPattern.matcher(pidS).matches()) {
                                value++;
                            }
                            break;
                        case "cid":
                            break;
                        default:
                            System.out.println(spl.substring(0, 3));
                    }

                }
                if (value == 7){
                    result2++;
                }

            }
        }

        return result2;
    }


    public static void main(String[] args) {

        getInput("src/pl/dziwins/Day4/input");
        System.out.println("Result1: " + isValid(cards));
        System.out.println("Result2: " + isValid2(cards));

    }

}
