
/**
 * 单词反转
 * 翻转单词顺序列 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a
 * student. "，则输出"student. a am I"。
 * 
 * 说明： 
 * 无空格字符构成一个单词。 
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof
 * 
 * 更简洁的解法：
 * leetcode  151.反转字符串中的单词
 */
public class Solution {
    // 这种解法无法解决leetcode上的一些特殊要求，"如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个"。
    public String ReverseSentence(String str) {
        str = str.trim();
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
        while (i < j) {
            swap(c, i++, j--);
        }
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
            // 注意substring是左闭区间，右开区间，一定要j+1
            res.append(s.substring(i + 1, j + 1) + " ");
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }
        return res.toString().trim();
    }
}