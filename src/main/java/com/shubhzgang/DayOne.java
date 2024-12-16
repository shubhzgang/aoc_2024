package com.shubhzgang;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DayOne {
    public static void main(String[] args) {
        int n = 1000;
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        int[] leftList = new int[n];
        Map<Integer, Integer> rightCount = new HashMap<>();
        int prevCount;

        // file reading
        InputStream input = DayOne.class.getClassLoader().getResourceAsStream("puzzle_one_input.txt");
        Scanner scanner = new Scanner(input);
        int left, right;
        int i = 0;
        while (scanner.hasNextInt()) {
            left = scanner.nextInt();
            right = scanner.nextInt();
            pq1.add(left);
            pq2.add(right);
            leftList[i] = left;
            rightCount.put(right, rightCount.getOrDefault(right, 0) + 1);
            i++;
        }

        long diff = 0;
        i = 0;
        for (; i < n; i++) {
            diff += Math.abs(pq1.poll() - pq2.poll());
        }
        // part one answer
        System.out.println("diff " + diff);

        // part two calc
        long similarity = 0;
        for (i = 0; i < n; i++) {
            similarity += leftList[i] * rightCount.getOrDefault(leftList[i], 0);
        }
        System.out.println("similarity " + similarity);
    }
}
