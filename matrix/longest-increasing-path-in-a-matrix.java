class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        //dp[i][j]表示这个位置前后左右哪个位置的数字比它小，且数量最多，
        //比如第二个9的右(4)和下(6)都比9小，但是哪个累积的数量多，就选哪个(存储当前格子的最长递增长度)
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int res = 0;
         //dp有两个作用：1.判断是否访问过，2.存储当前格子的最长递增长度
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){

                //因为每一个位置上的数都有可能存着最大的结果，所以需要一个res来记录
                dp[i][j] = dfs(matrix, i, j, dp);
                res = Math.max(res, dp[i][j]);
            }
        }

        return res;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] dp){
        if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length){
            return 0;
        }

        //这里分别去判断4周是否比当前数小，然后去递归遍历,因为我们不知道哪个小，所以需要一个max去记录，去比较，才能找到最大的
        int max = 0;

        if(dp[i][j] > 0){
            return dp[i][j]; //如果遍历过的话就直接返回原来遍历过的结果就好了
        }
        
        //up
        if(i-1>=0 && matrix[i-1][j] < matrix[i][j]){
            max = Math.max(max, dfs(matrix, i-1, j, dp));
        }

        //down
        if(i+1<matrix.length && matrix[i+1][j] < matrix[i][j]){
            max = Math.max(max, dfs(matrix, i+1, j, dp));
        }

        //left
        if(j-1 >=0 && matrix[i][j-1] < matrix[i][j]){
            max = Math.max(max, dfs(matrix, i, j-1, dp));
        }

        //right
        if(j+1 <matrix[0].length && matrix[i][j+1] < matrix[i][j]){
            max = Math.max(max, dfs(matrix, i, j+1, dp));
        }

        dp[i][j] = max+1;//dp有两个作用：1.判断是否访问过（>0），2.存储当前格子的最长递增长度
        return max+1;

    }
}