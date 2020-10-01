package Question4_5;

import CtCILibrary.TreeNode;

/**
 * 实现一个函数，检查一棵二叉树是否为二叉查找树
 * 这个解法跑不过leetcode用例
 */
public class Question {
	public static Integer last_printed = null;
	public static boolean checkBST(TreeNode n) {
		if (n == null) {
			return true;
		}
		
		// Check / recurse left
		if (!checkBST(n.left)) {
			return false;
		}
		
		// Check current
		if (last_printed != null && n.data <= last_printed) {
			return false;
		}
		last_printed = n.data;
		
		// Check / recurse right
		if (!checkBST(n.right)) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int[] array = {Integer.MIN_VALUE, Integer.MAX_VALUE - 2, Integer.MAX_VALUE - 1, Integer.MAX_VALUE};
		TreeNode node = TreeNode.createMinimalBST(array);
		//node.left.data = 5;
		//node.left.right.data = 3;
		System.out.println(checkBST(node));
	}
}