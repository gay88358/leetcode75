package leetcode33;

// 技術: binary search within different sorted portion
// 實作細節: left <= right，因為mid - 1 or mid + 1有可能會導致left與right重疊，即便相同也能進行後續查找。
//     - left sorted portion (因為旋轉的特性，當nums[mid]大於nums[right]加上left sorted portion的值一定比right sorted portion來的大，
//     所以一定坐落於left sorted portion)
//       - out of range
//       - on the left side
//       - on the right side
//     - right sorted portion (因為旋轉的特性，當nums[mid]小於nums[left]加上left sorted portion一定比right sorted portion大，
//     所以一定坐落於right sorted portion)
//       - out of range
//       - on the left side
//       - on the right side
public class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int currentValue = nums[mid];
            if (currentValue == target) {
                return mid;
            }
            boolean isLeftSortedPortion = nums[left] <= currentValue;
            if (isLeftSortedPortion) {
                if (target < nums[left]) { // out of range
                    left = mid + 1;
                } else if (target > currentValue) { // right hand side
                    left = mid + 1;
                } else { // left hand sie
                    right = mid - 1;
                }
            } else { // right sorted portion
                if (target > nums[right]) { // out of range
                    right = mid - 1;
                } else if (target < currentValue) { // left hand side
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}