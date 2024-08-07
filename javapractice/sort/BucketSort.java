package sort;

import java.util.Arrays;

/**
 * 桶排序 参考：https://www.runoob.com/w3cnote/bucket-sort.html
 */
public class BucketSort {

    /**
     * 
     * @param arr
     * @param bucketSize 表示一个桶能容纳的元素个数
     */
    private static void bucketSort(int[] arr, int bucketSize) {
        if (arr.length == 0) {
            return;
        }

        int minValue = arr[0];
        int maxValue = arr[0];
        for (int value : arr) {
            if (value < minValue) {
                minValue = value;
            } else if (value > maxValue) {
                maxValue = value;
            }
        }

        int bucketCount = (int) Math.floor((maxValue - minValue) / bucketSize) + 1;
        // 行数表示桶的个数
        int[][] buckets = new int[bucketCount][0];

        // 利用映射函数将数据分配到各个桶中
        for (int i = 0; i < arr.length; i++) {
            int index = (int) Math.floor((arr[i] - minValue) / bucketSize);
            // 往数组的末尾添加元素，稍微有些麻烦
            buckets[index] = arrAppend(buckets[index], arr[i]);
        }

        int arrIndex = 0;
        for (int[] bucket : buckets) {
            if (bucket.length <= 0) {
                continue;
            }
            // 对每个桶进行排序，这里使用了插入排序
            InsertSort.insertSort(bucket);
            for (int value : bucket) {
                arr[arrIndex++] = value;
            }
        }
    }

    /**
     * 给数组扩容
     */
    private static int[] arrAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 3, 64, 2 };
        System.out.println("排序之前：");
        System.out.println(Arrays.toString(arr));
        bucketSort(arr, 5);
        System.out.println("排序之后：");
        System.out.println(Arrays.toString(arr));
    }
}