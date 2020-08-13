import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 回溯算法详解
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484709&idx=1&sn=1c24a5c41a5a255000532e83f38f2ce4&chksm=9bd7fb2daca0723be888b30345e2c5e64649fc31a00b05c27a0843f349e2dd9363338d0dac61&scene=21#wechat_redirect
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    // public List<List<Integer>> permute(int[] nums) {
    //     LinkedList<Integer> track = new LinkedList<>();
    //     backtrack(nums, track);
    //     return res;
    // }

    private void backtrack(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 因为对链表使用contains方法需要 O(N) 的时间复杂度,后面的解法二降低了时间复杂度
            if (track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            backtrack(nums, track);
            track.removeLast();
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        backtrack(nums, 0, list);
        return res;
    }

    // 优化解法，通过交换元素，降低了时间复杂度
    void backtrack(int[] nums, int start, LinkedList<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new LinkedList<>(list));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            list.add(nums[start]);
            backtrack(nums, start + 1, list);
            swap(nums, start, i);
            list.removeLast();
        }
    }

    void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
// @lc code=end

