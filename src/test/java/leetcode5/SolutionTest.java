package leetcode5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void longestPalindrome() {
        var s = new Solution();
        assertEquals("bb", s.longestPalindrome("abb"));
        assertEquals("bab", s.longestPalindrome("babad"));
        assertEquals("bb", s.longestPalindrome("cbbd"));
    }

    @Test
    void longestPalindromeByIndexWithOddLengthString() {
        var s = new Solution();
        assertEquals("b", s.longestPalindromeByIndex("bab", 0));
        assertEquals("bab", s.longestPalindromeByIndex("bab", 1));
        assertEquals("b", s.longestPalindromeByIndex("bab", 2));
    }

    @Test
    void longestPalindromeByIndexWithEvenLengthString() {
        var s = new Solution();
        assertEquals("b", s.longestPalindromeByIndex("bb", 1));
        assertEquals("bb", s.longestPalindromeByIndex("bb", 0));
    }
}