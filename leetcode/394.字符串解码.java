/*
 * @lc app=leetcode.cn id=394 lang=java
 *
 * [394] 字符串解码
 */

// @lc code=start
class Solution {
    int ptr;
    String src;
    public String decodeString(String s) {
        ptr = 0;
        src = s;
        return getString();
    }
    private String getString() {
        if (src.length() == ptr || src.charAt(ptr) == ']') {
            return "";
        }
        char cur = src.charAt(ptr);
        int repTime = 1;
        String ret = "";
        if (Character.isDigit(cur)) {
            repTime = getDigits();
            ptr++;
            String str = getString();
            ptr++;
            while(repTime-- > 0) {
                ret += str;
            }
        } else if (Character.isLetter(cur)) {
            // 这一段还是有些不理解
            ret = String.valueOf(src.charAt(ptr++));
        }
        return ret + getString();
    }

    private int getDigits() {
        int num  = 0;
        while (ptr < src.length() && Character.isDigit(src.charAt(ptr))) {
            num  = 10 * num + src.charAt(ptr++) - '0';
        }
        return num;
    }

}
// @lc code=end

