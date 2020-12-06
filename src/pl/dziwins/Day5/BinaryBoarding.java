package pl.dziwins.Day5;

import java.io.File;
import java.sql.SQLOutput;
import java.util.*;
import java.util.regex.Pattern;

public class BinaryBoarding {

    private static List<String> input = new ArrayList<>();
    //rows and columns index are numbered from 0
    private static final int totalRows = 128;
    private static final int totalColumns = 8;
    private static int maxId;

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

    private static int highestSeatId(List<String> input) {
        int result1 = 0;
        int steps = input.get(0).length();

        for (String s : input) {
            int UpperRow = totalRows - 1;
            int LowerRow = 0;
            int UpperColumn = totalColumns - 1;
            int LowerColumn = 0;

            for (int i = 0; i < steps; i++) {
//                System.out.println(s.charAt(i));127
                switch (s.charAt(i)) {
                    case 'F':
                        UpperRow = (int) Math.ceil(UpperRow - (UpperRow - LowerRow) / 2 - 1);
//                        System.out.println(LowerRow+"/"+UpperRow);
                        break;
                    case 'B':
                        LowerRow = (int) Math.floor(LowerRow + (UpperRow - LowerRow) / 2 + 1);
//                        System.out.println(LowerRow+"/"+UpperRow);
                        break;
                    case 'R':
                        LowerColumn = (int) Math.floor(LowerColumn + (UpperColumn - LowerColumn) / 2 + 1);
//                        System.out.println(LowerColumn+"/"+UpperColumn);
                        break;
                    case 'L':
                        UpperColumn = (int) Math.ceil(UpperColumn - (UpperColumn - LowerColumn) / 2 - 1);
//                        System.out.println(LowerColumn+"/"+UpperColumn);
                }
            }

            int row = 0;
            int column = 0;

            if (Character.toString(s.charAt(6)).equals("F")) {
                row = UpperRow;
            } else {
                row = LowerRow;
            }

            if (Character.toString(s.charAt(9)).equals("R")) {
                column = LowerColumn;
            } else {
                column = UpperColumn;
            }
            column = column < 0 ? column = 0 : column;
            row = row < 0 ? row = 0 : row;

            int id = row * 8 + column;
            result1 = result1 < id ? id : result1;

        }

        return result1;
    }

    private static int myId(List<String> input) {
        int result2 = 0;
        int steps = input.get(0).length();
        List<Integer> idList = new ArrayList<Integer>();

        for (String s : input) {
            int UpperRow = totalRows - 1;
            int LowerRow = 0;
            int UpperColumn = totalColumns - 1;
            int LowerColumn = 0;

            for (int i = 0; i < steps; i++) {
                switch (s.charAt(i)) {
                    case 'F':
                        UpperRow = (int) Math.ceil(UpperRow - (UpperRow - LowerRow) / 2 - 1);
                        break;
                    case 'B':
                        LowerRow = (int) Math.floor(LowerRow + (UpperRow - LowerRow) / 2 + 1);
                        break;
                    case 'R':
                        LowerColumn = (int) Math.floor(LowerColumn + (UpperColumn - LowerColumn) / 2 + 1);
                        break;
                    case 'L':
                        UpperColumn = (int) Math.ceil(UpperColumn - (UpperColumn - LowerColumn) / 2 - 1);
                }
            }

            int row = 0;
            int column = 0;

            if (Character.toString(s.charAt(6)).equals("F")) {
                row = UpperRow;
            } else {
                row = LowerRow;
            }

            if (Character.toString(s.charAt(9)).equals("R")) {
                column = LowerColumn;
            } else {
                column = UpperColumn;
            }
            column = column < 0 ? column = 0 : column;
            row = row < 0 ? row = 0 : row;

            int id = row * 8 + column;
            idList.add(id);
        }

        List<Integer> myIds = new ArrayList<Integer>();

        for (int i = 0; i < maxId; i++) {
            myIds.add(i);
        }

        myIds.removeAll(idList);

        for (int i : myIds) {
            for (int j : myIds) {
                if ((i != j+1) && (i != j-1)){
                    result2 = i;
                }
            }
        }

        return result2;
    }


    public static void main(String[] args) {

        getInput("src/pl/dziwins/Day5/input");
        maxId = highestSeatId(input);
        System.out.println("Result1: " + maxId);
        System.out.println("Result2: " + myId(input));

    }

}
