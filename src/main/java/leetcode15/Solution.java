package leetcode15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// 技術: two pointer 將O(n^2) => O(n)
// 實作細節: 記得在特定情境透過filter將重複的條件移出 (prevent duplicate triples)
// 當外層迴圈重複時、透過two pointer找到結果時，兩指針像內移動可能產生重複結果。
public class Solution {
    // -4, -1, -1, 0, 1, 2
    // a + b + c = 0;
    // b + c = 0 - a;
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // if duplicate triples contains
            // ex: -3, -3, 1, 2
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int currentValue = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left >= 0 && right < nums.length && left < right) {
                int currentSum = nums[left] + nums[right];
                if (currentSum + currentValue == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    // ex: -3 1 1 2 2
                    while (left < right && nums[left] == nums[left - 1] && nums[right] == nums[right + 1]) {
                        left++;
                        right--;
                    }
                } else if (currentSum + currentValue < 0) {
                    left++;
                } else {
                    right--;
                }
            }

        }
        return result;
    }
}
