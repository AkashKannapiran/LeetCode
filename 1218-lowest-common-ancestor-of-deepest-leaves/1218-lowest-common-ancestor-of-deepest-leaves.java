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
    static class Pair {
        TreeNode node;
        int depth;

        Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    private Pair findLCA(TreeNode current) {
        if (current == null) {
            return new Pair(null, 0);
        }

        Pair left = findLCA(current.left);
        Pair right = findLCA(current.right);

        if (left.depth == right.depth) {
            return new Pair(current, 1 + left.depth);
        } else if (left.depth > right.depth) {
            return new Pair(left.node, 1 + left.depth);
        } else {
            return new Pair(right.node, 1 + right.depth);
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Pair result = findLCA(root);

        return result.node;
    }
}