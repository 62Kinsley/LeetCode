/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


//注意审题，这道题是让我们从root-leaf, 那么root是什么， leaf又是什么，要想清楚
// class Solution {
//     public boolean hasPathSum(TreeNode root, int targetsum) {

//         if(root == null){
//             return false;
//         }

//         if(root.left == null && root.right == null && root.val == targetsum){//我们要想好leaf的条件是什么，no children
//             return true;
//         }

//         targetsum = targetsum - root.val;
        
//         boolean left = hasPathSum(root.left, targetsum);
//         boolean right = hasPathSum(root.right, targetsum);

//         return left || right;
//     }
// }
class Solution{
    public boolean  hasPathSum(TreeNode root, int targetSum){

            if(root == null){
                return false;
            }

            if(root.left == null && root.right == null && root.val == targetSum){//我们要想好leaf的条件是什么，no children
                return true;
            }
            
            boolean left = false;
            boolean right = false;
            if(root.left != null){
               left = hasPathSum(root.left, targetSum - root.val);
            }
            
            if(root.right != null){
                 right = hasPathSum(root.right, targetSum - root.val);
            }
            

            return left||right;
        
    }

}