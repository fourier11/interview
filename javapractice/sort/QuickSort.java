package sort;

import java.util.Arrays;

/**
 * 快速排序
 * quickSort2 的 partition 思路更清晰
 */
public class QuickSort {

	public static void quickSort1(int arr[], int left, int right) {
		int index = partition(arr, left, right);
		if (left < index - 1) { // Sort left half
			quickSort1(arr, left, index - 1);
		}
		if (index < right) { // Sort right half
			quickSort1(arr, index, right);
		}
	}

	private static int partition(int arr[], int left, int right) {
		int pivot = arr[(left + right) / 2]; // Pick a pivot point. Can be an element.

		while (left <= right) { // Until we've gone through the whole array
			// Find element on left that should be on right
			while (arr[left] < pivot) {
				left++;
			}

			// Find element on right that should be on left
			while (arr[right] > pivot) {
				right--;
			}

			// Swap elements, and move left and right indices
			if (left <= right) {
				swap(arr, left, right);
				left++;
				right--;
			}
		}
		return left;
	}

	private static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	public static void quickSort2(int arr[], int left, int right) {
		int index = partition2(arr, left, right);
		if (left < index - 1) {
			quickSort2(arr, left, index - 1);
		}
		if (index + 1 < right) { 
			// 注意index+1，如果不+1会导致无限递归，栈溢出
			quickSort2(arr, index + 1, right);
		}
	}

	private static int partition2(int arr[], int left, int right) {
		int pivot = arr[left];
		while (left < right) {
			while (left < right && arr[right] >= pivot) {
				right--;
			}
			arr[left] = arr[right];
			while (left < right && arr[left] <= pivot) {
				left++;
			}
			arr[right] = arr[left];
		}
		arr[left] = pivot;
		return left;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10 };
		System.out.println("排序前:");
		System.out.println(Arrays.toString(arr));
		quickSort1(arr, 0, arr.length - 1);
		System.out.println("quickSort1排序后:");
		System.out.println(Arrays.toString(arr));

		int[] arr2 = new int[] { 1, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10 };
		quickSort2(arr2, 0, arr2.length - 1);
		System.out.println("quickSort2排序后:");
		System.out.println(Arrays.toString(arr2));
	}
}
