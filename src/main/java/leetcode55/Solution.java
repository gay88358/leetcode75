package leetcode55;
// 技術: 使用動態規劃降低維度、使用貪婪演算法降低維度(local optimal => global optimal)
// 注意細節:
//    1. 動態規劃: 從後面累積、dp[i] = or所有dp[rangeClose(i + 1, i + nums[steps])]
//    2. 貪婪演算法: 設定一個目標為終點、透過從終點不斷逼近起始點來決定是否能到達終點。
//                 設定一個goal變數來tracking不斷變動的目標。
//                 當遇到的position加上此position能跨越的最大步伐超越目標時，代表我們能逼近起始點。

public class Solution {
    public boolean canJump(int[] nums) {
        // canJumpDp(nums);
        return canJumpGreedy(nums);
    }

    private boolean canJumpGreedy(int[] nums) {
        int goal = nums.length - 1;
        for (int position = nums.length - 2; position >= 0; position--) {
            int maxStepsOfPosition = nums[position];
            boolean canReachOverGoal = position + maxStepsOfPosition >= goal;
            if (canReachOverGoal) {
                // move goal to position
                // because we can reach goal from position
                // we don't need to consider original goal
                // instead we consider new goal (position)
                goal = position;
            }
        }
        return goal == 0;
    }

    private boolean canJumpDp(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        for (int i = dp.length - 1; i >= 0; i--) {
            if (i == dp.length - 1) {
                dp[i] = true;
                continue;
            }

            int steps = nums[i];
            for (int j = i + 1; j <= i + steps && j < dp.length; j++) {
                if (dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}
