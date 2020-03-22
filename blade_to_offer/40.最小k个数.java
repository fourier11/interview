class Solution {
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