import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=969 lang=java
 *
 * [969] 煎饼排序
 */

// @lc code=start
class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> pancakeSort(int[] arr) {
        sort(arr, arr.length);
        return res;
    }

    private void sort(int[] arr, int n) {
        if (n == 1) {
            return;
        }
        int maxIndex = 0;
        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
                maxIndex = i;
            }
        }
        reverse(arr, 0, maxIndex);
        res.add(maxIndex + 1);
        reverse(arr, 0, n - 1);
        res.add(n);
        sort(arr, n - 1);
    }

    private void reverse(int[] arr, int i, int j) {
        while(i < j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }
}
// @lc code=end

