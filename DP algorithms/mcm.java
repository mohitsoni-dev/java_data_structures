class Solution{
    public static int[][] dp;
    static int matrixMultiplication(int N, int arr[])
    {
        dp = new int[N][N];
        for (int[] d : dp) Arrays.fill(d, -1);
        Matrix[] matrices = new Matrix[N-1];
        for (int i = 1; i < N; i++) {
            matrices[i-1] = new Matrix(arr[i-1], arr[i]);
        }
        
        return helper(matrices, 0, N-2);
    }
    
    static int helper (Matrix[] matrices, int i, int j) {
        if (i >= j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        
        int cost = Integer.MAX_VALUE;
        
        for (int k = i; k < j; k++) {
            int cost1 = helper(matrices, i, k);
            int cost2 = helper(matrices, k+1, j);
            int tempCost = cost1 + cost2 + (matrices[i].n * matrices[k].m * matrices[j].m);
            cost = Math.min(tempCost, cost);
        }
        
        dp[i][j] = cost;
        
        return cost;
    }
}

class Matrix {
    public int n;
    public int m;
    public Matrix(int n, int m) {
        this.n = n;
        this.m = m;
    }
}
