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
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();//5,3
        Queue<TreeNode> queue = new LinkedList<>();//3,6
        Boolean res = false;
        queue.offer(root);
        
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();//3
            if(set.contains(k-cur.val)){//6
                res = true;
                break;
            }
            set.add(cur.val);
            if(cur.left != null){
                queue.add(cur.left);
            }
            if(cur.right != null){
                queue.add(cur.right);
            }
        }

        return res;

        
    }
}