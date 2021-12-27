package leetcode5;


import java.util.function.BinaryOperator;
import java.util.stream.IntStream;
// 技術: sliding window + two pointer
// 注意細節: 計算回文需要考慮even與odd

public class Solution {
    public String longestPalindrome(String s) {
        return IntStream
                .range(0, s.length())
                .boxed()
                .map(index -> longestPalindromeByIndex(s, index))
                .reduce("", palindromeWithMaxLength())
                ;
    }

    private BinaryOperator<String> palindromeWithMaxLength() {
        return (a, b) -> (a.length() >= b.length()) ? a : b;
    }

    public String longestPalindromeByIndex(String s, int index) {
        var evenPalindrome = longestEvenPalindromeByIndex(s, index);
        var oddPalindrome = longestOddPalindromeByIndex(s, index);
        if (evenPalindrome.length() > oddPalindrome.length()) {
            return evenPalindrome;
        } else {
            return oddPalindrome;
        }
    }

    private String longestOddPalindromeByIndex(String s, int index) {
        return longestPalindromeByIndex(s, index, index);
    }

    private String longestEvenPalindromeByIndex(String s, int index) {
        boolean isLastIndex = index + 1 >= s.length();
        // when the given index is in the last position
        // we should not consider next index, so we return start from index directly.
        if (isLastIndex) {
            return s.substring(index);
        }
        return longestPalindromeByIndex(s, index, index + 1);
    }

    public String longestPalindromeByIndex(String s, int left, int right) {
        // check boundary & compare with dp thinking
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}