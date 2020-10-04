
/**
 * 无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
 * 
 * 提示:
 * 字符都是英文字母。 字符串长度在[1, 9]之间。
 * 
 * 全排列问题
 * 经典DFS模板
 */
class Solution {
    private List<String> list = new ArrayList<>();
    private StringBuilder path = new StringBuilder();
    // 题目要求限制了字符串长度在[1, 9]之间。
    private boolean[] used = new boolean[10];

    public String[] permutation(String S) {
        dfs(S);
        //这一段利用java8的特性，把list转化为数组
        return list.stream().toArray(String[]::new);
    }

    private void dfs(String S) {
        if (path.length() == S.length()) {
            list.add(new String(path.toString()));
            return;
        }
        for (int i = 0; i < S.length(); i++) {
            // 这里比较巧妙用字符串的索引来作为数组的key，实际上这里也可以使用map，key是对应索引的字符串字符，value是boolean
            if (!used[i]) {
                path.append(S.charAt(i));
                used[i] = true;
                dfs(S);
                used[i] = false;
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}