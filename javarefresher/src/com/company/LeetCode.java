package com.company;

public class LeetCode {
    public static void run() {
//        fizzBuzz(15);
//        palindromeNumber(121);
//        palindromeNumber(1221);
//        palindromeNumber(1231);\
//        factorialTrailingZeroes(15);
        //pow(2, 3);
        //reverseString("Hello");
        kthPositiveNumber();
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
}
