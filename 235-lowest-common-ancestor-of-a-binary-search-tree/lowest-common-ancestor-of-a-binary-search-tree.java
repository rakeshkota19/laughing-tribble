/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode ans;

    boolean func(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return false;
        
      

        boolean left = func(root.left, p, q);
        boolean right = func(root.right, p, q);

        if (left && right) {
            ans = root;
            return true;
        }


        if (p.val == root.val || q.val == root.val)
        {

            if (left || right) {
                ans = root;
            }
            
            return true;
        }

        return left | right;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ans = null;
        func(root, p, q);
        return ans;
    }
}