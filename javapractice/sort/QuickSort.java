package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序
 */
public class QuickSort {

	public static void quickSort(int[] nums) {
		shuffle(nums);
		sort(nums, 0, nums.length - 1);
	}

	public static void sort(int[] nums, int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		int p = partition2(nums, lo, hi);
		sort(nums, lo, p - 1);
		sort(nums, p + 1, hi);
	}

	public static int partition(int[] nums, int lo, int hi) {
		int pivot = nums[lo];
		// 这里边界定义为开区间，[lo, i) <= pivot (j, hi] > pivot
		int i = lo + 1;
		int j = hi;
		while (i <= j) {
			while (i < hi && nums[i] <= pivot) {
				i++;
				// 当while结束时，nums[i] > pivot
			}
			while (j > lo && nums[j] > pivot) {
				j--;
				// 当while结束时，nums[j] <= pivot
			}
			if (i >= j) {
				break;
			}
			// 交换前 [lo, i) <= pivot (j, hi] > pivot
			swap(nums, i, j);
			// 交换后 [lo, i] <= pivot [j, hi] > pivot
		}
		swap(nums, lo, j);
		return j;
	}

	/**
	 * 洗牌算法，有利于快排
	 */
	private static void shuffle(int[] nums) {
		Random rand = new Random();
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			int r = i + rand.nextInt(n-i);
			swap(nums, i, r);
		}
	}

	private static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
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
		quickSort(arr);
		System.out.println("quickSort1排序后:");
		System.out.println(Arrays.toString(arr));
	}
}
