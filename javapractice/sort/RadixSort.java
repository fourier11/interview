package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Java Program sort an integer array using radix sort algorithm.
 * input: [180, 50, 10, 30, 10, 29, 60, 0, 17, 24, 12]
 * output: [0, 10, 10, 12, 17, 24, 29, 30, 50, 60, 180]
 * 
 * Time Complexity of Solution:
 *   Best Case O(k*n); Average Case O(k*n); Worst Case O(k*n),
 *   where k is the length of the longest number and n is the
 *   size of the input array.
 *
 *   Note: if k is greater than log(n) then an n*log(n) algorithm would be a
 *         better fit. In reality we can always change the radix to make k
 *         less than log(n).
 * 基数排序
 * https://www.java67.com/2018/03/how-to-implement-radix-sort-in-java.html
 * 注意：此代码没有考虑负数情况
 */

public class RadixSort {

    public static void radixSort(int[] arr) {
        final int RADIX = 10;

        List<List<Integer>> bucket = new ArrayList<>();

        for (int i = 0; i < RADIX; i++) {
            bucket.add(new ArrayList<Integer>());
        }

        boolean maxLength = false;
        // 表示第几位的具体值。-1是无效数字，正常值应该是在0~9，
        int tmp = -1;
        // 表示当前排序是以第几位为标准，1，10，100，1000
        int placement = 1;
        while (!maxLength) {
            maxLength = true;

            // split input between lists
            for (Integer i : arr) {
                tmp = i / placement;
                bucket.get(tmp % RADIX).add(i);
                // 当arr中所有的数字都出现tmp大于0，说明这时placement已经达到最大值
                if (maxLength && tmp > 0) {
                    maxLength = false;
                }
            }

            // empty lists into input array
            int a = 0;
            for (int b = 0; b < RADIX; b++) {
                for (Integer i : bucket.get(b)) {
                    arr[a++] = i;
                }
                bucket.get(b).clear();
            }

            // move to next digit
            placement *= RADIX;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 181, 51, 11, 33, 11, 39, 60, 2, 27, 24, 12 };
        System.out.println("排序前:");
        System.out.println(Arrays.toString(arr));
        radixSort(arr);
        System.out.println("排序后:");
        System.out.println(Arrays.toString(arr));
    }
}
