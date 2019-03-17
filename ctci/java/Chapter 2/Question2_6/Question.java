package Question2_6;

import CtCILibrary.LinkedListNode;
/**
 * 给定一个有环链表，实现一个算法返回环路的开头结点
 * TODO:抽空再看看
 * 解法过程：
 * 1.检测链表是否存在环路(快慢指针是否会碰到一起)
 * 2.什么时候碰到一起
 * 3.如何找到环路起始
 * 4.整合（FastPointer的移动速度是SlowPointer的两倍，当SlowPointer走了k个结点进入环路时，FastPointer已经进入链表环路 k个结点，也就是说FastPointer和SlowPointer相距 LOOP_SIZE-k 个结点，接下来，每走一次，距离会更近一个结点，走了LOOP_SIZE-k次后，两个结点它们会碰在一起）
 */
public class Question {

	public static LinkedListNode FindBeginning(LinkedListNode head) {
		LinkedListNode slow = head;
		LinkedListNode fast = head; 
		
		// Find meeting point，处于链表中LOOP_SIZE-k步的位置
		while (fast != null && fast.next != null) { 
			slow = slow.next; 
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}

		// Error check - there is no meeting point, and therefore no loop
		if (fast == null || fast.next == null) {
			return null;
		}

		/* Move slow to Head. Keep fast at Meeting Point. Each are k steps
		/* from the Loop Start. If they move at the same pace, they must
		 * meet at Loop Start. */
		slow = head; 
		while (slow != fast) { 
			slow = slow.next; 
			fast = fast.next; 
		}
		
		// Both now point to the start of the loop.
		return fast;
	}
	
	public static void main(String[] args) {
		int list_length = 100;
		int k = 10;
		
		// Create linked list
		LinkedListNode[] nodes = new LinkedListNode[list_length];
		for (int i = 0; i < list_length; i++) {
			nodes[i] = new LinkedListNode(i, null, i > 0 ? nodes[i - 1] : null);
		}
		
		// Create loop;
		nodes[list_length - 1].next = nodes[list_length - k];
		
		LinkedListNode loop = FindBeginning(nodes[0]);
		if (loop == null) {
			System.out.println("No Cycle.");
		} else {
			System.out.println(loop.data);
		}
	}

}
