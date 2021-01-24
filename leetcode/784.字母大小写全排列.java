import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=784 lang=java
 *
 * [784] 字母大小写全排列
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 * 
 * 提示：
 * S 的长度不超过12。
 * S 仅由数字和字母组成。
 */

// @lc code=start
class Solution {
    private List<String> res = new ArrayList<>();

    public List<String> letterCasePermutation(String S) {
        if (S == null) {
            return res;
        }
        dfs(S.toCharArray(), 0);
        return res;
    }

    private void dfs(char[] charArray, int start) {
        if (start == charArray.length) {
            res.add(new String(charArray));
            return;
        }
        // 不选择
        dfs(charArray, start + 1);
        if (Character.isLetter(charArray[start])) {
            charArray[start] ^= 1 << 5;
            dfs(charArray, start + 1);
            // 由于没有循环，只是start从前往后递增，下面这行可以省略
            charArray[start] ^= 1 << 5;
        }
    }
}
// @lc code=end

