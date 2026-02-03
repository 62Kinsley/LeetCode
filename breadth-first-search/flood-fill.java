class Solution {
   public static int[][] floodFill(int[][] image, int sr, int sc, int color){

        int target = image[sr][sc];
        if(target != color) {
            dfs(image, sr, sc, target, color);
        }

        return image;
  }

  public static void dfs(int[][] image, int i, int j, int target, int color){
        int m = image.length;
        int n = image[0].length;
          
        if(i<0 || i>=m || j<0 || j>=n || image[i][j] != target){
          return ;
        }
        
        image[i][j] = color;
        dfs(image, i-1, j, target, color);
        dfs(image, i+1, j, target, color);
        dfs(image, i, j-1, target, color);
        dfs(image, i, j+1, target, color);
        

  }
}