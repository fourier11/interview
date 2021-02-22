/**
 * 特定和的子序列
 * 
 * 给出一个数组和一个固定SUM，求出连续元素和为sum。例如：[1,2,3,4,5,6,7,8] sum = 10输出是1 2 3 4；sum= 15
 * 输出是1 2 3 4 5；4 5 6；7 8。
 */
public class ArraySum {
    public static void main(String[] args) {
        int[] num = { 1, 2, 2, 3, 4, 5, 6, 7, 8, 9 };
        int sum = 5;
        findSum(num, sum);
    }

    public static void findSum(int[] num, int sum) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < num.length; i++) {
            int curSum = 0;
            left = i;
            right = i;
            while (curSum < sum) {
                curSum += num[right++];
            }
            if (curSum == sum) {
                for (int j = left; j < right; j++) {
                    System.out.print(num[j] + " ");
                }
                System.out.println();
            }
        }
    }
}
