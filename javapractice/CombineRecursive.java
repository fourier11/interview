/**
 * 输出字符串的全部组合（注意：前提限制条件，字符串中的所有字符都不重复）
 */
public class CombineRecursive {
    /*
     * dfs
     */
    public static void combinate(char[] chars, int begin, int len, StringBuffer sb) {
        if (len == 0) {
            System.out.println(sb);
            return;
        }
        if (begin == chars.length)
            return;
        sb.append(chars[begin]); // 取当前字符
        combinate(chars, begin + 1, len - 1, sb);
        sb.deleteCharAt(sb.length() - 1); // 不取当前字符
        combinate(chars, begin + 1, len, sb);
    }

    public static void main(String[] args) {
        String str = "abc";
        char[] chars = str.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= str.length(); i++) {
            combinate(chars, 0, i, sb);
        }
    }
}