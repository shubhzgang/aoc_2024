package com.shubhzgang.dayone;

import java.io.File;
import java.io.InputStream;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PuzzleOne {
    public static void main(String[] args) {
        int n = 1000;
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        // file reading
        InputStream input = PuzzleOne.class.getClassLoader().getResourceAsStream("puzzle_one_input.txt");
        Scanner scanner = new Scanner(input);
        while (scanner.hasNextInt()) {
            pq1.add(scanner.nextInt());
            pq2.add(scanner.nextInt());
        }

        long diff = 0;
        for (int i = 0; i < n; i++) {
            diff += Math.abs(pq1.poll() - pq2.poll());
        }
        System.out.println(diff);
    }
}
