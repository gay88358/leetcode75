package leetcode49;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void groupAnagrams() {
        String[] strs = new String[] {"zte","tea","tan","ate","nat","bat"};
        var s = new Solution();

        var result = s.groupAnagrams(strs);

        assertEquals(4, result.size());
        assertEquals(Arrays.asList("tea", "ate"), result.get(0));
        assertEquals(Collections.singletonList("bat"), result.get(1));
        assertEquals(Arrays.asList("tan", "nat"), result.get(2));
        assertEquals(Collections.singletonList("zte"), result.get(3));
    }

    @Test
    void two_anagrams_with_same_letter_is_equals_to_each_other() {
        Solution.Anagrams a1 = new Solution.Anagrams("bat");
        Solution.Anagrams a2 = new Solution.Anagrams("tba");

        assertEquals(a1.id(), a2.id());
    }

    @Test
    void two_anagrams_with_diff_letter_is_not_equals_to_each_other() {
        Solution.Anagrams a1 = new Solution.Anagrams("bat");
        Solution.Anagrams a2 = new Solution.Anagrams("ccc");

        assertNotEquals(a1.id(), a2.id());
    }
}