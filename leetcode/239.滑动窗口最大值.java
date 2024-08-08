import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 * 
 * https://github.com/labuladong/fucking-algorithm/blob/master/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E7%B3%BB%E5%88%97/%E5%8D%95%E8%B0%83%E9%98%9F%E5%88%97.md
 * 
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 * 单调队列 
 * 双端队列
 */

// @lc code=start
class Solution {

    /**
     * 暴力解法 
     * 时间复杂度O(n^2),Time Limit Exceeded
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (k == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        for (int i = k - 1; i < nums.length; i++) {
            int maxNum = nums[i];
            for (int j = 1; j < k; j++) {
                if (nums[i - j] > maxNum) {
                    maxNum = nums[i - j];
                }
            }
            res[i - k + 1] = maxNum;
        }
        return res;
    }


    /**
     * 单调队列解法 时间复杂度O(n)
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <nums.length; i++) {
            if (i < k - 1) {
                // 先填满窗口
                window.push(nums[i]);
            } else {
                // 窗口向前滑动，加入新数字
                window.push(nums[i]);
                // 记录当前窗口的最大值
                res.add(window.max());
                // 移出旧数字
                window.pop(nums[i-k+1]);
            }
        }
        int[] arr = new int[res.size()];
        for (int i = 0; i< res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    /**
     * 单调队列实现
     */
    class MonotonicQueue {
        LinkedList<Integer> maxq = new LinkedList<>();
        
        public void push(int n) {
            while (!maxq.isEmpty() && maxq.peekLast() < n) {
                maxq.pollLast();
            }
            maxq.addLast(n);
        }

        public int max() {
            return maxq.getFirst();
        }

        /**
         * 之所以要判断 n == maxq.getFirst()，是因为我们想删除的队头元素 n 可能已经被「压扁」了，可能已经不存在了，所以这时候就不用删除了 
        */        
        public void pop(int n) {
            if (n == maxq.getFirst()) {
                maxq.pollFirst();
            }
        }
    }


}
// @lc code=end

