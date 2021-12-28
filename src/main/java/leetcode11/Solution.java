package leetcode11;
// 技術: two pointer O(n^2) -> O(n)
// 實作細節: two pointer可以從端點開始、也可能從中間出發，根據應用情境不同做選擇
// 暴力解法需要O(n^2)，透過two pointer能夠在每次尋找盡可能的最大值並且移動一個指標，因此將時間複雜度降到O(n)
public class Solution {
    public int maxArea(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int area = area(height, left, right);
            result = Math.max(result, area);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }

    private int area(int[] nums, int left, int right) {
        int width = right - left;
        int height =  Math.min(nums[left], nums[right]);
        return width * height;
    }
}