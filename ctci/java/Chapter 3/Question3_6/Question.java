package Question3_6;

import java.util.Stack;

import CtCILibrary.AssortedMethods;
/**
 * 按升序对栈进行排序（最大元素位于栈顶），最多只能用一个额外的栈存放临时数据，不得将这个元素复制到别的数据结构中
 * 该栈支持：push pop peek isEmpty
 */
public class Question {
	static int c = 0;
	/**
	 * 这个方法是方案二，用了2个额外的栈，采用了 mergesort 解法
	 * 递归排序每个栈，然后将它们归并到一起并排好序，放回原来的栈中
	 * 时间复杂度是O（N）
	 * @param inStack
	 * @return
	 */
	public static Stack<Integer> mergesort(Stack<Integer> inStack) {
		if (inStack.size() <= 1) {
			return inStack;
		}
		Stack<Integer> left = new Stack<Integer>();
		Stack<Integer> right = new Stack<Integer>();
		int count = 0;
		while (inStack.size() != 0) {
			count++;
			c++;
			if (count % 2 == 0) {
				left.push(inStack.pop());
			} else {
				right.push(inStack.pop());
			}
		}

		left = mergesort(left);
		right = mergesort(right);

		while (left.size() > 0 || right.size() > 0)
		{
			if (left.size() == 0)
			{
				inStack.push(right.pop());
			}
			else if (right.size() == 0)
			{
				inStack.push(left.pop());
			}
			else if (right.peek().compareTo(left.peek()) <= 0)
			{
				inStack.push(left.pop());
			}
			else
			{
				inStack.push(right.pop());
			}
		}

		Stack<Integer> reverseStack = new Stack<Integer>();
		while (inStack.size() > 0)
		{
			c++;
			reverseStack.push(inStack.pop());
		}

		return reverseStack;
	}
	/**
	 * 这里是方案1，只用了一个额外的栈，时间复杂度是O(N^2)
	 * @param s
	 * @return
	 */
	public static Stack<Integer> sort(Stack<Integer> s) {
		Stack<Integer> r = new Stack<Integer>();
		while(!s.isEmpty()) {
			//用到一个临时变量
			int tmp = s.pop();
			while(!r.isEmpty() && r.peek() > tmp) {
				s.push(r.pop());
			}
			r.push(tmp);
		}
		return r;
	}
		
	public static void main(String [] args) {
		for (int k = 1; k < 100; k++) {
			c = 0;
			Stack<Integer> s = new Stack<Integer>();
			for (int i = 0; i < 10 * k; i++) {
				int r = AssortedMethods.randomIntInRange(0,  1000);
				s.push(r);
			}
			s = mergesort(s);
			int last = Integer.MAX_VALUE;
			while(!s.isEmpty()) {
				int curr = s.pop();
				if (curr > last) {
					System.out.println("Error: " + last + " " + curr);
				}
				last = curr;
			}
			System.out.println(c);
		}
	}
}
