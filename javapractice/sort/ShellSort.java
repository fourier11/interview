package sort;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSort {

    public static void shellSort(int[] arr) {
        int gap = arr.length;
        while (true) {
            gap /= 2; // 增量每次减半
            for (int i = 0; i < gap; i++) {
                for (int j = i + gap; j < arr.length; j += gap) {// 这个循环里其实就是一个插入排序
                    int temp = arr[j];
                    int k = j - gap;
                    while (k >= 0 && arr[k] > temp) {
                        arr[k + gap] = arr[k];
                        k -= gap;
                    }
                    arr[k + gap] = temp;
                }
            }
            if (gap == 1) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1 };
        System.out.println("排序前:");
        System.out.println(Arrays.toString(arr));
        shellSort(arr);
        System.out.println("排序后:");
        System.out.println(Arrays.toString(arr));
    }
}