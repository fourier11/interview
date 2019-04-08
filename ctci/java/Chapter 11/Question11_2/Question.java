package Question11_2;

import java.util.Arrays;

import CtCILibrary.AssortedMethods;

/**
 * 编写一个方法，对字符串数组进行排序，将所有变位词排在相邻位置
 * 解法一：
 * 套用标准排序算法，比如归并排序或快排。修改比较器，指示两个字符串互为变位词就是相等
 */
public class Question {
	public static void main(String[] args) {
		String[] array = {"apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"};
		System.out.println(AssortedMethods.stringArrayToString(array));
		Arrays.sort(array, new AnagramComparator());
		System.out.println(AssortedMethods.stringArrayToString(array));
	}
}
