import java.util.ArrayList;
import java.util.Arrays;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
 * 输入描述：输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * 
 * 思路：
 * 深度优先遍历
 */
class Solution {
    public String[] permutation(String s) {
        ArrayList<String> res = new ArrayList<String>();
        char[] array = s.toCharArray();
        Arrays.sort(array);
        dfs(array, res, 0);
        String[] h = res.toArray(new String[res.size()]);
        return h;
    }

    private void dfs(char[] chars, ArrayList<String> res, int index) {
        if (index >= chars.length - 1) {
            res.add(new String(chars));
            return;
        }
        for (int i = index; i < chars.length; i++) {
            int flag = 0;
            if (i > index) {
                for (int j = index; j < i; j++) {
                    if (chars[i] == chars[j]) {
                        flag = 1;
                        break;
                    }
                }
            }
            // 出现重复字符
            if (flag == 1) {
                continue;
            }

            swap(chars, index, i);
            dfs(chars, res, index + 1);
            swap(chars, index, i);
        }

    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}