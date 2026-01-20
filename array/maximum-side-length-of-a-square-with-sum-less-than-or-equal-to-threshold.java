class Solution {
    public int maxSideLength(int[][] mat, int threshold) {

        //coner case: if mat[i][j] > threshold return 0;

       int m = mat.length;
       int n = mat[0].length;
       int[][] preSum = new int[m+1][n+1];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                preSum[i+1][j+1] = preSum[i+1][j] + preSum[i][j+1] - preSum[i][j] + mat[i][j];
            }
        }

        int res = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){                          
                while(i+res < m && j+res<n && countSum(preSum, i, j, i + res, j + res) <= threshold){
                    res++;//2
                }
            }
        }
        return res;
        
    }
    public int countSum(int[][] preSum, int r1, int c1, int r2, int c2){//l1:左上角横坐标，l2:左上角纵坐标
        return (preSum[r2+1][c2+1] - preSum[r2+1][c1] - preSum[r1][c2+1] + preSum[r1][c1]);
    }
}