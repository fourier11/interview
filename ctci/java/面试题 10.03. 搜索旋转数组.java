/**
 * 搜索旋转数组。给定一个排序后的数组，包含n个整数，但这个数组已被旋转过很多次了，次数不详。请编写代码找出数组中的某个元素，假设数组元素原先是按升序排列的。若有多个相同元素，返回索引值最小的一个。
 */
class Solution {
    public int search(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[left] < arr[mid]) {
                if (arr[left] <= target && target <= arr[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else if (arr[left] > arr[mid]) {
                if (arr[left] <= target || target <= arr[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else if (arr[left] == arr[mid]) {
                // 如果左值不等于目标，说明还没找到，需要逐一清理重复值。
                if (arr[left] != target) {
                    left++;
                } else {
                    right = left;
                }
            }
        }
        return (arr[left] == target) ? left : -1;
    }
}