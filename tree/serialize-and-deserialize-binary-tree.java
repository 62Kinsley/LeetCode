/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur != null){
                sb.append(cur.val + ",");
                queue.offer(cur.left);
                queue.offer(cur.right);
            }else{
                 sb.append("null,");
            }  
        }
        return sb.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")){
            return null;
        }
        String[] str = data.split(",");
        int rootval = Integer.parseInt(str[0]);
        TreeNode root = new TreeNode(rootval);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);//4,5
        int i=1;
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();//3
            if(!str[i].equals("null")){
                int leftval = Integer.parseInt(str[i]);
                cur.left = new TreeNode(leftval);
                queue.add(cur.left);
            }
            i++;

            if(!str[i].equals("null")){
                int rightval = Integer.parseInt(str[i]);
                cur.right = new TreeNode(rightval);
                queue.add(cur.right);
            }
            i++;
        }
        return root;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));