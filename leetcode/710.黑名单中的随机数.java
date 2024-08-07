/*
 * @lc app=leetcode.cn id=710 lang=java
 *
 * [710] 黑名单中的随机数
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    private int sz;
    private HashMap<Integer, Integer> mapping;

    public Solution(int N, int[] blacklist) {
        mapping = new HashMap<>(); // Initialize the HashMap
        sz = N - blacklist.length;
        for (int b : blacklist) {
            mapping.put(b, -1);
        }

        int last = N - 1;
        for (int b : blacklist) {
            // 如果 b 已经在区间 [sz, N)
            // 可以直接忽略
            if (b >= sz) {
                continue;
            }
            while (mapping.containsKey(last)) {
                last--;
            }
            // 此时last对应的是白名单数字的索引
            mapping.put(b, last);
            last--;
        }
    }

    public int pick() {
        // 随机选取一个索引
        int index = (int) (Math.random() * sz);
        // 这个索引命中了黑名单，
        // 需要被映射到其他位置
        if (mapping.containsKey(index)) {
            return mapping.get(index);
        }
        // 若没命中黑名单，则直接返回
        return index;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */
// @lc code=end

