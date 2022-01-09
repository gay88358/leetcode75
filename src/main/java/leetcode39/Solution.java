package leetcode39;

import java.util.ArrayList;
import java.util.List;
// 技術: 使用decision tree，但要確保兩種選擇:
//      1. 選擇維持目前的index
//      2. 跳過目前的index
// 實作細節: 透過index來進行backtracking、透過index來跳過忽略的值
// Time: O(n^t)
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
        if (currentIndex >= candidates.length || target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        combination.add(candidates[currentIndex]);
        dfs(combination, candidates, target - candidates[currentIndex], result, currentIndex);
        combination.remove(combination.size() - 1);
        dfs(combination, candidates, target, result, currentIndex + 1);
    }
}
