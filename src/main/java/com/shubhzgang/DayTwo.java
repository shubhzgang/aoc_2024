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
    }

    private static void puzzleOne(List<List<Integer>> levels) {
        int n = levels.size();
        int ans = 0;
        boolean increasing;
        int first, second, diff;
        for (List<Integer> level : levels) {
            // precheck
            first = level.get(0);
            second = level.get(1);
            diff = Math.abs(first - second);
            increasing = first < second;
            int i = 2;
            while (i < level.size() && diff > 0 && diff < 4) {
                if (increasing) {
                    diff = level.get(i) - level.get(i - 1);
                } else {
                    diff = level.get(i - 1) - level.get(i);
                }
                i++;
            }
            if (i == level.size() && diff > 0 && diff < 4) {
                System.out.println(level + " " + increasing + " true");
                ans++;
            } else {
                System.out.println(level + " " + increasing + " false");
            }
        }
        System.out.println(ans);
    }
}
