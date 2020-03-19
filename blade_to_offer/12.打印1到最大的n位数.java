class Solution {
    public int[] printNumbers(int n) {
        int sz = Math.pow(10, n) - 1;
        int[] ans = new int[sz];
        for (int i = 0; i < sz; i++) {
            ans[i] = i + 1;
        }
        return ans;
    }
}