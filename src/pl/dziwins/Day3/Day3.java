package pl.dziwins.Day3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day3 {

    private static List<String> inputList = new ArrayList<String>();
    private static int result1;
    private static long result2;

    private static void getInput(String url) {

        try {

            Scanner sc = new Scanner(new File(url));
            while (sc.hasNext()) {
                String line = sc.nextLine();
                inputList.add(line);
            }
            sc.close();
            System.out.println("Input added.");
            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static int puzzle1(int goRight, int goDown) {
        int counter = 0;
        int moveRight = 0;
        int rowLenght = inputList.get(0).length();

        for (int i = goDown; i < inputList.size(); i+=goDown) {

            moveRight+=goRight;
            if (moveRight >= rowLenght) {
                moveRight -= rowLenght;
            }

            if (inputList.get(i).charAt(moveRight) == '#'){
                counter++;
            }

        }

        return result1 = counter;
    }

    public static void main(String[] args) {

        System.out.println();
        System.out.println("Program starts.");

        getInput("src/pl/dziwins/Day3/input");
        int a = puzzle1(1,1);
        System.out.println(a);
        int b = puzzle1(3, 1);
        System.out.println(b);
        int c = puzzle1(5, 1);
        System.out.println(c);
        int d = puzzle1(7, 1);
        System.out.println(d);
        int e = puzzle1(1, 2);
        System.out.println(e);
        result2 = (long) a*b*c*d*e;


        System.out.println();
        System.out.println(result1);
        System.out.println();
        System.out.println(result2);
        System.out.println();
        System.out.println("The end.");

    }
}
