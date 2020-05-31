
/**
 * 翻转单词顺序列 
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a
 * student. "，则输出"student. a am I"。
 * 
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof
 */
public class Solution {
    public String ReverseSentence(String str) {
        int n = str.length();
        char[] chars = str.toCharArray();
        int i = 0, j = 0;
        while (j <= n) {
            if (j == n || chars[j] == ' ') {
                reverse(chars, i, j - 1);
                i = j + 1;
            }
            j++;
        }
        reverse(chars, 0, n - 1);
        return new String(chars);
    }

    private void reverse(char[] c, int i, int j) {
        while (i < j)
            swap(c, i++, j--);
    }

    private void swap(char[] c, int i, int j) {
        char t = c[i];
        c[i] = c[j];
        c[j] = t;
    }

    // 另一种方法
    public String reverseWords(String s) {
        s = s.trim();
        int j = s.length() - 1;
        int i = j;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            res.append(s.substring(i + 1, j + 1) + " ");
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }
        return res.toString().trim();
    }
}