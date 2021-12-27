package leetcode1;

import java.util.HashMap;
import java.util.Map;
// 技術: 使用HashMap來存取先前尋訪過的值與其位置。
// 注意細節: 透過互補的方式(target - currentValue)來決定剩餘的值是否已被經尋訪過 (有的話HashMap能獲取其位置)。
// 就能算出twoSum。

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int currentValue = nums[i];
            int compensationValue = target - currentValue;
            if (map.containsKey(compensationValue)) {
                return new int[] { i, map.get(compensationValue) };
            } else {
                map.put(currentValue, i);
            }
        }
        return new int[] {};
    }
}