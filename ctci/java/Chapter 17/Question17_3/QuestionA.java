package Question17_3;

/**
 * 设计一个算法，算出n阶乘有多少个尾随零
 * 思路：
 * 为了算出尾随零的数量，只需计算有多少对5和2倍数。2倍数总比5多，所以只需要算有多少5倍数
 */
public class QuestionA {
	public static int factorsOf5(int i) {
		int count = 0;
		while (i % 5 == 0) {
			count++;
			i /= 5;
		}
		return count;
	}
	
	public static int countFactZeros(int num) {
		int count = 0;		
		for (int i = 2; i <= num; i++) {
			count += factorsOf5(i);
		}
		return count;
	}
	
	public static int factorial(int num) {
		if (num == 1) {
			return 1;
		} else if (num > 1) {
			return num * factorial(num - 1);
		} else {
			return -1; // Error
		}
	}
	
	public static void main(String[] args) {
		for (int i = 1; i < 12; i++) {
			System.out.println(i + "! (or " + factorial(i) + ") has " + countFactZeros(i) + " zeros");
		}
	}

}
