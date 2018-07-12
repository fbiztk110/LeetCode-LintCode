/* Description
Given a binary tree, find the subtree with maximum sum. Return the root of the subtree.

LintCode will print the subtree which root is your return node.
It's guaranteed that there is only one subtree with maximum sum and the given binary tree is not an empty tree.

Example
Given a binary tree:

     1
   /   \
 -5     2
 / \   /  \
0   3 -4  -5 
return the node with value 3.
*/

//LintCode 628
/*Easy*/

/**
 * MaximumSubtree628
 */
import java.util.*;
public class MaximumSubtree628 {
    /**
     * @param root: the root of binary tree
     * @return: the maximum weight node
     */
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int x) {
            this.val = x;
            this.left = null;
            this.right = null;
        }
    }

    public TreeNode result = null;
    public int max = Integer.MIN_VALUE;

    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        helper(root);
        return result;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);

        if (result == null || left + right + root.val > max) {
            max = left + right + root.val;
            result = root;
        }
        return left + right + root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-5);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(-4);
        root.right.right = new TreeNode(-5);
        System.out.println(new MaximumSubtree628().findSubtree(root));
    }
}