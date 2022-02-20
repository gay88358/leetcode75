package leetcode67;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void add_with_zero() {
        var s = new Solution();

        assertEquals("0", s.addBinary("0", "0"));
        assertEquals("1", s.addBinary("0", "1"));
        assertEquals("1", s.addBinary("1", "0"));
        assertEquals("10", s.addBinary("10", "0"));
        assertEquals("10", s.addBinary("0", "10"));
        assertEquals("100", s.addBinary("100", "0"));
        assertEquals("100", s.addBinary("0", "100"));
    }

    @Test
    void add_two_non_zero_binary_string() {
        var s = new Solution();

        assertEquals("10", s.addBinary("1", "1"));
        assertEquals("11", s.addBinary("10", "1")); // scalar to iteration
        assertEquals("100", s.addBinary("11", "1")); // use carry at higher digit
        assertEquals("10101", s.addBinary("1010", "1011"));
    }
}