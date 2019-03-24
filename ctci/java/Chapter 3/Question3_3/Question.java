package Question3_3;

/**
 * 设想有一堆盘子，堆太高可能会倒下来，因此，现实生活中，盘子堆到一定高度，我们就会另外堆一堆盘子。
 * 实现数据结构SetOFStacks，模拟这种行为，由多个栈组成，当前一个栈填满时新建一个栈。
 * 进阶：实现一个popAt(int index)方法，根据指定的子栈，执行pop操作
 */
public class Question {
	public static void main(String[] args) {
		int capacity_per_substack = 5;
		SetOfStacks set = new SetOfStacks(capacity_per_substack);
		for (int i = 0; i < 34; i++) {
			set.push(i);
		}
		for (int i = 0; i < 34; i++) {
			System.out.println("Popped " + set.pop());
		}		
	}
}
