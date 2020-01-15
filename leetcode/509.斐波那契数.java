import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=509 lang=java
 *
 * [509] 斐波那契数
 */

// @lc code=start
class Solution {
    private HashMap<Integer, Integer> cache = new HashMap<>();
    public int fib(int N) {
        if (N < 2) {
            return N;
        }
        int result;
        if (cache.containsKey(N)) {
            return cache.get(N);
        } else {
            result = fib(N - 1) + fib(N - 2);
        }
        cache.put(N, result);
        return result;
    }
}
// @lc code=end

