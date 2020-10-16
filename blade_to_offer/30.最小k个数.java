/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 * 利用了快排的partition算法
 */
class Solution {
    /**
     * 复杂度：O(N) + O(1) 只有当允许修改数组元素时才可以使用 快速排序的 partition() 方法，会返回一个整数 j 使得 a[l..j-1]
     * 小于等于 a[j]，且 a[j+1..h] 大于等于 a[j]，此时 a[j] 就是数组的第 j 大元素。可以利用这个特性找出数组的第 K
     * 个元素，这种找第 K 个元素的算法称为快速选择算法。
     */
    public int[] smallestK(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        int[] res = new int[k];
        int l = 0;
        int h = arr.length - 1;
        while (l < h) {
            int index = partition(arr, l, h);
            if (index == k - 1) {
                break;
            } else if (index < k - 1) {
                l = index + 1;
            } else {
                h = index - 1;
            }
        }
        System.arraycopy(arr, 0, res, 0, k);
        return res;
    }

    private int partition(int[] nums, int l, int h) {
        int pivot = nums[l];
        while (l < h) {
            while (l < h && nums[h] >= pivot) {
                h--;
            }
            nums[l] = nums[h];
            while (l < h && nums[l] <= pivot) {
                l++;
            }
            nums[h] = nums[l];
        }
        nums[l] = pivot;
        return l;
    }
}