
/**
 * 二分查找的变种
 * 一个有重复元素的有序数组中查找 key 的最左位置
 */
public class NewBinarySearch {
    public int binarySearch(int[] nums, int key) {
        int l = 0;
        int h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            // 注意这里有等号，因为需要找的是最左位置key，需要包含等号情况
            if (nums[m] >= key) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}