package leetcode54;

import java.util.ArrayList;
import java.util.List;
// 技術: 使用four pointer來刪除traverse過後的matrix space，並且調整相對應位置。
// 注意細節: 當每次pointer更新時，要確保剩餘的matrix還能被traverse。

public class Solution {
    private int top;
    private int down;
    private int left;
    private int right;
    private int[][] matrix;

    public List<Integer> spiralOrder(int[][] matrix) {
        setupTraverseInformation(matrix);
        List<Integer> result = new ArrayList<>();
        spiralOrder(result);
        return result;
    }

    private void setupTraverseInformation(int[][] matrix) {
        this.matrix = matrix;
        this.top = 0;
        this.down = matrix.length;
        this.left = 0;
        this.right = matrix[0].length;
    }

    private List<Integer> spiralOrder(List<Integer> result) {
        recordTopRow(result);
        removeTraversedTopRowSpace();
        if (isAllMatrixTraversed()) {
            return result;
        }

        recordRightColumn(result);
        removeTraversedRightColumnSpace();
        if (isAllMatrixTraversed()) {
            return result;
        }

        recordDownRow(result);
        removeTraversedDownRowSpace();
        if (isAllMatrixTraversed()) {
            return result;
        }

        recordLeftColumn(result);
        removeTraversedLeftColumnSpace();
        if (isAllMatrixTraversed()) {
            return result;
        }

        return spiralOrder(result);
    }

    private boolean isAllMatrixTraversed() {
        return top == down || left == right;
    }

    private void recordTopRow(List<Integer> result) {
        for (int i = left; i < right; i++) {
            result.add(matrix[top][i]);
        }
    }

    private void recordRightColumn(List<Integer> result) {
        for (int i = top; i < down; i++) {
            result.add(matrix[i][right - 1]);
        }
    }

    private void recordDownRow(List<Integer> result) {
        for (int i = right - 1; i >= left; i--) {
            result.add(matrix[down - 1][i]);
        }
    }

    private void recordLeftColumn(List<Integer> result) {
        for (int i = down - 1; i >= top; i--) {
            result.add(matrix[i][left]);
        }
    }

    private void removeTraversedTopRowSpace() {
        top++;
    }

    private void removeTraversedRightColumnSpace() {
        right--;
    }

    private void removeTraversedDownRowSpace() {
        down--;
    }

    private void removeTraversedLeftColumnSpace() {
        left++;
    }
}
