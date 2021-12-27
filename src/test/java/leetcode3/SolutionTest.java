package leetcode3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void lengthOfLongestSubstring() {
        var s = new Solution();
        assertEquals(1, s.lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, s.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(3, s.lengthOfLongestSubstring("pwwkew"));
    }
}