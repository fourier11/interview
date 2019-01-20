package Question4_4;

import CtCILibrary.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 给定一个二叉树，设计一个算法，创建含有某一深度上所有结点的链表（比如树的深度为D，创建出D个列表）
 * 这个示例使用的是深度优先搜索的实现代码
 * TODO：这个例子没有理解
 */
public class QuestionDFS {

	public static void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
		// 终止条件
		if (root == null) return;
		LinkedList<TreeNode> list = null;
		if (lists.size() == level) { // Level not contained in list
			list = new LinkedList<TreeNode>();
			/* 以中序遍历所有层级，若这是第一次访问第i层，表示已经访问过0~i-1层，因此可以将这一层加到链表末端 */
			lists.add(list);  
		} else {
			list = lists.get(level);
		}
		list.add(root);
		createLevelLinkedList(root.left, lists, level + 1);
		createLevelLinkedList(root.right, lists, level + 1);
	}
	
	public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		createLevelLinkedList(root, lists, 0);
		return lists;
	}	
	
	public static void printResult(ArrayList<LinkedList<TreeNode>> result){
		int depth = 0;
		for(LinkedList<TreeNode> entry : result) {
			Iterator<TreeNode> i = entry.listIterator();
			System.out.print("Link list at depth " + depth + ":");
			while(i.hasNext()){
				System.out.print(" " + ((TreeNode)i.next()).data);
			}
			System.out.println();
			depth++;
		}
	}
	

	public static void main(String[] args) {
		int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = AssortedMethods.createTreeFromArray(nodes_flattened);
		ArrayList<LinkedList<TreeNode>> list = createLevelLinkedList(root);
		printResult(list);
	}

}
