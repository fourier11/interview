package Question2_2;

import CtCILibrary.*;

/**
 * 单向链表的倒数第k个结点，很常见的一道题，前面的解法没仔细看，感觉多余
 */

public class Question {

	public static int nthToLastR1(LinkedListNode head, int n) {
		if (n == 0 || head == null) {
			return 0;
		}
		int k = nthToLastR1(head.next, n) + 1;
		if (k == n) {
			System.out.println(n + "th to last node is " + head.data);
		}
		return k;
	}

	//IntWrapper是包裹类，在递归的时候模拟按引用传递。
	//方案缺点：递归调用，需要占用O(n)空间
	public static LinkedListNode nthToLastR2(LinkedListNode head, int n, IntWrapper i) {
		if (head == null) {
			return null;
		}
		LinkedListNode node = nthToLastR2(head.next, n, i);
		i.value = i.value + 1;
		if (i.value == n) {
			return head;
		} 
		return node;
	}
	
	public static Result nthToLastR3Helper(LinkedListNode head, int k) {
		if (head == null) {
			return new Result(null, 0);
		}
		Result res = nthToLastR3Helper(head.next, k);
		if (res.node == null) {
			res.count++;
			if (res.count == k) {
				res.node = head;
			} 
		}
		return res;
	}	
	
	public static LinkedListNode nthToLastR3(LinkedListNode head, int k) {
		Result res = nthToLastR3Helper(head, k);
		if (res != null) {
			return res.node;
		}
		return null;
	}		
	
	public static LinkedListNode nthToLast(LinkedListNode head, int n) {
		// 这个方法才是常见解法，两个指针，一快一慢
		LinkedListNode p1 = head;
		LinkedListNode p2 = head;
		
		if (n <= 0) return null;
		
		// Move p2 n nodes into the list.  Keep n1 in the same position.
		for (int i = 0; i < n - 1; i++) { 
			if (p2 == null) {
				return null; // Error: list is too small.这个很关键，针对特殊异常场景做处理
			}
			p2 = p2.next;
		}
		if (p2 == null) { // Another error check.
			return null;
		}
		
		// Move them at the same pace.  When p2 hits the end, 
		// p1 will be at the right element.
		while (p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
	  	}
	  	return p1;
	}
	
	public static void main(String[] args) {
		LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
		System.out.println(head.printForward());
		int nth = 3;
		IntWrapper wr = new IntWrapper();
		LinkedListNode n = nthToLastR3(head, nth);
		nthToLastR1(head, nth);
		if (n != null) {
			System.out.println(nth + "th to last node is " + n.data);
		} else {
			System.out.println("Null.  n is out of bounds.");
		}
	}

}
