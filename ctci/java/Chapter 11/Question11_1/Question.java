package Question11_1;

import CtCILibrary.AssortedMethods;

/**
 * 给定两个排序后的数组A和B，A的末端有足够的缓存容纳B，将B合入A并排序
 * 解法：
 * 关键点是从数组的末端开始插入，减少移动的元素个数
 * 这个结果应该不对吧？？？
 */
public class Question {


	/** Merges array
	 * @param a first array
	 * @param b second array
	 * @param lastA number of "real" elements in a
	 * @param lastB number of "real" elements in b
	 */
	public static void merge(int[] a, int[] b, int lastA, int lastB) {
		int indexMerged = lastB + lastA - 1; /* Index of last location of merged array */
		int indexA = lastA - 1; /* Index of last element in array b */
		int indexB = lastB - 1; /* Index of last element in array a */
	
		/* Merge a and b, starting from the last element in each */
		while (indexB >= 0) {
			if (indexA >= 0 && a[indexA] > b[indexB]) { /* end of a is bigger than end of b */
				a[indexMerged] = a[indexA]; // copy element
				indexA--; 
			} else {
				a[indexMerged] = b[indexB]; // copy element
				indexB--;
			}
			indexMerged--; // move indices			
		}
	}
	
	public static void main(String[] args) {
		int[] a = {2, 3, 4, 5, 6, 8, 10, 100, 0, 0, 0, 0, 0, 0};
		int[] b = {1, 4, 7, 6, 7, 7};
		merge(a, b, 8, 6);
		System.out.println(AssortedMethods.arrayToString(a));
	}

}
