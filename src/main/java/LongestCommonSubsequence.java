/*
    Given two sequences, find the longest subsequence present in both of them. A subsequence is a sequence that appears
    in the same relative order, but not necessarily contiguous.
    For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.

    e.g
    LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH”
    LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB”
 */

package main.java;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        System.out.println(findLongestCommonSubsequence("AGGTAB", "GXTXAYB"));
    }

    public static String findLongestCommonSubsequence(String str1, String str2) {
        String[][] memo = new String[str1.length()][str2.length()];
        for (int i=0; i<str1.length(); i++) {
            for (int j=0; j<str2.length(); j++) {
                memo[i][j] = "";
            }
        }
        return findLongestCommonSubsequence(str1, str2, 0, 0, memo);
    }

    private static String findLongestCommonSubsequence(String str1, String str2, int index1, int index2, String[][] memo) {
        if (index1 >= str1.length() || index2 >= str2.length()) {
            return "";
        }

        if (!memo[index1][index2].isEmpty()) {
            return memo[index1][index2];
        }

        if (str1.charAt(index1) == str2.charAt(index2)) {
            memo[index1][index2] = str1.charAt(index1) + findLongestCommonSubsequence(str1, str2, index1+1, index2+1, memo);
            return memo[index1][index2];
        }

        String result;
        String resultA = findLongestCommonSubsequence(str1, str2, index1+1, index2, memo);
        String resultB = findLongestCommonSubsequence(str1, str2, index1, index2+1, memo);
        if (resultA.length() > resultB.length()) {
            result = resultA;
        }
        else {
            result = resultB;
        }

        memo[index1][index2] = result;
        return memo[index1][index2];
    }

}
