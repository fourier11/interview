class Solution {
    private List<String> list = new ArrayList<>();
    private StringBuilder path = new StringBuilder();
    // 题目要求限制了字符串长度在[1, 9]之间。
    private boolean[] used = new boolean[10];

    public String[] permutation(String S) {
        char[] c = S.toCharArray();
        Arrays.sort(c);
        dfs(new String(c));
        return list.stream().toArray(String[]::new);
    }

    private void dfs(String S) {
        if (path.length() == S.length()) {
            list.add(new String(path.toString()));
            return;
        }
        for (int i = 0; i < S.length(); i++) {
            if (used[i]) {
                continue;
            }
            // 剪枝，排除重复元素带来的重复排列比如 q(1)q(2)e，q(2)q(1)e这种。
            if (i > 0 && S.charAt(i) == S.charAt(i - 1) && !used[i - 1]) {
                continue;
            }
            path.append(S.charAt(i));
            used[i] = true;
            dfs(S);
            used[i] = false;
            path.deleteCharAt(path.length() - 1);

        }
    }
}