/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 * 
 * 题目意思：降序排列后第k个元素
 * 
 * 解法：
 * 采用快排算法在leetcode上，最后一个case会出现概率性超时
 * 小顶堆方案不会
 */

// @lc code=start
class Solution {

    /**
     *  小顶堆解法
     */
    public int findKthLargest2(int[] nums, int k) {
        // 堆顶事最小元素
        final PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int val : nums) {
            queue.add(val);
            // 堆中元素多于k个，删除堆顶元素
            if (queue.size() > k)
                queue.poll();
        }
        return queue.peek();
    }


    public int findKthLargest(int[] nums, int k) {
        // 转化为排名第k个元素
        k = nums.length - k;
        int l = 0;
        int h = nums.length - 1;
        while(l < h) {
            int j = partition(nums, l, h);
            if (j == k) {
                break;
            } else if (j < k) {
                l = j + 1;
            } else {
                h = j - 1;
            }
        }
        return nums[k];
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
// @lc code=end

