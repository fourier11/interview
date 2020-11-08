/**
 * 给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。注意：n-m尽量最小，也就是说，找出符合条件的最短序列。函数返回值为[m,n]，若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。
 * 
 */
class Solution {
    public int[] subSort(int[] array) {
        int len = array.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int l = -1;
        int r = -1;
        for (int i = 0; i < len; i++) {
            if (array[i] >= max) {
                max = array[i];
            } else {
                r = i;
            }
        }
        for (int i = len - 1; i >= 0; i--) {
            if (array[i] <= min) {
                min = array[i];
            } else {
                l = i;
            }
        }
        return new int[] { l, r };
    }
}