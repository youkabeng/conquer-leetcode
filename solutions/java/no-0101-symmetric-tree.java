// @desc-start
// Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
// For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
// 
//     1
//    / \
//   2   2
//  / \ / \
// 3  4 4  3
// 
//  
// But the following [1,2,2,null,3,null,3] is not:
// 
//     1
//    / \
//   2   2
//    \   \
//    3    3
// 
//  
// Follow up: Solve it both recursively and iteratively.
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
    public boolean isSymmetric(TreeNode root) {
		return isSymmetric(root, root);
    }

	private boolean isSymmetric(TreeNode p, TreeNode q) {
		if(p == null && q == null) return true;
		if(p == null || q == null) return false;
		if(p.val != q.val) return false;
		return isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
	}
}
// @code-end
