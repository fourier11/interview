package Question4_1;
import CtCILibrary.TreeNode;
/**
 * 更高效的解法：递归向下检查每棵子树的高度，如果平衡，返回树的实际高度。如果不平衡，返回-1，中断执行
 */
public class QuestionImproved {
		
	public static int checkHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		// 检查左子树是否平衡
		int leftHeight = checkHeight(root.left);
		if (leftHeight == -1) {
			//表示不平衡
			return -1;
		}
		int rightHeight = checkHeight(root.right);
		if (rightHeight == -1) {
			return -1;
		}
		
		int heightDiff = leftHeight - rightHeight;
		if (Math.abs(heightDiff) > 1) {
			return -1;
		}
		else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}
	
	public static boolean isBalanced(TreeNode root) {
		if (checkHeight(root) == -1) {
			return false;
		} else {
			return true;
		}
	}
	
	public static void main(String[] args) {
		// Create balanced tree
		int[] array = {0, 1, 2, 3, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);

		
		System.out.println("Is balanced? " + isBalanced(root));
		
		root.insertInOrder(4); // Add 4 to make it unbalanced

		System.out.println("Is balanced? " + isBalanced(root));
	}

}
