package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Misc {
    public static void run() {
        // write your code here
        //isAnagram("abc", "cba");
        //isAnagram("ABba", "BabA");
        reverseString("Rajesh");
    }



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

    private static void reverseString(String str) {
        char[] arr = str.toCharArray();

        reverseString(arr, 0, arr.length);
        for (int j = 0, i = 0; i <= arr.length; i++) {
            if (i == arr.length || arr[i] == ' ') {
                reverseString(arr, j, i);
                j = i + 1;
            }
        }

        System.out.println(String.valueOf(arr));
    }

    private static void reverseString(char[] arr, int start, int end) {
        for (int i = 0; i < (end - start) / 2; i++) {
            char c = arr[start + i];
            arr[start + i] =  arr[end - i - 1];
            arr[end - i - 1] = c;
        }
    }

    private static void rotateMatrix(int[][] mat) {
        int size = mat.length;

        for (int first = 0; first < size / 2; first++) {
            int last = size - 1 - first;

            for (int i = first; i < last; i++) {
                int offset = i - first;

                int temp = mat[first][i];
                mat[first][i] = mat[last - offset][first];
                mat[last - offset][first] = mat[last][last - offset];
                mat[last][last - offset] = mat[i][last];
                mat[i][last] = temp;
            }
        }
    }

    private static void noduplicate() {
        int[] nums = new int[] { 1, 1, 2, 2, 3, 3, 4, 4, 5, 8, 8 };

        // binary search
        int n = nums.length, lo = 0, hi = n / 2;
        while (lo < hi)
        {
            int m = (lo + hi) / 2;
            if (nums[2 * m] != nums[2 * m + 1]) hi = m;
            else lo = m + 1;
        }
        System.out.println(nums[2 * lo]);
    }

    private static void recommendations() {
        List<String> purchases = getPurchases();
        String searchItem = "ABC";

        Map<String, List<String>> buyers = new HashMap<>();
        Map<String, List<String>> items = new HashMap<>();

        for (String purchaseItem : purchases) {
            String[] data = purchaseItem.split(":");

//            if (!buyers.containsKey(data[0]))
//                buyers.put([data[0], Arrays.asList(data[1]);
//            else
//                buyers.getOrDefault(data[0], new ArrayList<>()).add(data[1]);

//            foreach (var bItem in buyers[data[0]])
//            {
//                if (bItem != data[1])
//                {
//                    if (!items.ContainsKey(bItem))
//                        items[bItem] = new List<string>() { data[1] };
//                    else
//                        items[bItem].Add(data[1]);
//
//                    if (!items.ContainsKey(data[1]))
//                        items[data[1]] = new List<string>() { bItem };
//                    else
//                        items[data[1]].Add(bItem);
//                }
//            }
        }
    }

    private static List<String> getPurchases() {
        return Arrays.asList(
                "first:ABC",
                "first:HIJ",
                "sec:HIJ",
                "sec:KLM",
                "third:NOP",
                "fourth:ABC",
                "fourth:QRS",
                "first:DEF",
                "fifth:KLM",
                "fifth:TUV"
        );

    }



    public static void main(String[] args) {
//        reverseString("Rajesh Sharma");
        //    noduplicate();
        Map<String, List<String>> buyers = new HashMap<>();
//        List<String> s = new ArrayList<>();
//        s.add("aqwerqw");
//        buyers.put("ABC", s);
        int[] nums = new int[] { 1, 1, 2, 2, 3, 3, 4, 4, 5, 8, 8 };
        String s = Arrays
                .stream(nums)
                .mapToObj(String::valueOf)
                .reduce((a, b) -> a.concat(",").concat(b))
                .get();
        System.out.println(Arrays.toString(nums));
        System.out.println(s);
    }
}
