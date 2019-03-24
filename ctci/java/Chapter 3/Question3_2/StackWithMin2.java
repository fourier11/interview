package Question3_2;

import java.util.Stack;
/**
 * 第二种解法更省空间，利用额外的栈S2来存储最小值
 */
public class StackWithMin2 extends Stack<Integer> {
	Stack<Integer> s2;
	
	public StackWithMin2() {
		s2 = new Stack<Integer>();		
	}
	
	public void push(int value){
		if (value <= min()) {
			s2.push(value);
		}
		super.push(value);
	}
	
	public Integer pop() {
		int value = super.pop();
		if (value == min()) {
			s2.pop();			
		}
		return value;
	}
	
	public int min() {
		if (s2.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return s2.peek();
		}
	}
}


