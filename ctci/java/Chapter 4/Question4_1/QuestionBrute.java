package Question4_1;

import CtCILibrary.AssortedMethods;
import CtCILibrary.TreeNode;
/**
 * 实现一个函数，检查二叉树是否平衡。（平衡的定义是两棵子树的高度差不超过1）
 */
public class QuestionBrute {
	/**
	 * 递归获取树的高度
	 */
	public static int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
		
	public static boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		int heightDiff = getHeight(root.left) - getHeight(root.right);
		if (Math.abs(heightDiff) > 1) {
			return false;
		}
		else {
			return isBalanced(root.left) && isBalanced(root.right);
		}
	}
	
	public static void main(String[] args) {
		// Create balanced tree
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		System.out.println("Root? " + root.data);
		System.out.println("Is balanced? " + isBalanced(root));
		
		// Could be balanced, actually, but it's very unlikely...
		TreeNode unbalanced = new TreeNode(10);
		for (int i = 0; i < 10; i++) {
			unbalanced.insertInOrder(AssortedMethods.randomIntInRange(0, 100));
		}
		System.out.println("Root? " + unbalanced.data);
		System.out.println("Is balanced? " + isBalanced(unbalanced));
	}

}
