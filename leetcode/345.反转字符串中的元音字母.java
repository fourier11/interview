import java.lang.annotation.ElementType;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=345 lang=java
 *
 * [345] 反转字符串中的元音字母
 */

// @lc code=start
class Solution {
    public String reverseVowels(String s) {
        HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        
        if (s == null) {
            return null;
        }
        int i = 0;
        int j = s.length() - 1;
        char[] origin = s.toCharArray();
        char[] result = new char[s.length()];
        while (i <= j) {
            char iChar = origin[i];
            char jChar = origin[j];
            if (!vowels.contains(iChar)) {
                result[i++] = iChar;
            } else if (!vowels.contains(jChar)) {
                result[j--] = jChar;
            } else {
                result[i++] = jChar;
                result[j--] = iChar;
            }
        }
        return new String(result);
    }
}
// @lc code=end

