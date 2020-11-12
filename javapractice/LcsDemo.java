class LcsDemo {
    /**
     * Function to find LCS of String X[0..m-1] and Y[0..n-1]
     * 只返回一种情况，最长子序列
     */ 
    public static String LCS(String X, String Y, int m, int n, int[][] T) {
        // return empty string if we have reached the end of
        // either sequence
        if (m == 0 || n == 0) {
            return new String();
        }

        // if last character of X and Y matches
        if (X.charAt(m - 1) == Y.charAt(n - 1)) {
            // append current character (X[m-1] or Y[n-1]) to LCS of
            // substring X[0..m-2] and Y[0..n-2]
            return LCS(X, Y, m - 1, n - 1, T) + X.charAt(m - 1);
        }

        // else when the last character of X and Y are different

        // if top cell of current cell has more value than the left
        // cell, then drop current character of String X and find LCS
        // of substring X[0..m-2], Y[0..n-1]

        if (T[m - 1][n] > T[m][n - 1]) {
            return LCS(X, Y, m - 1, n, T);
        } else {
            // if left cell of current cell has more value than the top
            // cell, then drop current character of String Y and find LCS
            // of substring X[0..m-1], Y[0..n-2]

            return LCS(X, Y, m, n - 1, T);
        }
    }

    // Function to fill lookup table by finding the length of LCS
    // of substring X[0..m-1] and Y[0..n-1]
    public static void LCSLength(String X, String Y, int m, int n, int[][] T) {
        // fill the lookup table in bottom-up manner
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // if current character of X and Y matches
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    T[i][j] = T[i - 1][j - 1] + 1;
                }
                // else if current character of X and Y don't match
                else {
                    T[i][j] = Integer.max(T[i - 1][j], T[i][j - 1]);
                }
            }
        }
    }

    public static void main(String[] args) {
        String X = "XMJYAUZ", Y = "MZJAWXU";
        int m = X.length(), n = Y.length();

        // T[i][j] stores the length of LCS of substring
        // X[0..i-1], Y[0..j-1]
        int[][] T = new int[m + 1][n + 1];

        // fill lookup table
        LCSLength(X, Y, m, n, T);

        // find longest common sequence
        System.out.print(LCS(X, Y, m, n, T));
    }
}