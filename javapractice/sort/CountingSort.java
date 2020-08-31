package sort;

import java.util.Arrays;

/**
 * 计数排序
 */
public class CountingSort {

    public static void countingSort(int[] arr, int maxValue) {
        int bucketLen = maxValue + 1;
        int[] bucket = new int[bucketLen];

        for (int value : arr) {
            bucket[value]++;
        }

        int sortedIndex = 0;
        for (int j = 0; j < bucketLen; j++) {
            while (bucket[j] > 0) {
                arr[sortedIndex++] = j;
                bucket[j]--;
            }
        }
    }

    /**
     * 获取数组中的最大值
     */
    private static int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int value : arr) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int[] arr = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1 };
        System.out.println("排序之前：");
        System.out.println(Arrays.toString(arr));
        int maxValue = getMaxValue(arr);
        System.out.println("最大值: " + maxValue);
        countingSort(arr, maxValue);
        System.out.println("排序之后：");
        System.out.println(Arrays.toString(arr));
    }
}