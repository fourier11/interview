package Question9_1;

/**
 * 小孩上楼梯，有n个台阶，小孩可以上1阶，2阶，3阶。计算小孩有多少种上楼梯方式。
 */ 
public class Question {
	public static int countWaysDP(int n, int[] dp) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else if (dp[n] != 0) {
			return dp[n];
		} else {
			dp[n] = countWaysDP(n - 1, dp) + countWaysDP(n - 2, dp) + countWaysDP(n - 3, dp);
			return dp[n];
		}
	}

	public static int countWaysRecursive(int n) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else {
			return countWaysRecursive(n - 1) + countWaysRecursive(n - 2) + countWaysRecursive(n - 3);
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 30; i++) {
			long t1 = System.currentTimeMillis();
			int[] dp = new int[30 + 1];
			int c1 = countWaysDP(i, dp);
			long t2 = System.currentTimeMillis();
			long d1 = t2 - t1;

			long t3 = System.currentTimeMillis();
			int c2 = countWaysRecursive(i);
			long t4 = System.currentTimeMillis();
			long d2 = t4 - t3;
			System.out.println(i + " " + c1 + " " + c2 + " " + d1 + " " + d2);
		}
	}
}
