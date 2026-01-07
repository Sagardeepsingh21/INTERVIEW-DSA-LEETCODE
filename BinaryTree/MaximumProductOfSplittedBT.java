// leetcode-1339
// Maximum Product Of Splitted BT
// Tree,Binary Tree, DFS

class Solution {
    private long totalSum = 0;
    private long maxProduct = 0;
    private static final int MOD = 1_000_000_007;
     
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public int maxProduct(TreeNode root) {
        // Step 1: compute total sum
        totalSum = getTotalSum(root);

        // Step 2: compute max product
        computeSubtreeSum(root);

        return (int)(maxProduct % MOD);
    }

    // First DFS: total sum
    private long getTotalSum(TreeNode node) {
        if (node == null) return 0;
        return node.val + getTotalSum(node.left) + getTotalSum(node.right);
    }

    // Second DFS: try all splits
    private long computeSubtreeSum(TreeNode node) {
        if (node == null) return 0;

        long left = computeSubtreeSum(node.left);
        long right = computeSubtreeSum(node.right);

        long subtreeSum = node.val + left + right;
        long product = subtreeSum * (totalSum - subtreeSum);

        maxProduct = Math.max(maxProduct, product);

        return subtreeSum;
    }
}
