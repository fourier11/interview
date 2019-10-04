/**
 * 输出字符串的全部组合（注意：前提限制条件，字符串中的所有字符都不重复）
 * TODO:这两种方案都没有完全理解
 */
public class CombineRecursive {
    /*
     * 递归法
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

    /**
     * 根据每个字符只有取和不取两种情况，0表示不取，1表示取该字符，则原题可以解释为要求输001到111这个组合对应的字符串
     * @param c
     */
    public static void combinate2(char[] c) {
        if (c == null)
            return;
        int len = c.length;
        boolean used[] = new boolean[len]; // 默认值false；
        char cache[] = new char[len];
        int result = len;
        while (true) {
            int index = 0;
            while (used[index]) {
                used[index] = false;
                ++result;
                if (++index == len)
                    return;
            }
            used[index] = true;
            cache[--result] = c[index];
            System.out.print(new String(cache).substring(result) + " ");
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        char[] chars = str.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= str.length(); i++) {
            combinate(chars, 0, i, sb);
        }
        combinate2(chars);
    }
}