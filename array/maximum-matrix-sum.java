class Solution {
    public long maxMatrixSum(int[][] matrix) {
        //1.
        int n = matrix.length;
        int countNeg = 0;
        long res = 0;
        int minAbs = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int x = matrix[i][j];
                if( x < 0){
                    countNeg++;
                    x = -x;
                }
                minAbs = Math.min(minAbs, x);
                res += x;//所有数的绝对值都相加
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


// class Solution {
//     public long maxMatrixSum(int[][] matrix) {
//         long total = 0;
//         int negCnt = 0;
//         int mn = Integer.MAX_VALUE;
//         for (int[] row : matrix) {
//             for (int x : row) {
//                 if (x < 0) {
//                     negCnt++;
//                     x = -x; // 先把负数都变成正数
//                 }
//                 mn = Math.min(mn, x);
//                 total += x;
//             }
//         }

//         if (negCnt % 2 > 0) {
//             total -= mn * 2; // 给绝对值最小的数添加负号
//         }
//         return total;
//     }
// }

