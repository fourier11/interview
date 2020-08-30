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
		if (low < high) {
			int middle = (low + high) / 2;
			mergesort(array, helper, low, middle); // Sort left half
			mergesort(array, helper, middle + 1, high); // Sort right half
			merge(array, helper, low, middle, high); // Merge them
		}
	}

	private static void merge(int[] array, int[] helper, int low, int middle, int high) {
		/* Copy both halves into a helper array */
		for (int i = low; i <= high; i++) {
			helper[i] = array[i];
		}

		int helperLeft = low;
		int helperRight = middle + 1;
		int current = low;

		/*
		 * Iterate through helper array. Compare the left and right half, copying back
		 * the smaller element from the two halves into the original array.
		 */
		while (helperLeft <= middle && helperRight <= high) {
			if (helper[helperLeft] <= helper[helperRight]) {
				array[current] = helper[helperLeft];
				helperLeft++;
			} else { // If right element is smaller than left element
				array[current] = helper[helperRight];
				helperRight++;
			}
			current++;
		}

		/*
		 * Copy the rest of the left side of the array into the target array
		 * 右半部分的剩余元素不需要复制，因为在array[]中已经包含了右半部分
		 */
		int remaining = middle - helperLeft;
		for (int i = 0; i <= remaining; i++) {
			array[current + i] = helper[helperLeft + i];
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
