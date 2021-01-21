class Solution {
	public int[][] dp = new int[1001][1001];
    public int lps(String str, int i, int j) {
        if (i == j) return 1;
        if (i > j) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (str.charAt(i) == str.charAt(j)) {
            dp[i][j] = 2 + lps(str, i+1, j-1);
        } else {
            dp[i][j] = Math.max(lps(str, i+1, j), lps(str, i, j-1));
        }
        return dp[i][j];
    }
}
