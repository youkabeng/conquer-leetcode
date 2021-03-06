// @desc-start
// Given a complete binary tree, count the number of nodes.
// Note: 
// Definition of a complete binary tree from Wikipedia:
// In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
// Example:
// 
// Input: 
//     1
//    / \
//   2   3
//  / \  /
// 4  5 6
// 
// Output: 6
// 
// @desc-end


// @code-start
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
    public int countNodes(TreeNode root) {
		if(root==null) return 0;
		int lh = getHeight(root.left);
		int rh = getHeight(root.right);
		if(lh == rh) {
			return countNodes(root.left) + countNodes(root.right) + 1;
		} else {
			return countNodes(root.left) + (2 << rh);
		}
    }

	private int getHeight(TreeNode root) {
		if(root==null) return 0;
		return Math.max(getHeight(root.left), getHeight(root.right));
	}
}
// @code-end
