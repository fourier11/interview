import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * 连续数列
 * 
 * 输入描述:
 * 
 * 输入包含两个参数，1）连续正整数数列和S，2）数列里数的个数N。
 * 
 * 输出描述:
 * 
 * 如果有解输出数列K，如果无解输出-1
 * 
 * 示例1
 * 
 * 输入
 * 
 * 525 6
 * 
 * 输出
 * 
 * 85 86 87 88 89 90
 */
public class ContinuousSequence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int target = in.nextInt();
        int array_num = in.nextInt();
        boolean matching_flag = false;
        int[][] results = findContinuousSequence(target);

        for (int i = 0; i < results.length; i++) {
            for (int j = 0; j < results[i].length; j++) {
                if (array_num == results[i].length) {
                    System.out.print(results[i][j] + " ");
                    matching_flag = true;
                }
            }
        }
        if (!matching_flag) {
            System.out.println(-1);
        }
        in.close();
    }

    public static int[][] findContinuousSequence(int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int left = 1;
        int right = 1;
        int sum = 0;
        while (right < target && left <= right) {// 这里注意是right<target 而不是sum < target。
            sum += right;
            // System.out.println("sssss" + sum + "right" + right + "left" + left);
            while (sum > target) {
                sum -= left;
                // System.out.println("vvv" + sum);
                left++;
            }
            if (sum == target) {
                // System.out.println(sum);
                List<Integer> ans = new ArrayList<>(); // 这里千万要注意，这个List对象一定要这里，这样res加的是不同的对象，如果你定义在函数开始时，那么真个res对象里只有1个ans对象，所有数据是连在一起的，没法按组（按行）分开。
                for (int i = left; i <= right; i++) {
                    ans.add(i);
                }
                res.add(ans);
            }
            right++;
        }
        int[][] result = new int[res.size()][];
        int j = 0;
        for (List<Integer> li : res) {
            int[] row = new int[li.size()];
            int i = 0;
            for (Integer lii : li) {
                row[i++] = lii;
                // System.out.println("有序整数："+lii);
            }
            result[j++] = row;
        }
        return result;
    }

}