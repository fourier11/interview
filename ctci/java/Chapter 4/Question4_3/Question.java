package Question4_3;

import CtCILibrary.TreeNode;

/**
 * 给定一个有序的整数数组，元素各不相同且只升序排列，编写一个算法，创建一棵高度最小的二叉查找树
 */
public class Question {	
	public static void main(String[] args) {
		// 数组必须有序
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		// We needed this code for other files, so check out the code in the library
		TreeNode root = TreeNode.createMinimalBST(array);
		System.out.println("Root? " + root.data);
		System.out.println("Created BST? " + root.isBST());
		System.out.println("Height: " + root.height());
	}

}
