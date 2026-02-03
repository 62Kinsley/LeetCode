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
//  */
// class Solution {
//     public TreeNode sortedArrayToBST(int[] nums) {

//       return dfs( nums, 0, nums.length - 1);
       
//     }

//     public TreeNode dfs(int[] nums, int l, int r) {


//         if(l > r) return null;
        
//         int mid = l + (r-l)/2;

//         TreeNode root = new TreeNode(nums[mid]);

//         root.left = dfs(nums, l, mid - 1);

//         root.right = dfs(nums, mid+1, r);

//         return root;
        
//     }


// }


class Solution{
    public TreeNode sortedArrayToBST(int[] nums){
        int n = nums.length;
        int l=0, r=n-1;
        
        return  dfs(nums, l, r);

    }
    public TreeNode dfs(int[] nums, int l, int r){

        if(l > r ){
            return null;
        }
        if(l == r){
            return new TreeNode(nums[l]);
        }
        int mid = l + (r-l)/2;// 2

        TreeNode node = new TreeNode(nums[mid]);//0, -10

        node.left = dfs(nums, l , mid-1);//nums, 0,1
        node.right = dfs(nums, mid+1, r);//nums,3,4

        return node;
    }
}