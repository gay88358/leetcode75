package leetcode20;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void multiple_invalid_parentheses_pair() {
        var s = new Solution();

        assertFalse(s.isValid("()("));
    }

    @Test
    void invalid_parentheses_pair() {
        var s = new Solution();

        assertFalse(s.isValid("(]"));
        assertFalse(s.isValid("]["));
        assertFalse(s.isValid(")("));
        assertFalse(s.isValid("}{"));
    }

    @Test
    void valid_parentheses_pair() {
        var s = new Solution();

        assertTrue(s.isValid("[]"));
        assertTrue(s.isValid("{}"));
        assertTrue(s.isValid("()"));
    }

    @Test
    void multiple_valid_parentheses_pair() {
        var s = new Solution();

        assertTrue(s.isValid("()[]{}"));
    }



    @Test
    void f() {
        int interval = 1;
        int length = 8;
        while (interval < length) {
            for (int i = 0; i < length; i += (2 * interval)) {
                System.out.println(i + ", " + (i + interval));
            }
            interval *= 2;
        }

    }
}
// implement merge 2 list & merge k list