package com.company;

public class LeetCode {
    public static void run() {
//        fizzBuzz(15);
//        palindromeNumber(121);
//        palindromeNumber(1221);
//        palindromeNumber(1231);
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
}
