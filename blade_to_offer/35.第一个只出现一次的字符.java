/**
 * 
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * 
 * 示例： s = "abaccdeff" 返回 "b"
 * 
 * s = "" 返回 " "
 */
class Solution {
    public char firstUniqChar(String s) {
        int[] count = new int[256];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            count[c]++;
        }
        for (char c : chars) {
            if (count[c] == 1) {
                return c;
            }
        }
        return ' ';
    }
}