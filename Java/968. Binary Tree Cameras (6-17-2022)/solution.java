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
    public int minCameraCover(TreeNode root) {
        int val = helper(root);
        if (root.val == -1){
            return val+1;
        }
        return val;
    }
    public int helper(TreeNode root){
        int ChildCamera = 0;
        if(root.left != null){
            ChildCamera += helper(root.left);
            if(root.left.val==-1){
                root.val = -3;
            }
            else if(root.left.val == -3){
                root.val = -2;
            }
            else if(root.left.val == -2){
                root.val = -1;
            }
        }
        if(root.right != null){
            ChildCamera += helper(root.right);
            if(root.right.val==-1){
                root.val = -3;
            }
            else if(root.right.val == -3){
                root.val = Math.min(-2,root.val);
            }
            else if(root.right.val == -2){
                root.val = Math.min(-1,root.val);
            }
        }
        if((root.right == null) && (root.left == null)){
            root.val = -1;
            return 0;
        }
        if(root.val == -3){
            ChildCamera += 1;
        }
       return ChildCamera;
    }
}