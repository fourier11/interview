import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 
 * 时间复杂度O(4^n)
 * 
 * 回溯题型
 */

// @lc code=start
class Solution {
    private StringBuilder path = new StringBuilder();
    private List<String> res = new ArrayList<>();
    private HashMap<Character, String> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        backtrack(digits, 0);
        return res;
    }

    private void backtrack(String digits, int index) {
        if (path.length() == digits.length()) {
            res.add(path.toString());
            return;
        }
        char c = digits.charAt(index);
        String temp = map.get(c);
        for (char ch : temp.toCharArray()) {
            path.append(ch);
            backtrack(digits, index + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
// @lc code=end

