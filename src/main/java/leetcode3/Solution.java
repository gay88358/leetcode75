package leetcode3;

import java.util.HashSet;
import java.util.Set;

// 技術: sliding window將時間複雜度下降到O(n)，但需要Set來刪除重複空間複雜到O(n)
// 注意細節: 確保sliding window範圍正確
public class Solution {
    // abcabcbb
    // sliding window => reduce O(n^2) => O(n)
    public int lengthOfLongestSubstring(String s) {
        Set<Character> characterSet = new HashSet<>();
        int left = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            while (characterSet.contains(currentChar)) {
                characterSet.remove(s.charAt(left));
                left++;
            }
            characterSet.add(s.charAt(i));
            result = Math.max(result, i - left + 1);
        }
        return result;
    }
}
