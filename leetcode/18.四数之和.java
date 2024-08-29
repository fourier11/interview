/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                // 去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int l = j + 1;
                int r = nums.length - 1;
                
                while (l < r) {
                    if (r < nums.length - 1 && nums[r] == nums[r + 1]) {
                        // 去重
                        r--;
                    } else if (l > j + 1 && nums[l] == nums[l - 1]) {
                        // 去重
                        l++;
                    } else if ((long) nums[i] + nums[j] + nums[l] + nums[r] > target) {
                        r--;
                    } else if ((long) nums[i] + nums[j] + nums[l] + nums[r] < target) {
                        l++;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        r--;
                    }

                }
            }
        } 
        return res;
    }
}
// @lc code=end

