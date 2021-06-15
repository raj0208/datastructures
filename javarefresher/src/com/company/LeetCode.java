package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class LeetCode {
    public static void main(String[] args) {
//        fizzBuzz(15);
//        palindromeNumber(121);
//        palindromeNumber(1221);
//        palindromeNumber(1231);\
//        factorialTrailingZeroes(15);
        //pow(2, 3);
        //reverseString("Hello");
//        kthPositiveNumber();
//        maxAreaHistogram();
//        maxArea();
//        pascalTriangle();
//        kthrowinpascaltriangle();
        mergeIntervals();
    }

    /**
     * FizzBuzz
     * @param number
     */
    private static void fizzBuzz(int number) {
        for (int i = 1; i <= number; i++) {
            if (i % 5 == 0 && i % 3 == 0)
                System.out.println("FizzBuzz");
            else if (i % 5 == 0)
                System.out.println("Buzz");
            else if (i % 3 == 0)
                System.out.println("Fizz");
            else
                System.out.println(i);
        }

    }

    // Time : O(N), Space : O(1)
    private static void palindromeNumber(int num) {
        int original = num;

        if (num < 0 || (num % 10 == 0 && num != 0)) {
            System.out.println("num" + original + " is not palindrome");
            return;
        }

        int reversedNum = 0;
        while (num > reversedNum) {
            int lastdigit = num % 10;
            reversedNum = reversedNum * 10 + lastdigit;
            num = num / 10;
        }

        if (num == reversedNum || num == reversedNum / 10)
            System.out.println(original + " is palindrome");
        else
            System.out.println(original + " is not palindrome");
    }

    // T : O(log5 (n)) S : O(1)
    private static void factorialTrailingZeroes(int fnum) {
        int zerocount = 0;

        while (fnum > 0) {
            fnum /= 5;
            zerocount += fnum;
        }

        System.out.println("Trailing zeroes are " + zerocount);
    }

    private static void pow(int num, int power) {
        int ans = 1;

        while (power > 0) {
            if (power % 2 == 0) {
                num = num * num;
                power = power / 2;
            } else {
                ans = ans * num;
                power = power - 1;
            }
        }

        System.out.println(ans);
    }

    /* STRING */
    private static void reverseString(String str) {
        if (str == null || str.isEmpty()) {
            System.out.println("String is empty");
            return;
        }
        char[] cstr = str.toCharArray();

        int left = 0;
        int right = str.length() - 1;

        while(left < right) {
            char c = cstr[right];
            cstr[right] = cstr[left];
            cstr[left] = c;

            left++;
            right--;
        }

        System.out.println(new String(cstr));
    }

    private static void kthPositiveNumber() {
        int[] arr = new int[] {2,3,4,7,11};
        int k = 5;

        int lastIndex = 0;
        int last = arr.length + k + 1;
        int i = 0;
        boolean exist = false;

        for(i = 1; i < last; i++) {
            for (int j = lastIndex; j < arr.length; j++) {
                if (exist = (arr[j] == i)) {
                    lastIndex = j;
                    break;
                }
            }

            if (!exist && --k == 0)
                break;
        }

        System.out.println(i);
    }

    private static void maxAreaHistogram() {
        // input parameter
        int[] hist = new int [] {2,1,5,6,2,3};

        if (hist == null || hist.length == 0) {
            System.out.println("Nothing to calculate");
        }

        int max = 0;
        int index = 0;
        Stack<Integer> stack = new Stack<Integer>();

        while (index < hist.length) {
            // Push the index if the current index height > previous one
            if (stack.isEmpty() || hist[index] > hist[stack.peek()]) {
                stack.push(index);
                index++;
            } else { // calc max height
                int height = hist[stack.pop()];
                int width = stack.isEmpty() ? index : index - stack.peek() - 1;
                max = Math.max(max, height * width);
            }
        }

        while (!stack.isEmpty()) {
            int height = hist[stack.pop()];
            int width = stack.isEmpty() ? index : index - stack.peek() - 1;
            max = Math.max(max, height * width);
        }

        System.out.println("max height is " + max);
    }

    private static void maxArea() {
        int[] height = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};

        if (height == null || height.length == 0) {
            System.out.println("no size");
            return;
        }

        int left = 0;
        int right = height.length - 1;
        int area = 0;
        while (left < right) {
            area = Math.max(area, Math.min(height[left], height[right]) * (right - left));

            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        System.out.println("Max Area is " + area);
    }

    private static void pascalTriangle() {
        int numRow = 5;

        if (numRow <= 0) {
            System.out.println("Empty");
            return;
        }

        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();

        ArrayList<Integer> previous = new ArrayList<>();


        previous.add(1);
        triangle.add(previous);

        for(int i = 2; i <= numRow; i++) {
            ArrayList<Integer> current = new ArrayList<>();

            current.add(1); // first
            for(int j = 0; j < previous.size() - 1; j++) {
                current.add(previous.get(j) + previous.get(j + 1));
            }
            current.add(1); // last

            triangle.add(current);
            previous = current;
        }

        for(ArrayList<Integer> list : triangle) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.print("\n");
        }
    }

    private static void kthrowinpascaltriangle() {
        int kthrow = 5;

        if (kthrow <= 0)
            return;

        ArrayList<Integer> row = new ArrayList<>();
        row.add(1);

        for(int i = 1; i <= kthrow; i++) {
            for(int j = row.size() - 2; j >= 0; j--) {
                row.set(j + 1, row.get(j) + row.get(j + 1));
            }
            row.add(1);
        }

        for (int i: row) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void mergeIntervals() {
        List<Integer[]> intervals = getIntervals();
        List<Integer[]> result = new ArrayList<>();

        if (intervals == null || intervals.size() == 0) {
            System.out.println("Nothing to merge");
            return;
        }

        // sort the intervals by start.  if start is same, then by end
        Collections.sort(intervals, (x, y) -> (x[0] != y[0]) ? x[0] - y[0] : x[1] -y[1]);

        Integer[] previous = intervals.get(0);
        Integer[] current;
        for (int i = 0; i < intervals.size(); i++) {
            current = intervals.get(i);

            if (current[0] > previous[1]) {
                result.add(previous);
                previous = current;
            } else {
                previous = new Integer[] {previous[0], Math.max(previous[1], current[1]) };
            }
        }
        result.add(previous);

        for (Integer[] interval : result) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }

    private static ArrayList<Integer[]> getIntervals() {
        ArrayList<Integer[]> intervals = new ArrayList<>();
        intervals.add(new Integer[] { 1, 3 });
        intervals.add(new Integer[] { 2, 6 });
        intervals.add(new Integer[] { 8, 10 });
        intervals.add(new Integer[] { 15, 18 });

        return intervals;
    }
}
