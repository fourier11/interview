package Question17_8;

/**
 * 给定一个整数数组（有正数有负数），找出综合最大的连续数列，并返回总和
 * 解法思路：
 * 什么情况下需要在子数列中包含负数呢？只有当它能将两个正子数列拼接在一起，并且两者加起来大于这个负数的时候。
 */
public class Question {
	
	public static int getMaxSum(int[] a) {
		int maxSum = 0;
		int runningSum = 0;
		for (int i = 0; i < a.length; i++) {
			runningSum += a[i];
			if (maxSum < runningSum) {
				maxSum = runningSum;
				// 整个数列都是负数的情况
			} else if (runningSum < 0) {
				runningSum = 0;
			}
		}
		return maxSum;
	}
	
	public static void main(String[] args) {
		int[] a = {2, -8, 3, -2, 4, -10};
		System.out.println(getMaxSum(a));
	}
}
