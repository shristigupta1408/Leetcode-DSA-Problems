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
    private List<List<Integer>> solution;

    private int findHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        int currHeight = Math.max(leftHeight, rightHeight) + 1;

        if (solution.size() == currHeight) {
            solution.add(new ArrayList<>());
        }

        solution.get(currHeight).add(root.val);

        return currHeight;
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        // Edge cases - only root, root == null
        // Always balanced?
        // Recursion - just return root
        // Level Order Traversal
        // left == null and right == null

        solution = new ArrayList<>();

        findHeight(root);

        return solution;
    }
}