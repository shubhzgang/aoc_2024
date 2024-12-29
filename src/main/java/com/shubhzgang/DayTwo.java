package com.shubhzgang;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayTwo {
    public static void main(String[] args) {
        InputStream is = DayTwo.class.getClassLoader().getResourceAsStream("input_2.txt");
        if (is == null) {
            System.out.println("Input file not found");
            return;
        }
        Scanner scanner = new Scanner(is);
        List<List<Integer>> levels = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            List<Integer> level = new ArrayList<>();
            String[] levelStr = line.split(" ");
            for (String s : levelStr) {
                level.add(Integer.parseInt(s));
            }
            levels.add(level);
        }
        //System.out.println(levels);
        puzzleOne(levels);
        puzzleTwo(levels);
    }

    private static boolean isValidLevel(List<Integer> level) {
        boolean isInc = false;
        boolean isDec = false;
        int n = level.size();
        for (int i = 0; i < n - 1; i++) {
            int diff = level.get(i) - level.get(i + 1);
            if (diff > 0) {
                isInc = true;
                if (diff > 3) {
                    return false;
                }
            }
            if (diff < 0) {
                isDec = true;
                if (diff < -3) {
                    return false;
                }
            }
            if (diff == 0) {
                return false;
            }
        }
        if (isInc && isDec) {
            return false;
        }
        return isInc || isDec;
    }

    private static void puzzleTwo(List<List<Integer>> levels) {
        int ans = 0;

    }

    private static void puzzleOne(List<List<Integer>> levels) {
        int ans = 0;
        for (List<Integer> level : levels) {
            boolean isValid = isValidLevel(level);
            if (isValid) {
                ans++;
            }
            System.out.println(level + " : " + isValid);
        }
        System.out.println(ans);
    }
}
