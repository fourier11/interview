package Question7_7;

import java.util.Queue;
import java.util.LinkedList;

/**
 * 有些数的素因子只有3，5，7，请设计一个算法，找出其中第k个数
 * OS：这道题对数学功底要求有点强，暂定……
 */
public class QuestionA {

	public static int removeMin(Queue<Integer> q) {
		int min = q.peek();
		for (Integer v : q) {
			if (min > v) {
				min = v;
			}
		}
		while (q.contains(min)) {
			q.remove(min);
		}
		return min;
	}
	
	public static void addProducts(Queue<Integer> q, int v) {
		q.add(v * 3);
		q.add(v * 5);
		q.add(v * 7);
	}
	
	public static int getKthMagicNumber(int k) {
		if (k < 0) {
			return 0;
		}
		int val = 1;
		Queue<Integer> q = new LinkedList<Integer>();
		addProducts(q, 1);
		for (int i = 0; i < k; i++) { // Start at 1 since we've already done one iteration
			val = removeMin(q);
			addProducts(q, val);
		}
		return val;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 14; i++) {
			System.out.println(i + " : " + getKthMagicNumber(i));
		}
	}
}
