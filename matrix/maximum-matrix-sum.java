class Solution {
    public long maxMatrixSum(int[][] matrix) {
        //1.
        int n = matrix.length;
        int countNeg = 0;
        long res = 0;
        int minAbs = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] <= 0){
                    countNeg++;
                }
                 minAbs = Math.min(minAbs, Math.abs(matrix[i][j]));
                res += Math.abs(matrix[i][j]);//所有数的绝对值都相加
            }
        }

        //偶数的时候就直接输出答案
        //奇数的话，就看有没有0，其实不管有没有0，都不用特地的去判断
        //因为刚刚相加所有的数的绝对值的时候，
        //如果有0 那么得到的结果就是(0+正数+abs(负数)), 这时候 minAbs是0，所以res-2* minAbs = res
        //如果没有0， 那么得到的结果就是 正数+abs(负数) 这时候 minAbs是abs（最大的负数）所以 最终的结果就是res要➖2倍的这个绝对值，
        if(countNeg % 2 != 0){
            res -= 2* minAbs;
        }
        return res;
    }
}