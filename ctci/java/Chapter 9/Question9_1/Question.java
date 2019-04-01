package Question9_1;


// 小孩上楼梯，有n个台阶，小孩可以上1阶，2阶，3阶。计算小孩有多少种上楼梯方式。
public class Question {
	// 动态规划方式，效果更优。还需要多理解它是如何做的缓存？
	public static int countWaysDP(int n, int[] map) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else if (map[n] > -1) {
			return map[n];
		} else {
			map[n] = countWaysDP(n - 1, map) + 
					 countWaysDP(n - 2, map) + 
					 countWaysDP(n - 3, map);
			return map[n];
		}
	}
	
	/**
	 * 最简单方法，容易理解。但是对同一数值调用很多次
	 * 最后一步可能是从第 n-1 阶往上走 1 阶，从第n-2阶往上走2阶，从第n-3阶往上走3阶
	 */
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
			int[] map = new int[30 + 1];
			for (int j = 0; j < map.length; j++) {
				map[j] = -1;
			}
			int c1 = countWaysDP(i, map);
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
