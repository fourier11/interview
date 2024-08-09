package sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

	public static void mergeSort(int[] array) {
		int[] helper = new int[array.length];
		mergesort(array, helper, 0, array.length - 1);
	}

	private static void mergesort(int[] array, int[] helper, int low, int high) {
		if (low == high) {
			return;
		}
		int middle = low + (high - low) / 2;
		mergesort(array, helper, low, middle); // Sort left half
		mergesort(array, helper, middle + 1, high); // Sort right half
		merge(array, helper, low, middle, high); // Merge them
	}

	private static void merge(int[] array, int[] helper, int low, int middle, int high) {
		// 先把low~high的值放入辅助数组，以便合并的值直接放入array
		for (int i = low; i <= high; i++) {
			helper[i] = array[i];
		}

		int i = low;
		int j = middle + 1;
		for (int p = low; p <= high; p++) {
			if (i == middle + 1) {
				array[p] = helper[j++];
			} else if (j == high + 1) {
				array[p] = helper[i++];
			} else if (helper[i] > helper[j]) {
				array[p] = helper[j++];
			} else {
				array[p] = helper[i++];
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10 };
		System.out.println("排序前:");
		System.out.println(Arrays.toString(arr));
		mergeSort(arr);
		System.out.println("排序后:");
		System.out.println(Arrays.toString(arr));
	}
}
