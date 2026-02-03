// class Solution {
//     public List<Integer> spiralOrder(int[][] matrix) {
//         //这道题考查--i， i--之间的区别
//         //也考察
        
//     int u=0, d = matrix.length -1, l=0, r= matrix[0].length-1;

//     List<Integer> res = new ArrayList<>();

//     while(true){

//         //left to right
//         for(int i=l; i<=r; i++){
//             res.add(matrix[u][i]);
//         }
//         //u = u+1
//         if(++u > d) break;//此时++u就代表u已经+1了
        
//         //up to down
//         for(int i=u; i<=d; i++){//u此时是1
//             res.add(matrix[i][r]);
//         }
//         //r = r-1
//         if(--r < l) break;

//         // right to left
//         for(int i=r; i>=l; i--){
//             res.add(matrix[d][i]);
//         }
//         //d = d-1
//         if(--d < u) break;


//         //down to up
//          for(int i=d; i>=u; i--){
//             res.add(matrix[i][l]);
//         }
//         if(++l > r) break;


//     }
//     return res;
  
//     }
// }

class Solution{
    public List<Integer>  spiralOrder(int[][] matrix){
        int up = 0, down = matrix.length-1;
        int left = 0, right = matrix[0].length-1;
        List<Integer> res = new ArrayList<>();
        
        while(true){

            //left to right
            for(int j=left; j<=right; j++){ 
                res.add( matrix[up][j]);
            }
            up++;//1
            if(up > down){
                break;
            }

            for(int i=up; i<=down; i++){
                res.add(matrix[i][right]);
            }
            right--;
            if(right < left){
                break;
            }

            for(int j=right; j>=left; j--){ //
                res.add( matrix[down][j]);
            }
            down--;
            if(down < up){
                break;
            }

            for(int i=down; i>=up; i--){
                res.add(matrix[i][left]);
            }
            left++;
            if(left > right){
                break;
            }
        }
       return res;
    }
}