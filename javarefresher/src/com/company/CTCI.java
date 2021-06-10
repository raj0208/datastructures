package com.company;

public class CTCI {
    public static void run() {
        isPalindrome("abba siss baba");
        urlify();

    }

    private static void isPalindrome(String phrase) {
        int counter = 0;

        boolean[] flag = new boolean[26];

        for(char c : phrase.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                int index = c - 'a';

                if (flag[index] = !flag[index]) {
                    counter++;
                } else {
                    counter--;
                }
            }
        }

        System.out.println("'"  + phrase + "' is palindrome =>" + (counter <= 1 ? "Yes" : "No"));
    }

    private static void urlify() {
        String str = "this is testing";
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ')
                count++;
        }

        char[] nstr = new char[str.length() + (count * 2)];
        count = nstr.length - 1;

        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ') {
                nstr[count] = '0';
                nstr[count - 1] = '2';
                nstr[count - 2] = '%';
                count -= 3;
            } else {
                nstr[count--] = str.charAt(i);
            }
        }

        System.out.println(new String(nstr));
    }

}
