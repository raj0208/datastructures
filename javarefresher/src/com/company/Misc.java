package com.company;

public class Misc {
    public static void run() {
        // write your code here
//        isAnagram("abc", "cba");
//        isAnagram("ABba", "BabA");
        trailingZeros(5);
    }

    /**
     * Trailing Zeroes in th factorial
     * @param number factorial of a number
     */
    private static void trailingZeros(int number) {

    }

    /**
     * IsAnagram
     * @param s1 string one
     * @param s2 string two
     */
    private static void isAnagram(String s1, String s2) {
        // none of parameters should be null
        // length of both string should be same
        if (s1 == null || s2 == null || s1.length() == 0 || s1.length() != s2.length()) {
            System.out.println("'" + s1 + "' & '" + s2 + "' => false");
            return;
        }

        int result = 0;
        for (int i = 0; i < s1.length(); i++) {
            result ^= s1.charAt(i);
            result ^= s2.charAt(i);
        }

        System.out.println("'" + s1 + "' & '" + s2 + "' => " + ((result == 0) ? "true" : "false"));
    }
}
