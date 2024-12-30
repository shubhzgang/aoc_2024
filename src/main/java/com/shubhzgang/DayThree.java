package com.shubhzgang;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayThree {

    public static void main(String[] args) {
        InputStream is = DayThree.class.getClassLoader().getResourceAsStream("input3.txt");
        if (is == null) {
            System.out.println("File not found");
            return;
        }
        Scanner scanner = new Scanner(is);
        List<String> lines = new ArrayList<>();
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }
        scanner.close();
        puzzleOne(lines);
    }

    private static void puzzleOne(List<String> lines) {
        long ans = 0L;
        for (String line : lines) {
            int pos = line.indexOf("mul(");
            System.out.println("mulFound: " + pos);
            while (pos < line.length() && pos >= 0) {
                ans += getProduct(line, pos + 4);
                pos++;
                pos = line.indexOf("mul(", pos);
                System.out.println("mulFound: " + pos);
            }
        }
        System.out.println("puzzle one ans:" + ans);
    }

    private static long getProduct(String line, int pos) {
        if (pos == line.length()) {
            return 0;
        }
        int a, b;
        a = b = 0;
        int i = 0;
        char c = line.charAt(pos);
        while (c >= '0' && c <= '9' && i < 3) {
            a = (a * 10) + (c - '0');
            i++;
            c = line.charAt(pos + i);
        }
        System.out.println("a: " + a + " b: " + b);
        if (c != ',') {
            return 0;
        }
        pos = pos + i + 1;
        i = 0;
        c = line.charAt(pos);
        while (c >= '0' && c <= '9' && i < 3) {
            b = (b * 10) + (c - '0');
            i++;
            c = line.charAt(pos + i);
        }
        System.out.println("a: " + a + " b: " + b);
        if (c != ')') {
            return 0;
        }
        return (long) a * b;
    }
}
