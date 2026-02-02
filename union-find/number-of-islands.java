//If we want to find a possible path,
// DFS will be more efficient. 
//Because DFS will return a possible path if found, 
//while it may not the shortest path.


// class Solution {
//     public int numIslands(char[][] grid) {
//         int res = 0;
//         for(int i=0; i<grid.length; i++){
//             for(int j=0; j<grid[0].length; j++){
//                 if(grid[i][j] == '1'){
//                     dfs(grid, i, j);//把同一个island的1都变成2
//                     res++;
//                 }
//             }

//         }
//         return res;
//     }

//     private void dfs(char[][] grid, int i, int j){
//         if(i<0 || i >=grid.length || j<0 || j >= grid[0].length || grid[i][j] != '1'){
//             return ;
//         }

//         grid[i][j] = '2';

//         dfs(grid, i-1, j);
//         dfs(grid, i+1, j);
//         dfs(grid, i, j-1);
//         dfs(grid, i, j+1);   
//     }

//     //时间复杂度：O(mn)，其中 m 和 n 分别为 grid 的行数和列数。
//     //空间复杂度：O(mn)。最坏情况下，递归需要 O(mn) 的栈空间。

// }

class Solution{
    public int numIslands(char[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for(int i=0; i<m; i++){
           for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    res++;
                }
            } 
        }
        return res;
    }
//   ["2","2","0","0","0"],
//   ["2","2","0","0","0"],
//   ["0","0","1","0","0"],
//   ["0","0","0","1","1"]
    public void dfs(char[][] grid, int i, int j){//0,0

        int m = grid.length;
        int n = grid[0].length;

        if(i<0 || i>=m || j<0 || j>=n || grid[i][j] != '1'){
            return ;
        }

        grid[i][j] = '2';

        dfs(grid, i-1, j);// 
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);//
        dfs(grid, i, j+1);
        
    }
}