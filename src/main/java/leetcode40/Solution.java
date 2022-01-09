package leetcode40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// 技術: 使用index紀錄已經讀取過的value、透過sorted array來省略重複的combination
// 實作細節: 透過sorted precondition，我們能夠使用一個變數來驗證是否有重複。，透過index+1能夠忽略已經拜訪過的值。

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        var result = new ArrayList<List<Integer>>();
        dfs(new ArrayList<>(), candidates, target, result, 0);
        return result;
    }

    private void dfs(
            List<Integer> combination,
            int[] candidates,
            int target,
            List<List<Integer>> result,
            int currentIndex) {
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        if (target < 0 || currentIndex >= candidates.length) {
            return;
        }
        int prev = Integer.MIN_VALUE;
        for (int i = currentIndex; i < candidates.length; i++) {
            int currentValue = candidates[i];
            if (currentValue == prev) {
                continue;
            } else {
                prev = currentValue;
            }
            combination.add(currentValue);
            dfs(combination, candidates, target - currentValue, result, i + 1);
            combination.remove(combination.size() - 1);
        }
    }
}
