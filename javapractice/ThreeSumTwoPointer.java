import java.util.Arrays;

public class ThreeSumTwoPointer {

    /**
     * 统计数组中三个元素加和为0的情况，总共有多少种
     * 这个方法是最优方案
     */
    public static int count(int[] nums) {
        int N = nums.length;
        int cnt = 0;
        Arrays.sort(nums);
        for (int i = 0; i < N - 2; i++) {
            int l = i + 1, h = N - 1, target = -nums[i];
            while (l < h) {
                int sum = nums[l] + nums[h];
                if (sum == target) {
                    cnt++;
                    l++;
                    h--;
                } else if (sum < target) {
                    l++;
                } else {
                    h--;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = { -1, 2, 4 ,5, -1, -2, -2};
        int result = count(nums);
        System.out.println(result);
    }
}