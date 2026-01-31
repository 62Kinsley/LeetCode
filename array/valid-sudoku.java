// class Solution{
//     public boolean isValidSudoku(char[][] board){

//         //分别创建3个二维数组（row, col, box）
//         整个board有9行，第二维的维数10是为了让下标有9，和数独中的数字9对应。
//         int[][] row = new int[9][10]; //9表示9个row，10表示0-9这10个数(每个只能出现一次），长度是10，出现的话就表示第x行出现过数字y，标记为1， 
//         int[][] col = new int[9][10]; //9表示9个col，10表示0-9这10个数(每个只能出现一次），长度是10,出现的话就表示第x列出现过数字y，标记为1，
//         int[][] box = new int[9][10]; //9表示9个(3 * 3大小的)box，10表示0-9这10个数(每个只能出现一次），长度是10,出现的话就表示第x box出现过数字y，标记为1， 

//         for(int i=0; i<9; i++){
//             for(int j=0; j<9; j++){
//                 //开始遍历board里的每一个数
//                 if(board[i][j] == '.'){ //！！双引号是string，单引号是char！！
//                     continue;//如果没有存数字，就跳过当前的，继续下一个
//                 }
//                 int num = board[i][j] - '0';//将string转化为int，求出当前位置的数字
//                 if(row[i][num] == 1){
//                      //这里说明，比如，记录row出现数字情况的二维数组里，比如第i行之前出现数字9，那么row[i][9]之前就应该被标记为1，如果现在再遍历这个发现等于1的话，就说明这行出现过这个数字了
//                 //那就说明这一行有数字重复了，所以要返回的是false
//                     return false;
//                 } 
//                 if(col[j][num] == 1){
//                        //这里说明，比如，记录col出现数字情况的二维数组里，比如第j行之前出现数字9，那么row[j][9]之前就应该被标记为1，如果现在再遍历这个发现这个位置等于1的话，就说明这列出现过这个数字了
//                 //那就说明这一列有数字重复了，所以要返回的是false
//                     return false;
//                 }
//                 if(box[(i/3)*3 + (j/3)][num] == 1){
//                     //box的情况比较特殊，box[0-8]是有规律的，可以试着找一找
//                     return false;
//                 }
//                 //如果没有出现过的话，就标记他们为1
//                 row[i][num] = 1;
//                 col[j][num] = 1;
//                 box[(i/3)*3 + (j/3)][num] = 1;
//                 //其实这样做的好处是，遍历board[i][j]的时候，相当于每次同时把第i行和第j列还有box[]是否出现这个数处理了一遍，不管是否标记为1，
//                 //而不像暴力法，先把[i][j]遍历的时候，先遍历一遍【i】,再起一个loop遍历【j】，以及box[]             
//             }

//         }
//         return true;

//     }
// }


class Solution{
    public boolean isValidSudoku(char[][] board){
        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][] grid = new boolean[9][10];

        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m; i++){
             for(int j=0; j<n; j++){
                if(board[i][j] != '.'){
                    char c = board[i][j];
                    int num = c - '0';

                    int boxNum = (i/3)*3 + (j/3);
                    if(row[i][num]  || col[j][num] || grid[boxNum][num]){
                        return false;
                    }
                    
                    row[i][num] = col[j][num] = grid[boxNum][num] = true;

                }
            }
        }
        return true;
    }
}