package Question2_4;

import CtCILibrary.LinkedListNode;

/**
 * 以给定值x为基准，把链表分成两部分，所有小于x的结点排在大于或等于x的结点之前
 * 解法：分成两个链表，分别是比x小的，比x大的，最后合并链表。一个是往头部插入，一个是往尾部插入
 */

public class QuestionC {

	public static LinkedListNode partition(LinkedListNode node, int x) {
		if (node == null) {
			return null;
		}
		LinkedListNode head = node;
		LinkedListNode tail = node;
		
		/* Partition list */
		while (node != null) {
			LinkedListNode next = node.next;
			if (node.data < x) {
				/* Insert node at head. */
				node.next = head;
				head = node;
			} else {
				/* Insert node at tail. */
				tail.next = node;
				tail = node;
			}
			// 这里相当于移动指针了，node是用来存放当前node引用的一个变量	
			node = next;
		}
		tail.next = null;
		
		return head;
	}
	
	public static void main(String[] args) {
		int length = 20;
		LinkedListNode[] nodes = new LinkedListNode[length];
		for (int i = 0; i < length; i++) {
			nodes[i] = new LinkedListNode(i >= length / 2 ? length - i - 1 : i, null, null);
		}
		
		for (int i = 0; i < length; i++) {
			if (i < length - 1) {
				nodes[i].setNext(nodes[i + 1]);
			}
			if (i > 0) {
				nodes[i].setPrevious(nodes[i - 1]);
			}
		}
		
		LinkedListNode head = nodes[0];
		System.out.println(head.printForward());
		
		LinkedListNode h = partition(head, 8);
		System.out.println(h.printForward());
	}

}
