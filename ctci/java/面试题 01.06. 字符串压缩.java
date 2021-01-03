class Solution {
    public String compressString(String S) {
        if (S == null || S.length() == 0) {
            return S;
        }
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        char ch = S.charAt(0);
        for (int i = 1; i < S.length(); i++) {
            if (ch == S.charAt(i)) {
                cnt++;
            } else {
                sb.append(ch);
                sb.append(cnt);
                ch = S.charAt(i);
                cnt = 1;
            }
        }
        sb.append(ch);
        sb.append(cnt);
        return sb.length() >= S.length() ? S : sb.toString();
    }
}