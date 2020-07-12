/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int left = 0;
        int right = 0;
        int n = s.length();
        boolean[] used = new boolean[128];
        int max = 0;
        while (right < n) {
            // 在数组索引中，字符类型会自动转成ASCII
            if (used[s.charAt(right)] == false) {
                used[s.charAt(right)] = true;
                right++;
            } else {
                max = Math.max(max, right - left);
                while (left < right && s.charAt(left) != s.charAt(right)) {
                    used[s.charAt(left)] = false;
                    left++;
                }
                left++;
                right++;
            }
        }
        max = Math.max(max, right - left);
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        int len = 0;

        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        int firstPoint = 0;
        int nextPoint = 0;

        boolean[] exist = new boolean[255];

        while (nextPoint < s.length() && firstPoint < s.length()) {

            int currMax = 0;
            int index = s.charAt(nextPoint) - 0;
            while (exist[index] == false && nextPoint < s.length()) {
                exist[s.charAt(nextPoint) - 0] = true;
                nextPoint++;
                if (nextPoint < s.length()) {
                    index = s.charAt(nextPoint) - 0;
                }

            }

            currMax = Math.max(currMax, nextPoint - firstPoint);
            firstPoint++;
            nextPoint = firstPoint;
            len = Math.max(len, currMax);
            for (int i = 0; i < 255; i++) {
                exist[i] = false;
            }

        }

        return len;
    }

    public static int lengthOfLongestSubstring3(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int maxLength = 0;
        int now = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                now = Math.max(map.get(s.charAt(i)) + 1, now);
                if ((i - now + 1) > maxLength) {
                    maxLength = i - now + 1;
                }
            } else {
                if ((i - now + 1) > maxLength) {
                    maxLength = i - now + 1;
                }
            }
            map.put(s.charAt(i), i);
        }
        return maxLength;
    }

    /**
     * 滑动窗口模板
     */
    public static int lengthOfLongestSubstring4(String s) {
        int[] window = new int[128];
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window[c]++;
            // 判断左侧是否需要收缩，大于1表示已经有重复字符了
            while(window[c] > 1) {
                char d = s.charAt(left);
                left++;
                window[d]--;
            }
            res = Math.max(res, right - left);
        }
        return res;
    } 
}
