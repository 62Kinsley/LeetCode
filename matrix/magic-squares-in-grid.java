// class Solution {
//     public int numMagicSquaresInside(int[][] grid) {

//         //conner case: if the gird[i][j] >=10  continue
//         //if grid.length < 3 || grid[i].length < 3 contine return 0
//         //
//         //这道题的规律在于，如果这个square 是magic squre的话，
//         //那么中间一定是5，又因为 1-9相加是45，所以如果row column diagonals要想等的话
//         //5的上下，左右或者diagonals must be 1-9, 2-8, 3-7, 4-6
//         int m = grid.length;
//         int n = grid[0].length;
//         int ans = 0;

//         if(grid.length < 3 || grid[0].length < 3 ){
//             return 0;
//         }
//         for(int i=0;  i<m-2; i++){
//             for(int j=0;  j<n-2; j++){
//                 if( grid[i+1][j+1] != 5){
//                     continue;
//                 }

//                 //中间为5的时候
//                 int[] count = new int[10];
//                 int[] rowSum = new int[3]; //// 三行的和
//                 int[] colSum = new int[3];// // 三列的和
//                  boolean valid = true;

//                 for(int x=0; x<=2; x++){
//                     for(int y=0; y<=2; y++){
//                         int k = grid[i+x][j+y];//1+0,1+0 1,2

//                         // 数字必须在 1-9 之间
//                         if (k < 1 || k > 9) {
//                             valid = false;
//                             break;
//                         }
//                         count[k]++;//记录这个数字出现的次数
//                         rowSum[x] += k;
//                         colSum[y] += k;
//                     } 
//                 }
//                 // 检查每个数字是否恰好出现 1 次
//                 if (valid) {
//                     for (int num = 1; num <= 9; num++) {
//                         if (count[num] != 1) {
//                             valid = false;
//                             break;
//                         }
//                     }
//                 }

//                 // 第三关：检查前两行、前两列的和是否为 15
//                 if (valid &&
//                     rowSum[0] == 15 && rowSum[1] == 15 &&
//                     colSum[0] == 15 && colSum[1] == 15) {
//                     ans++;
//                 }

//             }
//         }
//     return ans;
//     }
// }


class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        ////if grid.length < 3 || grid[i].length < 3 contine return 0
        //conner case: if the gird[i][j] >9|| grid[i][j]<1 continue

        //grid[i+1][j+1] == 5? the center integer must be 5
        //no? continue
        //yes? check each integer in the 3 x 3 grid  >=1 && <=9? -> no break, yes->
        //only check first 2 row, first 2 column

        int m = grid.length, n = grid[0].length;
        int res = 0;

        if(m < 3 || n < 3){
            return 0;
        }

        for(int i=0; i<= m-3; i++){
            for(int j=0; j<= n-3; j++){
                ////check  center integer is 5
                //if not, continue
                if(grid[i][j] < 1 || grid[i+1][j+1] >9){
                    continue;
                }
                if(grid[i+1][j+1] != 5){
                    continue; 
                }

                //center integer is 5
                //check the magic square with distinct numbers from 1 to 9 
                int[] count = new int[10];
                int[] rowSum = new int[3];
                int[] colSum = new int[3];
                boolean valid = true;

                for(int x=0; x<=2; x++){
                    for(int y=0; y<=2; y++){
                        int k = grid[i+x][j+y];

                        if(k < 1 || k >9){
                            break;//not the  magic square
                        }
                        count[k]++;
                        rowSum[x] += k;
                        colSum[y] += k;

                    }
                }

                for(int z=1; z<=9; z++){//保证 filled with distinct numbers from 1 to 9 
                    if(count[z] != 1){
                        valid = false;
                        break;
                    }
                }

                if(valid){
                    if(rowSum[0] == 15 && rowSum[1] == 15 && colSum[0] == 15 && colSum[1] == 15){
                        res++;
                    }
                }
                


            }
        }

        return res;

    }
}