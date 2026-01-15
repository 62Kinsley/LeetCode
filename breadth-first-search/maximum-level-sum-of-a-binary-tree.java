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
class Solution {
    public int maxLevelSum(TreeNode root) {
        if(root == null){
            return 0;
        }

        int maxSum = Integer.MIN_VALUE;
        int res = 0;
        int level = 1;
        Queue<TreeNode> queue = new LinkedList<>();//7,0
        queue.add(root);

        while(!queue.isEmpty()){
            int levelCount = 0;
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode cur = queue.poll();//7
                levelCount += cur.val;//7

                if(cur.left != null){
                    queue.add(cur.left);//
                }
                if(cur.right != null){
                    queue.add(cur.right);
                }

            }
            if(levelCount > maxSum ){
                maxSum = levelCount;//1
                res = level;//1
            }
            level++;//2

            
        }

        return res;

        
    }
}