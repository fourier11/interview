/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 */
class Solution {
    /**
     * 复杂度：O(N) + O(1) 只有当允许修改数组元素时才可以使用 快速排序的 partition() 方法，会返回一个整数 j 使得 a[l..j-1]
     * 小于等于 a[j]，且 a[j+1..h] 大于等于 a[j]，此时 a[j] 就是数组的第 j 大元素。可以利用这个特性找出数组的第 K
     * 个元素，这种找第 K 个元素的算法称为快速选择算法。
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        int[] res = new int[k];
        findKthSmallest(arr, k - 1);
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    private void findKthSmallest(int[] nums, int k) {
        int l = 0;
        int h = nums.length - 1;
        while (l < h) {
            int index = partition(nums, l, h);
            if (index == k) {
                break;
            } else if (index > k) {
                h = index - 1;
            } else {
                l = index + 1;
            }
        }
    }

    private int partition(int[] nums, int l, int h) {
        int p = nums[l];
        int i = l;
        int j = h + 1;
        while (true) {
            while (i != h && nums[++i] < p)
                ;
            while (j != l && nums[--j] > p)
                ;
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}