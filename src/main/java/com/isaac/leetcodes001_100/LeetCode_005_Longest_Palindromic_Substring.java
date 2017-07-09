package com.isaac.leetcodes001_100;

/**
 * Created by zhanghao on 9/7/17.
 * @author ZHANG HAO
 */
public class LeetCode_005_Longest_Palindromic_Substring {
    public static void main (String[] args) {
        String str = "babad"; // maximal length 1000
        System.out.println(longestPalindrome(str));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.isEmpty())
            return null;
        if (s.length() == 1)
            return s;
        String global = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            // for aba form
            String local = curLongest(s, i, i);
            global = global.length() > local.length() ? global : local;
            // for abba form
            local = curLongest(s, i, i + 1);
            global = global.length() > local.length() ? global : local;
        }
        return global;
    }

    public static String curLongest (String str, int start, int end) {
        while (start >= 0 && end <= str.length() - 1 && str.charAt(start) == str.charAt(end)) {
            start--;
            end++;
        }
        return str.substring(start + 1, end);
    }
}
